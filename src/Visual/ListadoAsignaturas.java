package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConexionDB;
import logico.SelectionListener;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoAsignaturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaAsignaturas;
	private JButton btnEliminar;
	private JButton btnModificar;
	private int indiceFilaSeleccionada = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoAsignaturas dialog = new ListadoAsignaturas(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoAsignaturas(SelectionListener listener) {
		setTitle("Listado de asignaturas");
		setBounds(100, 100, 985, 553);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				tablaAsignaturas = new JTable();
				tablaAsignaturas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
				tablaAsignaturas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						btnModificar.setEnabled(true);
						btnEliminar.setEnabled(true);
					}
				});
				tablaAsignaturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String[] columnas = {"Codigo Asig.", "Nombre", "Creditos", "Horas Teoricas", "Horas Practicas"};
				DefaultTableModel model = (DefaultTableModel) tablaAsignaturas.getModel();
				model.setColumnIdentifiers(columnas);
				actualizarFilasAsignaturas(model);
				scrollPane.setViewportView(tablaAsignaturas);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						indiceFilaSeleccionada = tablaAsignaturas.getSelectedRow();
						
						if (listener != null) {
							Object value = tablaAsignaturas.getValueAt(indiceFilaSeleccionada, 0);
							listener.setValorSeleccionado(value, "codigo asignatura");
							dispose();
						}else {
							
						
							int selection = JOptionPane.showOptionDialog(null, "�Est� seguro de que desea continuar?",
							        "Confirmar eliminaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							        new Object[] {"Si", "No"}, null);
							
							if(selection == 0) {
								if(indiceFilaSeleccionada != -1) {
									String codigo = (String) tablaAsignaturas.getValueAt(indiceFilaSeleccionada, 0);
									eliminarAsignatura(codigo);
									actualizarFilasAsignaturas((DefaultTableModel)tablaAsignaturas.getModel());
									indiceFilaSeleccionada = -1;
								}
								
								tablaAsignaturas.clearSelection();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
							}
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						indiceFilaSeleccionada = tablaAsignaturas.getSelectedRow();
						if(indiceFilaSeleccionada != -1) {
							AgregarAsignatura agregarAsig = new AgregarAsignatura(
								(String)tablaAsignaturas.getValueAt(indiceFilaSeleccionada, 0));
							agregarAsig.setVisible(true);
							actualizarFilasAsignaturas((DefaultTableModel)tablaAsignaturas.getModel());
							indiceFilaSeleccionada = -1;
						}
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						tablaAsignaturas.clearSelection();
					
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		if (listener != null) {
			btnEliminar.setText("Seleccionar");
			btnModificar.setEnabled(false);
			btnModificar.setVisible(false);
		}
	}

	private void actualizarFilasAsignaturas(DefaultTableModel model) {
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM Asignatura";
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String codigo = rs.getString("CodAsignatura");
	            String nombre = rs.getString("Nombre");
	            int creditos = rs.getInt("Creditos");
	            int Ht = rs.getInt("HorasTeoricas");
	            int Hp = rs.getInt("HorasPracticas");
	            String[] fila = {codigo, nombre, Integer.toString(creditos), Integer.toString(Ht),
	            				Integer.toString(Hp)};
	            model.addRow(fila);
	        }
			p.close();
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private void eliminarAsignatura(String codigo) {
		Connection conexion = ConexionDB.conectarDB();
		try {
			String sql = "DELETE FROM Asignatura WHERE CodAsignatura = " + "'"+codigo+"'";
			Statement stm = conexion.createStatement();
			int result = stm.executeUpdate(sql);
			
			//Hacer limitacion para delete
			
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
