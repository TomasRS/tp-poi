package ar.edu.TPPOI;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import org.junit.Assert;

public class ActualizarLocalesComercialesTest {
	
	ProcActualizarLocalesComerciales actualizadorDeLocalesComerciales;
	MapaPOI mapaInteractivo;
	LocalComercial cineAbasto;
	LocalComercial sportClubLibertador7395;
	LocalComercial starbucksRivadavia;
	ConfiguradorDeProcesos configuradorDeProcesos;
	ReintentarNVeces reintentarNVeces;
	NoRealizarAccion noRealizarAccion;
	Date horario1;
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		cineAbasto = soporteParaTests.cineAbasto();
		starbucksRivadavia=soporteParaTests.starbucksRivadavia();
		actualizadorDeLocalesComerciales= soporteParaTests.actualizadorDeLocalesComerciales();
		mapaInteractivo=soporteParaTests.mapa();
		actualizadorDeLocalesComerciales.setMapa(mapaInteractivo);
		configuradorDeProcesos= soporteParaTests.configuradorDeProcesos();
		reintentarNVeces= soporteParaTests.reintentarNVeces();
		noRealizarAccion= soporteParaTests.noRealizarAccion();
		horario1=soporteParaTests.generarHorario();
		sportClubLibertador7395=soporteParaTests.sportClubLibertador7395();
}
	
	@Test
	public void seActualizan4LosTagsDelCineAbasto() {
		
		actualizadorDeLocalesComerciales.run();
		
		Assert.assertEquals(4, cineAbasto.getTags().size());
		
	}
	@Test
	public void seDetectan1ElementosAfectados(){
		Assert.assertEquals(1,cineAbasto.getTags().size());
		actualizadorDeLocalesComerciales.run();
		Assert.assertEquals(1,actualizadorDeLocalesComerciales.getResultadoDeEjecucion().cantidadDeElementosAfectados,0);
	}
	@Test
	public void queda1soloTagEnsportClubLibertador7395(){
		Assert.assertEquals(3, sportClubLibertador7395.getTags().size());
	}

	@Test
	public void seActualizanLosTagsDeStarbucks(){
		Assert.assertEquals(1, starbucksRivadavia.getTags().size());
		actualizadorDeLocalesComerciales.run();
		Assert.assertEquals(3,starbucksRivadavia.getTags().size());
		
	}
	@Test 
	public void seDetectanTresElemntosAfectados(){
		actualizadorDeLocalesComerciales.run();
		Assert.assertEquals(4,actualizadorDeLocalesComerciales.getResultadoDeEjecucion().cantidadDeElementosAfectados,0);
	}
}