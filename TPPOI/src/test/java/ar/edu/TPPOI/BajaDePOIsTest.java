package ar.edu.TPPOI;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import org.junit.Assert;

public class BajaDePOIsTest {

	ProcDarDeBajaPOIs procesoBajaDePOIs;
	ProcDarDeBajaPOIs procesoBajaDePOIs2;
	MapaPOI mapaInteractivo;
	LocalComercial cineAbasto;
	ConfiguradorDeProcesos configuradorDeProcesos;
	NoRealizarAccion noRealizarAccion;
	ServicioBajaPOIs servicioBajaDePOIs;
	ServicioBajaPOIs servicioBajaDePOIs2;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		cineAbasto = soporteParaTests.cineAbasto();
		mapaInteractivo=soporteParaTests.mapa();
		procesoBajaDePOIs = soporteParaTests.procesoBajaDePOIs();
		procesoBajaDePOIs2 = soporteParaTests.procesoBajaDePOIs();
		servicioBajaDePOIs = soporteParaTests.servicioBajaDePOIs();
		servicioBajaDePOIs2 = soporteParaTests.servicioBajaDePOIs();
		procesoBajaDePOIs.setMapa(mapaInteractivo);
		procesoBajaDePOIs2.setMapa(mapaInteractivo);
		procesoBajaDePOIs.setServicioDeBaja(servicioBajaDePOIs);
		procesoBajaDePOIs2.setServicioDeBaja(servicioBajaDePOIs2);
		configuradorDeProcesos= soporteParaTests.configuradorDeProcesos();
		noRealizarAccion= soporteParaTests.noRealizarAccion();
	
		procesoBajaDePOIs.accionesEnCasoDeError.add(noRealizarAccion);
		procesoBajaDePOIs2.accionesEnCasoDeError.add(noRealizarAccion);
	}

//-------------------------------Tests para probar el proceso de Dar de Baja-------------------------------
	@Test
	public void testDarDeBajaUnPOIExistente(){
		servicioBajaDePOIs.agregarNombreDePOIADarDeBaja("Banco Ciudad");
		procesoBajaDePOIs.run();
		Assert.assertEquals(mapaInteractivo.buscar("Banco Ciudad").size(), 0);
	}
	
	@Test
	public void testSeDetecta1ElementoAfectadoPorHaberEliminado1POI(){
		servicioBajaDePOIs.agregarNombreDePOIADarDeBaja("Banco Ciudad");
		procesoBajaDePOIs.run();
		Assert.assertEquals(1, procesoBajaDePOIs.getResultadoDeEjecucionDelProceso().getCantidadDeElementosAfectados(), 0);
	}
	
	@Test
	public void testNoSeDioDeBajaUnPOIPorqueNoEstabaEnElMapa(){
		servicioBajaDePOIs.agregarNombreDePOIADarDeBaja("lala");
		procesoBajaDePOIs.run();
		Assert.assertEquals(procesoBajaDePOIs.getResultadoDeEjecucionDelProceso().isResultadoDeLaEjecucion(), false);
	}
	
//----------Test de ejecucion automatica de procesos en base al horario definido----------	
	
	@Test
	public void testLasTareasSeIngresanOrdenadasAlBatchPorFechaYHora(){
		LocalDateTime fechaYHora = LocalDateTime.of(2016, 8, 7, 16, 30, 30);
		LocalDateTime fechaYHora2 = LocalDateTime.of(2016, 8, 7, 16, 30, 0);
		
		//Se ingresa primero el proceso que deberia ir segundo, y segundo el proceso que deberia ir primero
		configuradorDeProcesos.agregarProcesoAlBatch(procesoBajaDePOIs, fechaYHora);
		configuradorDeProcesos.agregarProcesoAlBatch(procesoBajaDePOIs2, fechaYHora2);

		Assert.assertEquals(configuradorDeProcesos.getTareasEnBatch().get(0).getFechaYHora().equals(fechaYHora2), true);
	}
	

/*	@Test
	public void testChequearEjecucionAutomaticaDeLosProcesosAgregadosAlBatch(){
		servicioBajaDePOIs.agregarNombreDePOIADarDeBaja("Banco Ciudad");
		servicioBajaDePOIs2.agregarNombreDePOIADarDeBaja("SportClub");
		
		LocalDateTime fechaYHora = LocalDateTime.of(2016, 8, 7, 18, 27, 0);
		LocalDateTime fechaYHora2 = LocalDateTime.of(2016, 8, 7, 18, 27, 30);
													//YYYY, MM, DD, HH, MIN, SEG
		
		configuradorDeProcesos.agregarProcesoAlBatch(procesoBajaDePOIs, fechaYHora);
		configuradorDeProcesos.agregarProcesoAlBatch(procesoBajaDePOIs2, fechaYHora2);
		
		configuradorDeProcesos.iniciarModoBatch();
		
		System.out.println("Se termino de ejecutar el modo Batch.");
		
		//Espera de 1 segundo a que se termine de ejecutar el ultimo proceso asi luego hago los assert
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		    Assert.assertEquals(mapaInteractivo.buscar("Banco Ciudad").size(), 0);
		    Assert.assertEquals(mapaInteractivo.buscar("SportClub").size(), 0);
		}
	}*/
	
}
