package Visual;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Database.ConexionDB;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoEstudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable TablaEstudiante;
	private JTable table;
	private JButton btn_modificar;
	private JButton btn_eliminar;
	private String matricula = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoEstudiantes dialog = new ListadoEstudiantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the dialog.
	 */
	public ListadoEstudiantes() {
		setTitle("Listado de estudiantes");
		setBounds(100, 100, 1082, 582);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					//Se crea un scrollPane, se añade la tabla al scroll, se edita el modelo y se presenta la tabla
					TablaEstudiante = new JTable();
					TablaEstudiante.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							btn_modificar.setEnabled(true);
							btn_eliminar.setEnabled(true);
						}
					});
					TablaEstudiante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnas = {"Matrícula", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Carrera", "CategoriaPago", "Nacionalidad", "Dirección"};
					DefaultTableModel model = (DefaultTableModel) TablaEstudiante.getModel();
					model.setColumnIdentifiers(columnas);
					actualizarFilasEstudiante(model);
					scrollPane.setViewportView(TablaEstudiante);
				}
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btn_modificar = new JButton("Modificar");
				btn_modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_modificar.setEnabled(false);
						btn_eliminar.setEnabled(false);
						TablaEstudiante.clearSelection();
					}
				});
				btn_modificar.setEnabled(false);
				buttonPane.add(btn_modificar);
			}
			{
				btn_eliminar = new JButton("Eliminar");
				btn_eliminar.setEnabled(false);
				btn_eliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int selection = JOptionPane.showOptionDialog(null, "¿Está seguro de que desea continuar?",
						        "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						        new Object[] {"Si", "No"}, null);
						
						if(selection == 0) {
							int indiceFilaSeleccionada = TablaEstudiante.getSelectedRow();
							if(indiceFilaSeleccionada != 1) {
								matricula = (String) TablaEstudiante.getValueAt(indiceFilaSeleccionada, 0);
								eliminarEstudiante(matricula);
								actualizarFilasEstudiante((DefaultTableModel)TablaEstudiante.getModel());
							}
							
							TablaEstudiante.clearSelection();
							btn_eliminar.setEnabled(false);
							btn_modificar.setEnabled(false);
						}
					}
				});
				buttonPane.add(btn_eliminar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
	private void actualizarFilasEstudiante(DefaultTableModel model) {
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM Estudiante";
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String matricula = rs.getString("Matricula");
	            String nombre1 = rs.getString("Nombre1");
	            String nombre2 = rs.getString("Nombre2");
	            String apellido1 = rs.getString("Apellido1");
	            String apellido2 = rs.getString("Apellido2");
	            String carrera = rs.getString("Carrera");
	            String categoria = rs.getString("CategoriaPago");
	            String nacionalidad = rs.getString("Nacionalidad");
	            String direccion = rs.getString("Direccion");
	            String[] fila = {matricula, nombre1, nombre2, apellido1, apellido2, carrera, categoria, 
	            					nacionalidad, direccion};
	            model.addRow(fila);
	        }
			p.close();
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	private void eliminarEstudiante(String matricula) {
		Connection conexion = ConexionDB.conectarDB();
		try {
			String sql = "DELETE FROM Estudiante WHERE Matricula = " + matricula;
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
