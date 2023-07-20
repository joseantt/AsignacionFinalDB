package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AgregarEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarEstudiante dialog = new AgregarEstudiante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarEstudiante() {
		setTitle("Agregar estudiante");
		setBounds(100, 100, 749, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setBounds(38, 41, 77, 16);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(121, 38, 209, 22);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Primer Nombre:");
		lblNombre.setBounds(38, 101, 100, 16);
		contentPanel.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 98, 180, 22);
		contentPanel.add(textField_1);
		
		JLabel lblSegundoNombre = new JLabel("Segundo Nombre:");
		lblSegundoNombre.setBounds(367, 104, 111, 16);
		contentPanel.add(lblSegundoNombre);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(490, 101, 180, 22);
		contentPanel.add(textField_2);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		lblPrimerApellido.setBounds(38, 146, 100, 16);
		contentPanel.add(lblPrimerApellido);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 143, 180, 22);
		contentPanel.add(textField_3);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setBounds(367, 149, 111, 16);
		contentPanel.add(lblSegundoApellido);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(490, 146, 180, 22);
		contentPanel.add(textField_4);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(38, 227, 69, 16);
		contentPanel.add(lblCarrera);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(121, 227, 209, 22);
		contentPanel.add(comboBox);
		
		JLabel lblCategoriaDePago = new JLabel("Categoria de pago:");
		lblCategoriaDePago.setBounds(367, 279, 123, 16);
		contentPanel.add(lblCategoriaDePago);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(490, 276, 180, 22);
		contentPanel.add(comboBox_1);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(38, 282, 100, 16);
		contentPanel.add(lblNacionalidad);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(121, 279, 209, 22);
		contentPanel.add(comboBox_2);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(38, 343, 69, 16);
		contentPanel.add(lblDireccion);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(121, 340, 549, 22);
		contentPanel.add(textField_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
