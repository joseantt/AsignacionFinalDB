package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
	
	public static Connection conectarDB() {
	
		String url = "jdbc:sqlserver://LAPTOP-M7KGMKK3\\RGSMSSQL;"
				+ "Database=RegistroAcademico;"
				+ "IntegratedSecurity=false;"
				+ "TrustServerCertificate=True;";
		
		String user = "general";
		String pwd = "54321";
		
		try {
            Connection conexion = DriverManager.getConnection(url,user,pwd);
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
	    StringBuilder sql = new StringBuilder("INSERT ").append(nombreTabla).append(" VALUES (");

	    for (int i = 0; i < cantCampos; i++) {
	        sql.append("'").append(valores[i]).append("'");
	        if (i != cantCampos - 1) {
	            sql.append(',');
	        }
	    }
	    sql.append(')');

	    return sql.toString();
	}
	
	public static ResultSet buscarFilasTabla(String nombreTabla, String[] pkNombres, String[] pkValores, int cantElementosPk) {
		try {
			Connection conexion = conectarDB();
			String sql = queryBuscar(nombreTabla, pkNombres, pkValores, cantElementosPk);
			PreparedStatement p = conexion.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			return rs;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String queryBuscar(String nombreTabla, String[] pkNombres, String[] pkValores, int cantElementosPk) {
	    StringBuilder sql = new StringBuilder("SELECT * FROM ").append(nombreTabla).append(" WHERE ");
	    for (int i = 0; i < cantElementosPk; i++) {
	        sql.append(nombreTabla).append('.').append(pkNombres[i]).append(" = ").append("'").append(pkValores[i]).append("'");
	        if (i != cantElementosPk - 1) {
	            sql.append(" AND ");
	        }
	    }

	    return sql.toString();
	}
	
	public static void updateTabla(String nombreTabla, String[]columnas, String[] valores, int cantColumns, String[]Pks, String[] valoresPks, int cantPk) {
		try {
			Connection conexion = ConexionDB.conectarDB();
			
			String sql = queryUpdate(nombreTabla, columnas, valores, cantColumns, Pks, valoresPks, cantPk);
			Statement stm = conexion.createStatement();
			int result = stm.executeUpdate(sql);
			
			//Hacer limitacion para ete diparate
			
			conexion.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static String queryUpdate(String nombreTabla, String[] columnas, String[] valores, int cantColumns, String[] Pks, String[] valoresPks, int cantPk) {
	    StringBuilder sql = new StringBuilder("UPDATE ").append(nombreTabla).append(" SET ");
	    for (int i = 0; i < cantColumns; i++) {
	        sql.append(columnas[i]).append(" = ").append("'").append(valores[i]).append("'");
	        if (i != cantColumns - 1) {
	            sql.append(", ");
	        }
	    }

	    sql.append(" WHERE ");
	    for (int j = 0; j < cantPk; j++) {
	        sql.append(Pks[j]).append(" = ").append("'").append(valoresPks[j]).append("'");
	        if (j != cantPk - 1) {
	            sql.append(" AND ");
	        }
	    }

	    return sql.toString();
	}
}
