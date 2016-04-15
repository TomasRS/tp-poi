package ar.edu.TPPOI;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Dia {
	private List<Intervalo> intervalos;

	public void addHorarios(Intervalo horario) {
		this.intervalos.add(horario);
	}
	
//LO HIZO FRAN 
	/*public boolean noTieneDisponibleElHorario(Date dia){
		return this.getHorarios().stream()
		.filter(unH->(dia.after(unH.getHoraInicio())&&dia.before(unH.getHoraFin())))
		.collect(Collectors.toList())
		.isEmpty();		
	}*/

}
