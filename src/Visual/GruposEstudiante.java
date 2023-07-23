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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GruposEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			GruposEstudiante dialog = new GruposEstudiante("10147015");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public GruposEstudiante(String Matricula) {
		setTitle("GruposEstudiante");
		setBounds(100, 100, 894, 471);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String[] columnas = {"Codigo asignatura", "Numgrupo", "Horario"};
				model.setColumnIdentifiers(columnas);
				loadListado(model, Matricula);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
private void loadListado(DefaultTableModel model, String matricula) {
		
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM dbo.InscripcionesEstudiantes(?)";
			PreparedStatement p = conexion.prepareStatement(sql);
			p.setString(1, matricula);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String CodAsignatura = rs.getString("CodAsignatura");
	            String NumGrupo = rs.getString("NumGrupo");
	            String Horario = rs.getString("Horario");
	            String[] fila = {CodAsignatura ,NumGrupo, Horario};
	            
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
