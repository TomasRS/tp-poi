package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TerminalTest {

	Terminal terminalAbasto;
	MapaPOI mapaInteractivo;
	Notificar accionNotificar;
	Notificar accionNotificar2;
	Almacenar accionAlmacenar;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		terminalAbasto = soporteParaTests.terminal();
		mapaInteractivo = soporteParaTests.mapa();
		accionNotificar = soporteParaTests.notificar();
		accionNotificar2 = soporteParaTests.notificar();
		accionAlmacenar = soporteParaTests.almacenar();
		terminalAbasto.setMapa(mapaInteractivo);

	}
	
//Tests de Notificar: Faltan los casos especiales	
	@Test
	public void testNotificarCuandoSeExcedeElTiempoLimite(){
		accionNotificar.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		
		terminalAbasto.buscar("114");
		Assert.assertEquals( true,accionNotificar.getMailEnviado());
	}
	
	@Test
	public void testNoNotificaCuandoNoSeExcedeElTiempoLimite(){
		accionNotificar.setTiempoLimite(1000000000); //1 segundo
		terminalAbasto.activarAccion(accionNotificar);
		
		terminalAbasto.buscar("114");
		Assert.assertEquals(false,accionNotificar.getMailEnviado());
	}
	
//Test de que pasa si agrego dos notificaciones a la terminal 
	@Test (expected = YaExisteUnNotificarException.class)
	public void testNotificarDosVeces(){
		accionNotificar.setTiempoLimite(1);
		accionNotificar2.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		terminalAbasto.activarAccion(accionNotificar2);
	}
	
//Tests de Almacenar: Faltan los casos especiales
	@Test ()
	public void testAlmacenarResultadosDeBusqueda(){
		
		terminalAbasto.activarAccion(accionAlmacenar);
		terminalAbasto.buscar("114");
		Assert.assertEquals( "114",terminalAbasto.getBusquedasHechas().get(0).getFrase());
		Assert.assertEquals( (Integer) 2,terminalAbasto.getBusquedasHechas().get(0).getCantDeResultados());

	}
	
//Test Terminal tiene activado 2 acciones 
	@Test 
	public void testTerminalNotificaYalmacena(){
		accionNotificar.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionAlmacenar);
		terminalAbasto.activarAccion(accionNotificar);
		terminalAbasto.buscar("HOLA");
		Assert.assertEquals((Integer)0,terminalAbasto.getBusquedasHechas().get(0).getCantDeResultados());
		Assert.assertEquals("HOLA",terminalAbasto.getBusquedasHechas().get(0).getFrase());
		Assert.assertEquals( true,accionNotificar.getMailEnviado());
		Assert.assertEquals(2, terminalAbasto.acciones.size());
		
	}
	
	
}
