package pois;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

@Entity
public class CGP extends EmpresaMultiServicios {
	
	@Transient
	private Polygon comuna;
	@ElementCollection
	private List<String> zonasQueIncluye;
	
	@SuppressWarnings(value="unnused")
	public CGP(){}

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
				|| this.getZonasQueIncluye().contains(unTextoLibre) || this.direccion.coincideConCalle(unTextoLibre);
	}

	public void actualizar(POI unCGPExterno) {
		this.actualizarDesdeDatos(unCGPExterno.getCoordenada(), unCGPExterno.getDireccion(), unCGPExterno.getTags(),
				((CGP) unCGPExterno).getServicios());
	}

	public void actualizarDesdeDatos(Point unaCoordenada, Direccion unaDireccion, List<String> unosTags,
			List<Servicio> unosServicios) {
		this.setCoordenada(unaCoordenada);
		this.direccion = unaDireccion;
		this.tags = unosTags;
		this.servicios = unosServicios;
	}

	public boolean esCGP() {
		return true;
	}

	public boolean soyElMismoPOI(POI otroPOI) {
		return otroPOI.esCGP() && super.soyElMismoPOI(otroPOI);
	}

}