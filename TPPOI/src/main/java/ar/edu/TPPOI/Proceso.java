package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import excepciones.ProblemaConAccionesEnCasoDeFalla;

public abstract class Proceso{

	MapaPOI mapa;
	ResultadoDelProceso resultadoDeEjecucionDelProceso;
	List<ManejoDeResultado> accionesEnCasoDeError = new ArrayList<>();
	
	public void esperarParaEjecutar(LocalDateTime fechaYHora){
		LocalDateTime dateTime2 = LocalDateTime.now();
		long diffInMilli = java.time.Duration.between(dateTime2, fechaYHora).toMillis();
		try {
			Thread.sleep(diffInMilli);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			this.run();
		}
	}
	
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

	public abstract void run();
		
	public void sumarElementosAfectados(Integer unaCant){
		resultadoDeEjecucionDelProceso.agregarElementosAfectados(unaCant);
	}
	
	public void instanciarResultadoDeEjecucion(){
		ResultadoDelProceso resultado=new ResultadoDelProceso(LocalDateTime.now(),0,true);
		this.setResultadoDeEjecucionDelProceso(resultado);
	}
}
