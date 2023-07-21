package logico;

public class Inscripcion {

	private String codPeriodoAcad;
	private String matricula;
	private String codAsignatura;
	private String numGrupo;
	
	public String getCodPeriodoAcad() {
		return codPeriodoAcad;
	}
	public void setCodPeriodoAcad(String codPeriodoAcad) {
		this.codPeriodoAcad = codPeriodoAcad;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	
	public Inscripcion(String codPeriodoAcad, String matricula, String codAsignatura, String numGrupo) {
		super();
		this.codPeriodoAcad = codPeriodoAcad;
		this.matricula = matricula;
		this.codAsignatura = codAsignatura;
		this.numGrupo = numGrupo;
	}
	
	
}
