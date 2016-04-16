package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class CGP extends POI {
	
	private List<Servicio> servicios = new ArrayList<>();
	private Polygon comuna;
	
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void addServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public void setPoligono(Polygon unaComuna){
		this.comuna = unaComuna;
	}
	
	//Hacerlo con Polygon (nos van a pasar la biblioteca)
	public boolean estasCercaDe (Point unaCoordenada){
		return this.comuna.isInside(unaCoordenada);
	}
	
	public boolean contiene(String unaPalabraClave){
		return (super.contiene(unaPalabraClave) ||
			   this.getServicios().stream()
			   .anyMatch(unServicio -> this.estanContenidos(unaPalabraClave, unServicio.getNombre()))
			   );
				
	}

	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio){
		if (unServicio != null){
			return unServicio.disponibleEn(unMomento);
		}else {
			return this.servicios.stream()
					.anyMatch(servicio->servicio.disponibleEn(unMomento));
		}
	}
	
}
