package uy.edu.ort.obli;
import util.*;

class Main 
{
	
	public static void main(String args[]) 
	{ 
		ListaSimple lista = new ListaSimple();
		
		lista.InsertarNodoAlFinal(33);
		lista.InsertarNodoAlFinal(2);
		lista.InsertarNodoAlFinal(77);
		lista.InsertarNodoAlFinal(-15);
		lista.InsertarNodoAlFinal(73);
		lista.InsertarNodoAlFinal(-5);
		lista.InsertarNodoAlFinal(3);
		lista.InsertarNodoAlFinal(18);
		lista.InsertarNodoAlFinal(99);
		lista.InsertarNodoAlFinal(92);
		lista.InsertarNodoAlFinal(2879);
		lista.InsertarNodoAlFinal(4554);
		lista.InsertarNodoAlFinal(78);
		
		lista.ImprimirListaAscendente();
		lista.OrdenarListaAscendente();
		lista.ImprimirListaAscendente();
		
	}
	
	
	 
	

}
