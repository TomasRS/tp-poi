package ar.edu.TPPOI;

import java.util.Date;

public class Intervalo{
	
	private Date horaInicio;
	private Date horaFin;
	
	public Intervalo(Date horaInicio, Date horaFin){
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	public Date getHoraInicio() {
	return horaInicio;
	}

	public Date getHoraFin() {
	return horaFin;
	}

	public boolean estaEnLaFranja(Date unaHora){
		
		return (unaHora.after(horaInicio) && unaHora.before(horaFin));
	}

}
