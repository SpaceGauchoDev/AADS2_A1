package util;

public class NodoListaSimple {
	public int dato;
	public NodoListaSimple siguiente;
	
	public NodoListaSimple(){
		dato = 0;
		siguiente = null;
	}
	
	public NodoListaSimple(int pDato){
		dato = pDato;
		siguiente = null;		
	}
	
	public  NodoListaSimple(int pDato, NodoListaSimple pSiguiente){
		dato = pDato;
		siguiente = pSiguiente;
	}
}
