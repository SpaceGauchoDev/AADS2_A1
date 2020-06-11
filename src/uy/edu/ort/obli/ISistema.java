package uy.edu.ort.obli;

public interface ISistema {

	// restricci�n de eficiencia : No
	Retorno inicializarSistema(int maxPuntos);

	// restricci�n de eficiencia : No
	Retorno destruirSistema();

	// restricci�n de eficiencia : log (n) promedio
	Retorno registrarRepartidor(String matricula, String nombre);

	// restricci�n de eficiencia : log (n) promedio	
	Retorno buscarRepartidor(String matricula);

	// restricci�n de eficiencia : n promedio	
	Retorno listarRepartidores();
	
	// restricci�n de eficiencia : No
	Retorno registrarCentro(String nombre, double coordX, double coordY, EnumCriticidad criticidad);

	// restricci�n de eficiencia : No	
	Retorno registrarEsquina(double coordX, double coordY);

	// restricci�n de eficiencia : No
	Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros);

	// restricci�n de eficiencia : No	
	Retorno centroCriticoMasCercano(double coordX, double coordY);

	// restricci�n de eficiencia : No	
	Retorno caminoSeguro();

	// restricci�n de eficiencia : No	
	Retorno dibujarMapa();

}
