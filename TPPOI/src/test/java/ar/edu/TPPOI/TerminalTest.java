package ar.edu.TPPOI;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TerminalTest {

	Terminal terminalAbasto;
	Terminal terminalCaballito;
	MapaPOI mapaInteractivo;

	@Before
	public void init(){
		
	
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		mapaInteractivo = soporteParaTests.mapa();
		terminalAbasto = soporteParaTests.terminal();
		terminalCaballito = soporteParaTests.terminal();
		
		List<Accion>accionesAbasto=new ArrayList<>();
		accionesAbasto.add(new Notificar());
		accionesAbasto.add(new Almacenar());
		terminalAbasto.setMapa(mapaInteractivo);
		terminalAbasto.setAcciones(accionesAbasto);
		List<Accion>accionesCaballito=new ArrayList<>();
		accionesCaballito.add(new ObtenerReporte());
		accionesCaballito.add(new Notificar());
		accionesCaballito.add(new Almacenar());
		terminalCaballito.setMapa(mapaInteractivo);
		terminalCaballito.setAcciones(accionesCaballito);
	}		
	
	@Test
	public void testTerminalNotificaCuandoSeExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1); //en nanosegundos
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.seEnvioElMail(), true);
		
	}
	
	@Test
	public void testTerminalNONotificaCuandoNOExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1000000000); // = 1 segundo
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.seEnvioElMail(), false);
		
	}
	
	@Test
	public void testTerminalAlmacenaLosResultadosDeLasBusquedas(){
		terminalAbasto.setTiempoLimite(1000000000);
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.filtrarBusquedasAlmacenadasPorFrase("114").size(),1);
	}
}
