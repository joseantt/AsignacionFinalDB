package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public void agregarFilaTabla(String[] valores, int cantCampos) {
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			String sql = "INSERT Estudiante VALUES (";
			for(int i = 0; i < cantCampos; i++) {
				sql += "";
			}
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
