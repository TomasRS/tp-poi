package ar.edu.TPPOI;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Dia {
	private List<Horario> horarios;

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public boolean noTieneDisponibleElHorario(Date dia){
		return this.getHorarios().stream()
		.filter(unH->(dia.after(unH.getHoraInicio())&&dia.before(unH.getHoraFin())))
		.collect(Collectors.toList())
		.isEmpty();		
	}

}
