package logico;

import java.util.ArrayList;

public class Academica {

	private ArrayList<Asignatura> asignaturas;
	private ArrayList<Grupo> grupos;
	private ArrayList<GrupoHorario> grupoHorarios;
	private ArrayList<PeriodoAcademico> periodoAcademicos;
	private ArrayList<Inscripcion> inscripciones;
	private ArrayList<DiaSemana> diasSemana;
	private ArrayList<Estudiante> estudiantes;
	private static Academica academica = null;
	
	
	public static Academica getAcademica() {
		if (academica == null) {
			academica = new Academica();
		}
		return academica;
	}

	private Academica() {
		super();
		asignaturas = new ArrayList<Asignatura>();
		grupos = new ArrayList<Grupo>();
		grupoHorarios = new ArrayList<GrupoHorario>();
		periodoAcademicos = new ArrayList<PeriodoAcademico>();
		estudiantes = new ArrayList<Estudiante>();
		inscripciones = new ArrayList<Inscripcion>();
		diasSemana = new ArrayList<DiaSemana>();
	}
	
}
