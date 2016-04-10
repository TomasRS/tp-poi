import java.util.List;

public class Comuna {
	private double longitudMin;
	private double longitudMax;
	private double latitudMin;
	private double latitudMax;
	public double getLongitudMin() {
		return longitudMin;
	}
	public void setLongitudMin(double longitudMin) {
		this.longitudMin = longitudMin;
	}
	public double getLongitudMax() {
		return longitudMax;
	}
	public void setLongitudMax(double longitudMax) {
		this.longitudMax = longitudMax;
	}
	public double getLatitudMin() {
		return latitudMin;
	}
	public void setLatitudMin(double latitudMin) {
		this.latitudMin = latitudMin;
	}
	public double getLatitudMax() {
		return latitudMax;
	}
	public void setLatitudMax(double latitudMax) {
		this.latitudMax = latitudMax;
	}
	private List<POI> pois;
	public List<POI> getPois() {
		return pois;
	}
	public void setPois(List<POI> pois) {
		this.pois = pois;
	}
	public static Comuna getComuna(){
		return getComuna();
	};
}
