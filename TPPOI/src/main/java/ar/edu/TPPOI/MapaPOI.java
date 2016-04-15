package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapaPOI {

	List<POI> listaDePOIs = new ArrayList<>();
	
	public List<POI> getListaDePOIs() {
		return listaDePOIs;
	}

	public List<POI> buscar(String palabraClave){
		return (this.getListaDePOIs()
					.stream()
					.filter(unPOI -> unPOI.contiene(palabraClave))
					.collect(Collectors.toList()));
	}
}
