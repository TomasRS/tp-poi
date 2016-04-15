package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CGP extends POI {
	

	List<Servicio> servicios = new ArrayList<Servicio>();

	public  void addServicio(Servicio servicio){
		this.servicios.add(servicio);
	}

	public List<Servicio> serviciosCumplenCondicion(Date fechaHorarioDado){
		return  (this.servicios
				.stream()
				.filter(servicio -> servicio.estaAtendiendo(fechaHorarioDado))
				.collect(Collectors.toList()));
		
	}
	
		public Boolean estaDisponible(Date fechaHorario, Servicio unServicio) {

		if (unServicio != null ){
			
			return unServicio.estaAtendiendo(fechaHorario);
		
		}else{
			
			return (this.serviciosCumplenCondicion(fechaHorario).size()) >= 1;
			
		}
		
		
	}

}
