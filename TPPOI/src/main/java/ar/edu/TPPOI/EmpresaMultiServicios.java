package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class EmpresaMultiServicios extends POI {

	protected List<Servicio> servicios = new ArrayList<>();

	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio) {

		if (unServicio != null) {
			if (this.servicios.contains(unServicio)) {
				return unServicio.disponibleEn(unMomento);
			} else {
				throw new NoExisteServicioAsociadoException(
						"No existe el servicio " + unServicio.getNombre() + " en " + this.getNombre());
			}
		} else {
			return this.servicios.stream().anyMatch(servicio -> servicio.disponibleEn(unMomento));
		}
	}
	
	public void agregarServicio (Servicio unServicio){
		this.servicios.add(unServicio);
	}

	public abstract void actualizar( POI unPOIExterno);
}
