package ar.edu.TPPOI;

import java.time.LocalDate;

public class ObtenerReporte extends Accion {

	
	public int cantidadDeBusquedasPorFecha(LocalDate fecha, AlmacenTerminales unAlmacen){
		//modificar bien el return para que devuelva lo que corresponde
		return unAlmacen.busquedasEnFecha(fecha).size();
	}
	
	
	
}
