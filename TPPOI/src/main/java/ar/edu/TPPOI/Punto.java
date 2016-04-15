package ar.edu.TPPOI;

public class Punto {
	private double latitud;
	private double longitud;
	
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
	

	//Formula para calcular la distancia entre dos coordenadas (lat, long) EN FORMA DECIMAL
	public double distFrom(Punto unaCoordenada) {
		double lat1 = this.getLatitud();
		double lng1 = this.getLongitud();
		double lat2 = unaCoordenada.getLatitud();
		double lng2 = unaCoordenada.getLongitud();
		
	    double earthRadius = 6371000; //meters
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = (double) (earthRadius * c);
	    
	    //LO DEVUELVE EN METROS
	    return dist;
	    } 

}
