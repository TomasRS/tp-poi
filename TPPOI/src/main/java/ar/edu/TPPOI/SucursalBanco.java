package ar.edu.TPPOI;

import java.util.List;

import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania) {
		this.setNombreCoordRadio(unNombre, unaCoordenada, unRadioCercania);
	}
	
	public void agregarServicio (Servicio unServicio){
		this.servicios.add(unServicio);
	}
	public void agregarListaDeServicios (List<Servicio> servicios){
		this.servicios.addAll(servicios);
	}
	public void AgregarServicioAlBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania, Servicio unServicio){
	
	}
	
	public void setNombreCoordRadio(String unNombre, Point unaCoordenada, Integer radioCercania){
		this.nombre = unNombre;
		this.setCoordenada(unaCoordenada);
		this.radioCercania = radioCercania;
	}
}
