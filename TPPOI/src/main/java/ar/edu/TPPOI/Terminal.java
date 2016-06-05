package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class Terminal implements InterfaceTerminal{

	private double tiempoLimite;
	private MapaPOI mapa;
	private double tiempoQueDemoroLaBusqueda;
	private InterfaceTerminal interfazDeTerminal;
	
	public void setTiempoLimite(double tiempo){
		this.tiempoLimite = tiempo;
	}
	
	//Este metodo lo llama el Mapa para decirle que se setee el tiempoQueDemoro la busqueda
	public void setTiempoQueDemoroLaBusqueda(double unTiempo){
		this.tiempoQueDemoroLaBusqueda = unTiempo;
	}

	
	public void buscar(String unTextoLibre){
		
		this.mapa.buscarDesdeTerminal(unTextoLibre, this);
		
		if (this.superaTiempoLimite()){
			
			interfazDeTerminal.mandarMail();
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
