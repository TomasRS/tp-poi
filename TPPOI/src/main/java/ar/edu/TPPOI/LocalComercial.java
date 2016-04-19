package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.geodds.Point;

public class LocalComercial extends POI {
	private List<Horario> horarios = new ArrayList<Horario>();

	public LocalComercial(String unNombre, Point unaCoordenada, List<Horario> unosHorarios) {
		this(unNombre, unaCoordenada, 500, unosHorarios);
	}

	public LocalComercial(String unNombre, Point unaCoordenada, Integer unRadioCercania, List<Horario> unosHorarios) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.horarios.addAll(unosHorarios);
	}

	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio) {
		return this.horarios.stream().anyMatch(horario -> horario.estaEnMiHorario(unMomento));
	}

}