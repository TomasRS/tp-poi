package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestEntrega1 {
	
	ParadaDeColectivo parada114DeCabildoYMonroe = new ParadaDeColectivo();
	Punto coordenadaParada114 = new Punto();
	Punto coordenadaMia = new Punto();
	SucursalBanco bancoCiudadCabildo = new SucursalBanco();
	Punto coordenadaBancoCiudad = new Punto();
	
	@Before
	public void init(){
	
	//Parada 114 de Cabildo y Monroe
	parada114DeCabildoYMonroe.setCoordenada(coordenadaParada114);
	coordenadaParada114.setLatitud(-34.558164509672146);
	coordenadaParada114.setLongitud(-58.459845185279846);
	
	//Abasto Shopping
	coordenadaMia.setLatitud(-34.60421247366349);
	coordenadaMia.setLongitud(-58.41059446334839);
	
	//Banco Ciudad de Cabildo y Congreso
	bancoCiudadCabildo.setCoordenada(coordenadaBancoCiudad);
	coordenadaBancoCiudad.setLatitud(-34.5545459);
	coordenadaBancoCiudad.setLongitud(-58.46362049999999);
		
	}
	@Test
	public void testParadaDeColectivoNoEstaCercaDeMiCoordenada(){
		Assert.assertEquals(parada114DeCabildoYMonroe.estasCercaDe(coordenadaMia),false);
	}
	
	@Test
	public void testUnPOIEstaAMenosDeXMetrosDeOtroPOI(){
		Assert.assertEquals(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe), true);
	}
	
}
