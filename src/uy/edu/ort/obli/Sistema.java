package uy.edu.ort.obli;

import util.*;
import uy.edu.ort.obli.Retorno.Resultado;

public class Sistema implements ISistema {
	ABB repartidores;
	Grafo mapa;

	@Override
	public Retorno inicializarSistema(int maxPuntos) {
		if (maxPuntos <= 0) {
			return new Retorno(Resultado.ERROR_1); // Descripcion del error: maxPuntos debe ser positivo mayor que cero
		}else {
			//	iniciar arbol que guarda repartidores
			repartidores = new ABB(Enums.Dir.Descendente);
			
			// iniciar estructura mapa
			mapa = new Grafo(maxPuntos);
			
			// todo inició correctamente
			return new Retorno(Resultado.OK);
		}
	}

	@Override
	public Retorno destruirSistema() {
		//	destruir arbol que guarda repartidores
		repartidores.BorrarArbol();
		repartidores = null;
		
		// destruir estructura mapa
		mapa.BorrarGrafo();
		mapa = null;
		
		// todo cerró correctamente
		return new Retorno(Resultado.OK);
	}

	@Override
	public Retorno registrarRepartidor(String matricula, String nombre) {
			Retorno r = new Retorno(Resultado.NO_IMPLEMENTADA);
			
	    	// valido la matricula
	    	if(!Repartidor.MatriculaValida(matricula)) {
	    		r.resultado = Retorno.Resultado.ERROR_1;
	    	}
	    	
	    	// me fijo que el repartidor no esté ingresado ya en el sistema
	    	else if(null != repartidores.Buscar(repartidores.raiz,matricula)) {
	    		r.resultado = Retorno.Resultado.ERROR_2;
	    	}
			// todo bien, podemos insertar nuevo nodo    	
	    	else {
	    		repartidores.raiz = repartidores.InsertarNodo(repartidores.raiz, matricula, nombre);
	    		r.resultado = Retorno.Resultado.OK;
	    	}

			return r;
	}

	@Override
	public Retorno buscarRepartidor(String matricula) {
    	Retorno r = new Retorno(Resultado.NO_IMPLEMENTADA);
    	
    	if(!Repartidor.MatriculaValida(matricula)) {
    		
    		// matricula invalida
    		r.resultado = Resultado.ERROR_1;
    	}else {
    		
    		NodoABB_Iteraciones inicioBusqueda = new NodoABB_Iteraciones(repartidores.raiz, 0);
    		NodoABB_Iteraciones repartidorBuscado = repartidores.BuscarConIteraciones(inicioBusqueda, matricula);
    		if (repartidorBuscado.nodo == null) {

    			// matricula no existe en el sistema
    			r.resultado = Resultado.ERROR_2;
    		}else {
    			
    			// encontramos repartidor
    			r.resultado = Resultado.OK;
    			r.valorString = repartidorBuscado.nodo.dato.matricula + ";" + repartidorBuscado.nodo.dato.nombre;
    			r.valorEntero = repartidorBuscado.iteraciones;
    		}
    	}
    	
    	return r;
	}

	@Override
	public Retorno listarRepartidores() {
		Retorno r = new Retorno(Resultado.OK);
		
		String listadoDeRepartidores = "";
		listadoDeRepartidores = repartidores.InicioImprimirInOrder();

		r.valorString = listadoDeRepartidores;
		
		return r;
	}

	@Override
	public Retorno registrarCentro(String nombre, double coordX, double coordY, EnumCriticidad criticidad) {
		Retorno r = new Retorno(Resultado.NO_IMPLEMENTADA);
		
		// ya se han inicializado la cantidad maxima de vertices
		if (mapa.verticesInicializados == mapa.cantidadDeVertices) {
			r.resultado = Resultado.ERROR_1;
		}else {
			// ya se ha registrado un punto en esas coordenadas
			if(mapa.BuscarVerticeInicializado(coordX, coordY) != null) {
				r.resultado = Resultado.ERROR_2;
			}else {
				
				// todo bien, podemos registrar centro medico
				mapa.InicializarVerticeCentro(nombre, coordX, coordY, criticidad);
				r.resultado = Resultado.OK;
			}
		}
		return r;
	}

	@Override
	public Retorno registrarEsquina(double coordX, double coordY) {
		Retorno r = new Retorno(Resultado.NO_IMPLEMENTADA);
		
		// ya se han inicializado la cantidad maxima de vertices
		if (mapa.verticesInicializados == mapa.cantidadDeVertices) {
			r.resultado = Resultado.ERROR_1;
		}else {
			
			// ya se ha registrado un punto en esas coordenadas
			if(mapa.BuscarVerticeInicializado(coordX, coordY) != null) {
				r.resultado = Resultado.ERROR_2;
			}else {
				
				// todo bien, podemos registrar esquina
				mapa.InicializarVerticeEsquina(coordX, coordY);
				r.resultado = Resultado.OK;
			}
		}
		return r;
	}

	@Override
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros) {
		Retorno r = new Retorno(Resultado.NO_IMPLEMENTADA);
		
		// distancia solo puede ser positiva mayor que cero
		if(metros <= 0) {
			r.resultado = Resultado.ERROR_1;
		}else {
			
			// importante!
			// esta funcion deber correr si o si antes de InicializarArista
			// ver comentarios en Grafo / InicializarArista()
			if(!mapa.ExistenParDeVerticesInicializados(coordXi, coordYi, coordXf, coordYf)) {
				// los vertices no han sido inicializados
				r.resultado = Resultado.ERROR_2;
			}else {
				// verifico que la arista no esté ya registrada
				if(mapa.ExisteArista(coordXi, coordYi, coordXf, coordYf)) {
					r.resultado = Resultado.ERROR_3;
				}else {
					// todo bien, intentamos registrar tramo
					if(!mapa.InicializarArista(coordXi, coordYi, coordXf, coordYf, metros)) {
						// caso excepcional, en algun punto olvidé setear los vertices temporales
						r.resultado = Resultado.ERROR_4;
					}else {
						r.resultado = Resultado.OK;
					}
				}
			}
		}
		return r;
	}

	@Override
	public Retorno centroCriticoMasCercano(double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoSeguro() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		Retorno r = new Retorno(Resultado.OK);
		
		String apiKey = "AIzaSyB7pBWV7XFfIbxYWxfXRWM8Rx420nRkF-Y";
		PaginaWeb web = new PaginaWeb(apiKey , mapa.ObtenerVerticesInicializados());
		web.EscribirArchivo();
		web.EjecutarArchivo();	
		
		return r;
	}
	
	
	public Sistema() {
		repartidores = null;
		mapa = null;
	}	
}
