package ar.edu.TPPOI;

public class Punto {
	private double latitud;
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	private double longitud;

	
	public double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
		
		double EARTH_RADIUS_KM=6371;
		// Conversion de grados a radianes de las latitudes
		double firstLatToRad = Math.toRadians(lat1);
		double secondLatToRad = Math.toRadians(lat2);

		// Diferencia de longitudes
		double deltaLongitudeInRad = Math.toRadians(lng2 - lng1);

		// Calculo de la distancia entre los puntos
		return Math.acos(Math.cos(firstLatToRad) * Math.cos(secondLatToRad)
		* Math.cos(deltaLongitudeInRad) + Math.sin(firstLatToRad)
		* Math.sin(secondLatToRad))
		* EARTH_RADIUS_KM;
	}  

}
