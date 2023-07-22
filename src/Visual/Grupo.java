package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class Grupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtnumerogrupo;
	private JTextField txtcodperiodoacad;
	private JTextField txthorario;
	private JTextField txtcodasignatura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Grupo dialog = new Grupo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Grupo() {
		setTitle("Crear Grupo");
		setBounds(100, 100, 431, 329);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCodigoPeriodoAcademico = new JLabel("Codigo periodo academico:");
			lblCodigoPeriodoAcademico.setBounds(223, 24, 180, 17);
			panel.add(lblCodigoPeriodoAcademico);
			{
				JLabel lblNewLabel = new JLabel("Codigo de asignatura:");
				lblNewLabel.setBounds(12, 97, 144, 17);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNumeroDeGrupo = new JLabel("Numero de grupo:");
				lblNumeroDeGrupo.setBounds(12, 24, 144, 17);
				panel.add(lblNumeroDeGrupo);
			}
			{
				JLabel lblCupoDeGrupo = new JLabel("Cupo de grupo:");
				lblCupoDeGrupo.setBounds(12, 173, 109, 17);
				panel.add(lblCupoDeGrupo);
			}
			{
				JLabel lblHorario = new JLabel("Horario:");
				lblHorario.setBounds(223, 97, 70, 17);
				panel.add(lblHorario);
			}
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spinner.setBounds(12, 202, 83, 22);
			panel.add(spinner);
			
			txtnumerogrupo = new JTextField();
			txtnumerogrupo.setBounds(12, 53, 144, 21);
			panel.add(txtnumerogrupo);
			txtnumerogrupo.setColumns(10);
			
			txtcodperiodoacad = new JTextField();
			txtcodperiodoacad.setBounds(223, 53, 144, 21);
			panel.add(txtcodperiodoacad);
			txtcodperiodoacad.setColumns(10);
			
			txthorario = new JTextField();
			txthorario.setBounds(223, 126, 169, 21);
			panel.add(txthorario);
			txthorario.setColumns(10);
			
			txtcodasignatura = new JTextField();
			txtcodasignatura.setBounds(12, 126, 144, 21);
			panel.add(txtcodasignatura);
			txtcodasignatura.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btncrear = new JButton("Crear");
				btncrear.setActionCommand("OK");
				buttonPane.add(btncrear);
				getRootPane().setDefaultButton(btncrear);
			}
			{
				JButton btncancelar = new JButton("Cancelar");
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
