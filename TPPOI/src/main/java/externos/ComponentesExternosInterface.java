package externos;

import java.util.List;

import ar.edu.TPPOI.POI;

public interface ComponentesExternosInterface {

	public List<POI> buscar(String textoLibre);

	public List<POI> buscarCompuesta(String textoLibre, String otroTextoLibre);
}
