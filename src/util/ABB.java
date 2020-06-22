package util;

public class ABB {
	public NodoABB raiz;
	Enums.Dir direccion;
	
	// Iniciar la recursión de la recorrida InOrder 
    public void InicioRecorridoInOrder(){
    	if(raiz != null) {
    		RecorridoInOrder(raiz);	
    	}
    }
    
	// Recorre InOrder recursivamente    
    void RecorridoInOrder(NodoABB pNodo){
    	// si el nodo pasado por parametro es nulo, no tiene datos y terminamos
        if (pNodo == null) {
        	return;
        } 
  
        RecorridoInOrder(pNodo.izq); 
        I.Log(pNodo.dato.matricula + " ");
        RecorridoInOrder(pNodo.der); 
    } 
    
    
	// Iniciar la recursión de la impresion InOrder 
    public String InicioImprimirInOrder(){
    	
    	String resultado = "";
    	ListaSimple lista = new ListaSimple();
    	
    	if(raiz != null) {
    		lista = ListarInOrder(raiz, lista);	
    	}
    	
    	resultado = lista.ConcatenarLista();
    	
    	return resultado;
    }
    
	// Imprime InOrder recursivamente    
    ListaSimple ListarInOrder(NodoABB pNodo, ListaSimple pLista){
    	if (pNodo != null) {
            ListarInOrder(pNodo.izq, pLista); 
            pLista.InsertarNodoAlFinal(pNodo.dato.matricula + ";" + pNodo.dato.nombre); 
            ListarInOrder(pNodo.der, pLista);
    	}
    	return pLista;
   } 
    
    /*
	// Iniciar la recursión de la insercion de un nodo
    public int InicioInsertar(String pMatricula, String pNombre){
    	int resultado;
    	
    	// valido la matricula
    	if(!Repartidor.MatriculaValida(pMatricula)) {
    		resultado = 1;
    	}
    	
    	// me fijo que el repartidor no esté ingresado ya en el sistema
    	else if(null != Buscar(raiz,pMatricula)) {
    		resultado = 2;
    	}
		// todo bien, podemos insertar nuevo nodo    	
    	else {
    		raiz = InsertarNodo(raiz, pMatricula, pNombre);
    		resultado = 0;
    	}
    	
    	return resultado;
    }
    */
	
	// Inserta nodo recursivamente	
    public NodoABB InsertarNodo(NodoABB pNodo, String pMatricula, String pNombre){ 
    	// si el nodo o sub arbol es vacío, creamos un nuevo nodo, lo insertamos como raiz y lo devolvemos
        if (pNodo == null) { 
        	pNodo = new NodoABB(pMatricula, pNombre);
            return pNodo; 
        }
  
        ABC comparador = new ABC();
        int comparacionAlfabetica = comparador.compararStrings(pMatricula, pNodo.dato.matricula, direccion);
        
        if (comparacionAlfabetica < 0) { 
        	pNodo.izq = InsertarNodo(pNodo.izq, pMatricula, pNombre);
        } else { 
        	pNodo.der = InsertarNodo(pNodo.der, pMatricula, pNombre); 
        }
        
        return pNodo; 
    }
    
    /*
    public Retorno InicioBuscar(String pMatricula) {
    	Retorno salida = new Retorno(Resultado.NO_IMPLEMENTADA);
    	
    	if(!Repartidor.MatriculaValida(pMatricula)) {
    		
    		// matricula invalida
    		salida.resultado = Resultado.ERROR_1;
    	}else {
    		NodoABB repartidorBuscado = Buscar(raiz,pMatricula);
    		if (repartidorBuscado == null) {

    			// matricula no existe en el sistema
    			salida.resultado = Resultado.ERROR_2;
    		}else {
    			
    			// encontramos repartidor
    			salida.resultado = Resultado.OK;
    			salida.valorString = repartidorBuscado.dato.matricula + ";" + repartidorBuscado.dato.nombre;
    		}
    	}
    	
    	return salida;
    }
    */
    
    public NodoABB Buscar(NodoABB pNodo, String pMatricula) {
 
        if (pNodo == null || pNodo.dato.matricula == pMatricula) {
        	return pNodo;
        } 

        ABC comparador = new ABC();
        int comparacionAlfabetica = comparador.compararStrings(pMatricula, pNodo.dato.matricula, direccion);
        
        if (comparacionAlfabetica < 0) {
        	return Buscar(pNodo.izq, pMatricula);
        }else {
        	return Buscar(pNodo.der, pMatricula);	
        }
        
    }
    
    /*
    public Retorno InicioBuscarConIteraciones(String pMatricula) {
    	Retorno salida = new Retorno(Resultado.NO_IMPLEMENTADA);
    	
    	if(!Repartidor.MatriculaValida(pMatricula)) {
    		
    		// matricula invalida
    		salida.resultado = Resultado.ERROR_1;
    	}else {
    		
    		NodoABB_Iteraciones inicioBusqueda = new NodoABB_Iteraciones(raiz, 0);
    		NodoABB_Iteraciones repartidorBuscado = BuscarConIteraciones(inicioBusqueda, pMatricula);
    		if (repartidorBuscado.nodo == null) {

    			// matricula no existe en el sistema
    			salida.resultado = Resultado.ERROR_2;
    		}else {
    			
    			// encontramos repartidor
    			salida.resultado = Resultado.OK;
    			salida.valorString = repartidorBuscado.nodo.dato.matricula + ";" + repartidorBuscado.nodo.dato.nombre;
    			salida.valorEntero = repartidorBuscado.iteraciones;
    		}
    	}
    	
    	return salida;
    } 
    */   
    
    public NodoABB_Iteraciones BuscarConIteraciones(NodoABB_Iteraciones pNodoI, String pMatricula) {
    	 
        if (pNodoI.nodo == null || pNodoI.nodo.dato.matricula == pMatricula) {
        	return pNodoI;
        }
        
        ABC comparador = new ABC();
        int comparacionAlfabetica = comparador.compararStrings(pMatricula, pNodoI.nodo.dato.matricula, direccion);
        
        if (comparacionAlfabetica < 0) {
        	NodoABB_Iteraciones busquedaIzq = new NodoABB_Iteraciones(pNodoI.nodo.izq, pNodoI.iteraciones+1);
        	return BuscarConIteraciones(busquedaIzq, pMatricula);
        }else {
        	NodoABB_Iteraciones busquedaDer = new NodoABB_Iteraciones(pNodoI.nodo.der, pNodoI.iteraciones+1);
        	return BuscarConIteraciones(busquedaDer, pMatricula);
        }
    }
    
    public void BorrarArbol() {
		raiz = null;
    }
	
	public ABB(Enums.Dir pDir){
		direccion = pDir;
		raiz = null;
	}
}
