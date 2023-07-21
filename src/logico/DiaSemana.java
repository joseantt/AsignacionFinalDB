package logico;

public class DiaSemana {

	private int dia;
	private String nombre;
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DiaSemana(int dia, String nombre) {
		super();
		this.dia = dia;
		this.nombre = nombre;
	}
	
	
}
