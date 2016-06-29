package ar.edu.TPPOI;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProcDarDeBajaPOIs extends Proceso{
	
	private ServicioBajaPOIs servicioBajaDePOIs;
	
	public void run() {
		List<String> nombresDeLosPOIsABajar = new ArrayList<>();
		nombresDeLosPOIsABajar = servicioBajaDePOIs.getPOIsADarDeBaja();
		
		ResultadoDelProceso resultado=new ResultadoDelProceso(LocalDate.now(),0,true);
		this.setResultadoDeEjecucionDelProceso(resultado);
		
		try{	
			this.getMapa().eliminarPOIs(nombresDeLosPOIsABajar);
			this.sumarUnElementoAfectado();
		}
		catch (Exception e){
			this.accionesEnCasoDeError.forEach(unaA->unaA.ejecutarEnCasoDeFalla(this));
			
		}
		
		
		
	}
}
