package uy.edu.ort.obli;

public interface ISistema {

	// restricción de eficiencia : No
	Retorno inicializarSistema(int maxPuntos);

	// restricción de eficiencia : No
	Retorno destruirSistema();

	// restricción de eficiencia : log (n) promedio
	Retorno registrarRepartidor(String matricula, String nombre);

	// restricción de eficiencia : log (n) promedio	
	Retorno buscarRepartidor(String matricula);

	// restricción de eficiencia : n promedio	
	Retorno listarRepartidores();
	
	// restricción de eficiencia : No
	Retorno registrarCentro(String nombre, double coordX, double coordY, EnumCriticidad criticidad);

	// restricción de eficiencia : No	
	Retorno registrarEsquina(double coordX, double coordY);

	// restricción de eficiencia : No
	Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros);

	// restricción de eficiencia : No	
	Retorno centroCriticoMasCercano(double coordX, double coordY);

	// restricción de eficiencia : No	
	Retorno caminoSeguro();

	// restricción de eficiencia : No	
	Retorno dibujarMapa();

}
