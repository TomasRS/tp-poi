package ar.edu.TPPOI;

import java.util.List;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class CGP extends EmpresaMultiServicios {

	private Polygon comuna;
	private List<String> zonasQueIncluye;

	public List<String> getZonasQueIncluye() {
		return zonasQueIncluye;
	}

	public void setZonasQueIncluye(List<String> zonasQueIncluye) {
		this.zonasQueIncluye = zonasQueIncluye;
	}

	public CGP(String unNombre, String unRubro, Polygon unaComuna, Direccion unaDireccion) {
		this.nombre = unNombre;
		this.rubro = unRubro;
		this.comuna = unaComuna;
		this.direccion = unaDireccion;
	}

	public boolean estasCercaDe(Point unaCoordenada) {
		return this.comuna.isInside(unaCoordenada);
	}
	
	public boolean coincideConAtributo(String unTextoLibre){
		return servicios.stream()
						.anyMatch(unServicio -> this.estanContenidos(unTextoLibre, unServicio.getNombre()));
	}

}
