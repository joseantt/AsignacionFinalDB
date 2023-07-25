package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConexionDB;
import javafx.scene.shape.Box;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HorarioEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaHorario;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			HorarioEstudiante dialog = new HorarioEstudiante("10147015", "320222023");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public HorarioEstudiante(String matricula, String codPeriodoAcad) {
		setTitle("HorarioEstudiante");
		setBounds(100, 100, 976, 580);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					tablaHorario = new JTable();
					tablaHorario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					DefaultTableModel model = (DefaultTableModel) tablaHorario.getModel();
					String[] columnas = {"", "", "", "", "", ""};
					model.setColumnIdentifiers(columnas);
					actualizarFilasHorario(model, matricula, codPeriodoAcad);
					scrollPane.setViewportView(tablaHorario);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	}

	private void actualizarFilasHorario(DefaultTableModel model, String matricula, String codPeriodoAcad) {
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "EXEC dbo.HorarioEstudiante '"+matricula+"', '"+codPeriodoAcad+"'";
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String c1 = rs.getString("C1");
	            String c2 = rs.getString("C2");
	            String c3 = rs.getString("C3");
	            String c4 = rs.getString("C4");
	            String c5 = rs.getString("C5");
	            String c6 = rs.getString("C6");
	            String[] fila = {c1, c2, c3, c4, c5, c6};
	            model.addRow(fila);
	        }
			p.close();
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Verifique que los campos esten correctamente insertados","Error",JOptionPane.ERROR_MESSAGE);
		} 
	}

}
