
public abstract class POI {
	private String nombre;
	private String rubro;
	private Direccion direccion;
	private Coordenada coordenada;
	
	public boolean estaCercaDe(POI unPOI){
		// a implementar
		return false;
	}
	
	public boolean esValido(){
		//a implementar
		return false;
	}
	
	public abstract boolean estaDisponibleEn(Momento unMomento);
}
