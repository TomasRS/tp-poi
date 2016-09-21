package ar.edu.TPPOI;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import acciones.Accion;
import deApoyo.GeneradorDeReportes;
import deApoyo.Comuna;
import deApoyo.RepositorioDeTerminales;
import pois.POI;

import java.time.LocalDate;



import java.util.ArrayList;
import java.util.HashSet;

@Entity
@Table(name="Terminales")
public class Terminal {
	
	@Id @GeneratedValue
	private long id;
	
	@Transient
	RepositorioDeTerminales rep;
	
	@Transient
	MapaPOI mapa;
	
	@OneToMany(cascade=CascadeType.ALL) @JoinColumn(name="Terminal_id")
	List<BusquedaHecha> busquedasHechas;
	
	@ManyToMany(cascade=CascadeType.ALL) @JoinTable(name="AccionPorTerminal")
	Set<Accion> acciones;
		
	@ManyToOne(cascade=CascadeType.ALL)
	Comuna comuna;
	
	private String descripcion;
	
	//-------------------------------------------------------------
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Terminal(){
		busquedasHechas = new ArrayList<BusquedaHecha>();
		acciones = new HashSet<Accion>();
	}
	
	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
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
		return GeneradorDeReportes.generarReportePorFecha(unaFecha, this.getBusquedasHechas());   
	}
	public List<Integer> generarReportePorBusqueda(){
		return GeneradorDeReportes.generarReportePorBusqueda(this.getBusquedasHechas());
	}

	public void activarAcciones(Set<Accion> accionesPorProceso) {
		this.getAcciones().addAll(accionesPorProceso);
	}

	public void desactivarAcciones(Set<Accion> accionesPorProceso) {
		this.getAcciones().addAll(accionesPorProceso);
	}

	public void setBusquedasHechas(List<BusquedaHecha> busquedasHechas) {
		this.busquedasHechas = busquedasHechas;
	}

	public void setAcciones(Set<Accion> acciones) {
		this.acciones = acciones;
	}

}
