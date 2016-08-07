package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConfiguradorDeProcesos{

	List<Tarea> tareasEnBatch = new ArrayList<>();
	List<String> numeros = new ArrayList<>();
	
	public void agregarProcesoAlBatch(Proceso unProceso, LocalDateTime fechaYHora){
		Tarea nuevaTarea = new Tarea(unProceso, fechaYHora);
		this.tareasEnBatch.add(nuevaTarea);
		this.ordenarTareasDelBatch();
	}
	
	public void iniciarModoBatch(){
		Tarea primerTarea = this.getTareasEnBatch().get(0);
		
		this.esperarParaEjecutarElPrimero(primerTarea);
	}
	
	//---------------------------------------------------------
	public List<Tarea> getTareasEnBatch(){
		return this.tareasEnBatch;
	}
	
	public void ordenarTareasDelBatch(){
		Collections.sort(tareasEnBatch, new Comparator<Tarea>() {
	        @Override
	        public int compare(Tarea tarea1, Tarea tarea2)
	        {
	            return tarea1.getFechaYHora().compareTo(tarea2.getFechaYHora());
	        }
		});
	}
	
	public void esperarParaEjecutarElPrimero(Tarea unaTarea){
		LocalDateTime dateTime2 = LocalDateTime.now();
		long diffInMilli = java.time.Duration.between(dateTime2, unaTarea.getFechaYHora()).toMillis();
		try {
			Thread.sleep(diffInMilli);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			unaTarea.getProceso().run();
			tareasEnBatch.remove(0);
			
			if (!tareasEnBatch.isEmpty()){
				this.esperarParaEjecutarElPrimero(tareasEnBatch.get(0));
			}
			
		}
	}

}
