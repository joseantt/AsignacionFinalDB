package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Database.ConexionDB;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class AgregarPeriodoAcademico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodigo;
	private JTextField txtdescripcion;
	private JButton btnagregar;
	private JButton btncancelar;
	private JSpinner spn_FechaInicio;
	private JSpinner spn_FechaInicioClases;
	private JSpinner spn_FechaFin;
	private JSpinner spn_FechaFinClases;
	private JSpinner spn_FechaLimitePago;
	private JSpinner spn_FechaLimitePrematricula;
	private JSpinner spn_FechaLimiteRetiro;
	private JSpinner spn_FechaLimitePublicacion;
	

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
		setBounds(100, 100, 690, 499);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel.setBounds(45, 28, 610, 60);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				lblNewLabel.setBounds(0, 0, 56, 19);
				panel.add(lblNewLabel);
			}
			{
				txtcodigo = new JTextField();
				txtcodigo.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (txtcodigo.getText().length() == 8) {
							btnagregar.setEnabled(true);
						}
					}
				});
				txtcodigo.setBounds(0, 31, 223, 22);
				panel.add(txtcodigo);
				txtcodigo.setColumns(10);
			}
			{
				JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
				lblDescripcin.setBounds(306, 1, 85, 16);
				panel.add(lblDescripcin);
			}
			{
				txtdescripcion = new JTextField();
				txtdescripcion.setBounds(306, 31, 300, 22);
				panel.add(txtdescripcion);
				txtdescripcion.setColumns(10);
			}
		}
		{
			JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio:");
			lblFechaDeInicio.setBounds(46, 120, 101, 16);
			contentPanel.add(lblFechaDeInicio);
		}
		
		spn_FechaInicio = new JSpinner();
		spn_FechaInicio.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
		spn_FechaInicio.setBounds(46, 148, 200, 22);
		spn_FechaInicio.setEditor(new JSpinner.DateEditor(spn_FechaInicio,"yyyy-MM-dd"));
		contentPanel.add(spn_FechaInicio);
		{
			JLabel lblFechaDeFin = new JLabel("Fecha Fin:");
			lblFechaDeFin.setBounds(352, 120, 75, 16);
			contentPanel.add(lblFechaDeFin);
		}
		{
			spn_FechaFin = new JSpinner();
			spn_FechaFin.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaFin.setBounds(352, 148, 200, 22);
			spn_FechaFin.setEditor(new JSpinner.DateEditor(spn_FechaFin,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaFin);
		}
		{
			JLabel lblFechaDeInicio_1 = new JLabel("Fecha inicio de clases:");
			lblFechaDeInicio_1.setBounds(46, 193, 139, 16);
			contentPanel.add(lblFechaDeInicio_1);
		}
		{
			spn_FechaInicioClases = new JSpinner();
			spn_FechaInicioClases.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaInicioClases.setBounds(46, 221, 200, 22);
			spn_FechaInicioClases.setEditor(new JSpinner.DateEditor(spn_FechaInicioClases,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaInicioClases);
		}
		{
			JLabel lblFechaFinDe = new JLabel("Fecha fin de clases:");
			lblFechaFinDe.setBounds(352, 193, 126, 16);
			contentPanel.add(lblFechaFinDe);
		}
		{
			spn_FechaFinClases = new JSpinner();
			spn_FechaFinClases.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaFinClases.setBounds(352, 221, 200, 22);
			spn_FechaFinClases.setEditor(new JSpinner.DateEditor(spn_FechaFinClases,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaFinClases);
		}
		{
			JLabel lblFechaLimite = new JLabel("Fecha limite para retiro:");
			lblFechaLimite.setBounds(46, 327, 175, 16);
			contentPanel.add(lblFechaLimite);
		}
		{
			JLabel lblFechaLimitePago = new JLabel("Fecha limite pago:");
			lblFechaLimitePago.setBounds(46, 260, 139, 16);
			contentPanel.add(lblFechaLimitePago);
		}
		{
			spn_FechaLimitePago = new JSpinner();
			spn_FechaLimitePago.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimitePago.setBounds(46, 288, 200, 22);
			spn_FechaLimitePago.setEditor(new JSpinner.DateEditor(spn_FechaLimitePago,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimitePago);
		}
		{
			spn_FechaLimiteRetiro = new JSpinner();
			spn_FechaLimiteRetiro.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimiteRetiro.setBounds(46, 355, 200, 22);
			spn_FechaLimiteRetiro.setEditor(new JSpinner.DateEditor(spn_FechaLimiteRetiro,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimiteRetiro);
		}
		{
			JLabel lblFechaLimitePrematrcula = new JLabel("Fecha limite prematr\u00EDcula:");
			lblFechaLimitePrematrcula.setBounds(352, 260, 175, 16);
			contentPanel.add(lblFechaLimitePrematrcula);
		}
		{
			spn_FechaLimitePrematricula = new JSpinner();
			spn_FechaLimitePrematricula.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimitePrematricula.setBounds(352, 288, 200, 22);
			spn_FechaLimitePrematricula.setEditor(new JSpinner.DateEditor(spn_FechaLimitePrematricula,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimitePrematricula);
		}
		{
			JLabel lblFechaLimitePara = new JLabel("Fecha limite publicaci\u00F3n:");
			lblFechaLimitePara.setBounds(352, 327, 156, 16);
			contentPanel.add(lblFechaLimitePara);
		}
		{
			spn_FechaLimitePublicacion = new JSpinner();
			spn_FechaLimitePublicacion.setModel(new SpinnerDateModel(new Date(1689825600000L), null, null, Calendar.DAY_OF_YEAR));
			spn_FechaLimitePublicacion.setBounds(352, 355, 200, 22);
			spn_FechaLimitePublicacion.setEditor(new JSpinner.DateEditor(spn_FechaLimitePublicacion,"yyyy-MM-dd"));
			contentPanel.add(spn_FechaLimitePublicacion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnagregar = new JButton("Agregar");
				btnagregar.setEnabled(false);
				btnagregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtcodigo.getText().length() != 9) {
							JOptionPane.showMessageDialog(null,"Ha ingresado un codigo invalido","Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
						String[] valores = {txtcodigo.getText(), txtdescripcion.getText(), new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaInicio.getValue()),
								new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaFin.getValue()), new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaInicioClases.getValue()), 
								new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaFinClases.getValue()), new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaLimitePago.getValue()), 
								new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaLimitePrematricula.getValue()), new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaLimiteRetiro.getValue()),
								new SimpleDateFormat("yyyy-MM-dd").format((Date)spn_FechaLimitePublicacion.getValue())};
							ConexionDB.agregarFilaTabla("PeriodoAcademico", valores, 10);
							clean();
						}
					}
				});
				btnagregar.setActionCommand("OK");
				buttonPane.add(btnagregar);
				getRootPane().setDefaultButton(btnagregar);
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
	
	private void clean() {
		txtcodigo.setText("");
		txtdescripcion.setText("");
	}
}






