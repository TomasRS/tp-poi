package ar.edu.TPPOI;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import org.junit.Assert;

public class ActualizarLocalesComercialesTest {
	
	ProcActualizarLocalesComerciales actualizadorDeLocalesComerciales;
	MapaPOI mapaInteractivo;
	LocalComercial cineAbasto;
	ConfiguradorDeProcesos configuradorDeProcesos;
	ReintentarNVeces reintentarNVeces;
	NoRealizarAccion noRealizarAccion;
	Date horario1;
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
		horario1=(Date) soporteParaTests.generarHorario();
		
}
	
	@Test
	public void seActualizan4LosTagsDelCineAbasto() throws ProblemaConAccionesEnCasoDeFalla{
		actualizadorDeLocalesComerciales.run();
		Assert.assertEquals(4, cineAbasto.getTags().size());
		
	}
	@Test
	public void seDetectan3ElementosAfectados(){
		Assert.assertEquals(1,cineAbasto.getTags().size());
		actualizadorDeLocalesComerciales.run();
		Assert.assertEquals(3,actualizadorDeLocalesComerciales.getResultadoDeEjecucion().cantidadDeElementosAfectados,0);
	}

}