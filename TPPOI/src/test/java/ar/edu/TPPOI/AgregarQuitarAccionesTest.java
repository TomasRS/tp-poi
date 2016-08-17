package ar.edu.TPPOI;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Polygon;


public class AgregarQuitarAccionesTest {
	
	EnvioDeMail envioDeMail1;
	MapaPOI mapaInteractivo;
	ProcAgregarAccionesParaUsuarios procAgregarAcciones;
	ProcQuitarAccionesParaUsuarios procQuitarAcciones;
	Notificar accionNotificar;
	Almacenar accionAlmacenar;
	Terminal terminalAbasto;
	Terminal terminalCaballito;
	Terminal terminalDevoto;
	Terminal terminalBelgrano;
	ComunaALaQuePertenece comunaCriterio; 
	TodosLosUsuarios todosUsersCriterio;
	UsuariosElegidosPorAdmin adminCriterio;
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
		terminalDevoto = soporteParaTests.terminal();
		terminalBelgrano = soporteParaTests.terminal();
		terminalAbasto.setComuna(comunaAbasto);
		terminalCaballito.setComuna(comunaCaballito);
		terminalDevoto.setComuna(comunaAbasto);
		terminalBelgrano.setComuna(comunaAbasto);
		terminalDevoto.activarAccion(accionAlmacenar);
		terminalDevoto.activarAccion(accionNotificar);
		terminalBelgrano.activarAccion(accionAlmacenar);
		terminalBelgrano.activarAccion(accionNotificar);
		
		todosUsersCriterio = soporteParaTests.todosUsersCriterio();
		
		adminCriterio = soporteParaTests.adminCriterio();
		
		comunaCriterio = soporteParaTests.comunaCriterio();
		comunaCriterio.setComunaAsociada(comunaAbasto);
		
		RepositorioDeTerminales.getSingletonInstance().agregarTerminal(terminalAbasto);
	
		RepositorioDeTerminales.getSingletonInstance().agregarTerminal(terminalCaballito);
		
		
		
	}
	
	//------------------------------ Tests de Agregar/Quitar
	// ---------------------ITEM 1
	@Test
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunComuna(){
		procAgregarAcciones.setCriterio(comunaCriterio);
		procAgregarAcciones.agregarAccion(accionAlmacenar);
		procAgregarAcciones.agregarAccion(accionNotificar);
		procAgregarAcciones.run();
		Assert.assertEquals(1, procAgregarAcciones.getTerminalesFiltradas().size(),0);
	}

	/*@Test (expected = NoSePuedeDesactivarException.class)
	public void testQuitarAccionesATerminalSinAccionesActivadasSegunComuna(){
		procQuitarAcciones.setCriterio(comunaCriterio);
		procQuitarAcciones.agregarAccion(accionAlmacenar);
		procQuitarAcciones.agregarAccion(accionNotificar);
		procQuitarAcciones.run();
	}
	
	@Test
	public void testQuitarAccionesATerminalConAccionesActivadasSegunComuna(){
		procQuitarAcciones.setCriterio(comunaCriterio);
		procQuitarAcciones.agregarAccion(accionAlmacenar);
		procQuitarAcciones.agregarAccion(accionNotificar);
		procQuitarAcciones.run();
		Assert.assertEquals(2, procQuitarAcciones.getTerminalesFiltradas().size(),0);
	}
	
	//DEBERIAN FALLAR ?????? 
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQuitarAccionesATerminalConAccionesActivadasYDesactivadasSegunComuna(){
		procQuitarAcciones.setCriterio(comunaCriterio);
		procQuitarAcciones.agregarAccion(accionAlmacenar);
		procQuitarAcciones.agregarAccion(accionNotificar);
		procQuitarAcciones.run();
	}
	
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testAgregarAccionesATerminalConAccionesActivadasYDesactivadasSegunComuna(){
		procAgregarAcciones.setCriterio(comunaCriterio);
		procAgregarAcciones.agregarAccion(accionAlmacenar);
		procAgregarAcciones.run();
	}
	
	// ------------------------- ITEM 2
	@Test 
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunTodosLosUsuarios(){
		procAgregarAcciones.setCriterio(todosUsersCriterio);
		procAgregarAcciones.agregarAccion(accionAlmacenar);
		procAgregarAcciones.agregarAccion(accionNotificar);
		procAgregarAcciones.run();
		Assert.assertEquals(2, terminalCaballito.getAcciones().size(),0);
		Assert.assertEquals(2, terminalAbasto.getAcciones().size(),0);
	}
	
	@Test 
	public void testQuitarAccionesATerminalSinAccionesActivadasSegunTodosLosUsuarios(){
		procQuitarAcciones.setCriterio(todosUsersCriterio);
		procQuitarAcciones.agregarAccion(accionAlmacenar);
		procQuitarAcciones.agregarAccion(accionNotificar);
		procQuitarAcciones.run();
		Assert.assertEquals(2, procQuitarAcciones.getTerminalesFiltradas().size(),0);
	}
	
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testAgregarAccionesATerminalConAccionesActivadasYDesactivadasTodosLosUsuarios(){
		procAgregarAcciones.setCriterio(todosUsersCriterio);
		procAgregarAcciones.agregarAccion(accionAlmacenar);
		procAgregarAcciones.run();
	}
	
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQuitarAccionesATerminalConAccionesActivadasYDesactivadasTodosLosUsuarios(){
		procQuitarAcciones.setCriterio(comunaCriterio);
		procQuitarAcciones.agregarAccion(accionAlmacenar);
		procQuitarAcciones.agregarAccion(accionNotificar);
		procQuitarAcciones .run();
	}
	
	// ------------------------------ ITEM 3 
	
	@Test 
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunAdmin(){
		procAgregarAcciones.setCriterio(adminCriterio);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalAbasto);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalCaballito);
		procAgregarAcciones.agregarAccion(accionAlmacenar);
		procAgregarAcciones.agregarAccion(accionNotificar);
		procAgregarAcciones.run();
		Assert.assertEquals(2, terminalCaballito.getAcciones().size(),0);
		Assert.assertEquals(2, terminalAbasto.getAcciones().size(),0);
	}
	
	@Test 
	public void testQuitarAccionesATerminalSinAccionesActivadasSegunAdmin(){
		procQuitarAcciones.setCriterio(adminCriterio);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalDevoto);
		adminCriterio.agregarTerminalesElegidasPorAdmin(terminalBelgrano);
		procQuitarAcciones.agregarAccion(accionAlmacenar);
		procQuitarAcciones.agregarAccion(accionNotificar);
		procQuitarAcciones.run();
		Assert.assertEquals(0, terminalDevoto.getAcciones().size(),0);
		Assert.assertEquals(0, terminalBelgrano.getAcciones().size(),0);
	}*/
	//SI TIENEN QUE FALLAR NO HAGO LOS TEST DE FALLA, YA QUE FUERON PROBADOS SI ANDAN EN LOS DEMAS 
	// de lo contrario me faltarian esos dos !
}
