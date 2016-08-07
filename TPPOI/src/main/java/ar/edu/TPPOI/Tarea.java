package ar.edu.TPPOI;

import java.time.LocalDateTime;

public class Tarea {

	Proceso proceso;
	LocalDateTime fechaYHora;
	
	public Tarea (Proceso unProceso, LocalDateTime fechaYHora){
		this.proceso = unProceso;
		this.fechaYHora = fechaYHora;
	}
	
	public Proceso getProceso(){
		return this.proceso;
	}
	
	public LocalDateTime getFechaYHora(){
		return this.fechaYHora;
	}
}
