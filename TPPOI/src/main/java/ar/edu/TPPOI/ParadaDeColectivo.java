package ar.edu.TPPOI;

public class ParadaDeColectivo extends POI {
	private String linea;
	

	public String getLinea() {
		return linea;
	}


	public void setLinea(String linea) {
		this.linea = linea;
	}


	public boolean estasCercaDe (Punto unaCoordenada){
		return this.estasAMenosDeXMetrosDe (100,unaCoordenada);
	}
	
	public boolean estoyEn(String textoDondeBuscar){
		return super.estoyEn(textoDondeBuscar)||textoDondeBuscar.contains(this.linea);
	}
}
