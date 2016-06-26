package ar.edu.TPPOI;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ActualizarLocalesComercialesTest {
	
	ProcActualizarLocalesComerciales actualizadorDeLocalesComerciales;
	MapaPOI mapaInteractivo;
	LocalComercial cineAbasto;
	ConfiguradorDeProcesos configuradorDeProcesos;
	ReintentarNVeces reintentarNVeces;
	NoRealizarAccion noRealizarAccion;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		cineAbasto = soporteParaTests.cineAbasto();
		actualizadorDeLocalesComerciales= soporteParaTests.actualizadorDeLocalesComerciales();
		mapaInteractivo=soporteParaTests.mapa();
		actualizadorDeLocalesComerciales.setMapa(mapaInteractivo);
		configuradorDeProcesos= soporteParaTests.configuradorDeProcesos();
		reintentarNVeces= soporteParaTests.reintentarNVeces();
		noRealizarAccion= soporteParaTests.noRealizarAccion();
		
}
	
	@Test
	public void seActualizan4LosTagsDelCineAbasto() throws ProblemaConAccionesEnCasoDeFalla{
		actualizadorDeLocalesComerciales.ejecutar();
		Assert.assertEquals(4, cineAbasto.getTags().size());
		
	}
	@Test
	public void seDetectan3ElementosAfectados(){
		Assert.assertEquals(1,cineAbasto.getTags().size());
		actualizadorDeLocalesComerciales.ejecutar();
		Assert.assertEquals(3,actualizadorDeLocalesComerciales.getResultadoDeEjecucion().cantidadDeElementosAfectados,0);
	}
	
}