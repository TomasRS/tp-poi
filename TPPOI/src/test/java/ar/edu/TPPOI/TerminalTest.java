package ar.edu.TPPOI;

import java.time.LocalDateTime;
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
		accionesAbasto.add(new ObtenerReporte());
		accionesAbasto.add(new ResultadoPorBusqueda());
		terminalAbasto.setMapa(mapaInteractivo);
		terminalAbasto.setAcciones(accionesAbasto);
		
		List<Accion>accionesCaballito=new ArrayList<>();
		accionesCaballito.add(new ObtenerReporte());
		accionesCaballito.add(new Notificar());
		accionesCaballito.add(new Almacenar());
		accionesCaballito.add(new ResultadoTotalPorTerminal());
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
	public void testFiltraBusquedaAlmacenada(){
		terminalAbasto.setTiempoLimite(1000000000);
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.filtrarBusquedasAlmacenadasPorFrase("114").size(),1);
	}
	
	@Test
	public void testTerminalAlmacenaLaBusqueda(){
		terminalAbasto.setTiempoLimite(1000000000);
		terminalAbasto.buscar("114");
		terminalAbasto.buscar("San Cristobal");
		Assert.assertTrue(terminalAbasto.almacenoBusqueda());
	}
	

	/*@Test
	public void testReporte(){
		terminalCaballito.setTiempoLimite(1000000000);
		LocalDateTime a = LocalDateTime.now();
		terminalCaballito.buscar("114");
		Assert.assertEquals(terminalCaballito.obtenerReporteDeBusquedasPorFecha(a), (Integer) 1);
	}
	
	@Test
	public void testReporteDobleBusqueda(){
		terminalCaballito.setTiempoLimite(1000000000);
		LocalDateTime a = LocalDateTime.now();
		terminalCaballito.buscar("114");
		terminalCaballito.buscar("San Cristobal");
		Assert.assertEquals(terminalCaballito.busquedasPorFecha.get(a), (Integer) 2);
	}*/
	
	@Test
	public void testResultadoPorBusqueda(){
		terminalCaballito.setTiempoLimite(1000000000);
		terminalCaballito.buscar("114");
		Assert.assertEquals(terminalCaballito.reporteDeResultadosPorBusqueda("114"), (Integer) 1);
	}

	
}
