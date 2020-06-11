package util;

public class NodoABB {
	//public int dato;
	public Repartidor dato;
	
	public NodoABB izq;
	public NodoABB der;
	
	/*
 	// nodos basado en ints
	// vacio
	public NodoABB(){
		dato = 0;
		izq = null;
		der = null;
	}
	
	// dato
	public NodoABB(int pDato){
		dato = pDato;
		izq = null;
		der = null;
	}

	// dato y nodos
	public NodoABB(int pDato, NodoABB pIzq, NodoABB pDer){
		dato = pDato;
		izq = pIzq;
		der = pDer;
	}
	*/
	
 	// nodo basado en repartidores
	// vacio
	/*
	public NodoABB(){
		dato = new Repartidor();
		izq = null;
		der = null;
	}
	*/
	
	// dato
	public NodoABB(Repartidor pDato){
		dato = pDato;
		izq = null;
		der = null;
	}
	
	// dato y nodos
	public NodoABB(Repartidor pDato, NodoABB pIzq, NodoABB pDer){
		dato = pDato;
		izq = pIzq;
		der = pDer;
	}	
	
	// matricula nombre
	public NodoABB(String pMatricula, String pNombre){
		dato = new Repartidor(pMatricula, pNombre);
		izq = null;
		der = null;
	}
	
	// matricula nombre y nodos
	public NodoABB(String pMatricula, String pNombre, NodoABB pIzq, NodoABB pDer){
		dato = new Repartidor(pMatricula, pNombre);
		izq = pIzq;
		der = pDer;
	}
}
