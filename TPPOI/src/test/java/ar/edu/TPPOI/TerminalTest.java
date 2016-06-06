package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TerminalTest {

	Terminal terminalAbasto;
	MapaPOI mapaInteractivo;
	Notificar notificarDeTerminalAbasto;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		mapaInteractivo = soporteParaTests.mapa();
		terminalAbasto = soporteParaTests.terminalAbasto();
		notificarDeTerminalAbasto = soporteParaTests.notificarDeTerminal();
		terminalAbasto.setMapa(mapaInteractivo);
		terminalAbasto.setAccionNotificar(notificarDeTerminalAbasto);
		
	}
	
	@Test
	public void testTerminalNotificaCuandoSeExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1); //en nanosegundos
		notificarDeTerminalAbasto.setActivado(true);
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.notificoMail(), true);
		
	}
	
	@Test
	public void testTerminalNONotificaCuandoNOExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1000000000); // = 1 segundo
		notificarDeTerminalAbasto.setActivado(true);
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.notificoMail(), false);
		
	}
}
