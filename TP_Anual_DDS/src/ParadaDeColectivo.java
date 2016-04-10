
public class ParadaDeColectivo extends POI{
	
	public ParadaDeColectivo(){
		super();
	}
	public boolean esCercanoA (POI poi, Comuna comuna){
		return 0.1>(double)this.calculateDistance(super.getLatitud(), super.getLongitud(), poi.getLatitud(), poi.getLongitud());
	}

}
