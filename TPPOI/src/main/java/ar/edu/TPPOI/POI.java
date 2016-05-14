package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.uqbar.geodds.Point;

public abstract class POI {
	protected String id;
	protected String nombre;
	protected String rubro;
	protected Integer radioCercania;
	protected Point coordenada;
	protected Direccion direccion;
	protected List<String> tags = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public Integer getRadioCercania() {
		return radioCercania;
	}

	public void setRadioCercania(Integer radioCercania) {
		this.radioCercania = radioCercania;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setCoordenada(Point coordenada) {
		this.coordenada = coordenada;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Point getCoordenada() {
		return coordenada;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public void setTag(String unTag) {
		this.tags.add(unTag);
	}

	public abstract boolean coincideConAtributo(String unTextoLibre);
	
	public boolean soyElMismoPOI(POI otroPOI){
		return otroPOI.getId() == id;
	}

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

	private boolean estasAMenosDeXMetrosDe(Integer unosMetros, Point unaCoordenada) {
		return this.distanciaAUnaCoordenada(unaCoordenada) < (unosMetros / 1000.0);
	}

	private double distanciaAUnaCoordenada(Point unaCoordenada) {
		return this.getCoordenada().distance(unaCoordenada);
	}

	public boolean estasAMenosDeXMetrosDe(Integer unosMetros, POI unPOI) {
		return this.estasAMenosDeXMetrosDe(unosMetros, unPOI.getCoordenada());
	}

	private boolean coincideConAlgunTag(String unTextoLibre) {
		return tags.stream().anyMatch(unTag -> unTag.equals(unTextoLibre));
	}

	public boolean busqueda(String unTextoLibre, String otroTextoLibre) {
		return busquedaConcreta(unTextoLibre) && (otroTextoLibre == "" || busquedaConcreta(otroTextoLibre));
	}

	private boolean busquedaConcreta(String unTextoLibre) {
		return this.coincideConAtributo(unTextoLibre) || this.coincideConAlgunTag(unTextoLibre);
	}

	protected boolean estanContenidos(String unaPalabraClave, String unAtributo) {
		return StringUtils.containsIgnoreCase(unaPalabraClave, unAtributo)
				|| StringUtils.containsIgnoreCase(unAtributo, unaPalabraClave);
	}

	public String printString() {
		return nombre + rubro + radioCercania.toString() + coordenada.toString();
	}
	
	public void busquedaParaActualizarmeSiCorresponde(MapaPOI unMapaPOI){
		unMapaPOI.actualizarPOISiCorresponde(this, this.getNombre());
	}
	

}
