package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class Terminal implements InterfaceTerminal{

	private long tiempoLimite;
	private MapaPOI mapa;
	private long tiempoQueDemoroLaBusqueda;

	
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public void setTiempoLimite(long tiempo){
		this.tiempoLimite = tiempo;
	}
	
	//Este metodo lo llama el Mapa para mandarle los datos de la busqueda (frase,cantResult,tiempo)
	public void setDatosDeBusqueda(String unTexto, int cantDeResultados, long elapsedTime){
		this.tiempoQueDemoroLaBusqueda = elapsedTime;
		
		Almacenar terminalConAlmacenar = new Almacenar();
		terminalConAlmacenar.registrar(unTexto, cantDeResultados, elapsedTime);
		
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
