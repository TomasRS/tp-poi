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

	public Polygon getComuna() {
		return comuna;
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

	public boolean coincideConAtributo(String unTextoLibre) {
		return this.servicios.stream()
				.anyMatch(unServicio -> this.estanContenidos(unTextoLibre, unServicio.getNombre()))
				|| this.getZonasQueIncluye().contains(unTextoLibre)
				||this.direccion.coincideConCalle(unTextoLibre);
	}

	public void actualizar(POI unCGPExterno) {
		this.setCoordenada(unCGPExterno.getCoordenada());
		this.setDireccion(unCGPExterno.getDireccion());
		this.setTags(unCGPExterno.getTags());
		this.setServicios(((CGP) unCGPExterno).getServicios());
	}

	public boolean soyCGP() {
		return true;
	}

	public boolean soyElMismoPOI(POI otroPOI) {
		return otroPOI.soyCGP() && super.soyElMismoPOI(otroPOI);
	}

}
