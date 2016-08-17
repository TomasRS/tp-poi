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
		
		this.esperarParaEjecutar(primerTarea);
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
	
	public void esperarParaEjecutar(Tarea unaTarea){
		
		while (LocalDateTime.now().isBefore(unaTarea.getFechaYHora())){
		    // Espera
		}
		unaTarea.getProceso().run();
//		System.out.println("Se ejecuto el proceso de fecha: "+unaTarea.getFechaYHora());
		tareasEnBatch.remove(unaTarea);
		
		if (!tareasEnBatch.isEmpty()){
			this.esperarParaEjecutar(tareasEnBatch.get(0));
		}

	}

}
