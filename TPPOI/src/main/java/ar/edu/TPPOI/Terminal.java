package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Terminal{
	
	String identificador;//Unico, se usa para identificar a una terminal
	long tiempoLimite;
	Map<LocalDateTime,Integer> busquedasPorFecha=new HashMap<LocalDateTime,Integer>();
	MapaPOI mapa;
	List<Accion> acciones=new ArrayList<>(); 
	public List<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Accion> acciones) {
		this.acciones = acciones;
	}

	long tiempoQueDemoroLaBusqueda;
	List<BusquedaHecha> busquedasHechas = new ArrayList<>();
	
	public void agregarBusquedaHecha(BusquedaHecha unaBusqueda){
		busquedasHechas.add(unaBusqueda);
	}
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public void setTiempoLimite(long tiempo){
		this.tiempoLimite = tiempo;
	}
	
	public boolean almacenoBusqueda(){
		return busquedasHechas.size() >= 1;
	}
	
	public void buscar(String unTextoLibre){
		LocalDateTime fechaActual= LocalDateTime.now();
		Integer cantidadDeBusquedasDelDia=busquedasPorFecha.get(fechaActual);
		busquedasPorFecha.put(fechaActual, cantidadDeBusquedasDelDia++);		
		long start = System.nanoTime();
		Integer cantidadDeResultados=this.mapa.buscarDesdeTerminal(unTextoLibre);		
		this.tiempoQueDemoroLaBusqueda = System.nanoTime() - start;
		if (this.superaTiempoLimite()) {
			this.filtrarPorAccion("notificar").mandarMail(this);
			}
			
		this.almacenarBusquedaSiEstaActivado(unTextoLibre,this.tiempoQueDemoroLaBusqueda,cantidadDeResultados);
		}
		
	
	private void almacenarBusquedaSiEstaActivado(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados) {
		this.filtrarPorAccion("almacenar").almacenarBusqueda(unTextoLibre, tiempoQueDemoroLaBusqueda2,cantidadDeResultados,this);
	}
	
	public Accion filtrarPorAccion(String unaAccion){
		return acciones.stream().filter(unaA->unaA.getNombreAccion().equals(unaAccion)).collect(Collectors.toList()).get(0);
	}

	public boolean superaTiempoLimite(){
		return this.tiempoQueDemoroLaBusqueda > this.tiempoLimite;	
	}
	
	public Integer obtenerReporteDeBusquedasPorFecha(LocalDateTime unaFecha){
		return this.filtrarPorAccion("obtenerReporte").cantidadDeBusquedasPorFecha(unaFecha,this);
	}
	
	public Integer reporteDeResultadosPorBusqueda(String unTextoLibre){
		return this.filtrarPorAccion("resultadoPorBusqueda").resultadoPorBusqueda(unTextoLibre,this);
	}
	
	public Integer reporteDeResultadosTotalPorTerminal(){
		return this.busquedasHechas.stream().mapToInt(unaB->unaB.getCantDeBusquedas()).sum();
	}
	


	public boolean seEnvioElMail() {
		return true;
		
	}

	
}