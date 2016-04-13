package ar.edu.TPPOI;

public abstract class POI {
	private String nombre;
	private String rubro;
	private String direccion;
	private Punto coordenada;
	private String calle1;
	private String calle2;
	private Integer numero;
	private String callePrincipal;
	private Integer piso;
	private char depto;
	private char unidad;
	private String codigoPostal;
	private String localidad;
	private String barrio;
	private String provincia;
	private String pais;
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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCallePrincipal() {
		return callePrincipal;
	}
	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public char getDepto() {
		return depto;
	}
	public void setDepto(char depto) {
		this.depto = depto;
	}
	public char getUnidad() {
		return unidad;
	}
	public void setUnidad(char unidad) {
		this.unidad = unidad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Punto getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Punto unaCoordenada) {
		this.coordenada = unaCoordenada;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	//Este es el metodo base que se va a usar para el "Requerimiento Detallado 1"
	public boolean estasCercaDeLaCoordenada (Punto unaCoordenada){
		return estasAMenosDeXMetrosDe (500,unaCoordenada);
	}
	
	public boolean estasAMenosDeXMetrosDe (Integer unosMetros, Punto unaCoordenada){
		return this.getCoordenada().distFrom(this.getCoordenada().getLatitud(), this.getCoordenada().getLongitud(), unaCoordenada.getLatitud(), unaCoordenada.getLongitud()) < unosMetros;
	}

}
