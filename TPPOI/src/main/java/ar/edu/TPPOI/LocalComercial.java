package ar.edu.TPPOI;

import java.util.List;

public class LocalComercial extends POI{
	private String rubro;
	List<Integer> horariosDeAtencion;
	private double radioCercania;
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	public double getRadioCercania() {
		return radioCercania;
	}
	public void setRadioCercania(double radioCercania) {
		this.radioCercania = radioCercania;
	}
	public List<Integer> getHorariosDeAtencion() {
		return horariosDeAtencion;
	}
	public void setHorariosDeAtencion(List<Integer> horariosDeAtencion) {
		this.horariosDeAtencion = horariosDeAtencion;
	}
	
	public boolean estoyCercaRespectoA (POI poi){
		return poi.getPunto().distanciaCoord(this.getPunto().getLatitud(), this.getPunto().getLongitud(), poi.getPunto().getLatitud(), poi.getPunto().getLongitud())<radioCercania;
	}
}