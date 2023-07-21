package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
	
	public static Connection conectarDB() {
	
		String url = "jdbc:sqlserver://LAPTOP-KQA2PJRS;"
				+ "Database=RegistroAcademico;"
				+ "IntegratedSecurity=true;"
				+ "TrustServerCertificate=True;";
		
		try {
            Connection conexion = DriverManager.getConnection(url);
            return conexion;
        }
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("La conexión a la base de datos no pudo ser establecida");
			return null;
		}
	}
	
	public static void agregarFilaTabla(String nombreTabla, String[] valores, int cantCampos) {
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			String sql = queryInsert(nombreTabla, valores, cantCampos);
			Statement stm = conexion.createStatement();
			int result = stm.executeUpdate(sql);
			
			//Hacer limitacion para que no se ingrese un usuario con el mismo ID
			
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static String queryInsert(String nombreTabla, String[] valores, int cantCampos) {
		String sql = "INSERT "+ nombreTabla +" VALUES (";
		
		for(int i = 0; i < cantCampos; i++) {
			sql += "'"+valores[i]+"'";
			if(i != cantCampos-1) {
				sql += ',';
			}
		}
		sql += ')';
		
		return sql;
	} 
}
