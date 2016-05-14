package externos;

import java.util.List;

import ar.edu.TPPOI.POI;

public interface SistemaExternoAdapterInterface {

	public List<POI>  buscar(String unTextoLibre, String otroTextoLibre);

	public List<CentroDTO> buscar(String unTextoLibre);

}
