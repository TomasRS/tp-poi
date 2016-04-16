package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SucursalBanco extends POI {
	
	private List<Horario> horariosBanco = new ArrayList<Horario>();
	
	public void addHorarioBancario(Horario horarioBanco){
		this.horariosBanco.add(horarioBanco);
		
	}
	

	//para que el banco use estasCercaDeLaCoordenada no hace falta usar super ya que
	//al ser subclase de POI, directamente hereda todo los metodos que hayan en POI.
	//Method Lookup se llama
	
	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio){
		return this.horariosBanco.stream()
				.anyMatch(horario->horario.estaEnMiHorario(unMomento));
	}
}
