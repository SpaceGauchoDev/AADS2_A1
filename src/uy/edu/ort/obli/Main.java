package uy.edu.ort.obli;
import util.*;

class Main {
	
	public static void main(String args[]){ 
		ABB arbol = new ABB(Enums.Dir.Descendente);
		//ABB arbol = new ABB(Enums.Dir.Ascendente);
		
		arbol.InsertarNodo(arbol.raiz, "AAA1111", "ManuelD");
		arbol.InsertarNodo(arbol.raiz, "AAA1112", "Seba");
		arbol.InsertarNodo(arbol.raiz, "AAA2111", "ManuelA");
		
		I.Log(arbol.InicioImprimirInOrder());
		/*arbol.InicioBuscar("AAA1112");*/
		/*
		Retorno test = arbol.InicioBuscarConIteraciones("AAA2111");
		
		if(test.resultado == Retorno.Resultado.OK) {
			I.Log("Lo encontró.");
			I.Log("Numero de iteraciones: " + test.valorEntero);
			I.Log("Nombre: " + test.valorString);
		}
		if(test.resultado == Retorno.Resultado.ERROR_1) {
			I.Log("Error de formato");
		}
		if(test.resultado == Retorno.Resultado.ERROR_2) {
			I.Log("No lo encontro");
		}
		 */
		
	}
	
	
	 
	

}
