package logico;

import java.sql.Date;

public class GrupoHorario {

	private String codPeriodoActual;
	private String codAsignatura;
	private String numGrupo;
	private int dia;
	private Date fechaInicial;
	private Date fechaFinal;
	
	
	public String getCodPeriodoActual() {
		return codPeriodoActual;
	}


	public void setCodPeriodoActual(String codPeriodoActual) {
		this.codPeriodoActual = codPeriodoActual;
	}


	public String getCodAsignatura() {
		return codAsignatura;
	}


	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}


	public String getNumGrupo() {
		return numGrupo;
	}


	public void setNumGrupo(String numGrupo) {
		this.numGrupo = numGrupo;
	}


	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}


	public Date getFechaInicial() {
		return fechaInicial;
	}


	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}


	public Date getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public GrupoHorario(String codPeriodoActual, String codAsignatura, String numGrupo, int dia, Date fechaInicial,
			Date fechaFinal) {
		super();
		this.codPeriodoActual = codPeriodoActual;
		this.codAsignatura = codAsignatura;
		this.numGrupo = numGrupo;
		this.dia = dia;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}
	
	
}
