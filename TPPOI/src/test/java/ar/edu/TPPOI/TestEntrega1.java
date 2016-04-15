package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEntrega1 {
	
	Punto coordenadaMia = new Punto();
	ParadaDeColectivo parada114DeCabildoYMonroe = new ParadaDeColectivo();
	Punto coordenadaParada114 = new Punto();
	SucursalBanco bancoCiudadCabildo = new SucursalBanco();
	Punto coordenadaBancoCiudad = new Punto();
	MapaPOI mapaInteractivo = new MapaPOI();
	CGP cgp1 = new CGP();
	Servicio cargaSUBE;
	
	@Before
	public void init(){
	
	//Mapa interactivo
	mapaInteractivo.listaDePOIs.add(parada114DeCabildoYMonroe);
	mapaInteractivo.listaDePOIs.add(bancoCiudadCabildo);
	
	//Parada 114 de Cabildo y Monroe
	parada114DeCabildoYMonroe.setCoordenada(coordenadaParada114);
	coordenadaParada114.setLatitud(-34.558164509672146);
	coordenadaParada114.setLongitud(-58.459845185279846);
	parada114DeCabildoYMonroe.setCalle1("Monroe");
	parada114DeCabildoYMonroe.setCalle2("Cabildo");

	//Mi coordenada - Abasto Shopping
	coordenadaMia.setLatitud(-34.60421247366349);
	coordenadaMia.setLongitud(-58.41059446334839);
	
	//Banco Ciudad de Cabildo y Congreso
	bancoCiudadCabildo.setCoordenada(coordenadaBancoCiudad);
	coordenadaBancoCiudad.setLatitud(-34.5545459);
	coordenadaBancoCiudad.setLongitud(-58.46362049999999);
	bancoCiudadCabildo.setCalle1("Cabildo");
	bancoCiudadCabildo.setCalle2("Congreso");

	//CGP1
		cargaSUBE = new Servicio("cargar SUBE");
		Horario horario1 = new Horario("FRIDAY", "08:00", "13:00");
		Horario horario2 = new Horario("FRIDAY", "15:00", "20:00");
		cargaSUBE.addHorario(horario1);
		cargaSUBE.addHorario(horario2);
		cgp1.addServicio(cargaSUBE);
		cgp1.setRubro("Propositos generales");
		cgp1.setCoordenada(coordenadaParada114);
	}
	
	//Tests para Calculo de Cercanias
	@Test
	public void testParadaDeColectivoNoEstaCercaDeMiCoordenada(){
		Assert.assertEquals(parada114DeCabildoYMonroe.estasCercaDe(coordenadaMia),false);
	}
	
	@Test
	public void testUnPOIEstaAMenosDeXMetrosDeOtroPOI(){
		Assert.assertEquals(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe), true);
	}
	
	//Tests para Busqueda de Texto Libre
	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreJusto(){
		Assert.assertEquals(mapaInteractivo.buscar("Cabildo").size(), 2);
	}
	
	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreMasLargo(){
		Assert.assertEquals(mapaInteractivo.buscar("Avenida Cabildo").size(), 2);
	}
	
	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreMasChico(){
		Assert.assertEquals(mapaInteractivo.buscar("Cabil").size(), 2);
	}
	
	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreErroneo(){
		Assert.assertEquals(mapaInteractivo.buscar("Docabil").size(), 0);
	}
	
	//Tests de disponibilidad
	@Test
	public void testDisponibilidad(){
		Assert.assertTrue(cgp1.estoyDisponibleEn(LocalDateTime.now()));
	}
}
