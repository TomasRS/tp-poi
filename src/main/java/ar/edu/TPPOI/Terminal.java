package ar.edu.TPPOI;

import java.util.List;
import java.util.Set;

import acciones.Accion;
import deApoyo.GeneradorDeReportes;
import deApoyo.Poligono;
import deApoyo.RepositorioDeTerminales;
import pois.POI;

import java.time.LocalDate;



import java.util.ArrayList;
import java.util.HashSet;

public class Terminal {
	
	RepositorioDeTerminales rep;
	MapaPOI mapa;
	List<BusquedaHecha> busquedasHechas = new ArrayList<>();
	Set<Accion> acciones = new HashSet<Accion>();
	GeneradorDeReportes reporte;
	Poligono comuna;
	
	//-------------------------------------------------------------
	
	public Poligono getComuna() {
		return comuna;
	}

	public void setComuna(Poligono comuna) {
		this.comuna = comuna;
	}

	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public MapaPOI getMapa(){
		return this.mapa;
	}
	
	public void activarAccion(Accion unaAccion){
		this.acciones.add(unaAccion);
	}
	
	
	public void desactivarAccion(Accion unaAccion){
		if (acciones.contains(unaAccion)){
			this.acciones.remove(unaAccion);
		}
	}

	
	public void agregarBusquedaHecha(BusquedaHecha unaBusquedaHecha){
		this.busquedasHechas.add(unaBusquedaHecha);
	}
	
	public List<BusquedaHecha> getBusquedasHechas(){
		return this.busquedasHechas;
	}
	
	public Set<Accion> getAcciones(){
		return this.acciones;
	}
	
	public GeneradorDeReportes getReporte() {
		return reporte;
	}

	public void setReporte(GeneradorDeReportes reporte) {
		this.reporte = reporte;
	}
	
	//--------------------------------------------------------------
	 
	public List<POI> buscar(String unTextoLibre){
		BusquedaHecha unaBusqueda = new BusquedaHecha();
		this.guardarBusqueda(unaBusqueda,unTextoLibre);
		this.accionesAutomaticas(unaBusqueda,this);
		return this.devolverPOIs(unTextoLibre);
	}
	
	private void accionesAutomaticas(BusquedaHecha unaBusqueda, Terminal terminal) {
		acciones.forEach(unaAccion -> unaAccion.ejecutarLuegoDeLaBusqueda(unaBusqueda, this));
		
	}

	private void guardarBusqueda(BusquedaHecha unaBusqueda, String unTextoLibre) {
		unaBusqueda.datosDeLaBusqueda(unTextoLibre,this.devolverPOIs(unTextoLibre));
	}

	public List<POI> devolverPOIs(String unTextoLibre){
		return getMapa().buscar(unTextoLibre);
	}

	public int obtenerReporte(LocalDate unaFecha){
		return this.getReporte().generarReportePorFecha(unaFecha, this.getBusquedasHechas());   
	}
	public List<Integer> generarReportePorBusqueda(){
		return this.getReporte().generarReportePorBusqueda(this.getBusquedasHechas());
	}

	public void activarAcciones(Set<Accion> accionesPorProceso) {
		this.getAcciones().addAll(accionesPorProceso);
	}

	public void desactivarAcciones(Set<Accion> accionesPorProceso) {
		this.getAcciones().addAll(accionesPorProceso);
	}

}
