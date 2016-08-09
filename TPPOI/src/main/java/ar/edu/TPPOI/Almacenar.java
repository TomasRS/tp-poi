package ar.edu.TPPOI;

public class Almacenar implements Accion{

	public void luegoDeLaBusqueda(BusquedaHecha unaBusqueda, Terminal unaTerminal){
		
		unaTerminal.agregarBusquedaHecha(unaBusqueda);
	}
	
}
