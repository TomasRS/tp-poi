package ar.edu.TPPOI;

public class Almacenar extends Accion{

	public void ejecutar(String unTextoLibre, Integer cantPOIs, long tiempoDeBusqueda, Terminal unaTerminal){
		
		BusquedaHecha nuevaBusqueda = new BusquedaHecha(unTextoLibre, cantPOIs, tiempoDeBusqueda);
		unaTerminal.agregarBusquedaHecha(nuevaBusqueda);
	}
}
