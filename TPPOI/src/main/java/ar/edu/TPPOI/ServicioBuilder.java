package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class ServicioBuilder {

	public Servicio servicioConHorarioBanco(String unNombre) {
		List<Horario> horarios = new ArrayList<>();
		horarios.add(new Horario("MONDAY", "10:00", "15:00"));
		horarios.add(new Horario("TUESDAY", "10:00", "15:00"));
		horarios.add(new Horario("WEDNESDAY", "10:00", "15:00"));
		horarios.add(new Horario("THURSDAY", "10:00", "15:00"));
		horarios.add(new Horario("FRIDAY", "10:00", "15:00"));
		
		return new Servicio(unNombre, horarios);
	}
}
