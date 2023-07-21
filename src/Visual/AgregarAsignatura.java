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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class AgregarAsignatura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JButton btnagregar;
	private String text = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarAsignatura dialog = new AgregarAsignatura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the dialog.
	 */
	public AgregarAsignatura() {
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
			
			txtcodigo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (txtcodigo.getText().length() == 6) {
						btnagregar.setEnabled(true);
					}
				}
			});
			
			
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
			JSpinner spncreditos = new JSpinner();
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
			JSpinner spnteoricas = new JSpinner();
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
			JSpinner spnpracticas = new JSpinner();
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
				btnagregar.setEnabled(false);
				
				btnagregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtcodigo.getText().length() != 6) {
							JOptionPane.showMessageDialog(null,"Ha ingresado un codigo invalido","Error",JOptionPane.INFORMATION_MESSAGE);
						}else {
							
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
	}

}
