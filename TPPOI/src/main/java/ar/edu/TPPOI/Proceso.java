package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import excepciones.ProblemaConAccionesEnCasoDeFalla;

public abstract class Proceso extends TimerTask implements Comparable<Proceso>{

	MapaPOI mapa;
	ResultadoDelProceso resultadoDeEjecucionDelProceso;
	Date fechaYHora;
	List<ManejoDeResultado> accionesEnCasoDeError = new ArrayList<>();
	
	@Override
    public int compareTo(Proceso unP) {
        if ( fechaYHora.getTime() < unP.fechaYHora.getTime()) {
            return -1;
        }
        if (fechaYHora.getTime() > unP.fechaYHora.getTime()) {
            return 1;
        }
        return 0;
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
	public Date getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(Date fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public abstract void run();
		
	public void sumarElementosAfectados(Integer unaCant){
		resultadoDeEjecucionDelProceso.agregarElementosAfectados(unaCant);
	}
	
	public void instanciarResultadoDeEjecucion(){
		ResultadoDelProceso resultado=new ResultadoDelProceso(LocalDate.now(),0,true);
		this.setResultadoDeEjecucionDelProceso(resultado);
	}
}
