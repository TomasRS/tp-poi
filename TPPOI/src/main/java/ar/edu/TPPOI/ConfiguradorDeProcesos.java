package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConfiguradorDeProcesos{

	List<Tarea> procesosEnBatch = new ArrayList<>();
	
	public void agregarProcesoAlBatch(Proceso unProceso, LocalDateTime fechaYHora){
		
		unProceso.esperarParaEjecutar(fechaYHora);
	}
	
	public void agregarProcesoAlBatch2(Proceso unProceso, LocalDateTime fechaYHora){
		Tarea nuevaTarea = new Tarea(unProceso, fechaYHora);
		this.procesosEnBatch.add(nuevaTarea);
		Collections.sort(procesosEnBatch, new Comparator<Tarea>() {
	        @Override
	        public int compare(Tarea tarea1, Tarea tarea2)
	        {
	            return tarea1.getFechaYHora().compareTo(tarea2.getFechaYHora());
	        }
		});
	}
	
	public List<Tarea> getProcesosEnBatch(){
		return this.procesosEnBatch;
	}
}
