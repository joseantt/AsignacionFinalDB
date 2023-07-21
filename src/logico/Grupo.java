package logico;

public class Grupo {

	private String codPeriodoActural;
	private String codAsignatura;
	private String numGrupo;
	private int cupoGrupo;
	private String horario;
	
	
	
	public String getCodPeriodoActural() {
		return codPeriodoActural;
	}



	public void setCodPeriodoActural(String codPeriodoActural) {
		this.codPeriodoActural = codPeriodoActural;
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



	public int getCupoGrupo() {
		return cupoGrupo;
	}



	public void setCupoGrupo(int cupoGrupo) {
		this.cupoGrupo = cupoGrupo;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	public Grupo(String codPeriodoActural, String codAsignatura, String numGrupo, int cupoGrupo, String horario) {
		super();
		this.codPeriodoActural = codPeriodoActural;
		this.codAsignatura = codAsignatura;
		this.numGrupo = numGrupo;
		this.cupoGrupo = cupoGrupo;
		this.horario = horario;
	}
	
	
}
