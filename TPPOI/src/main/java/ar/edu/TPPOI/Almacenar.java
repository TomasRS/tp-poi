package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class Almacenar extends Accion {

	List<Historial> busquedasHechas = new ArrayList<>();
	
	public void registrar(String unTexto, int cantDeResultados, long elapsedTime){
		
		Historial unaBusquedaHecha = new Historial();
		unaBusquedaHecha.setFrase(unTexto);
		unaBusquedaHecha.setCantDeBusquedas(cantDeResultados);
		unaBusquedaHecha.setTiempoQueTardoLaBusqueda(elapsedTime);
		
		this.agregarBusqueda(unaBusquedaHecha);
	}
	
	public void agregarBusqueda(Historial unaBusqueda){
		busquedasHechas.add(unaBusqueda);
	}
}
