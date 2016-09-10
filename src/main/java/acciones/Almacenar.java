package acciones;

import ar.edu.TPPOI.BusquedaHecha;
import ar.edu.TPPOI.Terminal;

public class Almacenar implements Accion{

	public void ejecutarLuegoDeLaBusqueda(BusquedaHecha unaBusqueda, Terminal unaTerminal){
		
		unaTerminal.agregarBusquedaHecha(unaBusqueda);
	}
	
}
