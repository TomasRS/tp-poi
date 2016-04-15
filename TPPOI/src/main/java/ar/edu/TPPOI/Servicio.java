package ar.edu.TPPOI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
	
	private List<Horario> horarios = new ArrayList<Horario>();
	private String nombre;

	public Servicio(String nombre) {
		this.nombre = nombre;
	}
	
	public void addHorario(Horario horario){
		this.horarios.add(horario);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean disponibleEn(LocalDateTime unMomento){
		return this.horarios.stream()
			.anyMatch(horario->horario.estaEnMiHorario(unMomento));
	}
	
}
