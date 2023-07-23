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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class GrupoHorario extends JDialog implements SelectionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btncancelar;
	private JTextField txtcodperiodoacad;
	private JTextField txtcodasignatura;
	private JTextField txtnumerogrupo;
	private JButton btnperiodoacad;
	private JButton btnasignatura;
	private JButton btncrear;
	private JSpinner spndia;
	private JSpinner spnfechafinal;
	private JSpinner spnfechainicial;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			GrupoHorario dialog = new GrupoHorario("320222023", "ICC-201", "001");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public GrupoHorario(String codPeriodoAcad, String codAsignatura, String numGrupo) {
		setTitle("Crear Horario de grupo");
		setBounds(100, 100, 660, 418);
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
				txtcodperiodoacad.setEditable(false);
				txtcodperiodoacad.setBounds(12, 51, 148, 21);
				panel.add(txtcodperiodoacad);
				txtcodperiodoacad.setColumns(10);
			}
			{
				txtcodasignatura = new JTextField();
				txtcodasignatura.setEditable(false);
				txtcodasignatura.setBounds(264, 51, 148, 21);
				panel.add(txtcodasignatura);
				txtcodasignatura.setColumns(10);
			}
			{
				txtnumerogrupo = new JTextField();
				if(codPeriodoAcad != null || codAsignatura != null || numGrupo != null)
					txtnumerogrupo.setEnabled(false);
				txtnumerogrupo.setBounds(12, 130, 148, 21);
				panel.add(txtnumerogrupo);
				txtnumerogrupo.setColumns(10);
			}
			{
				spnfechainicial = new JSpinner();
				spnfechainicial.setModel(new SpinnerDateModel(new Date(1689912000000L), null, null, Calendar.DAY_OF_YEAR));
				spnfechainicial.setBounds(264, 130, 154, 22);
				panel.add(spnfechainicial);
			}
			{
				spnfechafinal = new JSpinner();
				spnfechafinal.setModel(new SpinnerDateModel(new Date(1689912000000L), null, null, Calendar.DAY_OF_YEAR));
				spnfechafinal.setBounds(264, 200, 148, 22);
				panel.add(spnfechafinal);
			}
			{
				spndia = new JSpinner();
				spndia.setModel(new SpinnerNumberModel(1, 1, 7, 1));
				spndia.setBounds(12, 200, 54, 22);
				panel.add(spndia);
			}
			{
				btnperiodoacad = new JButton("Seleccionar");
				if(codPeriodoAcad != null || codAsignatura != null || numGrupo != null)
					btnperiodoacad.setEnabled(false);
				
				btnperiodoacad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoPeriodosAcademicos periodosAcademicos = new ListadoPeriodosAcademicos(GrupoHorario.this);
						periodosAcademicos.setVisible(true);
						periodosAcademicos.setModal(true);
					}
				});
				btnperiodoacad.setBounds(165, 50, 89, 23);
				panel.add(btnperiodoacad);
			}
			{
				btnasignatura = new JButton("Seleccionar");
				if(codPeriodoAcad != null || codAsignatura != null || numGrupo != null)
					btnasignatura.setEnabled(false);
				btnasignatura.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListadoAsignaturas asignaturas = new ListadoAsignaturas(GrupoHorario.this);
						asignaturas.setVisible(true);
						asignaturas.setModal(true);
					}
				});
				btnasignatura.setBounds(437, 50, 89, 23);
				panel.add(btnasignatura);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btncrear = new JButton("Crear");
				if(codPeriodoAcad != null && codAsignatura != null && numGrupo != null)
					btncrear.setText("Modificar");
				btncrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(codPeriodoAcad != null && codAsignatura != null && numGrupo != null){
							Timestamp ini = new Timestamp (((Date)spnfechainicial.getValue()).getTime());
							Timestamp fin = new Timestamp (((Date)spnfechafinal.getValue()).getTime());
							updateGrupoHorario(codPeriodoAcad, codAsignatura, numGrupo, (Integer)spndia.getValue(), ini, fin);
							JOptionPane.showMessageDialog(null,"El horario del grupo ha sido modificado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);

						}else {
							if (txtnumerogrupo.getText().length() != 3) {
								JOptionPane.showMessageDialog(null,"El numero de grupo debe ser de 3 elementos.","Error",JOptionPane.ERROR_MESSAGE);
							}else {
								
								String[] valoreStrings = {txtcodperiodoacad.getText(),txtcodasignatura.getText(),txtnumerogrupo.getText()};
								agregarGrupoHorario(valoreStrings);
								JOptionPane.showMessageDialog(null,"El horario del grupo ha sido insertado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
							
							}
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
		restablecerCampos(codPeriodoAcad, codAsignatura, numGrupo);
	}


	private void agregarGrupoHorario(String[] valoresTipoString) {
		
		Date inicial = (Date) spnfechainicial.getValue();
		Date fina = (Date) spnfechafinal.getValue();
		Timestamp ini = new Timestamp(inicial.getTime());
		Timestamp fin = new Timestamp(fina.getTime());
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("INSERT GrupoHorario VALUES ('")
			          .append(valoresTipoString[0])
			          .append("','")
			          .append(valoresTipoString[1])
			          .append("','")
			          .append(valoresTipoString[2])
			          .append("','")
			          .append(spndia.getValue())
			          .append("','")
			          .append(ini)
			          .append("','")
			          .append(fin)
			          .append("')");

			String sql = sqlBuilder.toString();
			
			Statement stm = conexion.createStatement();
			stm.executeUpdate(sql);
			
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
	
	private void restablecerCampos(String codPeriodoAcad, String codAsignatura, String numGrupo) {
		if(codPeriodoAcad == null || codAsignatura == null || numGrupo == null)
			return;
		String[] pkNombres = {"CodPeriodoAcad", "CodAsignatura", "NumGrupo"};
		String[] pkValores = {codPeriodoAcad, codAsignatura, numGrupo};
		try {
			ResultSet rs = ConexionDB.buscarFilasTabla("GrupoHorario", pkNombres, pkValores, 3);
			rs.next();
			txtcodasignatura.setText(codAsignatura);
			txtcodperiodoacad.setText(codPeriodoAcad);
			txtnumerogrupo.setText(numGrupo);
			spnfechainicial.setValue((Date)rs.getTimestamp("FechaInicial"));
			spnfechafinal.setValue((Date)rs.getTimestamp("FechaFinal"));
			spndia.setValue(rs.getInt("Dia"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateGrupoHorario(String CodPeriodoAcad, String CodAsignatura, String NumGrupo, int Dia, Timestamp FechaInicial, Timestamp FechaFinal) {
		Connection conexion = ConexionDB.conectarDB();
		
		try {
			String sql = "UPDATE GrupoHorario SET Dia = ?, FechaInicial = ?, FechaFinal = ? WHERE CodPeriodoAcad = ? AND CodAsignatura = ? AND NumGrupo = ?";
			
			PreparedStatement stm = conexion.prepareStatement(sql);
			stm.setInt(1, Dia);
			stm.setTimestamp(2, FechaInicial);
			stm.setTimestamp(3, FechaFinal);
			stm.setString(4, CodPeriodoAcad);
			stm.setString(5, CodAsignatura);
			stm.setString(6, NumGrupo);
			stm.executeUpdate();
			
			stm.close();
			conexion.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
	}
}
