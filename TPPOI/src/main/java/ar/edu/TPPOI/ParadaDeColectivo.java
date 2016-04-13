package ar.edu.TPPOI;

public class ParadaDeColectivo extends POI {
	private String linea;
	

	public String getLinea() {
		return linea;
	}


	public void setLinea(String linea) {
		this.linea = linea;
	}


	public boolean estoyCercaRespectoA (POI poi){
		return	this.getPunto().distanciaCoord(this.getPunto().getLatitud(), this.getPunto().getLongitud(), poi.getPunto().getLatitud(),poi.getPunto().getLongitud())<0.01;
	}
}
