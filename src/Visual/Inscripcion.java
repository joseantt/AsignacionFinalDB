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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Inscripcion extends JDialog implements SelectionListener{

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
	private JButton btnselperiodo;
	private JButton btnnumgrupo;
	private JButton btnasignatura;

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

	interface selectionlistener{
		void setValorSeleccionado(Object valor);
	}
	/**
	 * Create the dialog.
	 */
	public Inscripcion() {
		setTitle("Inscripcion");
		setBounds(100, 100, 379, 408);
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
				lblNewLabel.setBounds(12, 103, 195, 17);
				panel.add(lblNewLabel);
			}
			{
				lblMatricula = new JLabel("Matricula:");
				lblMatricula.setBounds(12, 31, 72, 17);
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
				txtcodperiodoacad.setEditable(false);
				txtcodperiodoacad.setBounds(12, 131, 167, 21);
				panel.add(txtcodperiodoacad);
				txtcodperiodoacad.setColumns(10);
			}
			{
				txtmatricula = new JTextField();
				txtmatricula.setBounds(12, 59, 167, 21);
				panel.add(txtmatricula);
				txtmatricula.setColumns(10);
			}
			{
				txtcodigoasignatura = new JTextField();
				txtcodigoasignatura.setEditable(false);
				txtcodigoasignatura.setBounds(12, 199, 167, 21);
				panel.add(txtcodigoasignatura);
				txtcodigoasignatura.setColumns(10);
			}
			{
				txtnumerogrupo = new JTextField();
				txtnumerogrupo.setEditable(false);
				txtnumerogrupo.setBounds(12, 269, 167, 21);
				panel.add(txtnumerogrupo);
				txtnumerogrupo.setColumns(10);
			}
			
			btnselperiodo = new JButton("Seleccionar");
			btnselperiodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadoPeriodosAcademicos periodosAcademicos = new ListadoPeriodosAcademicos(Inscripcion.this);
					periodosAcademicos.setVisible(true);
					periodosAcademicos.setModal(true);
				}
			});
			btnselperiodo.setBounds(211, 130, 112, 23);
			panel.add(btnselperiodo);
			{
				btnnumgrupo = new JButton("Seleccionar");
				btnnumgrupo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoGrupo listadoGrupo = new ListadoGrupo(Inscripcion.this);
						listadoGrupo.setVisible(true);
						listadoGrupo.setModal(true);
					}
				});
				btnnumgrupo.setBounds(211, 268, 112, 23);
				panel.add(btnnumgrupo);
			}
			{
				btnasignatura = new JButton("Seleccionar");
				btnasignatura.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoAsignaturas asignaturas = new ListadoAsignaturas(Inscripcion.this);
						asignaturas.setVisible(true);
						asignaturas.setModal(true);
					}
				});
				btnasignatura.setBounds(211, 198, 112, 23);
				panel.add(btnasignatura);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btninscribir = new JButton("Inscribir");
				btninscribir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtcodigoasignatura.getText().isEmpty() || txtcodperiodoacad.getText().isEmpty() ||
								txtmatricula.getText().isEmpty() || txtnumerogrupo.getText().isEmpty() || txtmatricula.getText().length() != 8){
							JOptionPane.showMessageDialog(null,"Verifique que los campos esten correctamente insertados","Error",JOptionPane.ERROR_MESSAGE);
						}else {
							
							String[] valores = {txtcodperiodoacad.getText(),txtmatricula.getText(),txtcodigoasignatura.getText(),txtnumerogrupo.getText()};
							agregarInscripcion(valores);
							
						}
						}
				});
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
	
	private void clean() {
		txtcodigoasignatura.setText("");
		txtcodperiodoacad.setText("");
		txtmatricula.setText("");
		txtnumerogrupo.setText("");
	}

	private void agregarInscripcion(String[] valoresTipoString) {
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			String sql = "INSERT Inscripcion VALUES ('"+valoresTipoString[0]+"','"+valoresTipoString[1]+"','"+valoresTipoString[2]+"','"
					+valoresTipoString[3]+"')";
			
			Statement stm = conexion.createStatement();
			stm.executeUpdate(sql);
			
			
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha inscrito satisfactoriamente", "Información",JOptionPane.INFORMATION_MESSAGE);
			clean();
		}
		catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Verifique que los campos esten correctamente insertados","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	public void setValorSeleccionado(Object valor) {
		txtnumerogrupo.setText(valor.toString());
	}

	@Override
	public void setValorSeleccionado(Object valor, String objetivo) {
		// TODO Auto-generated method stub
		if (objetivo.equals("periodo academico")) {
			txtcodperiodoacad.setText(valor.toString());
		}else if (objetivo.equals("codigo asignatura")) {
			txtcodigoasignatura.setText(valor.toString());
		}else if (objetivo.equals("numero grupo")) {
			txtnumerogrupo.setText(valor.toString());
		}
	}
}
