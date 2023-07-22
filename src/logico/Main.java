package logico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.ConexionDB;

public class Main {

	public static void main(String[] args) {
		String nombreTabla = "Estudiante";
		int cantColumns = 8;
		String[] columnas = {"Nombre1", "Nombre2", "Apellido1", "Apellido2", "Carrera", "CategoriaPago", "Nacionalidad", "Direccion"};
		String[] valores = {"Cristopher", "Edward", "Nolan", "Tav", "COM", "V", "GBR", "Padre las Casas, Santiago, Rep. Dom"};
		
		
		String sql = "UPDATE "+nombreTabla+" SET ";
		for(int i = 0; i < cantColumns; i++) {
			sql += columnas[i]+" = "+ "'"+valores[i]+"'";
			if(i != cantColumns-1) {
				sql+= ", ";
			}
		}
		int cantPk = 1;
		String[] Pks = {"Matricula"};
		String[] valoresPks = {"10304050"};
		sql += " WHERE ";
		for(int j = 0; j < cantPk; j++) {
			sql+= Pks[j]+" = "+ "'"+valoresPks[j]+"'";
			if(j != cantPk-1) {
				sql+= " AND ";
			}
		}

		System.out.println(sql);
	}
}
