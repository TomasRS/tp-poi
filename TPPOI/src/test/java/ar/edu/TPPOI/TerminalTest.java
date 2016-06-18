package ar.edu.TPPOI;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TerminalTest {

	Terminal terminalAbasto;
	MapaPOI mapaInteractivo;
	Notificar accionNotificar;
	Almacenar accionAlmacenar;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		terminalAbasto = soporteParaTests.terminal();
		mapaInteractivo = soporteParaTests.mapa();
		accionNotificar = soporteParaTests.notificar();
		accionAlmacenar = soporteParaTests.almacenar();
		terminalAbasto.setMapa(mapaInteractivo);

	}
	
//Tests de Notificar: Faltan los casos especiales	
	@Test
	public void testNotificarCuandoSeExcedeElTiempoLimite(){
		accionNotificar.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		
		terminalAbasto.buscar("114");
		Assert.assertEquals(accionNotificar.getMailEnviado(), true);
	}
	
	@Test
	public void testNoNotificaCuandoNoSeExcedeElTiempoLimite(){
		accionNotificar.setTiempoLimite(1000000000); //1 segundo
		terminalAbasto.activarAccion(accionNotificar);
		
		terminalAbasto.buscar("114");
		Assert.assertEquals(accionNotificar.getMailEnviado(), false);
	}
	
	
	
	
}
