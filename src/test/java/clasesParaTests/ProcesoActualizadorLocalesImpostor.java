package clasesParaTests;

import ar.edu.TPPOI.ProcActualizarLocalesComerciales;

public class ProcesoActualizadorLocalesImpostor extends ProcActualizarLocalesComerciales {
	
	public void ejecutar(){
		procesarLinea("Starbucks;cafe te muffin");
		procesarLinea("musimundo;musica");
		procesarLinea("cine Abasto;pochoclos peliculas entradas cine");
		procesarLinea("SportClub;aparatos");
	}
	
}
