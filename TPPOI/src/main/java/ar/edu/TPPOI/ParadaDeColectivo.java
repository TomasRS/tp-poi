package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

import org.uqbar.geodds.Point;

public class ParadaDeColectivo extends POI {

	public ParadaDeColectivo(String unNombre, Point unaCoordenada, Direccion unaDireccion) {
		this(unNombre, unaCoordenada, 100, unaDireccion);
	}

	public ParadaDeColectivo(String unNombre, Point unaCoordenada, Integer unRadioCercania, Direccion unaDireccion) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.direccion = unaDireccion;
		this.rubro = "Transporte";
	}

	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio) {
		return true;
	}
	
	public boolean coincideConAtributo(String unTextoLibre){
		return this.nombre.equals(unTextoLibre);
	}
	
	//No hace nada es para hacer andar actualizar en POI  
	public void actualizar( POI unPOIExterno){
		}
	
}
