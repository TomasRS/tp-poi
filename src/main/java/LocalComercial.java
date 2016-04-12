import java.util.List;

public class LocalComercial extends POI {

	private TipoLocal tipo;
	private Double radioCercania;
	private List<Horario> horarios;
	
	
	public boolean estaCercaDe(POI unPOI){
		// a implementar
		return false;
	}
	
	@Override
	public boolean estaDisponibleEn(Momento unMomento) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static LocalComercial nuevaLibreriaEscolar(){
		return null;
	}
	
	public static LocalComercial nuevoKiosko(){
		return null;
	}
	
	public static LocalComercial nuevoLocal(TipoLocal unTipoLocal, Double radioCercania, List<Horario> horarios){
		return null;
	}
}
