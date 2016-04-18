package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Horario {
	private String day;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public static List<Horario> horariosComunes(List<String> dias, String horaInicioComun, String horaFinComun){
		//retorna lista de horarios con la misma hora de inicio y fin, para una lista de dias
		List<Horario> horariosComunes = new ArrayList<Horario>();
		for (String dia:dias){
			horariosComunes.add(new Horario(dia, horaInicioComun, horaFinComun));
		}
		return horariosComunes;
	}

	public Horario(String day, String horaInicio, String horaFin) {
		// Dia debe ser la palabra del dia en ingles y mayuscula
		this.day = day;
		// La hora va en formato HH:MM
		this.horaInicio = LocalTime.parse(horaInicio);
		this.horaFin = LocalTime.parse(horaFin);
	}

	public boolean estaEnMiHorario(LocalDateTime unaFecha) {
		String diaDeSemana = unaFecha.toLocalDate().getDayOfWeek().toString();
		boolean cumpleDia = day.equals(diaDeSemana);
		LocalTime horaDelDia = unaFecha.toLocalTime();

		return cumpleDia && (horaDelDia.isAfter(horaInicio) && horaDelDia.isBefore(horaFin));
	}

}
