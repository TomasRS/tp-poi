package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReintentosPorFallaTest {
	private ProcesoImpostorParaTest proceso;
	private ReintentarNVeces manejoReintento;
	
	@Before
	public void init(){
		proceso = new ProcesoImpostorParaTest();
		manejoReintento = new ReintentarNVeces();
		manejoReintento.setVeces(5);
		proceso.setAccionEnCasoDeError(manejoReintento);
	}
	
	@Test
	public void seReintenta4Veces(){
		proceso.fallarEn(4);
		proceso.run();
		Assert.assertEquals(5, proceso.cantidadEjecucionesRealizadas(), 0);
	}
	
	@Test
	public void UsaTodosLosReintentos(){
		proceso.fallarEn(8);
		proceso.run();
		Assert.assertEquals(6, proceso.cantidadEjecucionesRealizadas(), 0);
	}
	
	@Test
	public void primeraEjecucionExitosa(){
		proceso.fallarEn(0);
		proceso.run();
		Assert.assertEquals(1, proceso.cantidadEjecucionesRealizadas(), 0);
	}
	
}
