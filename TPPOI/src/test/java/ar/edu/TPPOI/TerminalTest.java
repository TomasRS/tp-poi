package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TerminalTest {

	Terminal terminalAbasto;
	MapaPOI mapaInteractivo;
	Notificar notificarDeTerminalAbasto;
	Almacenar almacenarDeTerminalAbasto;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		mapaInteractivo = soporteParaTests.mapa();
		terminalAbasto = soporteParaTests.terminalAbasto();
		notificarDeTerminalAbasto = soporteParaTests.notificarDeTerminal();
		almacenarDeTerminalAbasto = soporteParaTests.almacenarDeTerminal();
		notificarDeTerminalAbasto.setActivado(true);
		almacenarDeTerminalAbasto.setActivado(true);
		terminalAbasto.setMapa(mapaInteractivo);
		terminalAbasto.setAccionNotificar(notificarDeTerminalAbasto);
		terminalAbasto.setAccionAlmacenar(almacenarDeTerminalAbasto);
		
	}
	
	@Test
	public void testTerminalNotificaCuandoSeExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1); //en nanosegundos
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.notificoMail(), true);
		
	}
	
	@Test
	public void testTerminalNONotificaCuandoNOExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1000000000); // = 1 segundo
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.notificoMail(), false);
		
	}
	
	@Test
	public void testTerminalAlmacenaLosResultadosDeLasBusquedas(){
		terminalAbasto.setTiempoLimite(1000000000);
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.almacenoBusqueda(), true);
	}
}
