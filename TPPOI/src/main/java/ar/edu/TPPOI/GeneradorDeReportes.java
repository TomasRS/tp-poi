package ar.edu.TPPOI;

public class GeneradorDeReportes {
	private static GeneradorDeReportes generadorDeReportes;
	
	private GeneradorDeReportes() {
		
	}
	
	public static GeneradorDeReportes getSingletonInstance(){
		if (generadorDeReportes == null){
			generadorDeReportes = new GeneradorDeReportes();
		}
		return generadorDeReportes;
	}
}
