package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.geodds.Point;

public class LocalComercial extends POI {
	private List<Horario> horarios = new ArrayList<Horario>();

	public static LocalComercial nuevoLocalConRubroLibreriaEscolar(String unNombre, Point unaCoordenada,
			List<Horario> unosHorarios) {
		return new LocalComercial(unNombre, unaCoordenada, 500, unosHorarios, "LibreriaEscolar");
	}

	public static LocalComercial nuevoLocalConRubroKioscoDiarios(String unNombre, Point unaCoordenada,
			List<Horario> unosHorarios) {
		return new LocalComercial(unNombre, unaCoordenada, 200, unosHorarios, "Kiosco Diarios");
	}

	public static LocalComercial nuevoLocal(String unNombre, Point unaCoordenada, Integer unRadioCercania,
			List<Horario> unosHorarios, String unRubro) {
		return new LocalComercial(unNombre, unaCoordenada, unRadioCercania, unosHorarios, "Kiosco Diarios");
	}

	private LocalComercial(String unNombre, Point unaCoordenada, Integer unRadioCercania, List<Horario> unosHorarios,
			String unRubro) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.horarios.addAll(unosHorarios);
		this.rubro = unRubro;
	}

	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio) {
		return this.horarios.stream().anyMatch(horario -> horario.estaEnMiHorario(unMomento));
	}

}