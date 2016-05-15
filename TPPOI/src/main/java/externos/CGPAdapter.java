package externos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.TPPOI.CGP;
import ar.edu.TPPOI.POI;

public class CGPAdapter implements SistemaExternoAdapterInterface{
	
	CGPExterno CGPExternoImpostor;
	
	public CGPAdapter(CGPExterno unSistemaConsultaDeCGPsExterno) {
		CGPExternoImpostor = unSistemaConsultaDeCGPsExterno;
	}

	public List<POI> buscar(String unTextoLibre){
		List<CentroDTO> listaDeCGPsExternos = CGPExternoImpostor.buscar(unTextoLibre);
		List<POI> listaCGPEncontrados = new ArrayList<>();
		if (listaDeCGPsExternos==null){//code smells, no deberia retornar null
			//
		} else {
			listaCGPEncontrados = this.generarNuevosCGPs(listaDeCGPsExternos);
		}
		return listaCGPEncontrados;
	}

	private List<POI> generarNuevosCGPs(List<CentroDTO> listaDeCGPsExternos) {
		List<POI> nuevasCGPs = new ArrayList<>();
		listaDeCGPsExternos.stream().forEach(unCGP->nuevasCGPs.add(setAtributosParaActualizar(unCGP)));
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

