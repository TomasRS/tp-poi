package ar.edu.TPPOI;

public class ParadaDeColectivo extends POI {
	private String linea;
	

	public String getLinea() {
		return linea;
	}


	public void setLinea(String linea) {
		this.linea = linea;
	}


	public boolean estasCercaDeLaCoordenada (Punto unaCoordenada){
		return estasAMenosDeXMetrosDe (100,unaCoordenada);
	}
}
