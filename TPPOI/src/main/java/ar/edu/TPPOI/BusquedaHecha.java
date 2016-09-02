package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.List;

public class BusquedaHecha {
	
	String frase;
	Integer cantDeResultados;
	long tiempoDeBusqueda;
	LocalDate fecha;
	
	public void setFrase(String frase){
		this.frase = frase;
	}
	
	public void setCantDeResultados(Integer cantDeResultados){
		this.cantDeResultados = cantDeResultados;
	}
	
	public void setTiempoDeBusqueda(long tiempoDeBusqueda){
		this.tiempoDeBusqueda = tiempoDeBusqueda;
	}
	
	
	
	public String getFrase(){
		return this.frase;
	}
	
	public Integer getCantDeResultados(){
		return this.cantDeResultados;
	}
	
	public long getTiempoDeBusqueda(){
		return this.tiempoDeBusqueda;
	}
	
	public LocalDate getFecha(){
		return fecha;
	}
	
	public BusquedaHecha datosDeLaBusqueda(String unTextoLibre,List<POI> poisEncontrados){
	long tiempoInicio;
	tiempoInicio = System.nanoTime(); 
	cantDeResultados = poisEncontrados.size();
	tiempoDeBusqueda = System.nanoTime() - tiempoInicio;
	this.setFrase(unTextoLibre);
	this.setCantDeResultados(cantDeResultados);
	this.setTiempoDeBusqueda(tiempoDeBusqueda);
	this.setFecha(LocalDate.now());
	return this;
	}

	private void setFecha(LocalDate unaFecha) {
		this.fecha = unaFecha;
	}
}
