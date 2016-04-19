package ar.edu.TPPOI;

import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	public SucursalBanco(String unNombre, Point unaCoordenada) {
		this(unNombre, unaCoordenada, 500);
	}

	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania) {
		this.nombre = unNombre;
		this.setCoordenada(unaCoordenada);
		this.radioCercania = unRadioCercania;
	}

}
