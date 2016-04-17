package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

import org.uqbar.geodds.Point;

public class ParadaDeColectivo extends POI {
	private String linea;

	public ParadaDeColectivo(String unNombre, Point unaCoordenada) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
	}

	protected List<String> palabrasClave() {
		List<String> posiblesPalabrasClaves = super.palabrasClave();
		posiblesPalabrasClaves.add(this.linea);
		return posiblesPalabrasClaves;
	}

	public boolean estasCercaDe(Point unaCoordenada) {
		return this.estasAMenosDeXMetrosDe(100, unaCoordenada);
	}

	public boolean estaDisponible(LocalDateTime unMomento, Servicio unServicio) {
		return true;
	}

}
