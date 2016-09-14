package criteriosFiltradoTerminales;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.TPPOI.Terminal;
import deApoyo.Poligono;

public class ComunaALaQuePertenece extends Criterio{

	Poligono comunaAsociada;
	
	
	public List<Terminal> filtrarTerminales(ArrayList<Terminal> terminales) {
		
	return	terminales.stream().filter(unaT->unaT.getComuna().equals(comunaAsociada)).collect(Collectors.toList());
	}


	public Poligono getComunaAsociada() {
		return comunaAsociada;
	}


	public void setComunaAsociada(Poligono comunaAsociada) {
		this.comunaAsociada = comunaAsociada;
	}

}
