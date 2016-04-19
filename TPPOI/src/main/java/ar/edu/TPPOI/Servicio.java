package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Servicio {

	private List<Horario> horarios = new ArrayList<Horario>();
	private String nombre;

	public Servicio(String nombre) {
		this.nombre = nombre;
	}

	public Servicio(String unNombre, Horario unHorario) {
		this.nombre = unNombre;
		this.horarios.add(unHorario);
	}

	public static Servicio nuevoServicioBanco(String unNombre) {
		return new Servicio(unNombre, Servicio.horariosBanco());
	}

	public static List<Horario> horariosBanco() {
		List<Horario> horarios = new ArrayList<>();
		horarios.add(new Horario("MONDAY", "10:00", "16:00"));
		horarios.add(new Horario("TUESDAY", "10:00", "16:00"));
		horarios.add(new Horario("WEDNESDAY", "10:00", "16:00"));
		horarios.add(new Horario("THURSDAY", "10:00", "16:00"));
		horarios.add(new Horario("FRIDAY", "10:00", "16:00"));
		horarios.add(new Horario("SATURDAY", "10:00", "16:00"));
		return horarios;
	}

	public Servicio(String unNombre, List<Horario> unosHorarios) {
		this.nombre = unNombre;
		this.horarios.addAll(unosHorarios);
	}

	public String getNombre() {
		return nombre;
	}

	public boolean disponibleEn(LocalDateTime unMomento) {
		return this.horarios.stream().anyMatch(horario -> horario.estaEnMiHorario(unMomento));
	}

}
