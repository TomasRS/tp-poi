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
	protected List<String> tags = new ArrayList<>();

	// Getters y setters
	public String getNombre() {
		return this.nombre;
	}

	public Point getCoordenada() {
		return coordenada;
	}
	
	public List<String> getTags(){
		return this.tags;
	}

	public void setTag(String unTag){
		this.tags.add(unTag);
	}
	// --------------------Fin-Getters----------------------------
	
	public abstract boolean coincideConAtributo(String unTextoLibre);
	
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
	
	public boolean coincideConAlgunTag(String unTextoLibre){
		return tags.stream()
				   .anyMatch(unTag -> unTag.equals(unTextoLibre));
	}


	public boolean contiene(String unTextoLibre){
		return (this.coincideConAtributo(unTextoLibre) ||
				this.coincideConAlgunTag(unTextoLibre));
	}
	
	protected boolean estanContenidos(String unaPalabraClave, String unAtributo) {
		return StringUtils.containsIgnoreCase(unaPalabraClave, unAtributo)
				|| StringUtils.containsIgnoreCase(unAtributo, unaPalabraClave);
	}
	
	

}
