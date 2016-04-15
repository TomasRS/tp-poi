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

	public List<Dia> getDias() {
		return dias;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean disponiblePara(Date fecha ){
		return this.horasDisp(fecha).isEmpty();
		
	}

	private List<Dia> horasDisp(Date fecha) {
		return this.getDias().stream()
				.filter(unD->unD.noTieneDisponibleElHorario(fecha))
				.collect(Collectors.toList());
	}
	
}
