package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import Database.ConexionDB;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AgregarEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_matricula;
	private JTextField txt_primerNombre;
	private JTextField txt_segundoNombre;
	private JTextField txt_primerApellido;
	private JTextField txt_segundoApellido;
	private JTextField txt_Direccion;
	private JComboBox cbx_Carrera;
	private JComboBox cbx_Nacionalidad;
	private JComboBox cbx_Pago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarEstudiante dialog = new AgregarEstudiante(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarEstudiante(String matricula) {
		setTitle("Agregar estudiante");
		setBounds(100, 100, 749, 502);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setBounds(38, 24, 77, 16);
		contentPanel.add(lblNewLabel);
		
		txt_matricula = new JTextField();
		txt_matricula.setBounds(38, 50, 209, 22);
		contentPanel.add(txt_matricula);
		txt_matricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Primer Nombre:");
		lblNombre.setBounds(38, 101, 100, 16);
		contentPanel.add(lblNombre);
		
		txt_primerNombre = new JTextField();
		txt_primerNombre.setColumns(10);
		txt_primerNombre.setBounds(150, 98, 180, 22);
		contentPanel.add(txt_primerNombre);
		
		JLabel lblSegundoNombre = new JLabel("Segundo Nombre:");
		lblSegundoNombre.setBounds(367, 104, 111, 16);
		contentPanel.add(lblSegundoNombre);
		
		txt_segundoNombre = new JTextField();
		txt_segundoNombre.setColumns(10);
		txt_segundoNombre.setBounds(490, 101, 180, 22);
		contentPanel.add(txt_segundoNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		lblPrimerApellido.setBounds(38, 146, 100, 16);
		contentPanel.add(lblPrimerApellido);
		
		txt_primerApellido = new JTextField();
		txt_primerApellido.setColumns(10);
		txt_primerApellido.setBounds(150, 143, 180, 22);
		contentPanel.add(txt_primerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setBounds(367, 149, 111, 16);
		contentPanel.add(lblSegundoApellido);
		
		txt_segundoApellido = new JTextField();
		txt_segundoApellido.setColumns(10);
		txt_segundoApellido.setBounds(490, 146, 180, 22);
		contentPanel.add(txt_segundoApellido);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(38, 227, 69, 16);
		contentPanel.add(lblCarrera);
		
		cbx_Carrera = new JComboBox();
		cbx_Carrera.setModel(new DefaultComboBoxModel(new String[] {"ICC", "ITT", "IIS", "DIR", "COM", "ARQ", "EDU", "FIL", "IESP", "IESE", "PSC", "NUT", "MED", "ADHA"}));
		cbx_Carrera.setBounds(121, 227, 209, 22);
		contentPanel.add(cbx_Carrera);
		
		JLabel lblCategoriaDePago = new JLabel("Categoria de pago:");
		lblCategoriaDePago.setBounds(367, 279, 123, 16);
		contentPanel.add(lblCategoriaDePago);
		
		cbx_Pago = new JComboBox();
		cbx_Pago.setModel(new DefaultComboBoxModel(new String[] {"UNI", "I", "IV", "IVA", "V", "XII", "XIII", "XXI"}));
		cbx_Pago.setBounds(490, 276, 180, 22);
		contentPanel.add(cbx_Pago);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(38, 282, 100, 16);
		contentPanel.add(lblNacionalidad);
		
		cbx_Nacionalidad = new JComboBox();
		cbx_Nacionalidad.setModel(new DefaultComboBoxModel(new String[] {"DOM", "ESP", "ITA", "BRA", "MEX", "USA", "JPN", "CAN", "FRA", "GBR", "DEU"}));
		cbx_Nacionalidad.setBounds(121, 279, 209, 22);
		contentPanel.add(cbx_Nacionalidad);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(38, 343, 69, 16);
		contentPanel.add(lblDireccion);
		
		txt_Direccion = new JTextField();
		txt_Direccion.setColumns(10);
		txt_Direccion.setBounds(121, 340, 549, 22);
		contentPanel.add(txt_Direccion);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				if(matricula != null)
					okButton.setText("Modificar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(matricula != null) {
							String[] columnas = {"Nombre1", "Nombre2", "Apellido1", "Apellido2", "Carrera", "CategoriaPago", "Nacionalidad", "Direccion"};
							String[] valores = {txt_primerNombre.getText(), txt_segundoNombre.getText(),
									txt_primerApellido.getText(), txt_segundoApellido.getText(),
									(String)cbx_Carrera.getSelectedItem(), (String)cbx_Pago.getSelectedItem(),
									(String)cbx_Nacionalidad.getSelectedItem(), txt_Direccion.getText()};
							String[] Pks = {"Matricula"};
							String[] valoresPks = {txt_matricula.getText()};
							ConexionDB.updateTabla("Estudiante", columnas, valores, 8, Pks, valoresPks, 1);						
							dispose();
						}else {	
							
							if (txt_matricula.getText().length() != 8) {
								JOptionPane.showMessageDialog(null,"Ha ingresado una matricula invalida","Error",JOptionPane.ERROR_MESSAGE);
							}else {
								
								String[] valores = {txt_matricula.getText(), txt_primerNombre.getText(), txt_segundoNombre.getText(),
										txt_primerApellido.getText(), txt_segundoApellido.getText(),
										(String)cbx_Carrera.getSelectedItem(), (String)cbx_Pago.getSelectedItem(),
										(String)cbx_Nacionalidad.getSelectedItem(), txt_Direccion.getText()};
								
								ConexionDB.agregarFilaTabla("Estudiante", valores, 9);
								limpiarCampos();
								
							}
						}
					}
				});
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
		establecerCampos(matricula);
	}
	
	private void limpiarCampos() {
		txt_matricula.setText("");
		txt_primerNombre.setText("");
		txt_segundoNombre.setText("");
		txt_primerApellido.setText("");
		txt_segundoApellido.setText("");
		txt_Direccion.setText("");
		cbx_Carrera.setSelectedIndex(0);
		cbx_Nacionalidad.setSelectedIndex(0);
		cbx_Pago.setSelectedIndex(0);
	}
	
	private void establecerCampos(String matricula) {
		if(matricula == null)
			return;
		try {
			String[] pkNombres = {"Matricula"};
			String[] pkValores = {matricula};
			ResultSet rs = ConexionDB.buscarFilasTabla("Estudiante", pkNombres, pkValores, 1);
			rs.next();
			txt_matricula.setText(matricula);
			txt_matricula.setEnabled(false);
			txt_primerNombre.setText(rs.getString("Nombre1"));
			txt_segundoNombre.setText(rs.getString("Nombre2"));
			txt_primerApellido.setText(rs.getString("Apellido1"));
			txt_segundoApellido.setText(rs.getString("Apellido2"));
			txt_Direccion.setText(rs.getString("Direccion"));
			
			String item;
			for(int i = 0; i < cbx_Carrera.getModel().getSize(); i++) {
				item = (String)cbx_Carrera.getModel().getElementAt(i);
				if(item.equalsIgnoreCase(rs.getString("Carrera"))) {
					cbx_Carrera.setSelectedIndex(i);
					break;
				}
			}
			
			for(int i = 0; i < cbx_Nacionalidad.getModel().getSize(); i++) {
				item = (String)cbx_Nacionalidad.getModel().getElementAt(i);
				if(item.equalsIgnoreCase(rs.getString("Nacionalidad"))) {
					cbx_Nacionalidad.setSelectedIndex(i);
					break;
				}
			}
			
			for(int i = 0; i < cbx_Pago.getModel().getSize(); i++) {
				item = (String)cbx_Pago.getModel().getElementAt(i);
				if(item.equalsIgnoreCase(rs.getString("CategoriaPago"))) {
					cbx_Pago.setSelectedIndex(i);
					break;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
