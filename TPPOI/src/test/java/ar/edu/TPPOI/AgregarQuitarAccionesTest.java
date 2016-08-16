package ar.edu.TPPOI;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Polygon;

import excepciones.NoSePuedeDesactivarException;

public class AgregarQuitarAccionesTest {
	
	ProcAgregarAccionesParaUsuarios procAgregarAcciones;
	ProcQuitarAccionesParaUsuarios procQuitarAcciones;
	Notificar accionNotificar;
	Almacenar accionAlmacenar;
	Terminal terminalAbasto;
	Terminal terminalCaballito;
	RepositorioDeTerminales rep;
	EnvioDeMail envioDeMail1;
	MapaPOI mapaInteractivo;
	ComunaALaQuePertenece comunaCriterio; 
	Polygon comunaAbasto;
	Polygon comunaCaballito;

	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		
		envioDeMail1 = soporteParaTests.envioDeMail();
		accionNotificar = soporteParaTests.notificar(envioDeMail1);
		accionAlmacenar = soporteParaTests.almacenar();
		
		mapaInteractivo = soporteParaTests.mapa();
		
		procAgregarAcciones = soporteParaTests.procAgregarAcciones();
		procQuitarAcciones = soporteParaTests.procQuitarAcciones();
		
		comunaAbasto = soporteParaTests.crearComunaAbasto();
		comunaCaballito = soporteParaTests.crearComunaCaballito();
		terminalAbasto = soporteParaTests.terminal();
		terminalCaballito = soporteParaTests.terminal();
		terminalAbasto.setMapa(mapaInteractivo);
		terminalCaballito.setMapa(mapaInteractivo);
		terminalAbasto.setComuna(comunaAbasto);
		terminalCaballito.setComuna(comunaCaballito);
		
		comunaCriterio = soporteParaTests.comunaCriterio();
		comunaCriterio.setComunaAsociada(comunaAbasto);
		
		rep = soporteParaTests.repositorio();
		procAgregarAcciones.setRepTerminales(rep);
		procQuitarAcciones.setRepTerminales(rep);
		rep.agregarTerminal(terminalAbasto);
		rep.agregarTerminal(terminalCaballito);
		
		
	}
	
	//------------------------------ Tests de Agregar/Quitar
	
	@Test
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunComuna(){
		procAgregarAcciones.setCriterio(comunaCriterio);
		procAgregarAcciones.agregarAccion(accionAlmacenar);
		procAgregarAcciones.agregarAccion(accionNotificar);
		procAgregarAcciones.run();
		Assert.assertEquals(1, procAgregarAcciones.getTerminalesFiltradas().size(),0);
	}

	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQuitarAccionesATerminalSinAccionesActivadasSegunComuna(){
		procQuitarAcciones.setCriterio(comunaCriterio);
		procQuitarAcciones.agregarAccion(accionAlmacenar);
		procQuitarAcciones.agregarAccion(accionNotificar);
		procQuitarAcciones.run();
	}
}
