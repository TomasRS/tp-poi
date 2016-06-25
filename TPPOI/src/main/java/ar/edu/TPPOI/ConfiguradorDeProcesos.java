package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class ConfiguradorDeProcesos {

	List<Proceso> procesos = new ArrayList<>();
	
	public void configurar(Proceso unProceso){
		procesos.add(unProceso);
	}
}
