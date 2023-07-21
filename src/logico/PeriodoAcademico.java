package logico;

import java.sql.Date;

public class PeriodoAcademico {

	private String codPeriodoActual;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaInicioClases;
	private Date fechaFinClases;
	private Date fechaLimitePago;
	private Date fechaLimitePrematricula;
	private Date fechaLimiteRetiro;
	private Date fechaLimitePublicacion;
	public String getCodPeriodoActual() {
		return codPeriodoActual;
	}
	public void setCodPeriodoActual(String codPeriodoActual) {
		this.codPeriodoActual = codPeriodoActual;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaInicioClases() {
		return fechaInicioClases;
	}
	public void setFechaInicioClases(Date fechaInicioClases) {
		this.fechaInicioClases = fechaInicioClases;
	}
	public Date getFechaFinClases() {
		return fechaFinClases;
	}
	public void setFechaFinClases(Date fechaFinClases) {
		this.fechaFinClases = fechaFinClases;
	}
	public Date getFechaLimitePago() {
		return fechaLimitePago;
	}
	public void setFechaLimitePago(Date fechaLimitePago) {
		this.fechaLimitePago = fechaLimitePago;
	}
	public Date getFechaLimitePrematricula() {
		return fechaLimitePrematricula;
	}
	public void setFechaLimitePrematricula(Date fechaLimitePrematricula) {
		this.fechaLimitePrematricula = fechaLimitePrematricula;
	}
	public Date getFechaLimiteRetiro() {
		return fechaLimiteRetiro;
	}
	public void setFechaLimiteRetiro(Date fechaLimiteRetiro) {
		this.fechaLimiteRetiro = fechaLimiteRetiro;
	}
	public Date getFechaLimitePublicacion() {
		return fechaLimitePublicacion;
	}
	public void setFechaLimitePublicacion(Date fechaLimitePublicacion) {
		this.fechaLimitePublicacion = fechaLimitePublicacion;
	}
	
	public PeriodoAcademico(String codPeriodoActual, String descripcion, Date fechaInicio, Date fechaFin,
			Date fechaInicioClases, Date fechaFinClases, Date fechaLimitePago, Date fechaLimitePrematricula,
			Date fechaLimiteRetiro, Date fechaLimitePublicacion) {
		super();
		this.codPeriodoActual = codPeriodoActual;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaInicioClases = fechaInicioClases;
		this.fechaFinClases = fechaFinClases;
		this.fechaLimitePago = fechaLimitePago;
		this.fechaLimitePrematricula = fechaLimitePrematricula;
		this.fechaLimiteRetiro = fechaLimiteRetiro;
		this.fechaLimitePublicacion = fechaLimitePublicacion;
	}
	
	
}
