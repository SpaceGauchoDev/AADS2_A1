package util;
import uy.edu.ort.obli.EnumCriticidad;

public class VerticeGrafo {
	public double x;
	public double y;
	public int indice;
	public String nombre;
	public Enums.TipoDePunto tipo;
	public EnumCriticidad crit; 
	
	public VerticeGrafo(){
		x = 0;
		y = 0;
		indice = 0;
		nombre = "";
		tipo = Enums.TipoDePunto.SinConfigurar;
	}
	
	public VerticeGrafo(double pX, double pY, int pIndice, Enums.TipoDePunto pTipoDePunto, EnumCriticidad pCrit, String pNombre){
		x = pX;
		y = pY;
		indice = pIndice;
		tipo = pTipoDePunto;
		crit = pCrit;
		nombre = pNombre;
	}
}
