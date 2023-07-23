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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AgregarAsignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JButton btnagregar;
	private String text = null;
	private JSpinner spncreditos;
	private JSpinner spnteoricas;
	private JSpinner spnpracticas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarAsignatura dialog = new AgregarAsignatura(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the dialog.
	 */
	public AgregarAsignatura(String codAsignatura) {
		setTitle("Agregar Asignatura");
		setBounds(100, 100, 575, 251);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setBounds(30, 30, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			txtcodigo = new JTextField();
			txtcodigo.setBounds(92, 28, 171, 22);
			contentPanel.add(txtcodigo);
			txtcodigo.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(30, 70, 56, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtnombre = new JTextField();
			txtnombre.setBounds(92, 68, 304, 22);
			contentPanel.add(txtnombre);
			txtnombre.setColumns(10);
		}
		{
			JLabel lblCreditos = new JLabel("Creditos:");
			lblCreditos.setBounds(30, 115, 56, 16);
			contentPanel.add(lblCreditos);
		}
		{
			spncreditos = new JSpinner();
			spncreditos.setModel(new SpinnerNumberModel(0, 0, 6, 1));
			spncreditos.setBounds(92, 113, 56, 22);
			contentPanel.add(spncreditos);
		}
		{
			JLabel lblHorasTericas = new JLabel("Horas te\u00F3ricas:");
			lblHorasTericas.setBounds(176, 115, 87, 16);
			contentPanel.add(lblHorasTericas);
		}
		{
			spnteoricas = new JSpinner();
			spnteoricas.setModel(new SpinnerNumberModel(0, 0, 6, 1));
			spnteoricas.setBounds(273, 113, 56, 22);
			contentPanel.add(spnteoricas);
		}
		{
			JLabel lblHorasPrs = new JLabel("Horas pr\u00E1cticas:");
			lblHorasPrs.setBounds(372, 115, 101, 16);
			contentPanel.add(lblHorasPrs);
		}
		{
			spnpracticas = new JSpinner();
			spnpracticas.setModel(new SpinnerNumberModel(0, 0, 6, 1));
			spnpracticas.setBounds(478, 113, 56, 22);
			contentPanel.add(spnpracticas);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnagregar = new JButton("Agregar");
				if(codAsignatura != null)
					btnagregar.setText("Modificar");
				
				btnagregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(codAsignatura != null) {
							String[] columnas = {"Nombre", "Creditos", "HorasTeoricas", "HorasPracticas"};
							String[] valores = {};
							String[] Pks = {""};
							String[] valoresPks = {txtcodigo.getText()};
							
							try {
								Connection conexion = ConexionDB.conectarDB();
								
								String sql = "UPDATE Asignatura SET ";
								sql += "Asignatura.Nombre"+" = '"+txtnombre.getText()+"'" + 
								", Asignatura.Creditos = " + (Integer)spncreditos.getValue() +
								", Asignatura.HorasTeoricas = " + (Integer)spnteoricas.getValue() + 
										", Asignatura.HorasPracticas = " + (Integer)spnpracticas.getValue();								
								sql += " WHERE "+ "CodAsignatura"+" = "+ "'"+txtcodigo.getText()+"'";
								
							
								Statement stm = conexion.createStatement();
								int result = stm.executeUpdate(sql);
								
								//Hacer limitacion
								
								conexion.close();
							}
							catch(SQLException e2) {
								e2.printStackTrace();
							}
							
							JOptionPane.showMessageDialog(null, "Se ha modificado la asignatura satisfactoriamente", "Informaci�n",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}else {
							if (txtcodigo.getText().length() != 7)
								JOptionPane.showMessageDialog(null,"Ha ingresado un codigo invalido","Error",JOptionPane.ERROR_MESSAGE);
							else {
								String[] valores = {txtcodigo.getText(), txtnombre.getText()};
								agregarFilaAsignatura(valores, 2);
								limpiarCampos();
							}
						}	
					}
				});
				btnagregar.setActionCommand("OK");
				buttonPane.add(btnagregar);
				getRootPane().setDefaultButton(btnagregar);
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
		restablecerCampos(codAsignatura);
	}
	
	private void agregarFilaAsignatura(String[] valoresTipoString, int cantCamposTipoString) {
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			String sql = "INSERT Asignatura VALUES (";
			
			for(int i = 0; i < cantCamposTipoString; i++) {
				sql += "'"+valoresTipoString[i]+"'";
				if(i != cantCamposTipoString-1) {
					sql += ',';
				}
			}
			sql+=", "+(Integer)spncreditos.getValue()+", "+(Integer)spnteoricas.getValue()
				+", "+(Integer)spnpracticas.getValue()+')';
			Statement stm = conexion.createStatement();
			stm.executeUpdate(sql);
			
			conexion.close();
			JOptionPane.showMessageDialog(null,"Se ha ingresado una asignatura correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Verifique que los campos esten correctamente insertados","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void limpiarCampos(){
		txtcodigo.setText("");
		txtnombre.setText("");
		spncreditos.setValue(0);
		spnpracticas.setValue(0);
		spnteoricas.setValue(0);
	}
	
	private void restablecerCampos(String codAsignatura) {
		if(codAsignatura == null)
			return;
		try {
			String[] pkNombres = {"CodAsignatura"};
			String[] pkValores = {codAsignatura};
			ResultSet rs = ConexionDB.buscarFilasTabla("Asignatura", pkNombres, pkValores, 1);
			rs.next();
			txtcodigo.setText(codAsignatura);
			txtcodigo.setEnabled(false);
			txtnombre.setText(rs.getString("Nombre"));
			spncreditos.setValue(rs.getInt("Creditos"));
			spnteoricas.setValue(rs.getInt("HorasTeoricas"));
			spnpracticas.setValue(rs.getInt("HorasPracticas"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
