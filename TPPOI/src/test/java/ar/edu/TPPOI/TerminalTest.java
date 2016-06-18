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
	Almacenar accionAlmacenar2;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		terminalAbasto = soporteParaTests.terminal();
		mapaInteractivo = soporteParaTests.mapa();
		accionNotificar = soporteParaTests.notificar();
		accionNotificar2 = soporteParaTests.notificar();
		accionAlmacenar = soporteParaTests.almacenar();
		accionAlmacenar2 = soporteParaTests.almacenar();
		terminalAbasto.setMapa(mapaInteractivo);

	}
	
//------------------------------ Tests de Notificar ------------------------------
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
	
//Tests de casos especiales
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testQueNoSePuedanAgregarMasDeUnNotificar(){
		accionNotificar.setTiempoLimite(1);
		accionNotificar2.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		terminalAbasto.activarAccion(accionNotificar2);
	}
	
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQueNoSePuedaSacarUnNotificarSiLaTerminalNoLoTiene(){
		accionNotificar.setTiempoLimite(1);
		accionNotificar2.setTiempoLimite(1);
		terminalAbasto.desactivarAccion(accionNotificar);
	}
	
//------------------------------ Tests de Almacenar ------------------------------
	@Test ()
	public void testAlmacenarResultadosDeBusqueda(){
		
		terminalAbasto.activarAccion(accionAlmacenar);
		terminalAbasto.buscar("114");
		Assert.assertEquals( "114",terminalAbasto.getBusquedasHechas().get(0).getFrase());
		Assert.assertEquals( 2,terminalAbasto.getBusquedasHechas().get(0).getCantDeResultados(), 0);

	}
	
//Tests de casos especiales
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testQueNoSePuedanAgregarMasDeUnAlmacenar(){
		terminalAbasto.activarAccion(accionAlmacenar);
		terminalAbasto.activarAccion(accionAlmacenar2);
	}
	
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQueNoSePuedaSacarUnAlmacenarSiLaTerminalNoLoTiene(){
		accionNotificar.setTiempoLimite(1);
		accionNotificar2.setTiempoLimite(1);
		terminalAbasto.desactivarAccion(accionAlmacenar);
	}
	
}
