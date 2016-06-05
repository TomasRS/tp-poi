package ar.edu.TPPOI;

//Este es el objeto que representa la estructura de la busqueda (frase, cantTotal, tiempo) para almacenar
public class Historial {

	String frase;
	int cantidadBusquedas;
	long tiempoQueTardoLaConsulta;
	
	public void setFrase(String unaFrase){
		this.frase = unaFrase;
	}
	
	public void setCantDeBusquedas(int cant){
		this.cantidadBusquedas = cant;
	}
	
	public void setTiempoQueTardoLaBusqueda(long unTiempo){
		this.tiempoQueTardoLaConsulta = unTiempo;
	}
}
