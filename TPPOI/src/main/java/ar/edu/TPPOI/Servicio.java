package ar.edu.TPPOI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



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
/*
	private List<Dia> dias;

	public List<Dia> getDias() {
		return dias;
	}

	public void setDias(List<Dia> dias) {
		this.dias = dias;
	}
	
	public boolean disponiblePara(Date fecha ){
		return this.horasDisp(fecha).isEmpty();
		
	}

	private List<Dia> horasDisp(Date fecha) {
		return this.getDias().stream()
				.filter(unD->unD.noTieneDisponibleElHorario(fecha))
				.collect(Collectors.toList());
	}}*/

