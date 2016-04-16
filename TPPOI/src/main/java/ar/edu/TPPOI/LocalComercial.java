package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.geodds.Point;

public class LocalComercial extends POI {
	private List<Horario> horariosLocal =  new ArrayList<Horario>();
	private Integer radioCercania;

	public Integer getRadioCercania() {
		return radioCercania;
	}

	public void setRadioCercania(Integer radioCercania) {
		this.radioCercania = radioCercania;
	}
	
	public void addHorarioDeAtencion(Horario horarioDeAtencion){
		this.horariosLocal.add(horarioDeAtencion);
	}

	
	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio){
		return this.horariosLocal.stream()
				.anyMatch(horario->horario.estaEnMiHorario(unMomento));
	}

	public boolean estasCercaDe(Point unaCoordenada) {
		return this.estasAMenosDeXMetrosDe(radioCercania, unaCoordenada);
	}
}