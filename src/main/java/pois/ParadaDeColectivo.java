package pois;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.uqbar.geodds.Point;

@Entity //@DiscriminatorValue(value="parada_colectivo")
public class ParadaDeColectivo extends POI {
	
	@SuppressWarnings(value="unused")
	public ParadaDeColectivo(){}

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

	public boolean estaDisponible(LocalDateTime unMomento) {
		return true;
	}

	public boolean coincideConAtributo(String unTextoLibre) {
		return this.nombre.equals(unTextoLibre);
	}

	public void actualizar(POI unPOI) {
		this.actualizarDesdeDatos(unPOI.getCoordenada(), unPOI.getRadioCercania(), unPOI.getRubro(),
				unPOI.getDireccion(), unPOI.getTags());
	}

}