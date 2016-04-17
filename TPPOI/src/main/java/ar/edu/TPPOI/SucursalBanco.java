package ar.edu.TPPOI;

import java.util.List;

import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania, Servicio unServicio) {
		this.setNombreCoordRadio(unNombre, unaCoordenada, unRadioCercania);
		this.servicios.add(unServicio);
	}

	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania, List<Servicio> unosServicios) {
		this.setNombreCoordRadio(unNombre, unaCoordenada, unRadioCercania);
		this.servicios.addAll(unosServicios);
	}
	
	public void setNombreCoordRadio(String unNombre, Point unaCoordenada, Integer radioCercania){
		this.nombre = unNombre;
		this.setCoordenada(unaCoordenada);
		this.radioCercania = radioCercania;
	}
}
