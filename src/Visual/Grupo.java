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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private JButton btncodasignatura;
	private JButton btncrear;
	private JButton btncancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Grupo dialog = new Grupo(null,null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Grupo(String numgrupo, String codperiodo, String codasignatura) {
		setTitle("Crear Grupo");
		setBounds(100, 100, 392, 509);
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
			lblCodigoPeriodoAcademico.setBounds(26, 175, 180, 17);
			panel.add(lblCodigoPeriodoAcademico);
			{
				JLabel lblNewLabel = new JLabel("Codigo de asignatura:");
				lblNewLabel.setBounds(26, 97, 144, 17);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNumeroDeGrupo = new JLabel("Numero de grupo:");
				lblNumeroDeGrupo.setBounds(26, 24, 144, 17);
				panel.add(lblNumeroDeGrupo);
			}
			{
				JLabel lblCupoDeGrupo = new JLabel("Cupo de grupo:");
				lblCupoDeGrupo.setBounds(26, 322, 109, 17);
				panel.add(lblCupoDeGrupo);
			}
			{
				JLabel lblHorario = new JLabel("Horario:");
				lblHorario.setBounds(26, 251, 70, 17);
				panel.add(lblHorario);
			}
			
			spncupo = new JSpinner();
			spncupo.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			spncupo.setBounds(26, 351, 83, 22);
			panel.add(spncupo);
			
			txtnumerogrupo = new JTextField();
			txtnumerogrupo.setBounds(26, 53, 144, 21);
			panel.add(txtnumerogrupo);
			txtnumerogrupo.setColumns(10);
			
			txtcodperiodoacad = new JTextField();
			txtcodperiodoacad.setEditable(false);
			txtcodperiodoacad.setBounds(26, 204, 144, 21);
			panel.add(txtcodperiodoacad);
			txtcodperiodoacad.setColumns(10);
			
			txthorario = new JTextField();
			txthorario.setBounds(26, 280, 144, 21);
			panel.add(txthorario);
			txthorario.setColumns(10);
			
			txtcodasignatura = new JTextField();
			txtcodasignatura.setEditable(false);
			txtcodasignatura.setBounds(26, 126, 144, 21);
			panel.add(txtcodasignatura);
			txtcodasignatura.setColumns(10);
			{
				btncodperiodo = new JButton("Seleccionar");
				btncodperiodo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoPeriodosAcademicos periodosAcademicos = new ListadoPeriodosAcademicos(Grupo.this);
						periodosAcademicos.setVisible(true);
						periodosAcademicos.setModal(true);
						
					}
				});
				btncodperiodo.setBounds(194, 203, 109, 23);
				panel.add(btncodperiodo);
			}
			{
				btncodasignatura = new JButton("Seleccionar");
				btncodasignatura.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoAsignaturas asignaturas = new ListadoAsignaturas(Grupo.this);
						asignaturas.setVisible(true);
						asignaturas.setModal(true);
					}
				});
				btncodasignatura.setBounds(194, 125, 109, 23);
				panel.add(btncodasignatura);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btncrear = new JButton("Crear");
				btncrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (numgrupo == null) {
							if (txtnumerogrupo.getText().length() != 3 ) {
								JOptionPane.showMessageDialog(null,"Numero de grupo erroneamente insertado","Error",JOptionPane.ERROR_MESSAGE);
							}else if (txtcodasignatura.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null,"Codigo de asignatura no encontrado","Error",JOptionPane.ERROR_MESSAGE);
							}else if (txtcodperiodoacad.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null,"Periodo academico no encontrado","Error",JOptionPane.ERROR_MESSAGE);
							}else {
								String[] valores = {txtcodperiodoacad.getText(), txtcodasignatura.getText(), 
										txtnumerogrupo.getText(), txthorario.getText()};
								agregarGrupo(valores);
								
							}
						}else {
							updateGrupo((int) spncupo.getValue(), txthorario.getText(), numgrupo, codperiodo, codasignatura);
							dispose();
						}
					}
				});
				btncrear.setActionCommand("OK");
				buttonPane.add(btncrear);
				getRootPane().setDefaultButton(btncrear);
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
		if (numgrupo != null) {
			loadGrupo(numgrupo,codperiodo,codasignatura);
			btncrear.setText("Modificar");
		}
	}
	
	private void loadGrupo(String numgrupo, String codperiodo, String codasignatura) {
		txtcodasignatura.setEditable(false);
		txtcodperiodoacad.setEditable(false);
		txtnumerogrupo.setEditable(false);
		btncodasignatura.setEnabled(false);
		btncodperiodo.setEnabled(false);
		String[] pks = {numgrupo,codperiodo,codasignatura};
		String[] nombrespks = {"NumGrupo","CodPeriodoAcad","CodAsignatura"};
		
		try {
			ResultSet rs = ConexionDB.buscarFilasTabla("Grupo", nombrespks, pks, 3);
			rs.next();
			
			txtnumerogrupo.setText(rs.getString(nombrespks[0]));
			txtcodperiodoacad.setText(rs.getString(nombrespks[1]));
			txtcodasignatura.setText(rs.getString(nombrespks[2]));
			txthorario.setText(rs.getString("Horario"));
			spncupo.setValue(rs.getInt("CupoGrupo"));
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	private void clean() {
		txtcodasignatura.setText("");
		txtcodperiodoacad.setText("");
		txthorario.setText("");
		txtnumerogrupo.setText("");
		spncupo.setValue(0);
	}
	
	private void agregarGrupo(String[] valoresTipoString) {
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			String sql = "INSERT Grupo VALUES ('"+valoresTipoString[0]+"','"+valoresTipoString[1]+"','"+valoresTipoString[2]+"','"
					+spncupo.getValue()+"','"+valoresTipoString[3]+"')";
			
			Statement stm = conexion.createStatement();
			stm.executeUpdate(sql);
			
			conexion.close();
			JOptionPane.showMessageDialog(null,"El grupo ha sido insertado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
			clean();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Verifique que los campos esten correctamente insertados","Error",JOptionPane.ERROR_MESSAGE);
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
	
	private void updateGrupo(int cupo, String horario, String numgrupo, String periodoacad, String asignatura) {
		Connection conexion = ConexionDB.conectarDB();
		
		try {
			String sql = "UPDATE Grupo SET CupoGrupo = ?, Horario = ? WHERE NumGrupo = ? AND CodPeriodoAcad = ? AND CodAsignatura = ?";
			
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setInt(1, cupo);
			stm.setString(2, horario);
			stm.setString(3, numgrupo);
			stm.setString(4, periodoacad);
			stm.setString(5, asignatura);
		
			stm.executeUpdate();
			
			conexion.close();
			JOptionPane.showMessageDialog(null, "Grupo modificado satisfactoriamente", "Información",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Verifique que los campos esten correctamente insertados","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
