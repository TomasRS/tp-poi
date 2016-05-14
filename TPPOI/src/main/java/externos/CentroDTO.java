package externos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.edu.TPPOI.Direccion;
import ar.edu.TPPOI.Intervalo;
import ar.edu.TPPOI.POI;
import ar.edu.TPPOI.Rango;

public class CentroDTO {
	
	private String id;
	private Integer numeroDeComuna;
	
	public Integer getNumeroDeComuna() {
		return numeroDeComuna;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNumeroDeComuna(Integer numeroDeComuna) {
		this.numeroDeComuna = numeroDeComuna;
	}

	public List<String> getZonas() {
		return zonas;
	}

	public void setZonas(List<String> zonas) {
		this.zonas = zonas;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDomicilioCompleto() {
		return domicilioCompleto;
	}

	public void setDomicilioCompleto(String domicilioCompleto) {
		this.domicilioCompleto = domicilioCompleto;
	}

	public Map<String, List<List<Intervalo>>> getServiciosDTO() {
		return serviciosDTO;
	}

	public void setServiciosDTO(Map<String, List<List<Intervalo>>> serviciosDTO) {
		this.serviciosDTO = serviciosDTO;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rango getRangos() {
		return rangos;
	}

	public void setRangos(Rango rangos) {
		this.rangos = rangos;
	}

	private List<String> zonas;
	private String director;
	private String domicilioCompleto;
	private Map<String,List<List<Intervalo>>> serviciosDTO;
	private String telefono;
	private Rango rangos;
	
	public List<CentroDTO> traer() {
		CentroDTO nuevoCGP = new CentroDTO();
		List<CentroDTO> listaDeCGPsExternosParaElAdapter= new ArrayList <CentroDTO>();
		Rango rangos= new Rango();
		rangos.traer();
		nuevoCGP.setId("Identificador 3");
		nuevoCGP.setDirector("Juan");
		nuevoCGP.setDomicilioCompleto("Junin 521");
		nuevoCGP.zonas.add("San Cristobal");
		nuevoCGP.zonas.add("Balvanera");
		nuevoCGP.setNumeroDeComuna(3);
		nuevoCGP.setTelefono("4375-0644/45");
		nuevoCGP.setRangos(rangos);
		this.serviciosDTO.put("asesoramiento", rangos.traer());
		listaDeCGPsExternosParaElAdapter.add(nuevoCGP);		
		return listaDeCGPsExternosParaElAdapter;
	}

	public POI setAtributosParaActualizar() {
		return null;
		
	}

	public Direccion partirDomicilio() {
		Integer numeracion=0;
		String callePrincipal="";
		String str = this.domicilioCompleto;
		String delimiter = "";
		String[] temp;
		temp = str.split(delimiter);
		for (int i = this.getDomicilioCompleto().length()-1;i==0; i--)
		{
		numeracion=Integer.parseInt(temp[1]);
		callePrincipal=str.substring(0, str.length()-temp.length);
		}
		Direccion domicilioConvertido= new Direccion();
		domicilioConvertido.setPrincipal(callePrincipal, numeracion);
		return domicilioConvertido;
	}
}
