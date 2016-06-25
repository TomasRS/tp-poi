package ar.edu.TPPOI;

import java.time.LocalDateTime;

public abstract class Proceso {
	
	MapaPOI mapa;
	ResultadoDelProceso resultadoDeEjecucionDelProceso;
	LocalDateTime fechaYHora;
	ManejoDeResultado accionEnCasoDeError; //el proceso es el que conoce la accion a hacer en caso de que el mismo falle.
	
	public MapaPOI getMapa() {
		return mapa;
	}
	public void setMapa(MapaPOI mapa) {
		this.mapa = mapa;
	}
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
		
	
}
