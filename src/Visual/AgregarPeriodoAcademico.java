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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarPeriodoAcademico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarPeriodoAcademico dialog = new AgregarPeriodoAcademico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarPeriodoAcademico() {
		setTitle("Agregar Periodo Acad\u00E9mico");
		setBounds(100, 100, 772, 499);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setBounds(68, 61, 56, 19);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(136, 59, 223, 22);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
			lblDescripcin.setBounds(46, 113, 85, 16);
			contentPanel.add(lblDescripcin);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(136, 110, 223, 22);
			contentPanel.add(textField_1);
		}
		{
			JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio:");
			lblFechaDeInicio.setBounds(46, 171, 101, 16);
			contentPanel.add(lblFechaDeInicio);
		}
		
		JSpinner spn_FechaInicio = new JSpinner();
		spn_FechaInicio.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
		spn_FechaInicio.setBounds(159, 168, 200, 22);
		spn_FechaInicio.setEditor(new JSpinner.DateEditor(spn_FechaInicio,"yyyy-MM-dd"));
		contentPanel.add(spn_FechaInicio);
		{
			JLabel lblFechaDeFin = new JLabel("Fecha Fin:");
			lblFechaDeFin.setBounds(392, 171, 75, 16);
			contentPanel.add(lblFechaDeFin);
		}
		{
			JSpinner spn_FechaFin = new JSpinner();
			spn_FechaFin.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaFin.setBounds(479, 168, 222, 22);
			spn_FechaFin.setEditor(new JSpinner.DateEditor(spn_FechaFin,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaFin);
		}
		{
			JLabel lblFechaDeInicio_1 = new JLabel("Fecha inicio de clases:");
			lblFechaDeInicio_1.setBounds(46, 224, 139, 16);
			contentPanel.add(lblFechaDeInicio_1);
		}
		{
			JSpinner spn_FechaInicioClases = new JSpinner();
			spn_FechaInicioClases.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaInicioClases.setBounds(197, 221, 162, 22);
			spn_FechaInicioClases.setEditor(new JSpinner.DateEditor(spn_FechaInicioClases,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaInicioClases);
		}
		{
			JLabel lblFechaFinDe = new JLabel("Fecha fin de clases:");
			lblFechaFinDe.setBounds(392, 224, 126, 16);
			contentPanel.add(lblFechaFinDe);
		}
		{
			JSpinner spn_FechaFinClases = new JSpinner();
			spn_FechaFinClases.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaFinClases.setBounds(530, 221, 171, 22);
			spn_FechaFinClases.setEditor(new JSpinner.DateEditor(spn_FechaFinClases,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaFinClases);
		}
		{
			JLabel lblFechaLimite = new JLabel("Fecha limite para retiro:");
			lblFechaLimite.setBounds(46, 327, 139, 16);
			contentPanel.add(lblFechaLimite);
		}
		{
			JLabel lblFechaLimitePago = new JLabel("Fecha limite pago:");
			lblFechaLimitePago.setBounds(46, 274, 139, 16);
			contentPanel.add(lblFechaLimitePago);
		}
		{
			JSpinner spn_FechaLimitePago = new JSpinner();
			spn_FechaLimitePago.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimitePago.setBounds(183, 271, 176, 22);
			spn_FechaLimitePago.setEditor(new JSpinner.DateEditor(spn_FechaLimitePago,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimitePago);
		}
		{
			JSpinner spn_FechaLimiteRetiro = new JSpinner();
			spn_FechaLimiteRetiro.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimiteRetiro.setBounds(197, 324, 162, 22);
			spn_FechaLimiteRetiro.setEditor(new JSpinner.DateEditor(spn_FechaLimiteRetiro,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimiteRetiro);
		}
		{
			JLabel lblFechaLimitePrematrcula = new JLabel("Fecha limite prematr\u00EDcula:");
			lblFechaLimitePrematrcula.setBounds(392, 277, 156, 16);
			contentPanel.add(lblFechaLimitePrematrcula);
		}
		{
			JSpinner spn_FechaLimitePrematricula = new JSpinner();
			spn_FechaLimitePrematricula.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimitePrematricula.setBounds(560, 271, 141, 22);
			spn_FechaLimitePrematricula.setEditor(new JSpinner.DateEditor(spn_FechaLimitePrematricula,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimitePrematricula);
		}
		{
			JLabel lblFechaLimitePara = new JLabel("Fecha limite publicaci\u00F3n:");
			lblFechaLimitePara.setBounds(392, 330, 156, 16);
			contentPanel.add(lblFechaLimitePara);
		}
		{
			JSpinner spn_FechaLimitePublicacion = new JSpinner();
			spn_FechaLimitePublicacion.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimitePublicacion.setBounds(543, 327, 162, 22);
			spn_FechaLimitePublicacion.setEditor(new JSpinner.DateEditor(spn_FechaLimitePublicacion,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimitePublicacion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
