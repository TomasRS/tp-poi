package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Timer;


public class ConfiguradorDeProcesos extends Timer{

	List<Proceso> procesos = new ArrayList<>();
	
	public void schedule(Proceso unProceso, Calendar calendario){
		this.schedule(unProceso, calendario);
		Collections.sort(this.procesos);
		procesos.add(unProceso);
	}

	
	
}
