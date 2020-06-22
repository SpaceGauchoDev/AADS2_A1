package util;
import uy.edu.ort.obli.EnumCriticidad;

// lista de adjacencia ponderada 
public class Grafo {
	
	public int cantidadDeVertices;
	public int verticesInicializados;
	VerticeGrafo[] vertices;
	ListaSimple[] aristasPorVertice;
	
	VerticeGrafo verticeInicioTemp;
	VerticeGrafo verticeFinTemp;
	boolean aristasEncontradas;
	

	void BorrarVerticesTemporales() {
		verticeInicioTemp = null;
		verticeFinTemp = null;
		aristasEncontradas = false;
	}
	
	public boolean ExistenParDeVerticesInicializados(double pXI, double pYI, double pXF, double pYF) {
		BorrarVerticesTemporales();
		boolean resultado = false;
		
		// esta busqueda se hara siempre que estamos por InizializarArista, por lo que si nos cacheamos
		// las aristas encontradas, nos ahorramos dos busquedas
		verticeInicioTemp = BuscarVerticeInicializado(pXI, pYI); 
		verticeFinTemp = BuscarVerticeInicializado(pXF, pYF); 
		
		if( verticeInicioTemp != null &&  verticeFinTemp != null) {
			resultado = true;
			aristasEncontradas = true;
		}
		
		// en caso de que una no halla sido encontrada, liberamos la memoria de las dos porque no seran usadas
		// en un InizializarArista
		if(resultado == false) {
			BorrarVerticesTemporales();
		}
		
		return resultado;
	}
	
	// busco ambos ida y vuelta por la construccion del grafo no dirigido
	public boolean ExisteArista(double pXI, double pYI, double pXF, double pYF) {

		boolean encontroAristaIda = false;
		boolean encontroAristaVuelta= false;
		
		for (int i = 0; i < verticesInicializados; i++) {
			ListaSimple lista = aristasPorVertice[i];
			if(lista != null) {
				if (lista.ObtenerDatoArista(pXI, pYI, pXF, pYF) != null) {
					encontroAristaIda = true;
				}
				
				if (lista.ObtenerDatoArista(pXF, pYF, pXI, pYI) != null) {
					encontroAristaVuelta = true;
				}
				
				if(encontroAristaIda && encontroAristaVuelta) {
					break;
				}
			}
		}
		
		return (encontroAristaIda && encontroAristaVuelta);
	}
	
	
	// muy importante!
	// solo debe ser llamada despues que ExistenParDeVerticesInicializados halla dado positivo! 
	// los vertices temporales deben ser borrados al fin de esta ejecucion 
	public boolean InicializarArista(double pXI, double pYI, double pXF, double pYF, int pMetros) {
		if(!aristasEncontradas) {
			return false;
		}else {
			// obtener primer vertice
			// ya lo tengo en verticeInicioTemp 
			
			// obtener lista de aristas del primer vertice a travez su indice
			ListaSimple listaDeAristasInicio = aristasPorVertice[verticeInicioTemp.indice];
			// si esta es la primer arista que se agrega a la lista de este vertice
			// la lista va a estar nula, la inicializamos y la agregamos al array
			if(listaDeAristasInicio == null) {
				listaDeAristasInicio = new ListaSimple();
				aristasPorVertice[verticeInicioTemp.indice] = listaDeAristasInicio;
			}
			
			// crear y agregar nueva arista a la lisa de aristas del primer vertice
			AristaGrafo inicioAFin = new AristaGrafo(verticeInicioTemp, verticeFinTemp, pMetros);
			NodoListaSimple nodoInicio = new NodoListaSimple(inicioAFin);
			
			listaDeAristasInicio.InsertarNodoAlFinal(nodoInicio);
			
			// obtener segundo vertice
			// ya lo tengo en verticeFinTemp		
			
			// obtener lista de aristas del segundo vertice a travez su indice
			ListaSimple listaDeAristasFin = aristasPorVertice[verticeFinTemp.indice];
			// si esta es la primer arista que se agrega a la lista de este vertice
			// la lista va a estar nula, la inicializamos y la agregamos al array
			if(listaDeAristasFin == null) {
				listaDeAristasFin = new ListaSimple();
				aristasPorVertice[verticeFinTemp.indice] = listaDeAristasFin;
			}			
			
			// crear y agregar nueva arista a la lisa de aristas del segundo vertice
			AristaGrafo finAInicio = new AristaGrafo(verticeFinTemp, verticeInicioTemp, pMetros);
			NodoListaSimple nodoFin = new NodoListaSimple(finAInicio);
			
			listaDeAristasFin.InsertarNodoAlFinal(nodoFin);
			
			BorrarVerticesTemporales();
			return true;
		}
	}
	
	
	
	public void InicializarVerticeCentro(String pNombre, double pX, double pY, EnumCriticidad pCrit ){
		vertices[verticesInicializados] = new VerticeGrafo(pX, pY, verticesInicializados, Enums.TipoDePunto.CentroMed, pCrit, pNombre);
		verticesInicializados++;
	}
	
	
	public void InicializarVerticeEsquina(double pX, double pY){
		// los datos "crit" y "nombre" son llenados en vertices tipo esquina para conservar la estructura pero no cumplen una funcion.
		vertices[verticesInicializados] = new VerticeGrafo(pX, pY, verticesInicializados, Enums.TipoDePunto.Esquina, EnumCriticidad.BAJA, "Esquina");
		verticesInicializados++;
	}
	
	// peor escenario, orden de n
	public VerticeGrafo BuscarVerticeInicializado(double pX, double pY) {
		VerticeGrafo resultado = null;
		if(cantidadDeVertices > 0) {
			for (int i = 0; i < verticesInicializados; i++) {
				if(vertices[i].x == pX && vertices[i].y == pY) {
					resultado = vertices[i];
				}
			}
		}
		return resultado;
	}
	
	
	public VerticeGrafo[] ObtenerVerticesInicializados() {
		VerticeGrafo[] arrayVerticesInicializados = new VerticeGrafo[verticesInicializados];
		for (int i = 0; i < verticesInicializados; i++) {
			arrayVerticesInicializados[i] = vertices[i];
		}
		return arrayVerticesInicializados;
	}
	
	
	public void BorrarGrafo() {
		// potencialmente redundante
		for (int i = 0; i < cantidadDeVertices; i++) {
			vertices[i] = null;
		}
		
		for (int i = 0; i < cantidadDeVertices; i++) {
			aristasPorVertice[i] = null;
		}
		
		BorrarVerticesTemporales();		
		
		vertices = null;
		aristasPorVertice = null;
		cantidadDeVertices = 0;
		verticesInicializados = 0;
	}
	
	public Grafo(int pCantidadDeVertices){
		vertices = new VerticeGrafo[pCantidadDeVertices];
		aristasPorVertice = new ListaSimple[pCantidadDeVertices];
		cantidadDeVertices = pCantidadDeVertices;
		verticesInicializados = 0;
		
		BorrarVerticesTemporales();	
		
		// potencialmente redundante
		for (int i = 0; i < pCantidadDeVertices; i++) {
			vertices[i] = null;
		}
		
		for (int i = 0; i < pCantidadDeVertices; i++) {
			aristasPorVertice[i] = null;
		}
	}
}
