package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConexionDB;
import Visual.Inscripcion.selectionlistener;
import logico.SelectionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable listagrupo;
	private JButton btncancelar;
	private JButton btneliminar;
	private JButton btnActualizar;
	private DefaultTableModel model;
	private selectionlistener listener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoGrupo dialog = new ListadoGrupo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoGrupo(SelectionListener listener) {
		setBounds(100, 100, 800, 462);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					listagrupo = new JTable();
					listagrupo.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int selectedrow = listagrupo.getSelectedRow();
							if (selectedrow >= 0) {
								btneliminar.setEnabled(true);
							}
						}
					});
					listagrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					String[] columnas = {"Numero de grupo", "Codigo de asignatura", "Codigo periodo academico", "Horario", "Cupo"};
					model = (DefaultTableModel) listagrupo.getModel();
					model.setColumnIdentifiers(columnas);
					
					scrollPane.setViewportView(listagrupo);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnActualizar = new JButton("Actualizar");
				btnActualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadListado(model);
						btneliminar.setEnabled(false);
					}
				});
				buttonPane.add(btnActualizar);
			}
			{
				btneliminar = new JButton("Eliminar");
				btneliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selectedRow = listagrupo.getSelectedRow();
				        if (selectedRow >= 0 && listener != null) {
				            Object value = model.getValueAt(selectedRow, 0);
				            listener.setValorSeleccionado(value,"numero grupo");
				            dispose();
				        }else {
							
				        	
						}
					}
				});
				
				btneliminar.setEnabled(false);
				btneliminar.setActionCommand("OK");
				buttonPane.add(btneliminar);
				getRootPane().setDefaultButton(btneliminar);
			}
			{
				btncancelar = new JButton("Cancelar");
				btncancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
		}
		if (listener != null) {
			btneliminar.setText("Seleccionar");
		}
		loadListado(model);
	}
	
	private void eliminarGrupo() {
		
	}

	private void loadListado(DefaultTableModel model) {
		
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM Grupo";
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String codperiodoacad = rs.getString("CodPeriodoAcad");
	            String codasignatura = rs.getString("CodAsignatura");
	            String numgrupo = rs.getString("NumGrupo");
	            String cupogrupo = rs.getString("CupoGrupo");
	            String horario = rs.getString("Horario");
	            String[] fila = {numgrupo, codasignatura, codperiodoacad, horario, cupogrupo};
	            
	            model.addRow(fila);
	        }
			p.close();
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
		
	}
}






