package ar.edu.TPPOI;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ActualizarLocalesComercialesTest {
	
	ProcActualizarLocalesComerciales actualizadorDeLocalesComerciales;
	MapaPOI mapaInteractivo;
	LocalComercial cineAbasto;
	ConfiguradorDeProcesos configuradorDeProcesos;
	
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		cineAbasto = soporteParaTests.cineAbasto();
		actualizadorDeLocalesComerciales= new ProcActualizarLocalesComerciales();
		mapaInteractivo=soporteParaTests.mapa();
		actualizadorDeLocalesComerciales.setMapa(mapaInteractivo);
		configuradorDeProcesos=new ConfiguradorDeProcesos();

	
	}
	
	@Test
	public void seActualizanLosTagsDelCineAbasto(){
		
		actualizadorDeLocalesComerciales.ejecutar();
		Assert.assertEquals(3, actualizadorDeLocalesComerciales.getResultadoDeEjecucion().getCantidadDeElementosAfectados(),0);
	}
}