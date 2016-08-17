package ar.edu.TPPOI;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Polygon;

import excepciones.NoSePuedeDesactivarException;
import excepciones.YaExisteUnaAccionDeEseTipoException;

public class AgregarQuitarAccionesTest {
	
	ProcAgregarAccionesParaUsuarios procAgregarAcciones1;
	ProcAgregarAccionesParaUsuarios procAgregarAcciones2;
	ProcAgregarAccionesParaUsuarios procAgregarAcciones3;
	ProcQuitarAccionesParaUsuarios procQuitarAcciones1;
	ProcQuitarAccionesParaUsuarios procQuitarAcciones2;
	ProcQuitarAccionesParaUsuarios procQuitarAcciones3;
	Notificar accionNotificar;
	Almacenar accionAlmacenar;
	Terminal terminalAbasto;
	Terminal terminalCaballito;
	Terminal terminalDevoto;
	Terminal terminalBelgrano;
	RepositorioDeTerminales rep1;
	RepositorioDeTerminales rep2;
	RepositorioDeTerminales rep3;
	EnvioDeMail envioDeMail1;
	MapaPOI mapaInteractivo;
	ComunaALaQuePertenece comunaCriterio1; 
	ComunaALaQuePertenece comunaCriterio2;
	ComunaALaQuePertenece comunaCriterio3;
	ComunaALaQuePertenece comunaCriterio4;
	Polygon comunaAbasto;
	Polygon comunaCaballito;
	TodosLosUsuarios todosUsersCriterio1;
	UsuariosElegidosPorAdmin adminCriterio;

	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		
		envioDeMail1 = soporteParaTests.envioDeMail();
		accionNotificar = soporteParaTests.notificar(envioDeMail1);
		accionAlmacenar = soporteParaTests.almacenar();
		
		mapaInteractivo = soporteParaTests.mapa();
		
		procAgregarAcciones1 = soporteParaTests.procAgregarAcciones();
		procAgregarAcciones2 = soporteParaTests.procAgregarAcciones();
		procAgregarAcciones3 = soporteParaTests.procAgregarAcciones();
		procQuitarAcciones1 = soporteParaTests.procQuitarAcciones();
		procQuitarAcciones2 = soporteParaTests.procQuitarAcciones();
		procQuitarAcciones3 = soporteParaTests.procQuitarAcciones();
		
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
		
		todosUsersCriterio1 = soporteParaTests.todosUsersCriterio();
		
		adminCriterio = soporteParaTests.adminCriterio();
		
		comunaCriterio1 = soporteParaTests.comunaCriterio();
		comunaCriterio1.setComunaAsociada(comunaAbasto);
		comunaCriterio2 = soporteParaTests.comunaCriterio();
		comunaCriterio2.setComunaAsociada(comunaAbasto);
		comunaCriterio3 = soporteParaTests.comunaCriterio();
		comunaCriterio3.setComunaAsociada(comunaAbasto);
		comunaCriterio4 = soporteParaTests.comunaCriterio();
		comunaCriterio4.setComunaAsociada(comunaAbasto);
		
		rep1 = soporteParaTests.repositorio();
		rep2 = soporteParaTests.repositorio();
		rep3 = soporteParaTests.repositorio();
		procAgregarAcciones1.setRepTerminales(rep1);
		procAgregarAcciones2.setRepTerminales(rep3);
		procAgregarAcciones3.setRepTerminales(rep1);
		procQuitarAcciones1.setRepTerminales(rep1);
		procQuitarAcciones2.setRepTerminales(rep2);
		procQuitarAcciones3.setRepTerminales(rep3);
		rep3.agregarTerminal(terminalAbasto);
		rep3.agregarTerminal(terminalBelgrano);
		rep3.agregarTerminal(terminalCaballito);
		rep2.agregarTerminal(terminalDevoto);
		rep2.agregarTerminal(terminalBelgrano);
		rep1.agregarTerminal(terminalAbasto);
		rep1.agregarTerminal(terminalCaballito);
		
		
	}
	
	//------------------------------ Tests de Agregar/Quitar
	// ---------------------ITEM 1
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
	
	//DEBERIAN FALLAR ?????? 
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQuitarAccionesATerminalConAccionesActivadasYDesactivadasSegunComuna(){
		procQuitarAcciones3.setCriterio(comunaCriterio3);
		procQuitarAcciones3.agregarAccion(accionAlmacenar);
		procQuitarAcciones3.agregarAccion(accionNotificar);
		procQuitarAcciones3.run();
	}
	
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testAgregarAccionesATerminalConAccionesActivadasYDesactivadasSegunComuna(){
		procAgregarAcciones2.setCriterio(comunaCriterio4);
		procAgregarAcciones2.agregarAccion(accionAlmacenar);
		procAgregarAcciones2.run();
	}
	
	// ------------------------- ITEM 2
	@Test 
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunTodosLosUsuarios(){
		procAgregarAcciones3.setCriterio(todosUsersCriterio1);
		procAgregarAcciones3.agregarAccion(accionAlmacenar);
		procAgregarAcciones3.agregarAccion(accionNotificar);
		procAgregarAcciones3.run();
		Assert.assertEquals(2, terminalCaballito.getAcciones().size(),0);
		Assert.assertEquals(2, terminalAbasto.getAcciones().size(),0);
	}
	
	@Test 
	public void testQuitarAccionesATerminalSinAccionesActivadasSegunTodosLosUsuarios(){
		procQuitarAcciones2.setCriterio(todosUsersCriterio1);
		procQuitarAcciones2.agregarAccion(accionAlmacenar);
		procQuitarAcciones2.agregarAccion(accionNotificar);
		procQuitarAcciones2.run();
		Assert.assertEquals(2, procQuitarAcciones2.getTerminalesFiltradas().size(),0);
	}
	
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testAgregarAccionesATerminalConAccionesActivadasYDesactivadasTodosLosUsuarios(){
		procAgregarAcciones2.setCriterio(todosUsersCriterio1);
		procAgregarAcciones2.agregarAccion(accionAlmacenar);
		procAgregarAcciones2.run();
	}
	
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQuitarAccionesATerminalConAccionesActivadasYDesactivadasTodosLosUsuarios(){
		procQuitarAcciones3.setCriterio(comunaCriterio3);
		procQuitarAcciones3.agregarAccion(accionAlmacenar);
		procQuitarAcciones3.agregarAccion(accionNotificar);
		procQuitarAcciones3.run();
	}
	
	// ------------------------------ ITEM 3 
	
	@Test 
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunAdmin(){
		procAgregarAcciones1.setCriterio(adminCriterio);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalAbasto);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalCaballito);
		procAgregarAcciones1.agregarAccion(accionAlmacenar);
		procAgregarAcciones1.agregarAccion(accionNotificar);
		procAgregarAcciones1.run();
		Assert.assertEquals(2, terminalCaballito.getAcciones().size(),0);
		Assert.assertEquals(2, terminalAbasto.getAcciones().size(),0);
	}
	
	@Test 
	public void testQuitarAccionesATerminalSinAccionesActivadasSegunAdmin(){
		procQuitarAcciones2.setCriterio(adminCriterio);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalDevoto);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalBelgrano);
		procQuitarAcciones2.agregarAccion(accionAlmacenar);
		procQuitarAcciones2.agregarAccion(accionNotificar);
		procQuitarAcciones2.run();
		Assert.assertEquals(0, terminalDevoto.getAcciones().size(),0);
		Assert.assertEquals(0, terminalBelgrano.getAcciones().size(),0);
	}
	
}
