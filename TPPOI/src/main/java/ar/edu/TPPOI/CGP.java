package ar.edu.TPPOI;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class CGP extends EmpresaMultiServicios {

	private Polygon comuna;

	public CGP(String unNombre, String unRubro, Polygon unaComuna) {
		this.nombre = unNombre;
		this.rubro = unRubro;
		this.comuna = unaComuna;
	}

	public boolean estasCercaDe(Point unaCoordenada) {
		return this.comuna.isInside(unaCoordenada);
	}

}
