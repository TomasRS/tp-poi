package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEntrega1 {
	
	ParadaDeColectivo parada114DeCabildoYMonroe = new ParadaDeColectivo();
	Punto coordenadaParada114 = new Punto();
	Punto coordenadaMia = new Punto(); //Abasto Shopping
	
	@Before
	public void init(){
		
	coordenadaParada114.setLatitud(-34.558164509672146);
	coordenadaParada114.setLongitud(-58.459845185279846);
	parada114DeCabildoYMonroe.setCoordenada(coordenadaParada114);
		
	coordenadaMia.setLatitud(-34.60421247366349);
	coordenadaMia.setLongitud(-58.41059446334839);
		
	}
	@Test
	public void testParadaDeColectivoNoEstaCerca(){
		Assert.assertEquals(parada114DeCabildoYMonroe.estasCercaDeLaCoordenada(coordenadaMia),false);
	}
	
}
