package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Universidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		setSize(dim.width-20, dim.height-70);
		setLocationRelativeTo(null); 
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Estudiante");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Visualizar listado");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEstudiantes ListadoE = new ListadoEstudiantes();
				ListadoE.setVisible(true);
				ListadoE.setModal(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agregar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarEstudiante agregarEstudiante = new AgregarEstudiante(null);
				agregarEstudiante.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Horario");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Asignatura");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Visualizar listado");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoAsignaturas asignaturas = new ListadoAsignaturas(null);
				asignaturas.setVisible(true);
				asignaturas.setModal(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Agregar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarAsignatura agregarAsignatura = new AgregarAsignatura(null);
				agregarAsignatura.setVisible(true);
				agregarAsignatura.setModal(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Grupo");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Visualizar listado");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoGrupo listadoGrupo = new ListadoGrupo(null);
				listadoGrupo.setVisible(true);
				listadoGrupo.setModal(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Agregar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grupo grupo = new Grupo();
				grupo.setVisible(true);
				grupo.setModal(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_3 = new JMenu("Periodo Acad\u00E9mico");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmVi = new JMenuItem("Visualizar listado");
		mntmVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPeriodosAcademicos periodosAcademicos = new ListadoPeriodosAcademicos(null);
				periodosAcademicos.setVisible(true);
				periodosAcademicos.setModal(true);
			}
		});
		mnNewMenu_3.add(mntmVi);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Agregar");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarPeriodoAcademico agregarPeriodoAcademico = new AgregarPeriodoAcademico();
				agregarPeriodoAcademico.setVisible(true);
				agregarPeriodoAcademico.setModal(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);

		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
