package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapaPOI {

	List<POI> listaDePOIs = new ArrayList<>();
	List<SistemaExternoAdapterInterface> listaDeSistemaExternoAdapter = new ArrayList<>();

	public List<POI> getListaDePOIs() {
		return listaDePOIs;
	}

	public List<POI> buscar(String textoLibre) {
		return buscar(textoLibre, "");
	}

	public List<POI> buscar(String textoLibre, String otroTextoLibre) {
		List<POI> listaDePOIsExternos = this.buscarEnSistemasExternos(textoLibre, otroTextoLibre);
		this.actualizarPOIsSiCorresponde(listaDePOIsExternos);
		return this.busquedaLocal(textoLibre, otroTextoLibre);
	}

	public List<POI> busquedaLocal(String textoLibre, String otroTextoLibre) {
		return this.getListaDePOIs().stream().filter(unPOI -> unPOI.busqueda(textoLibre, otroTextoLibre))
				.collect(Collectors.toList());
	}

	public List<POI> buscarEnSistemasExternos(String textoLibre, String otroTextoLibre) {
		List<POI> listaDePOIsExternos = new ArrayList<>();
		listaDeSistemaExternoAdapter.stream().forEach(unSistemaExternoAdapter -> listaDePOIsExternos
				.addAll(unSistemaExternoAdapter.buscar(textoLibre, otroTextoLibre)));
		return listaDePOIsExternos;
	}

	public void agregarPOI(POI poi) {
		listaDePOIs.add(poi);
	}

	public void borrarPOI(POI poi) {
		listaDePOIs.remove(poi);
	}

	
	private void actualizarPOIsSiCorresponde(List<POI> unaListaDePOIs) {
		unaListaDePOIs.stream().forEach(unPOI -> unPOI.busquedaParaActualizarmeSiCorresponde(this));
	 }
	
	public void actualizarPOISiCorresponde(POI unPOI, String unTextoLibre){
		this.busquedaLocal(unTextoLibre, "");
	}
	
	public void actualizarPOISiCorresponde(POI unPOI, String unTextoLibre, String otroTextoLibre){
		List<POI> unaListaPOIs = this.busquedaLocal(unTextoLibre, otroTextoLibre);
		if (unaListaPOIs.size() == 0){
			this.agregarPOI(unPOI);
		}else{
			//unaListaPOIs
		}		
	}
	 

	public void agregarSistemaExternoAdapter(SistemaExternoAdapterInterface unSistemaExternoAdapter) {
		listaDeSistemaExternoAdapter.add(unSistemaExternoAdapter);
	}

	public void borrarSistemaExternoAdapter(SistemaExternoAdapterInterface unSistemaExternoAdapter) {
		listaDeSistemaExternoAdapter.remove(unSistemaExternoAdapter);
	}

}
