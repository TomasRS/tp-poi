package ar.edu.TPPOI;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ConfigurarProcesosTest {
	ProcActualizarLocalesComerciales actualizadorDeLocalesComerciales;
	ConfiguradorDeProcesos configuradorDeProcesos;
	SoporteDeInstanciasParaTestsBuilder soporteParaTests=new SoporteDeInstanciasParaTestsBuilder();
	
	@Before
	public void init(){
		Calendar calendar1 = Calendar.getInstance();
	actualizadorDeLocalesComerciales= soporteParaTests.actualizadorDeLocalesComerciales();
	configuradorDeProcesos= soporteParaTests.configuradorDeProcesos();
	Date horario1= new Date();
	
	}
	
	@Test
	public void seConfiguraUnProcesoParaUnHorarioDweterminado(){
		
	}

}
