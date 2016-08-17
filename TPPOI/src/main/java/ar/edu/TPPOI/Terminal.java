package ar.edu.TPPOI;

import java.util.List;
import java.util.Set;

import org.uqbar.geodds.Polygon;
import java.time.LocalDate;



import java.util.ArrayList;
import java.util.HashSet;

public class Terminal {
	
	RepositorioDeTerminales rep;
	MapaPOI mapa;
	List<BusquedaHecha> busquedasHechas = new ArrayList<>();
	Set<Accion> acciones = new HashSet<Accion>();
	GeneradorDeReportes reporte;
	Polygon comuna;
	
	//-------------------------------------------------------------
	
	public Polygon getComuna() {
		return comuna;
	}

	public void setComuna(Polygon comuna) {
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
	 
	public void buscar(String unTextoLibre){
		BusquedaHecha unaBusqueda = new BusquedaHecha();
		unaBusqueda.datosDeLaBusqueda(unTextoLibre,this.getMapa().buscar(unTextoLibre));
		this.acciones.forEach(unaAccion -> unaAccion.luegoDeLaBusqueda(unaBusqueda, this));
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
