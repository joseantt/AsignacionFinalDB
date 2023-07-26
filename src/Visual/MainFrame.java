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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de estudiantes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoEstudiantes ListadoE = new ListadoEstudiantes();
				ListadoE.setVisible(true);
				ListadoE.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agregar estudiante");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarEstudiante agregarEstudiante = new AgregarEstudiante(null);
				agregarEstudiante.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Horario de estudiante");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarEstudiante buscarEstudiante = new BuscarEstudiante(null);
				buscarEstudiante.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Grupos Inscritos por estudiante");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarEstudiante buscarEstudiante = new BuscarEstudiante("Inscripciones");
				buscarEstudiante.setLocationRelativeTo(null);
				buscarEstudiante.setVisible(true);
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("Inscripci\u00F3n");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Listado inscripciones");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoInscripcion ListInsc = new ListadoInscripcion();
				ListInsc.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Inscribir estudiante");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscripcion insc = new Inscripcion();
				insc.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("Asignatura");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Listado de asignaturas");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoAsignaturas asignaturas = new ListadoAsignaturas(null);
				asignaturas.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Agregar asignatura");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarAsignatura agregarAsignatura = new AgregarAsignatura(null);
				agregarAsignatura.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("Grupo");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Listado de grupos");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoGrupo listadoGrupo = new ListadoGrupo(null);
				listadoGrupo.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Agregar grupo");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grupo grupo = new Grupo(null,null,null);
				grupo.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado de horarios");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoGrupoHorario listGrupoHorario = new ListadoGrupoHorario(null);
				listGrupoHorario.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Agregar horario a grupo");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupoHorario gH = new GrupoHorario(null, null, null);
				gH.setVisible(true);
			
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Periodo Acad\u00E9mico");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmVi = new JMenuItem("Listado periodo acad\u00E9mico");
		mntmVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPeriodosAcademicos periodosAcademicos = new ListadoPeriodosAcademicos(null);
				periodosAcademicos.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmVi);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Agregar periodo acad\u00E9mico");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarPeriodoAcademico agregarPeriodoAcademico = new AgregarPeriodoAcademico();
				agregarPeriodoAcademico.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);

		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
