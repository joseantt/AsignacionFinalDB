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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GrupoHorario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btncancelar;
	private JTextField txtcodperiodoacad;
	private JTextField txtcodasignatura;
	private JTextField txtnumerogrupo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GrupoHorario dialog = new GrupoHorario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GrupoHorario() {
		setTitle("Crear Horario de grupo");
		setBounds(100, 100, 473, 362);
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
				JLabel lblCodigoDePeriodo = new JLabel("Codigo de periodo academico:");
				lblCodigoDePeriodo.setBounds(12, 22, 201, 17);
				panel.add(lblCodigoDePeriodo);
			}
			{
				JLabel lblCodigoDeAsignatura = new JLabel("Codigo de asignatura:");
				lblCodigoDeAsignatura.setBounds(264, 22, 148, 17);
				panel.add(lblCodigoDeAsignatura);
			}
			{
				JLabel lblNumeroDeGrupo = new JLabel("Numero de grupo:");
				lblNumeroDeGrupo.setBounds(12, 101, 131, 17);
				panel.add(lblNumeroDeGrupo);
			}
			{
				JLabel lblDia = new JLabel("Dia:");
				lblDia.setBounds(12, 171, 54, 17);
				panel.add(lblDia);
			}
			{
				JLabel lblFechaInicial = new JLabel("Fecha inicial:");
				lblFechaInicial.setBounds(264, 101, 107, 17);
				panel.add(lblFechaInicial);
			}
			{
				JLabel lblFechaFinal = new JLabel("Fecha final:");
				lblFechaFinal.setBounds(264, 171, 89, 17);
				panel.add(lblFechaFinal);
			}
			{
				txtcodperiodoacad = new JTextField();
				txtcodperiodoacad.setBounds(12, 51, 148, 21);
				panel.add(txtcodperiodoacad);
				txtcodperiodoacad.setColumns(10);
			}
			{
				txtcodasignatura = new JTextField();
				txtcodasignatura.setBounds(264, 51, 148, 21);
				panel.add(txtcodasignatura);
				txtcodasignatura.setColumns(10);
			}
			{
				txtnumerogrupo = new JTextField();
				txtnumerogrupo.setBounds(12, 130, 148, 21);
				panel.add(txtnumerogrupo);
				txtnumerogrupo.setColumns(10);
			}
			{
				JSpinner spnfechainicial = new JSpinner();
				spnfechainicial.setModel(new SpinnerDateModel(new Date(1689912000000L), null, null, Calendar.DAY_OF_YEAR));
				spnfechainicial.setBounds(264, 130, 154, 22);
				panel.add(spnfechainicial);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setModel(new SpinnerDateModel(new Date(1689912000000L), null, null, Calendar.DAY_OF_YEAR));
				spinner.setBounds(264, 200, 148, 22);
				panel.add(spinner);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(0, 0, 7, 1));
				spinner.setBounds(12, 200, 54, 22);
				panel.add(spinner);
			}
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
				btncancelar = new JButton("Cancel");
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
