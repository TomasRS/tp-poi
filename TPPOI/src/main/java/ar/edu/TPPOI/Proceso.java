package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Proceso {

	MapaPOI mapa;
	ResultadoDelProceso resultadoDeEjecucionDelProceso;
	LocalDateTime fechaYHora;
	List<ManejoDeResultado> accionesEnCasoDeError; //el proceso es el que conoce la accion a hacer en caso de que el mismo falle.
	
	public ResultadoDelProceso getResultadoDeEjecucionDelProceso() {
		return resultadoDeEjecucionDelProceso;
	}
	public void setResultadoDeEjecucionDelProceso(ResultadoDelProceso resultadoDeEjecucionDelProceso) {
		this.resultadoDeEjecucionDelProceso = resultadoDeEjecucionDelProceso;
	}
	public void agregarAccionEnCasoDeError(ManejoDeResultado unManejo) throws ProblemaConAccionesEnCasoDeFalla{
		if (this.accionesEnCasoDeError.size()>0 & unManejo.noAceptaCombinarManejos()){
			throw new ProblemaConAccionesEnCasoDeFalla("Si desea no realizar acciones debe quitar las existentes");
		}else{
			this.accionesEnCasoDeError.add(unManejo);
		}
			
		}

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
	public abstract void ejecutar();
		
	
}
