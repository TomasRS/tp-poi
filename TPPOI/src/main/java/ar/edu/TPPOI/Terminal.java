package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class Terminal implements InterfaceTerminal{

	private int tiempoLimite;
	private MapaPOI mapa;
	

	
	public void buscarDesdeTerminal(String unTextoLibre){
		
		//codigo para buscar (le dice al mapa que busque)
	}
	
	public boolean superaTiempoDeBusqueda(int tiempoDeBusqueda){
		
		//codigo para ver si se supera el tiempo de Busqueda parametrizado (rompe xq no hay return)
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
