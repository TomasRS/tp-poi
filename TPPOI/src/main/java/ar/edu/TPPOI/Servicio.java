package ar.edu.TPPOI;

import java.util.Date;

public class Servicio {
	
	private Date comienzaServicio;
	private Date finalizaServicio;
	
	public Servicio(Date comienzaServicio, Date finalizaServicio){
		this.comienzaServicio = comienzaServicio;
		this.finalizaServicio = finalizaServicio;
	}
	
	public Date getFechaHoraServInicio(){
		return comienzaServicio;
	}
	
	public Date getFechaHoraServFin(){
		return finalizaServicio;
	}
	

	public Boolean estaAtendiendo(Date dateTime){
		
		return (dateTime.after(this.comienzaServicio) && (dateTime.before(this.finalizaServicio)));
	}
	
	
}
