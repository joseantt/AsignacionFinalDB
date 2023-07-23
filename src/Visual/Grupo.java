package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Database.ConexionDB;
import logico.SelectionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class Grupo extends JDialog implements SelectionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtnumerogrupo;
	private JTextField txtcodperiodoacad;
	private JTextField txthorario;
	private JTextField txtcodasignatura;
	private JButton btncodperiodo;
	private JSpinner spncupo;

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
		setBounds(100, 100, 577, 402);
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
				lblHorario.setBounds(312, 97, 70, 17);
				panel.add(lblHorario);
			}
			
			spncupo = new JSpinner();
			spncupo.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spncupo.setBounds(12, 202, 83, 22);
			panel.add(spncupo);
			
			txtnumerogrupo = new JTextField();
			txtnumerogrupo.setBounds(12, 53, 144, 21);
			panel.add(txtnumerogrupo);
			txtnumerogrupo.setColumns(10);
			
			txtcodperiodoacad = new JTextField();
			txtcodperiodoacad.setEditable(false);
			txtcodperiodoacad.setBounds(223, 53, 144, 21);
			panel.add(txtcodperiodoacad);
			txtcodperiodoacad.setColumns(10);
			
			txthorario = new JTextField();
			txthorario.setBounds(312, 126, 169, 21);
			panel.add(txthorario);
			txthorario.setColumns(10);
			
			txtcodasignatura = new JTextField();
			txtcodasignatura.setEditable(false);
			txtcodasignatura.setBounds(12, 126, 144, 21);
			panel.add(txtcodasignatura);
			txtcodasignatura.setColumns(10);
			{
				btncodperiodo = new JButton("Seleccionar");
				btncodperiodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoPeriodosAcademicos periodosAcademicos = new ListadoPeriodosAcademicos(Grupo.this);
						periodosAcademicos.setVisible(true);
					}
				});
				btncodperiodo.setBounds(403, 52, 89, 23);
				panel.add(btncodperiodo);
			}
			{
				JButton btncodasignatura = new JButton("Seleccionar");
				btncodasignatura.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoAsignaturas asignaturas = new ListadoAsignaturas(Grupo.this);
						asignaturas.setVisible(true);
						asignaturas.setModal(true);
					}
				});
				btncodasignatura.setBounds(180, 125, 89, 23);
				panel.add(btncodasignatura);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btncrear = new JButton("Crear");
				btncrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtnumerogrupo.getText().length() != 3 || txtcodasignatura.getText().isEmpty() || 
								txtcodperiodoacad.getText().isEmpty() )
							JOptionPane.showMessageDialog(null,"Ha ingresado un codigo invalido","Error",JOptionPane.INFORMATION_MESSAGE);
						else {
							String[] valores = {txtcodperiodoacad.getText(), txtcodasignatura.getText(), 
									txtnumerogrupo.getText(), txthorario.getText()};
							agregarGrupo(valores);
							
							JOptionPane.showMessageDialog(null,"El grupo ha sido insertado correctamente","Error",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
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
	
	private void agregarGrupo(String[] valoresTipoString) {
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			String sql = "INSERT Grupo VALUES ('"+valoresTipoString[0]+"','"+valoresTipoString[1]+"','"+valoresTipoString[2]+"','"
					+spncupo.getValue()+"','"+valoresTipoString[3]+"')";
			
			Statement stm = conexion.createStatement();
			int result = stm.executeUpdate(sql);
			
			//Hacer limitacion para que no se ingrese un usuario con el mismo ID
			
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setValorSeleccionado(Object valor, String objetivo) {
		// TODO Auto-generated method stub
		if (objetivo.equals("periodo academico")) {
			txtcodperiodoacad.setText(valor.toString());
		}else if (objetivo.equals("codigo asignatura")) {
			txtcodasignatura.setText(valor.toString());
		}
		
	}
}
