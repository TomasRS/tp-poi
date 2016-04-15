package ar.edu.TPPOI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Servicio {
	
	private List<Dia> dias;
	private String nombre;

	public Servicio(String nombre) {
		this.nombre = nombre;
	}
	
	public void addDias(Dia dia){
		this.dias.add(dia);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

// LO TENGO PREPARADO YO
/*	public Boolean estaAtendiendo(Date dateTime){
		
		EXTRAE EL DIA Y SE FIJA SI ESTA EN LA LISTA Y SI DEVUELVE TRUE EXTRAE LA HORA Y SE LA DA AL DIA COMO PARAMETRO
		
	}*/
	
	

//LO HIZO FRAN
	
	/*public boolean disponiblePara(Date fecha ){
		return this.horasDisp(fecha).isEmpty();
		
	}

	private List<Dia> horasDisp(Date fecha) {
		return this.getDias().stream()
				.filter(unD->unD.noTieneDisponibleElHorario(fecha))
				.collect(Collectors.toList());
	}
	
}
	}*/
	
}
