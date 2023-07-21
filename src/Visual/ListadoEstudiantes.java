package Visual;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Database.ConexionDB;

import java.awt.Color;

public class ListadoEstudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoEstudiantes dialog = new ListadoEstudiantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			String sql = "SELECT * FROM Estudiante";
			Connection conexion = null;
			PreparedStatement p = null;
			ResultSet rs = null;
			conexion = ConexionDB.conectarDB();
			p = conexion.prepareStatement(sql);
			rs = p.executeQuery();
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
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton_1 = new JButton("Modificar");
				buttonPane.add(btnNewButton_1);
			}
			{
				JButton btnNewButton_2 = new JButton("Eliminar");
				buttonPane.add(btnNewButton_2);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
