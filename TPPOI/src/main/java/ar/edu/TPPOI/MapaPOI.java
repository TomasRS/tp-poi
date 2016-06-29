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
		List<POI> resultadoBusquedaLocal = this.busquedaLocal(textoLibre);
		if (resultadoBusquedaLocal.isEmpty()) {
			List<POI> listaDePOIsExternos = this.buscarEnSistemasExternos(textoLibre);
			this.actualizarPOIsSiCorresponde(listaDePOIsExternos);
			resultadoBusquedaLocal = this.busquedaLocal(textoLibre);
		}
		return resultadoBusquedaLocal;
	}

	public List<POI> busquedaLocal(String textoLibre) {
		return this.getListaDePOIs().stream().filter(unPOI -> unPOI.busqueda(textoLibre)).collect(Collectors.toList());
	}

	public List<POI> buscarEnSistemasExternos(String textoLibre) {
		List<POI> listaDePOIsExternos = new ArrayList<>();
		listaDeSistemaExternoAdapter.stream().forEach(
				unSistemaExternoAdapter -> listaDePOIsExternos.addAll(unSistemaExternoAdapter.buscar(textoLibre)));
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

	private void actualizarPOISiCorresponde(POI unPOIExterno) {
		if (estaEnLocal(unPOIExterno)) {
			buscarPoi(unPOIExterno).actualizar(unPOIExterno);
		} else {
			agregarPOI(unPOIExterno);
		}
	}

	public POI buscarPoi(POI poi) {
		return listaDePOIs.stream().filter(unPOILocal -> unPOILocal.soyElMismoPOI(poi)).findFirst().orElse(null);
	}

	public boolean estaEnLocal(POI unPOIExterno) {
		return buscarPoi(unPOIExterno) != null;
	}

	public void agregarSistemaExternoAdapter(SistemaExternoAdapterInterface unSistemaExternoAdapter) {
		listaDeSistemaExternoAdapter.add(unSistemaExternoAdapter);
	}

	public void borrarSistemaExternoAdapter(SistemaExternoAdapterInterface unSistemaExternoAdapter) {
		listaDeSistemaExternoAdapter.remove(unSistemaExternoAdapter);
	}

	public Integer cantidadDePOIsEncontrados(String unTextoLibre) {
		return this.buscar(unTextoLibre).size();
	}

	

	List<String> obtenerTagsDelPOI(String nombreLocalComercial) {
		return this.getListaDePOIs().stream().filter(unPOI->unPOI.getNombre().equals("cine Abasto")).
				collect(Collectors.toList()).get(0).getTags();
	}

	public POI obtenerPOI(String nombreLocalComercial) {
			return this.getListaDePOIs().stream().filter(unP->unP.getNombre().equals(nombreLocalComercial))
					.collect(Collectors.toList()).get(0);
	}
	
	public void eliminarPOIs(List<String> nombresDeLosPOIs, ProcDarDeBajaPOIs proceso){
		nombresDeLosPOIs.forEach(unNombreDePOI -> this.eliminarElPOI(unNombreDePOI, proceso));
	}

	public void eliminarElPOI(String unNombreDePOI, ProcDarDeBajaPOIs proceso){
		POI poiEncontrado = this.buscar(unNombreDePOI).get(0);
		this.borrarPOI(poiEncontrado);
		proceso.sumarElementosAfectados(1);
	}
}