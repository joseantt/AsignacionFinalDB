package logico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.ConexionDB;

public class Main {

	public static void main(String[] args) {
		int cantCampos = 5;
		String[] valores = {"Jose", "Antonio", "Taveras", "Abreu", "ICC"};
		String NombreTabla = "Estudiante";
		String sql = "INSERT "+ NombreTabla +" VALUES (";
		for(int i = 0; i < cantCampos; i++) {
			sql += "'"+valores[i]+"'";
			if(i != cantCampos-1) {
				sql += ',';
			}
		}
		sql += ')';
		
		System.out.println(sql);
	}
}
