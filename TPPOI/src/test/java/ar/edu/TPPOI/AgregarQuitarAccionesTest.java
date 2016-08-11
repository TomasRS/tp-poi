package ar.edu.TPPOI;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
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

	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		accionNotificar = soporteParaTests.notificar(envioDeMail1);
		accionAlmacenar = soporteParaTests.almacenar();
		mapaInteractivo = soporteParaTests.mapa();
		envioDeMail1 = soporteParaTests.envioDeMail();
		rep = soporteParaTests.repositorio();
		procAgregarAcciones = soporteParaTests.procAgregarAcciones();
		terminalAbasto = soporteParaTests.terminal();
		terminalCaballito = soporteParaTests.terminal();
		terminalAbasto.setMapa(mapaInteractivo);
		terminalCaballito.setMapa(mapaInteractivo);
		comunaCriterio = soporteParaTests.comunaCriterio();
		
		List<Point> puntosAbasto = new ArrayList<>();
		puntosAbasto.add(new Point(-58.411898, -34.597984));
		puntosAbasto.add(new Point(-58.426446, -34.597878));
		puntosAbasto.add(new Point(-58.433334, -34.602696));
		puntosAbasto.add(new Point(-58.430051, -34.615469));
		puntosAbasto.add(new Point(-58.427899, -34.622162));
		puntosAbasto.add(new Point(-58.412372, -34.620890));
		Polygon comunaAbasto = new Polygon(puntosAbasto);
		terminalAbasto.setComuna(comunaAbasto);
		comunaCriterio.setComunaAsociada(comunaAbasto);
		
		List<Point> puntosCaballito = new ArrayList<>();
		puntosCaballito.add(new Point(-58.411898, -34.597984));
		puntosCaballito.add(new Point(-58.426446, -34.597878));
		puntosCaballito.add(new Point(-58.433334, -34.602696));
		puntosCaballito.add(new Point(-58.430051, -34.615469));
		puntosCaballito.add(new Point(-58.427899, -34.622162));
		puntosCaballito.add(new Point(-58.412372, -34.620891));
		Polygon comunaCaballito = new Polygon(puntosCaballito);
		terminalCaballito.setComuna(comunaCaballito);
		
		
		
	}
	
	//------------------------------ Tests de Agregar/Quitar
	
	@Test
	public void testAgregarAccionesSegunComuna(){
		procAgregarAcciones.setCriterio(comunaCriterio);
		procAgregarAcciones.setRepTerminales(rep);
		procAgregarAcciones.agregarAcciones(accionAlmacenar);
		procAgregarAcciones.agregarAcciones(accionNotificar);
		rep.agregarTerminal(terminalAbasto);
		rep.agregarTerminal(terminalCaballito);
		//ACA FALLA ESTE METODO RUN() POR QUE LLAMA AL FILTRARTERMINALES DE CRITERIO 
		//Y CRITERIO (COMUNAALAQUEPERTENECE) NECESITA UNA COMUNA ASOCIADA DE TIPO POLYGON
		//LA CUAL NO LA PUEDO INSTANCIAR
		procAgregarAcciones.run();
		ArrayList<Terminal> terminales = procAgregarAcciones.getRepTerminales().getTerminales();
		//PARA MI ASI TIENEN QUE QUEDAR AL FINAL Y FILTRAR SOLO LA TERMINAL ABASTO QUE 
		// ES LA QUE COINCIDE CON LA COORDENADA ABASTO QUE ES LA QUE VA A TENER EL CRITERIO 
		Assert.assertEquals(1, comunaCriterio.filtrarTerminales(terminales).size(),0);
	}

}
