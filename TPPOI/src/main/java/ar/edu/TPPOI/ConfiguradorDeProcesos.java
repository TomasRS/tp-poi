package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class ConfiguradorDeProcesos{

	public void agregarProcesoAlBatch(Proceso unProceso, LocalDateTime fechaYHora){
		
		unProceso.esperarParaEjecutar(fechaYHora);
	}    
}
