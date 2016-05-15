package externos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.TPPOI.CGP;
import ar.edu.TPPOI.Direccion;
import ar.edu.TPPOI.POI;

public class CGPAdapter implements SistemaExternoAdapterInterface{
	
	CGPExternoImpostor CGPExternoImpostor;
	
	public CGPAdapter(CGPExternoImpostor unSistemaConsultaDeCGPsExterno) {
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
		listaDeCGPsExternos.stream().forEach(unCGPExterno->nuevasCGPs.add(crearCGPDeExterno(unCGPExterno)));
		return nuevasCGPs;
	}

	private CGP crearCGPDeExterno(CentroDTO unCGPExterno){
		CGP nuevoCGP = new CGP(partirDomicilio(unCGPExterno));
		
		return nuevoCGP;
	}
	
	public Direccion partirDomicilio(CentroDTO unCGPExterno) {
		Integer numeracion=0;
		String callePrincipal="";
		String str = unCGPExterno.getDomicilioCompleto();
		String delimiter = "";
		String[] temp;
		temp = str.split(delimiter);
		for (int i = unCGPExterno.getDomicilioCompleto().length()-1;i==0; i--)
		{
		numeracion=Integer.parseInt(temp[1]);
		callePrincipal=str.substring(0, str.length()-temp.length);
		}
		Direccion domicilioConvertido= new Direccion();
		domicilioConvertido.setPrincipal(callePrincipal, numeracion);
		return domicilioConvertido;
	}

	@Override
	public List<POI> buscar(String unTextoLibre, String otroTextoLibre) {
		// TODO Auto-generated method stub
		return null;
	}
}

