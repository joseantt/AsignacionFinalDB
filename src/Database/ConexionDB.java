package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	
	public static Connection conectarDB() {
	
		String url = "jdbc:sqlserver://LAPTOP-KQA2PJRS;"
				+ "Database=RegistroAcademico;"
				+ "IntegratedSecurity=true;"
				+ "TrustServerCertificate=True;";
		
		try {
			try(Connection connection = DriverManager.getConnection(url)){
				return connection;
			}
		} catch (SQLException e) {
			System.out.println("Error al conectar la base de datos.");
			e.printStackTrace();
			
			return null;
		}
	}
	
}
