package ar.edu.TPPOI;

import java.util.List;
import org.uqbar.geodds.Point;

public class LocalComercial extends POI {
	private List<Integer> horariosDeAtencion;
	private Integer radioCercania;

	public Integer getRadioCercania() {
		return radioCercania;
	}

	public void setRadioCercania(Integer radioCercania) {
		this.radioCercania = radioCercania;
	}

	public List<Integer> getHorariosDeAtencion() {
		return horariosDeAtencion;
	}

	public void setHorariosDeAtencion(List<Integer> horariosDeAtencion) {
		this.horariosDeAtencion = horariosDeAtencion;
	}

	public boolean estasCercaDe(Point unaCoordenada) {
		return this.estasAMenosDeXMetrosDe(radioCercania, unaCoordenada);
	}
}