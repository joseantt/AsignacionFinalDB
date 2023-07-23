package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConexionDB;
import Visual.Inscripcion.selectionlistener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoGrupoHorario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablagrupohorario;
	private JButton btneliminar;
	private JButton btncancelar;
	private DefaultTableModel model;
	private selectionlistener listener;
	private JButton btnActualizar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoGrupoHorario dialog = new ListadoGrupoHorario(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoGrupoHorario(selectionlistener listener) {
		setBounds(100, 100, 811, 397);
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
					tablagrupohorario = new JTable();
					tablagrupohorario.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int selectedrow = tablagrupohorario.getSelectedRow();
							if (selectedrow >= 0) {
								btneliminar.setEnabled(true);
							}
						}
					});
					tablagrupohorario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnas = {"Numero de grupo", "Codigo de asignatura", "Codigo periodo academico", "Fecha inicial", "Fecha final", "Dia"};
					model = (DefaultTableModel) tablagrupohorario.getModel();
					model.setColumnIdentifiers(columnas);
					scrollPane.setViewportView(tablagrupohorario);
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
						int selectedRow = tablagrupohorario.getSelectedRow();
						int option = JOptionPane.showOptionDialog(null, "�Est� seguro de que desea continuar?",
						        "Confirmar eliminaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						        new Object[] {"Si", "No"}, null);
						if (option == 0) {
							eliminarGrupo(tablagrupohorario.getValueAt(selectedRow, 0).toString(),
									tablagrupohorario.getValueAt(selectedRow, 2).toString(),
									tablagrupohorario.getValueAt(selectedRow, 1).toString());
							btneliminar.setEnabled(false);
							tablagrupohorario.clearSelection();
							loadListado(model);
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
			this.listener = listener;
			btneliminar.setText("Seleccionar");
		}
		loadListado(model);
	}
	
	
	private void eliminarGrupo(String numgrupo, String periodoacad, String asignatura) {
		Connection conexion = ConexionDB.conectarDB();
		
		try {
			String sql = "DELETE FROM GrupoHorario WHERE NumGrupo = '" + numgrupo + "' AND CodAsignatura = '" + asignatura
					+ "' AND CodPeriodoAcad = '" + periodoacad + "'";
			Statement stm = conexion.createStatement();
			stm.executeUpdate(sql);
			
			conexion.close();
			JOptionPane.showMessageDialog(null,"Eliminacion exitosa","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"No fue posible eliminar el horario de grupo","Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void loadListado(DefaultTableModel model) {
		
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM GrupoHorario";
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String codperiodoacad = rs.getString("CodPeriodoAcad");
	            String codasignatura = rs.getString("CodAsignatura");
	            String numgrupo = rs.getString("NumGrupo");
	            String Dia = rs.getString("Dia");
	            String fechainicial = rs.getString("FechaInicial");
	            String fechafinal = rs.getString("FechaFinal");
	            String[] fila = {numgrupo ,codasignatura, codperiodoacad, fechainicial, fechafinal, Dia};
	            
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
