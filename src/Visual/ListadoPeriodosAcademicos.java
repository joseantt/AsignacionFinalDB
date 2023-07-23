package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConexionDB;
import logico.SelectionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoPeriodosAcademicos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaPeriodos;
	private JButton btneliminar;
	private JButton btnactualizar;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoPeriodosAcademicos dialog = new ListadoPeriodosAcademicos(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoPeriodosAcademicos(SelectionListener listener) {
		setTitle("Listado de periodos acad\u00E9micos");
		setBounds(100, 100, 1022, 496);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					tablaPeriodos = new JTable();
					tablaPeriodos.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (tablaPeriodos.getSelectedRow() >= 0) {
								btneliminar.setEnabled(true);
							}
						}
					});
					tablaPeriodos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String[] columnas = {"CodPeriodoAcad", "Descripcion", "FechaInicio", "FehcaFin", "FechaInicioClases",
							"FechaFinClases", "FechaLimitePago", "FechaLimitePrematricula", "FechaLimiteRetiro", "FechaLimitePublicacion"};
					model = (DefaultTableModel) tablaPeriodos.getModel();
					model.setColumnIdentifiers(columnas);
					actualizarFilasPeriodoAcad(model);
					scrollPane.setViewportView(tablaPeriodos);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					btneliminar = new JButton("Eliminar");
					btneliminar.setEnabled(false);
					btneliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int selectedrow = tablaPeriodos.getSelectedRow();
							if (listener != null) {
								Object value = tablaPeriodos.getValueAt(selectedrow, 0);
								listener.setValorSeleccionado(value,"periodo academico");
								dispose();
							}else {
								
							}
						}
					});
					{
						btnactualizar = new JButton("Actualizar");
						btnactualizar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actualizarFilasPeriodoAcad(model);
								btneliminar.setEnabled(false);
							}
						});
						buttonPane.add(btnactualizar);
					}
					buttonPane.add(btneliminar);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if (listener != null) {
			btneliminar.setText("Seleccionar");
		}
	}
	
	
	private void actualizarFilasPeriodoAcad(DefaultTableModel model) {
		Connection conexion = ConexionDB.conectarDB();
		model.setRowCount(0);
		try {
			String sql = "SELECT * FROM PeriodoAcademico";
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
	            String[] fila = {rs.getString("CodPeriodoAcad"), rs.getString("Descripcion"), rs.getString("FechaInicio"),
	            		rs.getString("FehcaFin"), rs.getString("FechaInicioClases"), rs.getString("FechaFinClases"),
	            		rs.getString("FechaLimitePago"), rs.getString("FechaLimitePrematricula"),
	            		rs.getString("FechaLimiteRetiro"), rs.getString("FechaLimitePublicacion")};
	            model.addRow(fila);
	        }
			p.close();
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}
