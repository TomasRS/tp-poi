import java.util.List;

public abstract class POI {
	private double latitud;
	private double longitud;
	private String nombre;
	private String calle;
	private Integer altura;
	private List<POI> pois;
	private String calle1;
	private String calle2;
	private Integer piso;
	
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public List<POI> getPois() {
		return pois;
	}

	public void setPois(List<POI> pois) {
		this.pois = pois;
	}

	public static double getAverageRadiusOfEarth() {
		return AVERAGE_RADIUS_OF_EARTH;
	}
	public String getCalle1() {
		return calle1;
	}

	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}

	public String getCalle2() {
		return calle2;
	}

	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getUnidad() {
		return unidad;
	}

	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	private Integer unidad;
	private String localidad;
	private String barrio;
	private String provincia;
	private String pais;
	
	
	public final static double AVERAGE_RADIUS_OF_EARTH = 6371;
	public boolean estoyCercaDe (POI point, Comuna comuna){
		
		return point.esCercanoA(this,Comuna.getComuna());
	}

	public abstract boolean esCercanoA(POI poi, Comuna comuna);

	
	public int calculateDistance(double unPoiLat, double unPoiLong,
	  double otroPoiLat, double otroPoiLong) {

	    double latDistance = Math.toRadians(unPoiLat - otroPoiLat);
	    double lngDistance = Math.toRadians(unPoiLong - otroPoiLong);

	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	      + Math.cos(Math.toRadians(unPoiLat)) * Math.cos(Math.toRadians(otroPoiLat))
	      * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH * c));
	}
}
