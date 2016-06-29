package ar.edu.TPPOI;

import java.util.List;
import java.util.ArrayList;

public class ProcDarDeBajaPOIs extends Proceso{
	
	private ServicioBajaPOIs servicioBajaDePOIs;
	
	public void run() {
		List<String> nombresDeLosPOIsABajar = new ArrayList<>();
		nombresDeLosPOIsABajar = servicioBajaDePOIs.getPOIsADarDeBaja();
		
		this.instanciarResultadoDeEjecucion();
		
		try{	
			this.getMapa().eliminarPOIs(nombresDeLosPOIsABajar, this);
		}
		catch (Exception e){
			this.accionesEnCasoDeError.forEach(unaA->unaA.ejecutarEnCasoDeFalla(this));
			this.getResultadoDeEjecucionDelProceso().setResultadoDeLaEjecucion(false);
		}
			
	}
	
	public void setServicioDeBaja(ServicioBajaPOIs servicioBajaDePOIs){
		this.servicioBajaDePOIs = servicioBajaDePOIs;
	}
}
