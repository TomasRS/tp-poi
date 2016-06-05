package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class Terminal implements InterfaceTerminal{

	private long tiempoLimite;
	private MapaPOI mapa;
	private long tiempoQueDemoroLaBusqueda;
	public InterfaceTerminal interfazDeTerminal;
	
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public void setTiempoLimite(long tiempo){
		this.tiempoLimite = tiempo;
	}
	
	//Este metodo lo llama el Mapa para decirle que se setee el tiempoQueDemoro la busqueda
	public void setTiempoQueDemoroLaBusqueda(long unTiempo){
		this.tiempoQueDemoroLaBusqueda = unTiempo;
	}
	
	public long getTiempoQueDemoroLaBusqueda(){
		return tiempoQueDemoroLaBusqueda;
	}

	
	public void buscar(String unTextoLibre){
		Notificar terminalConNotificar;
		
		this.mapa.buscarDesdeTerminal(unTextoLibre, this);
		
		if (this.superaTiempoLimite()){
			
			terminalConNotificar = new Notificar();
			terminalConNotificar.mandarMail();
		}
	
	}
		
	public boolean superaTiempoLimite(){
		
		return this.tiempoQueDemoroLaBusqueda > this.tiempoLimite;
			
	}

	
	//Metodos default para que Terminal entienda las firmas de la interfaz superior
	public void mandarMail(){
		
	}
	
	public void registrar(){
		
	}
	
	public int cantidadDeBusquedasPorFecha(LocalDateTime fecha){
		
		return 0;
	}

}
