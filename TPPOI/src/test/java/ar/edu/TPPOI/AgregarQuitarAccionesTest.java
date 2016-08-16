package ar.edu.TPPOI;


import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Polygon;

public class AgregarQuitarAccionesTest {
	
	ProcAgregarAccionesParaUsuarios procAgregarAcciones;
	Notificar accionNotificar;
	Almacenar accionAlmacenar;
	Terminal terminalAbasto;
	Terminal terminalCaballito;
	RepositorioDeTerminales rep;
	EnvioDeMail envioDeMail1;
	MapaPOI mapaInteractivo;
	ComunaALaQuePertenece comunaCriterio; 
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
		
		comunaAbasto = soporteParaTests.crearComunaAbasto();
		comunaCaballito = soporteParaTests.crearComunaCaballito();
		terminalAbasto = soporteParaTests.terminal();
		terminalCaballito = soporteParaTests.terminal();
		terminalAbasto.setMapa(mapaInteractivo);
		terminalCaballito.setMapa(mapaInteractivo);
		terminalAbasto.setComuna(comunaAbasto);
		terminalCaballito.setComuna(comunaCaballito);
		
		comunaCriterio = soporteParaTests.comunaCriterio();
		comunaCriterio.setComunaAsociada(comunaAbasto);
		
		rep = soporteParaTests.repositorio();
		procAgregarAcciones.setRepTerminales(rep);
		rep.agregarTerminal(terminalAbasto);
		rep.agregarTerminal(terminalCaballito);
		
		
	}
	
	//------------------------------ Tests de Agregar/Quitar
	
	@Test
	public void testAgregarAccionesATerminalSinAccionesActivadasSegunComuna(){
		procAgregarAcciones.setCriterio(comunaCriterio);
		procAgregarAcciones.agregarAcciones(accionAlmacenar);
		procAgregarAcciones.agregarAcciones(accionNotificar);
		procAgregarAcciones.run();
		ArrayList<Terminal> terminales = procAgregarAcciones.getRepTerminales().getTerminales();
		Assert.assertEquals(1, comunaCriterio.filtrarTerminales(terminales).size(),0);
	}

}
