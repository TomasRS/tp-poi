package ar.edu.TPPOI;

import java.util.List;

public class LocalComercial extends POI{
	private String rubro;
	List<Integer> horariosDeAtencion;
	private Integer radioCercania;
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
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
	
	public boolean estasCercaDeLaCoordenada (Punto unaCoordenada){
		return estasAMenosDeXMetrosDe (radioCercania,unaCoordenada);
	}
}