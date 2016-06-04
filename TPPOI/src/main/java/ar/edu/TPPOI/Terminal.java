package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class Terminal implements InterfaceTerminal{

	private int tiempoLimite;
	private MapaPOI mapa;
	private int tiempoQueDemoroLaBusqueda;
	
	public void setTiempoLimite(int tiempo){
		this.tiempoLimite = tiempo;
	}
	
	//Este metodo lo llama el Mapa para decirle que se setee el tiempoQueDemoro la busqueda
	public void setTiempoQueDemoroLaBusqueda(int unTiempo){
		this.tiempoQueDemoroLaBusqueda = unTiempo;
	}
	
	public int getTiempoQueDemoroLaBusqueda(){
		return tiempoQueDemoroLaBusqueda;
	}
	
	public void buscar(String unTextoLibre){
		
		this.mapa.buscarDesdeTerminal(unTextoLibre, this);
		
		if (this.superaTiempoLimite()){
			
			//decirle a Notificar que notifique
		}
	
	}
		
	public boolean superaTiempoLimite(){
		
		return this.getTiempoQueDemoroLaBusqueda() > this.tiempoLimite;
			
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
