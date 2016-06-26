package ar.edu.TPPOI;

import java.time.LocalDate;
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

	public void actualizarLocalesComerciales(String nombreLocalComercial, List<String> tagsParaActualizar, ProcActualizarLocalesComerciales procActualizarLocalesComerciales) {
		List<String>listaDeTags=this.obtenerTagsDelPOI(nombreLocalComercial);
		this.actualizarTags(listaDeTags, tagsParaActualizar,procActualizarLocalesComerciales );
			}

	public boolean actualizarTags(List<String> listaDeTags, List<String> tagsParaActualizar, ProcActualizarLocalesComerciales procActualizarLocalesComerciales) {
		Integer elementosAfectados=0;
		for (Integer i=0; i<listaDeTags.size();i++){
			if (listaDeTags.contains(tagsParaActualizar.get(i))){
		}else{
			listaDeTags.add(tagsParaActualizar.get(i));
			elementosAfectados++;
		}
		}
		ResultadoDelProceso resultado=new ResultadoDelProceso(LocalDate.now(),elementosAfectados,true);
		procActualizarLocalesComerciales.setResultadoDeEjecucion(resultado);
		return true;
	}

	private List<String> obtenerTagsDelPOI(String nombreLocalComercial) {
		return this.getListaDePOIs().stream().filter(unPOI->unPOI.getNombre().equals("cine Abasto")).
				collect(Collectors.toList()).get(0).getTags();
	}

}