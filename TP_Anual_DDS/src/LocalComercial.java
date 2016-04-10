
public class LocalComercial extends POI {
	private rubro rubro;
	

	public rubro getRubro() {
		return rubro;
	}

	public void setRubro(rubro rubro) {
		this.rubro = rubro;
	}

	public boolean esCercanoA(POI poi,Comuna comuna){
		rubro.esCercanoA(poi);
	}
}
