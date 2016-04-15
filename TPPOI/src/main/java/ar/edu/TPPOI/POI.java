package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

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
	private String depto;
	private String unidad;
	private String codigoPostal;
	private String localidad;
	private String barrio;
	private String provincia;
	private String pais;
	private List<String> palabrasClaves = new ArrayList<>();
	

	public String getCalle1() {
		return calle1;
	}
	public void setCalle1(String calle1) {
		this.calle1 = calle1;
		this.addPalabraClave(calle1);
	}
	public String getCalle2() {
		return calle2;
	}
	public void setCalle2(String calle2) {
		this.calle2 = calle2;
		this.addPalabraClave(calle2);
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
		this.addPalabraClave(String.valueOf(numero));
	}
	public String getCallePrincipal() {
		return callePrincipal;
	}
	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
		this.addPalabraClave(callePrincipal);
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
		this.addPalabraClave(String.valueOf(piso));
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
		this.addPalabraClave(depto);
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
		this.addPalabraClave(unidad);
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
		this.addPalabraClave(codigoPostal);
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
		this.addPalabraClave(localidad);
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
		this.addPalabraClave(barrio);
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
		this.addPalabraClave(provincia);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
		this.addPalabraClave(nombre);
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
		this.addPalabraClave(rubro);
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
		this.addPalabraClave(direccion);
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
		this.addPalabraClave(pais);
	}
	
	public void addPalabraClave(String unAtributo){
		palabrasClaves.add(unAtributo);
	}
	
	public boolean sosValido(){
		return this.tengoNombre() && this.tengoCoordenada();
	}
	
	public boolean tengoNombre(){
		return this.nombre != null;
	}
	
	public boolean tengoCoordenada(){
		return this.getCoordenada() != null;
	}
	
	//Este es el metodo que se va a usar para el "Requerimiento Detallado 1"
	public boolean estasCercaDe (Punto unaCoordenada){
		return this.estasAMenosDeXMetrosDe (500,unaCoordenada);
	}
	
	public boolean estasAMenosDeXMetrosDe (Integer unosMetros, Punto unaCoordenada){
		return this.getCoordenada().distFrom(unaCoordenada) < unosMetros;
	}
	
	//Caso especifico si le mandamos un POI como parametro (reusa el de arriba)
	public boolean estasAMenosDeXMetrosDe (Integer unosMetros, POI unPOI){
		return this.estasAMenosDeXMetrosDe(unosMetros, unPOI.getCoordenada());
	}
	
	public boolean contiene(String unaPalabraClave) throws NoSoyValidoException{
		try {
		return (palabrasClaves
					.stream()
					.anyMatch(unAtributo -> this.estanContenidos(unaPalabraClave,unAtributo))
			   );
		} catch (NoSoyValidoException excepcion){
			return false;
		}
	}
	
	//Delego la comparacion en una biblioteca que baja todo el string a minuscula
	//y hace el contains. Lo hice simetrico con respecto al uno incluido en el otro
	public boolean estanContenidos(String unaPalabraClave, String unAtributo){
		return StringUtils.containsIgnoreCase(unaPalabraClave, unAtributo) ||
			   StringUtils.containsIgnoreCase(unAtributo, unaPalabraClave);
	}
}
