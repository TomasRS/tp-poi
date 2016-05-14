package externos;

import java.util.List;

import ar.edu.TPPOI.POI;

public class CGPExterno implements SistemaExternoAdapterInterface{

	private CentroDTO CGPExterno;


	public List<CentroDTO> buscar(String unTextoLibre) {
		return CGPExterno.traer();
	}


	@Override
	public List<POI> buscar(String unTextoLibre, String otroTextoLibre) {
		// TODO Auto-generated method stub
		return null;
	}
}
