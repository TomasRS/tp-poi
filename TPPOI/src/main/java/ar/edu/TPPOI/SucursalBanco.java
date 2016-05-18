package ar.edu.TPPOI;

import org.apache.commons.lang3.StringUtils;
import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	private String nombreSucursal;

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public SucursalBanco(String unNombre, String unNombreSucursal, Point unaCoordenada, Direccion unaDireccion) {
		this(unNombre, unNombreSucursal, unaCoordenada, 500, unaDireccion);
	}

	private SucursalBanco(String unNombre, String unNombreSucursal, Point unaCoordenada, Integer unRadioCercania,
			Direccion unaDireccion) {
		this.nombre = unNombre;
		this.nombreSucursal = unNombreSucursal;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.direccion = unaDireccion;
		this.rubro = "Bancos";
	}

	public boolean coincideConAtributo(String unTextoLibre) {
		return this.getNombre().equals(unTextoLibre) || this.getNombreSucursal().equals(unTextoLibre);
	}

	public boolean soyBanco() {
		return true;
	}

	public boolean soyElMismoPOI(POI otroPOI) {

		if (otroPOI.soyBanco()) {
			SucursalBanco unaSucursalBanco = (SucursalBanco) otroPOI;
			return (StringUtils.containsIgnoreCase(unaSucursalBanco.getNombre(), this.getNombre())
					&& StringUtils.containsIgnoreCase(unaSucursalBanco.getNombreSucursal(), this.getNombreSucursal()));
		} else {
			return false;
		}

	}

	public void actualizar(POI unPOIExterno) {
		this.setCoordenada(unPOIExterno.getCoordenada());
		this.setDireccion(unPOIExterno.getDireccion());
		this.setServicios(((SucursalBanco) unPOIExterno).getServicios());
	}

}
