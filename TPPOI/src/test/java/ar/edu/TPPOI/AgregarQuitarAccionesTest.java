package ar.edu.TPPOI;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Polygon;

import excepciones.NoSePuedeDesactivarException;

public class AgregarQuitarAccionesTest {
	
	ProcAgregarAccionesParaUsuarios procAgregarAcciones1;
	ProcQuitarAccionesParaUsuarios procQuitarAcciones1;
	ProcQuitarAccionesParaUsuarios procQuitarAcciones2;
	Notificar accionNotificar;
	Almacenar accionAlmacenar;
	Terminal terminalAbasto;
	Terminal terminalCaballito;
	Terminal terminalDevoto;
	Terminal terminalBelgrano;
	RepositorioDeTerminales rep1;
	RepositorioDeTerminales rep2;
	EnvioDeMail envioDeMail1;
	MapaPOI mapaInteractivo;
	ComunaALaQuePertenece comunaCriterio1; 
	ComunaALaQuePertenece comunaCriterio2;
	Polygon comunaAbasto;
	Polygon comunaCaballito;

	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		
		envioDeMail1 = soporteParaTests.envioDeMail();
		accionNotificar = soporteParaTests.notificar(envioDeMail1);
		accionAlmacenar = soporteParaTests.almacenar();
		
		mapaInteractivo = soporteParaTests.mapa();
		
		procAgregarAcciones1 = soporteParaTests.procAgregarAcciones();
		procQuitarAcciones1 = soporteParaTests.procQuitarAcciones();
		procQuitarAcciones2 = soporteParaTests.procQuitarAcciones();
		
		comunaAbasto = soporteParaTests.crearComunaAbasto();
		comunaCaballito = soporteParaTests.crearComunaCaballito();
		terminalAbasto = soporteParaTests.terminal();
		terminalCaballito = soporteParaTests.terminal();
		terminalDevoto = soporteParaTests.terminal();
		terminalBelgrano = soporteParaTests.terminal();
		terminalDevoto.setMapa(mapaInteractivo);
		terminalBelgrano.setMapa(mapaInteractivo);
		terminalAbasto.setMapa(mapaInteractivo);
		terminalCaballito.setMapa(mapaInteractivo);
		terminalAbasto.setComuna(comunaAbasto);
		terminalCaballito.setComuna(comunaCaballito);
		terminalDevoto.setComuna(comunaAbasto);
		terminalBelgrano.setComuna(comunaAbasto);
		terminalDevoto.activarAccion(accionAlmacenar);
		terminalDevoto.activarAccion(accionNotificar);
		terminalBelgrano.activarAccion(accionAlmacenar);
		terminalBelgrano.activarAccion(accionNotificar);
		
		
		comunaCriterio1 = soporteParaTests.comunaCriterio();
		comunaCriterio1.setComunaAsociada(comunaAbasto);
		comunaCriterio2 = soporteParaTests.comunaCriterio();
		comunaCriterio2.setComunaAsociada(comunaAbasto);
		
		rep1 = soporteParaTests.repositorio();
		rep2 = soporteParaTests.repositorio();
		procAgregarAcciones1.setRepTerminales(rep1);
		procQuitarAcciones1.setRepTerminales(rep1);
		procQuitarAcciones2.setRepTerminales(rep2);
		rep2.agregarTerminal(terminalDevoto);
		rep2.agregarTerminal(terminalBelgrano);
		rep1.agregarTerminal(terminalAbasto);
		rep1.agregarTerminal(terminalCaballito);
		
		
	}
	
	//------------------------------ Tests de Agregar/Quitar
	
	@Test
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunComuna(){
		procAgregarAcciones1.setCriterio(comunaCriterio1);
		procAgregarAcciones1.agregarAccion(accionAlmacenar);
		procAgregarAcciones1.agregarAccion(accionNotificar);
		procAgregarAcciones1.run();
		Assert.assertEquals(1, procAgregarAcciones1.getTerminalesFiltradas().size(),0);
	}

	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQuitarAccionesATerminalSinAccionesActivadasSegunComuna(){
		procQuitarAcciones1.setCriterio(comunaCriterio1);
		procQuitarAcciones1.agregarAccion(accionAlmacenar);
		procQuitarAcciones1.agregarAccion(accionNotificar);
		procQuitarAcciones1.run();
	}
	
	@Test
	public void testQuitarAccionesATerminalConAccionesActivadasSegunComuna(){
		procQuitarAcciones2.setCriterio(comunaCriterio2);
		procQuitarAcciones2.agregarAccion(accionAlmacenar);
		procQuitarAcciones2.agregarAccion(accionNotificar);
		procQuitarAcciones2.run();
		Assert.assertEquals(2, procQuitarAcciones2.getTerminalesFiltradas().size(),0);
	}
}
