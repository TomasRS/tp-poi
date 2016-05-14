package externos;
/*package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class CGPAdapter implements SistemaExternoAdapterInterface{
	
CGPExterno CGPExternoImpostor;
public CGPAdapter(CGPExterno unSistemaConsultaDeCGPsExterno) {
	CGPExternoImpostor = unSistemaConsultaDeCGPsExterno;
}

public List<POI> buscar(String unTextoLibre){
	List<CentroDTO> listaDeCGPsExternos = CGPExternoImpostor.buscar(unTextoLibre);
	if (listaDeCGPsExternos==null){
		List<POI> listaVaciaDePOIs = new ArrayList<>();
		return listaVaciaDePOIs;
	}else
		return this.generarNuevosCGPs(listaDeCGPsExternos);
}

private List<POI> generarNuevosCGPs(List<CentroDTO> listaDeCGPsExternos) {
	List<POI> nuevasCGPs = new ArrayList<>();
	listaDeCGPsExternos.stream().map(unCGP->this.setAtributosParaActualizar(unCGP));
	return nuevasCGPs;
}

private CGP setAtributosParaActualizar(CentroDTO unCGP){
return new CGP(unCGP.partirDomicilio());
	
	
}

@Override
public List<POI> buscar(String unTextoLibre, String otroTextoLibre) {
	// TODO Auto-generated method stub
	return null;
}
}

*/