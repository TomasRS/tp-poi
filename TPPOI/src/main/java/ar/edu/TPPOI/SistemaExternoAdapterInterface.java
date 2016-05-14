package ar.edu.TPPOI;

import java.util.List;

public interface SistemaExternoAdapterInterface {

	public List<POI>  buscar(String unTextoLibre, String otroTextoLibre);

	public List<CentroDTO> buscar(String unTextoLibre);

}
