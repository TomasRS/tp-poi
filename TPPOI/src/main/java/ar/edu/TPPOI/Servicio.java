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

	public Servicio(String unNombre, List<Horario> unosHorarios) {
		this.nombre = unNombre;
		this.horarios.addAll(unosHorarios);
	}
	
	public Servicio(String unNombre, List<String> diasConHorariosComunes,String horaInicioComun, String horaFinComun){
		List<Horario> horariosComunes = Horario.horariosComunes(diasConHorariosComunes, horaInicioComun, horaFinComun);
		this.nombre = unNombre;
		this.horarios = horariosComunes;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean disponibleEn(LocalDateTime unMomento) {
		return this.horarios.stream().anyMatch(horario -> horario.estaEnMiHorario(unMomento));
	}

}
