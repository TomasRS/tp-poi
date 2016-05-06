package ar.edu.TPPOI;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapaPOI {

	List<POI> listaDePOIs = new ArrayList<>();
	
	public List<POI> getListaDePOIs() {
		return listaDePOIs;
	}

	public List<POI> buscar(String textoLibre){
		return (this.getListaDePOIs()
			.stream()
			.filter(unPOI -> unPOI.contiene(textoLibre))
			.collect(Collectors.toList()));
	}
	
	public void agregarPOI(POI poi){
		listaDePOIs.add(poi);
	}
	
	public void borrarPOI(POI poi){
		listaDePOIs.remove(poi);
	}

	public void modificarNombre(String nombreNuevo, String poiQueQuieroCambiar){
		Collator comparador = Collator.getInstance();
		comparador.setStrength(Collator.PRIMARY);
		this.getListaDePOIs()
		.stream()
		.filter(unPOI-> 0==comparador.compare(poiQueQuieroCambiar,unPOI.getNombre()))
		.collect(Collectors.toList())
		.get(0)
		.setNombre(nombreNuevo);
}
}
