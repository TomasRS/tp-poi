package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapaPOI {

	List<POI> listaDePOIs = new ArrayList<>();

	public List<POI> getListaDePOIs() {
		return listaDePOIs;
	}

	public List<POI> buscar(String textoLibre) {
		return (this.getListaDePOIs().stream().filter(unPOI -> unPOI.contiene(textoLibre))
				.collect(Collectors.toList()));
	}

	public List<POI> buscar(String textoLibre, String otroTextoLibre) {
		return (this.getListaDePOIs().stream()
				.filter(unPOI -> unPOI.contiene(textoLibre) && unPOI.contiene(otroTextoLibre))
				.collect(Collectors.toList()));
	}

	public void agregarPOI(POI poi) {
		listaDePOIs.add(poi);
	}

	public void borrarPOI(POI poi) {
		listaDePOIs.remove(poi);
	}

}
