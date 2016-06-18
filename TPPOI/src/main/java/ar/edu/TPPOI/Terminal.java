package ar.edu.TPPOI;

import java.util.List;
import java.util.ArrayList;

public class Terminal {
	
	MapaPOI mapa;
	List<BusquedaHecha> busquedasHechas = new ArrayList<>();
	List<Accion> acciones = new ArrayList<>();
	
	//-------------------------------------------------------------
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public void activarAccion(Accion unaAccion){
		if (this.yaExisteAccionDeEseTipo(unaAccion)){
			throw new YaExisteUnaAccionDeEseTipoException("Ya existe una accion de ese tipo") ;
		}
		else{
			this.acciones.add(unaAccion);
		}
	}
	
	public void desactivarAccion(Accion unaAccion){
		if (!acciones.contains(unaAccion)){
			throw new NoSePuedeDesactivarException("No se puede desactivar");
		}
		else{
			this.acciones.remove(unaAccion);
		}
	}
	
	public boolean yaExisteAccionDeEseTipo(Accion unaAccion){
		return acciones.stream().anyMatch(unaA -> unaA.getClass().equals(unaAccion.getClass()));
	}

	
	public void agregarBusquedaHecha(BusquedaHecha unaBusquedaHecha){
		this.busquedasHechas.add(unaBusquedaHecha);
	}
	
	public List<BusquedaHecha> getBusquedasHechas(){
		return this.busquedasHechas;
	}
	
	//--------------------------------------------------------------
	
	public void buscar(String unTextoLibre){
		long tiempoInicio;
		long tiempoDeBusqueda;
		Integer cantPOIs;
		
		tiempoInicio = System.nanoTime(); 
		cantPOIs = this.mapa.buscar(unTextoLibre).size();
		tiempoDeBusqueda = System.nanoTime() - tiempoInicio;
		
		this.acciones.forEach(unaAccion -> unaAccion.ejecutar(unTextoLibre, cantPOIs, tiempoDeBusqueda, this));
	}

}
