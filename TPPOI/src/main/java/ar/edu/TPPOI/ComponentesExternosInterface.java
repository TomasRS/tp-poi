package ar.edu.TPPOI;

import java.util.List;

public interface ComponentesExternosInterface {

	public List<POI> buscar(String textoLibre);

	public List<POI> buscarCompuesta(String textoLibre, String otroTextoLibre);
}
