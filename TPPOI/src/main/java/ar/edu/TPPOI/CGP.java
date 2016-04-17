package ar.edu.TPPOI;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;
import java.util.List;

public class CGP extends EmpresaMultiServicios {

	private Polygon comuna;

	public CGP(String unNombre, String unRubro, Servicio unServicio, Polygon unaComuna){
		this.nombre =  unNombre;
		this.rubro= unRubro;
		this.servicios.add(unServicio);
		this.comuna= unaComuna;
	}
	
	public CGP(String unNombre, String unRubro, List<Servicio> unosServicios, Polygon unaComuna){
		this.nombre =  unNombre;
		this.rubro= unRubro;
		this.servicios.addAll(unosServicios);
		this.comuna= unaComuna;
	}
	
	public boolean estasCercaDe(Point unaCoordenada) {
		return this.comuna.isInside(unaCoordenada);
	}

}
