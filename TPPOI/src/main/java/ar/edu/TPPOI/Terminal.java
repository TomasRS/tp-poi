package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Terminal{

	long tiempoLimite;
	MapaPOI mapa;
	long tiempoQueDemoroLaBusqueda;
	Notificar notificarDeTerminal;
	Almacenar almacenarDeTerminal;
	List<Historial> busquedasHechas = new ArrayList<>();
	
	public void agregarBusquedaHecha(Historial unaBusqueda){
		busquedasHechas.add(unaBusqueda);
	}
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public void setTiempoLimite(long tiempo){
		this.tiempoLimite = tiempo;
	}
	
	public void setAccionNotificar(Notificar unNotificar){
		this.notificarDeTerminal = unNotificar;
	}
	
	public void setAccionAlmacenar(Almacenar unAlmacenar){
		this.almacenarDeTerminal = unAlmacenar;
	}
	
	//Este metodo lo llama el Mapa para mandarle los datos de la busqueda (frase,cantResult,tiempo)
	public void setDatosDeBusqueda(String unTexto, int cantDeResultados, long elapsedTime){
		this.tiempoQueDemoroLaBusqueda = elapsedTime;
		LocalDate fecha = LocalDate.now();
		almacenarDeTerminal.registrar(unTexto, cantDeResultados, elapsedTime, fecha, this);
		
	}

	public boolean notificoMail(){
		return notificarDeTerminal.getMailEnviado();
	}
	
	public boolean almacenoBusqueda(){
		return busquedasHechas.size() >= 1;
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