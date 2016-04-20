package ar.edu.TPPOI;

import java.time.LocalDateTime;
import org.uqbar.geodds.Point;

public class ParadaDeColectivo extends POI {

	public ParadaDeColectivo(String unNombre, Point unaCoordenada) {
		this(unNombre, unaCoordenada, 100);
	}

	public ParadaDeColectivo(String unNombre, Point unaCoordenada, Integer unRadioCercania) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
	}

	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio) {
		return true;
	}

}
