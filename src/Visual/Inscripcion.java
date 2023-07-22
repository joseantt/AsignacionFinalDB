package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Inscripcion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btncancelar;
	private JButton btninscribir;
	private JLabel lblNewLabel;
	private JLabel lblMatricula;
	private JLabel lblCodigoDeAsignatura;
	private JLabel lblNumeroDeGrupo;
	private JTextField txtcodperiodoacad;
	private JTextField txtmatricula;
	private JTextField txtcodigoasignatura;
	private JTextField txtnumerogrupo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inscripcion dialog = new Inscripcion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the dialog.
	 */
	public Inscripcion() {
		setTitle("Inscripcion");
		setBounds(100, 100, 450, 408);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("Codigo de periodo academico:");
				lblNewLabel.setBounds(12, 30, 195, 17);
				panel.add(lblNewLabel);
			}
			{
				lblMatricula = new JLabel("Matricula:");
				lblMatricula.setBounds(12, 100, 72, 17);
				panel.add(lblMatricula);
			}
			{
				lblCodigoDeAsignatura = new JLabel("Codigo de asignatura:");
				lblCodigoDeAsignatura.setBounds(12, 170, 149, 17);
				panel.add(lblCodigoDeAsignatura);
			}
			{
				lblNumeroDeGrupo = new JLabel("Numero de grupo:");
				lblNumeroDeGrupo.setBounds(12, 240, 132, 17);
				panel.add(lblNumeroDeGrupo);
			}
			{
				txtcodperiodoacad = new JTextField();
				txtcodperiodoacad.setBounds(12, 59, 167, 21);
				panel.add(txtcodperiodoacad);
				txtcodperiodoacad.setColumns(10);
			}
			{
				txtmatricula = new JTextField();
				txtmatricula.setBounds(12, 129, 167, 21);
				panel.add(txtmatricula);
				txtmatricula.setColumns(10);
			}
			{
				txtcodigoasignatura = new JTextField();
				txtcodigoasignatura.setBounds(12, 199, 167, 21);
				panel.add(txtcodigoasignatura);
				txtcodigoasignatura.setColumns(10);
			}
			{
				txtnumerogrupo = new JTextField();
				txtnumerogrupo.setBounds(12, 269, 167, 21);
				panel.add(txtnumerogrupo);
				txtnumerogrupo.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btninscribir = new JButton("Inscribir");
				btninscribir.setActionCommand("OK");
				buttonPane.add(btninscribir);
				getRootPane().setDefaultButton(btninscribir);
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
	}

}
