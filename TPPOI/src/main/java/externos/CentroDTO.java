package externos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.edu.TPPOI.Direccion;
import ar.edu.TPPOI.Intervalo;
import ar.edu.TPPOI.POI;
import ar.edu.TPPOI.Rango;

public class CentroDTO {
	// esta clase debe ser wraper
	// o venir con sus propios metodos 
	// ya que es externa a nuestro sistema
	
	
	public String id;
	public Integer numeroDeComuna;
	public List<String> zonas;
	public String director;
	public String domicilioCompleto;
	public Map<String,List<List<Intervalo>>> serviciosDTO;
	public String telefono;
	public Rango rangos;
	
	public Integer getNumeroDeComuna() {
		return numeroDeComuna;
	}

	public String getId() {
		return id;
	}

	public List<String> getZonas() {
		return zonas;
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

	public Map<String, List<List<Intervalo>>> getServiciosDTO() {
		return serviciosDTO;
	}

	public String getTelefono() {
		return telefono;
	}

	public Rango getRangos() {
		return rangos;
	}
	
	/*public List<CentroDTO> traer() {
		//esto va en el mock
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
	}*/
}
