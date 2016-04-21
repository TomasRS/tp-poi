package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.uqbar.geodds.Point;

public abstract class POI {
	protected String nombre;
	protected String rubro;
	protected Integer radioCercania;
	protected Point coordenada;
	protected Direccion direccion;

	// Getters
	public String getNombre() {
		return this.nombre;
	}

	public Point getCoordenada() {
		return coordenada;
	}

	// --------------------Fin-Getters----------------------------

	public boolean sosValido() {
		return this.tengoNombre() && this.tengoCoordenada();
	}

	public boolean tengoNombre() {
		return this.getNombre() != null;
	}

	public boolean tengoCoordenada() {
		return this.getCoordenada() != null;
	}

	public boolean estasCercaDe(Point unaCoordenada) {
		return this.estasAMenosDeXMetrosDe(this.radioCercania, unaCoordenada);
	}

	public boolean estasAMenosDeXMetrosDe(Integer unosMetros, Point unaCoordenada) {
		return this.distanciaAUnaCoordenada(unaCoordenada) < (unosMetros / 1000.0);
	}

	public double distanciaAUnaCoordenada(Point unaCoordenada) {
		return this.getCoordenada().distance(unaCoordenada);
	}

	public boolean estasAMenosDeXMetrosDe(Integer unosMetros, POI unPOI) {
		return this.estasAMenosDeXMetrosDe(unosMetros, unPOI.getCoordenada());
	}

	protected List<String> palabrasClave() {
		List<String> posiblesPalabrasClaves = new ArrayList<>();
		posiblesPalabrasClaves.add(nombre);
		posiblesPalabrasClaves.add(rubro);
		posiblesPalabrasClaves.addAll(direccion.posiblesPalabrasClaves());
		return posiblesPalabrasClaves;
	}

	public boolean contiene(String unaPalabraClave) {
		List<String> posiblesPalabrasClaves = this.palabrasClave();
		return (posiblesPalabrasClaves.stream()
				.anyMatch(unAtributo -> this.estanContenidos(unaPalabraClave, unAtributo)));
	}

	protected boolean estanContenidos(String unaPalabraClave, String unAtributo) {
		return StringUtils.containsIgnoreCase(unaPalabraClave, unAtributo)
				|| StringUtils.containsIgnoreCase(unAtributo, unaPalabraClave);
	}
}
