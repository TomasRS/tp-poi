package ar.edu.TPPOI;

public class BusquedaHecha {
	
	String frase;
	Integer cantDeResultados;
	long tiempoDeBusqueda;
	
	public BusquedaHecha(String unTextoLibre, Integer cantPOIs, long tiempoBusqueda){
		this.frase = unTextoLibre;
		this.cantDeResultados = cantPOIs;
		this.tiempoDeBusqueda = tiempoBusqueda;
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
}
