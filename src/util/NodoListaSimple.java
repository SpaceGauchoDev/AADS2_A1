package util;

public class NodoListaSimple {
	public String dato;
	public NodoListaSimple siguiente;
	
	public NodoListaSimple(){
		dato = "";
		siguiente = null;
	}
	
	public NodoListaSimple(String pDato){
		dato = pDato;
		siguiente = null;		
	}
	
	public  NodoListaSimple(String pDato, NodoListaSimple pSiguiente){
		dato = pDato;
		siguiente = pSiguiente;
	}
}
