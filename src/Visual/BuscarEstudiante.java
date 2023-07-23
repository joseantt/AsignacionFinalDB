package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConexionDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BuscarEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMatricula;
	private JTextField txtPeriodoAcad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarEstudiante dialog = new BuscarEstudiante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarEstudiante() {
		setTitle("Horario estudiante");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matr\u00EDcula:");
		lblNewLabel.setBounds(41, 62, 112, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblPeriodoAcadmico = new JLabel("Periodo acad\u00E9mico:");
		lblPeriodoAcadmico.setBounds(26, 140, 120, 16);
		contentPanel.add(lblPeriodoAcadmico);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(121, 59, 205, 22);
		contentPanel.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtPeriodoAcad = new JTextField();
		txtPeriodoAcad.setColumns(10);
		txtPeriodoAcad.setBounds(158, 137, 168, 22);
		contentPanel.add(txtPeriodoAcad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String[] pkNombres = {"Matricula"};
						String[] pkValores = {txtMatricula.getText()};
						String[] pkNombres2 = {"CodPeriodoAcad"};
						String[] pkValores2 = {txtPeriodoAcad.getText()};
						
						boolean estudianteExiste = false;
						boolean periodoExiste = false;
						try {
							estudianteExiste = ConexionDB.buscarFilasTabla("Estudiante", pkNombres, pkValores, 1).next();
							periodoExiste = ConexionDB.buscarFilasTabla("PeriodoAcademico", pkNombres2, pkValores2, 1).next();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						if(estudianteExiste && periodoExiste) {
							HorarioEstudiante horarioEst = new HorarioEstudiante(
															txtMatricula.getText(), txtPeriodoAcad.getText());
							horarioEst.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"Uno de los campos no es valido","Error",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnBuscar.setActionCommand("OK");
				buttonPane.add(btnBuscar);
				getRootPane().setDefaultButton(btnBuscar);
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
	}
}
