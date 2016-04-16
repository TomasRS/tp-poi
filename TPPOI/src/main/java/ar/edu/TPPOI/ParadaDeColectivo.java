package ar.edu.TPPOI;

import java.time.LocalDateTime;

import org.uqbar.geodds.Point;

public class ParadaDeColectivo extends POI {
	private String linea;
	
	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
		this.addPalabraClave(linea);
	}

	public boolean estasCercaDe (Point unaCoordenada){
		return this.estasAMenosDeXMetrosDe (100,unaCoordenada);
	}
	
	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio){
		return true;
	}
	

}
