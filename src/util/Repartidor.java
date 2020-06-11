package util;

public class Repartidor {
	public String nombre; 
	public String matricula;
	
	public static boolean MatriculaValida(String pMatricula) {
		return (pMatricula.matches("[A-Z]{3}[0-9]{4}"));
	}
	
	public Repartidor(String pMatricula, String pNombre) {
		matricula = pMatricula;
		nombre = pNombre;
	}
}
