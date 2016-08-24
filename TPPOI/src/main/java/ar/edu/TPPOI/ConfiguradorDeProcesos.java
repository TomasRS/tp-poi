package ar.edu.TPPOI;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConfiguradorDeProcesos{

	List<Tarea> tareasEnBatch = new ArrayList<>();
	List<String> numeros = new ArrayList<>();
	
	public void agregarProcesoAlBatch(Proceso unProceso, LocalDateTime fechaYHora){
		Tarea nuevaTarea = new Tarea(unProceso, fechaYHora);
		this.tareasEnBatch.add(nuevaTarea);
	}
	
	public void work(){
		List<Tarea> tareasParaEjecutar = this.filtrarTareasAEjecutar();
		
		tareasParaEjecutar.forEach(unaT -> unaT.getProceso().run());
		tareasEnBatch.removeAll(tareasParaEjecutar);
	}
	
	
	//---------------------------------------------------------
	public List<Tarea> getTareasEnBatch(){
		return this.tareasEnBatch;
	}
	
	public List<Tarea> filtrarTareasAEjecutar(){
		
		return (tareasEnBatch
			   .stream()
			   .filter(unaT -> unaT.tieneFechaMenorOIgualAAhora(LocalDateTime.now()))
			   .collect(Collectors.toList()));
	}


}
