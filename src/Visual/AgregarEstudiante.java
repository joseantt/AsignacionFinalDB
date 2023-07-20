package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class AgregarEstudiante {

	private JFrame frmAgregarEstudiante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEstudiante window = new AgregarEstudiante();
					window.frmAgregarEstudiante.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarEstudiante() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarEstudiante = new JFrame();
		frmAgregarEstudiante.setTitle("Agregar Estudiante");
		frmAgregarEstudiante.setBounds(100, 100, 450, 300);
		frmAgregarEstudiante.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frmAgregarEstudiante.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
