package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class Terminal{

	long tiempoLimite;
	MapaPOI mapa;
	long tiempoQueDemoroLaBusqueda;
	Notificar notificarDeTerminal;
	
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public void setTiempoLimite(long tiempo){
		this.tiempoLimite = tiempo;
	}
	
	public void setAccionNotificar(Notificar unNotificar){
		this.notificarDeTerminal = unNotificar;
	}
	
	//Este metodo lo llama el Mapa para mandarle los datos de la busqueda (frase,cantResult,tiempo)
	public void setDatosDeBusqueda(String unTexto, int cantDeResultados, long elapsedTime){
		this.tiempoQueDemoroLaBusqueda = elapsedTime;
		
		Almacenar terminalConAlmacenar = new Almacenar();
		terminalConAlmacenar.registrar(unTexto, cantDeResultados, elapsedTime);
		
	}

	public boolean notificoMail(){
		return notificarDeTerminal.getMailEnviado();
	}
	
	public void buscar(String unTextoLibre){

		this.mapa.buscarDesdeTerminal(unTextoLibre, this);
		
		if (this.superaTiempoLimite()){
			notificarDeTerminal.mandarMail();
		}
	}
		
	public boolean superaTiempoLimite(){
		return this.tiempoQueDemoroLaBusqueda > this.tiempoLimite;	
	}
}