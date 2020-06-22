package util;

public class NodoListaSimple {
	public String dato;
	public AristaGrafo arista;
	public NodoListaSimple siguiente;
	
	// vacio
	public NodoListaSimple(){
		dato = "";
		siguiente = null;
		arista = null;
	}
	
	// para datos tipo texto
	public NodoListaSimple(String pDato){
		dato = pDato;
		siguiente = null;
		arista = null;
	}
	
	public  NodoListaSimple(String pDato, NodoListaSimple pSiguiente){
		dato = pDato;
		siguiente = pSiguiente;
		arista = null;
	}
	
	//para datos tipo arista
	public NodoListaSimple(AristaGrafo pArista){
		dato = "";
		arista = pArista;
		siguiente = null;		
	}
	
	//para datos tipo arista
	public NodoListaSimple(AristaGrafo pArista, NodoListaSimple pSiguiente){
		dato = "";
		arista = pArista;
		siguiente = pSiguiente;		
	}
}
