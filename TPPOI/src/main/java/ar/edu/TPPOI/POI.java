package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.uqbar.geodds.Point;

public abstract class POI {
	protected String nombre;
	protected String rubro;
	protected Integer radioCercania;
	private String direccion;
	protected Point coordenada;
	private String calle1;
	private String calle2;
	private Integer numero;
	private String callePrincipal;
	private Integer piso;
	private String depto;
	private String unidad;
	private String codigoPostal;
	private String localidad;
	private String barrio;
	private String provincia;
	private String pais;

	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Point getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Point unaCoordenada) {
		this.coordenada = unaCoordenada;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean sosValido() {
		return this.tengoNombre() && this.tengoCoordenada();
	}

	public boolean tengoNombre() {
		return this.nombre != null;
	}

	public boolean tengoCoordenada() {
		return this.getCoordenada() != null;
	}

	// Este es el metodo que se va a usar para el "Requerimiento Detallado 1"
	public boolean estasCercaDe(Point unaCoordenada) {
		return this.estasAMenosDeXMetrosDe(500, unaCoordenada);
	}

	public boolean estasAMenosDeXMetrosDe(Integer unosMetros, Point unaCoordenada) {
		return this.getCoordenada().distance(unaCoordenada) < (unosMetros / 1000.0);
	}

	// Caso especifico si le mandamos un POI como parametro (reusa el de arriba)
	public boolean estasAMenosDeXMetrosDe(Integer unosMetros, POI unPOI) {
		return this.estasAMenosDeXMetrosDe(unosMetros, unPOI.getCoordenada());
	}

	protected List<String> palabrasClave(){
		List<String> posiblesPalabrasClaves = new ArrayList<>();
		posiblesPalabrasClaves.add(nombre);
		posiblesPalabrasClaves.add(rubro);
		posiblesPalabrasClaves.add(direccion);
		posiblesPalabrasClaves.add(calle1);
		posiblesPalabrasClaves.add(calle2);
		posiblesPalabrasClaves.add(String.valueOf(numero));
		posiblesPalabrasClaves.add(callePrincipal);
		posiblesPalabrasClaves.add(String.valueOf(piso));
		posiblesPalabrasClaves.add(depto);
		posiblesPalabrasClaves.add(unidad);
		posiblesPalabrasClaves.add(codigoPostal);
		posiblesPalabrasClaves.add(localidad);
		posiblesPalabrasClaves.add(barrio);
		posiblesPalabrasClaves.add(provincia);
		posiblesPalabrasClaves.add(pais);
		return posiblesPalabrasClaves;
	}
	
	public boolean contiene(String unaPalabraClave) {
		List<String> posiblesPalabrasClaves = this.palabrasClave();
		try {
			return (posiblesPalabrasClaves
					.stream()
					.anyMatch(unAtributo -> this.estanContenidos(unaPalabraClave, unAtributo)));
		} catch (Exception excepcion) {
			return false;
		}
	}

	protected boolean estanContenidos(String unaPalabraClave, String unAtributo) {
		return StringUtils.containsIgnoreCase(unaPalabraClave, unAtributo)
				|| StringUtils.containsIgnoreCase(unAtributo, unaPalabraClave);
	}
}
