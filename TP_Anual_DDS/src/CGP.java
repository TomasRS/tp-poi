
public class CGP extends POI{
	public boolean esCercanoA(POI poi, Comuna comuna){
		return poi.getLatitud()<=comuna.getLatitudMax()&poi.getLatitud()>=comuna.getLatitudMin()
				&poi.getLongitud()<=comuna.getLongitudMax()&poi.getLongitud()>=comuna.getLongitudMin();
	}
}
