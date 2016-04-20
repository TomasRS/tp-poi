package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Horario {
	private String day;
	private LocalTime horaInicio;
	private LocalTime horaFin;

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