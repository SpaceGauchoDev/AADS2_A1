package util;

public class ListaSimple {
	NodoListaSimple inicio;
	int largo;
	
	// obtener nodo de primer instancia del dato en la lista
	// param dato
	
	// borrar nodo en pos
	// param pos
	
	// get largo de la lista
	public int ObtenerLargo() {
		return largo;
	}
	
	public NodoListaSimple ObtenerInicio() {
		return inicio;
	}
	
	// imprimir datos lista en orden ascendente
	public void ImprimirListaAscendente() {
		if(largo == 0) {
			I.Log("Lista vacía.");
		}else {
			NodoListaSimple nodoBuscador = inicio;
			StringBuilder s = new StringBuilder();
			s.append(inicio.dato);
			s.append(", ");
			
			while (nodoBuscador.siguiente != null) {
				nodoBuscador = nodoBuscador.siguiente;
				s.append(nodoBuscador.dato);
				
				s.append(", ");
			}
			//borramos el ultimo comaEspacio y agregamos un punto.
			s.delete(s.length() -2 , s.length());
			s.append(".");
			I.Log(s);
		}
	}
	
	
	public String ConcatenarLista() {
		if(largo == 0) {
			return "Lista vacía."; 
		}else {
			NodoListaSimple nodoBuscador = inicio;
			StringBuilder s = new StringBuilder();
			s.append(inicio.dato);
			s.append("|");
			
			while (nodoBuscador.siguiente != null) {
				nodoBuscador = nodoBuscador.siguiente;
				s.append(nodoBuscador.dato);
				
				s.append("|");
			}
			//borramos el ultimo comaEspacio y agregamos un punto.
			s.delete(s.length() -1 , s.length());
			return s.toString();
		}
	}
	
	
	// Obtener nodo
	// param posicion	
	public NodoListaSimple ObtenerNodoEnPosicion(int p) {
		NodoListaSimple resultado;
		
		if(p < 0 || p > largo){
			I.Log("Posición está de fuera de la lista.");
			resultado = null;
		}else {
			if(p == 0) {
				resultado = inicio;
			}else {
				int posicion = 0;
				resultado = inicio;
				
				while (posicion < p) {
					resultado = resultado.siguiente;
					posicion ++;
				}
			}
		}
		
		return resultado;
	}
	
	
	// insertar nodo al final
	// param dato
	public void InsertarNodoAlFinal(String pDato){
		NodoListaSimple nuevoNodo = new NodoListaSimple(pDato);
		
		if (largo == 0) {
			inicio = nuevoNodo;
		}else {
			NodoListaSimple nodoBuscador = inicio;
			while (nodoBuscador.siguiente != null) {
				nodoBuscador = nodoBuscador.siguiente;
			}
			
			nodoBuscador.siguiente = nuevoNodo;
		}
		
		largo++; 
	}
	
	// insertar nodo al final
	// param nodo
	public void InsertarNodoAlFinal(NodoListaSimple n){
		
		if (largo == 0) {
			inicio = n;
		}else {
			NodoListaSimple nodoBuscador = inicio;
			while (nodoBuscador.siguiente != null) {
				nodoBuscador = nodoBuscador.siguiente;
			}
			
			nodoBuscador.siguiente = n;
		}
		
		largo++; 
	}
	
	
	// insertar nodo al inicio
	// param nodo
	public void InsertarNodoAlInicio(NodoListaSimple n){
		if (largo == 0) {
			inicio = n;
		}else {
			NodoListaSimple restoDeLista = inicio;
			inicio = n;
			inicio.siguiente = restoDeLista;
		}
		
		largo++; 
	}
	
	// insertar nodo al inicio
	// param dato
	public void InsertarNodoAlInicio(String p){
		if (largo == 0) {
			inicio = new NodoListaSimple(p);
		}else {
			NodoListaSimple restoDeLista = inicio;
			inicio = new NodoListaSimple(p);
			inicio.siguiente = restoDeLista;
		}
		
		largo++; 
	}		
	
	// inserta un nodo en la posicion indicada, mueve todos los nodos posteriores 
	// param nodo
	public void InsertarNodoEnPos(NodoListaSimple n, int p) {
		if(p >= 0 && n != null) {
			if (largo == 0 && p == 0) {
				InsertarNodoAlFinal(n);
			}else if (p > largo && p > 0) {
				I.Log("Posición de inserción fuera de lista.");
			}else if(p == largo) {
				InsertarNodoAlFinal(n);
			}else if (p == 0) {
				InsertarNodoAlInicio(n);
			}else {
				NodoListaSimple nodoAnterior = inicio;
				int posicion = 0;
				
				while (posicion + 1 < p) {
					nodoAnterior = nodoAnterior.siguiente;
					posicion++; 
				}
				
				NodoListaSimple restoDeLista = nodoAnterior.siguiente;
				nodoAnterior.siguiente = n;
				n.siguiente = restoDeLista;
			}
		}else{
			if(p < 0) {
				I.Log("Posición de inserción negativa inválida.");	
			}
			if (n == null){
				I.Log("Nodo null inválido.");
			}
		}
	}
	
	public void IntercambiarNodosEnPos(int p1, int p2) {
		if(p1 < 0 || p1 > largo || p2 < 0 || p2 > largo){
			I.Log("Al menos una posición está de fuera de la lista.");
		}else {
			if(largo == 0) {
				I.Log("No se puede intercambiar nodos en una lista vacía.");
			}else {
				if( p1 == p2) {
					I.Log("No se puede intercambiar nodos en la misma posición.");
				}else {
					
					// intercambiar las posiciones para que 
					// p1 sea menor que p2
					if (p1 > p2) {
						int temp = p1;
						p1 = p2;
						p2 = temp;
					}
					
					NodoListaSimple  n1		= null;	// nodo 2
					NodoListaSimple  n1S	= null;	// nodo siguiente al nodo 1
					NodoListaSimple  n2A	= null;	// nodo anterior al nodo 1
					NodoListaSimple  n2		= null;	// nodo 2
					NodoListaSimple  n2S	= null;	// nodo siguiente al nodo 2
					NodoListaSimple  n1Old	= null;	// nodo temporal para intercambio de datos
					
					NodoListaSimple nodoBuscador = inicio; 
					int posicion = 0;
					
					while (posicion <= p2) {
						if(posicion == p1) {
							n1 = nodoBuscador;
							n1S = nodoBuscador.siguiente;
							
						}
						
						if(posicion == p2 - 1) {
							n2A = nodoBuscador;
						}
						
						if(posicion == p2) {
							n2 = nodoBuscador;
							n2S = nodoBuscador.siguiente;
						}
						
						nodoBuscador = nodoBuscador.siguiente;
						posicion++;
					}
					
					n1Old = new NodoListaSimple(n1.dato);
					n1.dato = n2.dato;
					n1.siguiente = n1S;
					n2A.siguiente = new NodoListaSimple(n1Old.dato);
					n2A.siguiente.siguiente = n2S;
				}
			}
		}
	}
	
	/*basado en bubble sort*/
	public void OrdenarListaAscendente() {
        // no ordenamos listas chicas
        if(largo == 0 || largo == 1){
            return;
        }
        
        ABC comparador = new ABC();
        /*int comparacionAlfabetica = comparador.compararStrings(pMatricula, pNodo.dato.matricula, direccion);*/
        
        for(int i = 0; i < largo - 1; i++){
            for(int j = 0; j < largo - 1; j++){

            	int comparacion = comparador.compararStrings(ObtenerNodoEnPosicion(j).dato, ObtenerNodoEnPosicion(j+1).dato, Enums.Dir.Ascendente);
            	/*
            	int i1 = ObtenerNodoEnPosicion(j).dato;
            	int i2 = ObtenerNodoEnPosicion(j+1).dato;
            	*/
                if( comparacion < 0){
                	IntercambiarNodosEnPos(j, j+1);
                }
            }
        }
	}
	
	public void OrdenarListaDescendente() {
        // no ordenamos listas chicas
        if(largo == 0 || largo == 1){
            return;
        }
        
        ABC comparador = new ABC();
        
        for(int i = 0; i < largo - 1; i++){
            for(int j = 0; j < largo - 1; j++){

           	
            	int comparacion = comparador.compararStrings(ObtenerNodoEnPosicion(j).dato, ObtenerNodoEnPosicion(j+1).dato, Enums.Dir.Descendente);
            	/*
            	int i1 = ObtenerNodoEnPosicion(j).dato;
            	int i2 = ObtenerNodoEnPosicion(j+1).dato;
            	*/
                if( comparacion < 0){
                	IntercambiarNodosEnPos(j, j+1);
                }
            }
        }
	}
	
	

	// borrar lista
	public void BorrarLista() {
		inicio = null;
		largo = 0;
	}
	
	public ListaSimple(){
		inicio = null;
		largo = 0;
	}
}
