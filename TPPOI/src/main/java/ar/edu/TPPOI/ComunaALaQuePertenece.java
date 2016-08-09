package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.geodds.Point;

public class ComunaALaQuePertenece extends Criterio{

	Point comunaAsociada;
	
	
	public List<Terminal> filtrarTerminales(ArrayList<Terminal> terminales) {
		
	return	terminales.stream().filter(unaT->unaT.comuna.isInside(this.getComunaAsociada())).collect(Collectors.toList());
	}


	public Point getComunaAsociada() {
		return comunaAsociada;
	}


	public void setComunaAsociada(Point comunaAsociada) {
		this.comunaAsociada = comunaAsociada;
	}

}
