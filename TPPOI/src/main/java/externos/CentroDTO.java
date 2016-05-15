package externos;

import java.util.List;

public class CentroDTO {
	// esta clase debe ser wraper
	// o venir con sus propios metodos 
	// ya que es externa a nuestro sistema
	
	
	public String id;
	public Integer numeroDeComuna;
	public List<String> zonas;
	public String director;
	public String domicilioCompleto;
	public ServicioDTO[] serviciosDTO;
	public String telefono;
	
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

	public String getDomicilioCompleto() {
		return domicilioCompleto;
	}

	public ServicioDTO[] getServiciosDTO() {
		return serviciosDTO;
	}

	public String getTelefono() {
		return telefono;
	}

}
