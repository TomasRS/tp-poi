package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TerminalTest {

	Terminal terminalAbasto;
	MapaPOI mapaInteractivo;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		mapaInteractivo = soporteParaTests.mapa();
		terminalAbasto = soporteParaTests.terminalAbasto();
		terminalAbasto.setMapa(mapaInteractivo);
	}
	
	@Test
	public void testTerminalNotificaCuandoSeExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.buscar("114");
	//	Assert.assertEquals(objetoNotificarInterno.getMailEnviado(), true);
		
	}
}
