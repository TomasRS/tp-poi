package ar.edu.TPPOI;

import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania) {
		this.setNombreCoordRadio(unNombre, unaCoordenada, unRadioCercania);
	}
	
	public void setNombreCoordRadio(String unNombre, Point unaCoordenada, Integer radioCercania){
		this.nombre = unNombre;
		this.setCoordenada(unaCoordenada);
		this.radioCercania = radioCercania;
	}
}
