package ar.edu.TPPOI;

import java.time.LocalDate;

public class Almacenar extends Accion {

	
	public void registrar(String unTexto, int cantDeResultados, long elapsedTime, LocalDate fecha, Terminal unaTerminal){
		
		if (this.getActivado()){
		Historial unaBusquedaHecha = new Historial();
		unaBusquedaHecha.setFrase(unTexto);
		unaBusquedaHecha.setCantDeBusquedas(cantDeResultados);
		unaBusquedaHecha.setTiempoQueTardoLaBusqueda(elapsedTime);
		unaBusquedaHecha.setFecha(fecha);
		
		unaTerminal.agregarBusquedaHecha(unaBusquedaHecha);
		}
	}
	
}
