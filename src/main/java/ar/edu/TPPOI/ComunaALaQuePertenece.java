package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.uqbar.geodds.Polygon;

public class ComunaALaQuePertenece extends Criterio{

	Polygon comunaAsociada;
	
	
	public List<Terminal> filtrarTerminales(ArrayList<Terminal> terminales) {
		
	return	terminales.stream().filter(unaT->unaT.comuna.equals(comunaAsociada)).collect(Collectors.toList());
	}


	public Polygon getComunaAsociada() {
		return comunaAsociada;
	}


	public void setComunaAsociada(Polygon comunaAsociada) {
		this.comunaAsociada = comunaAsociada;
	}

}
