package ar.edu.TPPOI;

import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	public SucursalBanco(String unNombre, Point unaCoordenada, Direccion unaDireccion) {
		this(unNombre, unaCoordenada, 500, unaDireccion);
	}

	public SucursalBanco(String unNombre, Point unaCoordenada, Integer unRadioCercania, Direccion unaDireccion) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.direccion = unaDireccion;
		this.rubro = "Bancos";
	}
	
	public boolean coincideConAtributo(String unTextoLibre){
		return false;
	}

}
