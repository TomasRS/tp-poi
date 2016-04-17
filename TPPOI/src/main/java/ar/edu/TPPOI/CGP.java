package ar.edu.TPPOI;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;
import java.util.List;

public class CGP extends EmpresaMultiServicios {

	private Polygon comuna;

	public CGP(String unNombre, String unRubro, Servicio unServicio, Polygon unaComuna){
		this.setNombreRubroComuna(unNombre, unRubro, unaComuna);
		this.servicios.add(unServicio);
	}
	
	public CGP(String unNombre, String unRubro, List<Servicio> unosServicios, Polygon unaComuna){
		this.setNombreRubroComuna(unNombre, unRubro, unaComuna);
		this.servicios.addAll(unosServicios);
	}
	
	public boolean estasCercaDe(Point unaCoordenada) {
		return this.comuna.isInside(unaCoordenada);
	}
	
	public void setNombreRubroComuna(String unNombre, String unRubro, Polygon unaComuna){
		this.nombre = unNombre;
		this.rubro = unRubro;
		this.comuna = unaComuna;
	}

}
