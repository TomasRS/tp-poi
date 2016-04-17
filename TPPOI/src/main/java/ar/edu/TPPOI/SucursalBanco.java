package ar.edu.TPPOI;

import java.util.List;

import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania, Servicio unServicio) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.servicios.add(unServicio);

	}
	
	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania, List<Servicio> unosServicios) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.servicios.addAll(unosServicios);

	}
}
