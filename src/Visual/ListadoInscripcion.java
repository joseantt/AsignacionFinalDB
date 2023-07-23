package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConexionDB;
import Visual.Inscripcion.selectionlistener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoInscripcion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable listainscripciones;
	private JButton btncancelar;
	private JButton btneliminar;
	private JButton btnActualizar;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoInscripcion dialog = new ListadoInscripcion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoInscripcion() {
		setBounds(100, 100, 759, 462);
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
					listainscripciones = new JTable();
					listainscripciones.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int selectedrow = listainscripciones.getSelectedRow();
							if (selectedrow >= 0) {
								btneliminar.setEnabled(true);
							}
						}
					});
					listainscripciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnas = {"Matricula", "Codigo de asignatura", "Codigo periodo academico", "Numero de grupo"};
					model = (DefaultTableModel) listainscripciones.getModel();
					model.setColumnIdentifiers(columnas);
					scrollPane.setViewportView(listainscripciones);
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
						
					}
				});
				btneliminar.setEnabled(false);
				btneliminar.setActionCommand("OK");
				buttonPane.add(btneliminar);
				getRootPane().setDefaultButton(btneliminar);
			}
			{
				btncancelar = new JButton("Cancelar");
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
		}
		
		loadListado(model);
	}

	private void loadListado(DefaultTableModel model) {
		
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM Inscripcion";
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String codperiodoacad = rs.getString("CodPeriodoAcad");
	            String codasignatura = rs.getString("CodAsignatura");
	            String numgrupo = rs.getString("NumGrupo");
	            String matricula = rs.getString("Matricula");
	            String[] fila = {matricula ,codasignatura, codperiodoacad, numgrupo};
	            
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
