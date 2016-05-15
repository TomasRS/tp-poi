package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import externos.SistemaExternoAdapterInterface;

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
		unaListaDePOIs.stream().forEach(unPOI -> actualizarPOISiCorresponde(unPOI));
	 }
	
	private void actualizarPOISiCorresponde(POI unPOIExterno){
		if (estaEnLocal(unPOIExterno)){
			//actualiza POI
		} else {
			agregarPOI(unPOIExterno);
		}
	}

	private boolean estaEnLocal(POI unPOIExterno){
		return listaDePOIs.stream().anyMatch(unPOILocal -> unPOILocal.soyElMismoPOI(unPOIExterno));
	}
	
	//metodo que retorna la lista de los ids de POIs como string (lo use para verificar algunas cosas)
	private String enLista(){
		String salida = "";
		for (POI unPOI: listaDePOIs){
			salida += unPOI.getId() + ',';
		}
		return salida;
	}

	public void agregarSistemaExternoAdapter(SistemaExternoAdapterInterface unSistemaExternoAdapter) {
		listaDeSistemaExternoAdapter.add(unSistemaExternoAdapter);
	}

	public void borrarSistemaExternoAdapter(SistemaExternoAdapterInterface unSistemaExternoAdapter) {
		listaDeSistemaExternoAdapter.remove(unSistemaExternoAdapter);
	}

}
