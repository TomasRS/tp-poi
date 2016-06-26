package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Timer;


public class ConfiguradorDeProcesos extends Timer{

	List<Proceso> procesos = new ArrayList<>();
	
	public void configurar(Proceso unProceso, Date unHorario){
		this.schedule(unProceso, unHorario);
		Collections.sort(this.procesos);
		procesos.add(unProceso);
	}

	
	
}
