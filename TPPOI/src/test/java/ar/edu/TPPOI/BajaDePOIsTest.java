package ar.edu.TPPOI;

import org.junit.Before;
import org.junit.Test;

import excepciones.ProblemaConAccionesEnCasoDeFalla;
import junit.framework.Assert;

public class BajaDePOIsTest {

	ProcDarDeBajaPOIs procesoBajaDePOIs;
	MapaPOI mapaInteractivo;
	LocalComercial cineAbasto;
	ConfiguradorDeProcesos configuradorDeProcesos;
	NoRealizarAccion noRealizarAccion;
	ServicioBajaPOIs servicioBajaDePOIs;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		cineAbasto = soporteParaTests.cineAbasto();
		mapaInteractivo=soporteParaTests.mapa();
		procesoBajaDePOIs = soporteParaTests.procesoBajaDePOIs();
		servicioBajaDePOIs = soporteParaTests.servicioBajaDePOIs();
		procesoBajaDePOIs.setMapa(mapaInteractivo);
		procesoBajaDePOIs.setServicioDeBaja(servicioBajaDePOIs);
		configuradorDeProcesos= soporteParaTests.configuradorDeProcesos();
		noRealizarAccion= soporteParaTests.noRealizarAccion();
	
		procesoBajaDePOIs.accionesEnCasoDeError.add(noRealizarAccion);
	}
	
	@Test
	public void testDarDeBajaUnPOIExistente(){
		servicioBajaDePOIs.agregarNombreDePOIADarDeBaja("fitness");
		procesoBajaDePOIs.run();
		Assert.assertEquals(mapaInteractivo.buscar("fitness").size(), 0);
	}
	
	@Test
	public void testSeDetecta1ElementoAfectadoPorHaberEliminado1POI(){
		servicioBajaDePOIs.agregarNombreDePOIADarDeBaja("fitness");
		procesoBajaDePOIs.run();
		Assert.assertEquals(1, procesoBajaDePOIs.getResultadoDeEjecucionDelProceso().getCantidadDeElementosAfectados(), 0);
	}
	
	@Test
	public void testNoSeDioDeBajaUnPOIPorqueNoEstabaEnElMapa(){
		servicioBajaDePOIs.agregarNombreDePOIADarDeBaja("lala");
		procesoBajaDePOIs.run();
		Assert.assertEquals(procesoBajaDePOIs.getResultadoDeEjecucionDelProceso().isResultadoDeLaEjecucion(), false);
	}
}
