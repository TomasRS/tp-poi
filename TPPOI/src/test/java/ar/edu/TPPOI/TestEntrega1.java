package ar.edu.TPPOI;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class TestEntrega1 {

	Point coordenadaMia;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	Point coordenadaParada114;
	SucursalBanco bancoCiudadCabildo;
	Point coordenadaBancoCiudad;
	MapaPOI mapaInteractivo;
	CGP cgp1 = new CGP();
	Servicio cargaSUBE;
	
	@Before
	public void init() {

		// Mi coordenada - Abasto Shopping
		coordenadaMia = new Point(-58.41059446334839, -34.60421247366349);
		// Parada 114 de Cabildo y Monroe
		parada114DeCabildoYMonroe = new ParadaDeColectivo();
		coordenadaParada114 = new Point(-58.459845185279846, -34.558164509672146);
		parada114DeCabildoYMonroe.setCoordenada(coordenadaParada114);
		parada114DeCabildoYMonroe.setCalle1("Monroe");
		parada114DeCabildoYMonroe.setCalle2("Cabildo");

		// Banco Ciudad de Cabildo y Congreso
		bancoCiudadCabildo = new SucursalBanco();
		coordenadaBancoCiudad = new Point(-58.46362049999999, -34.5545459);
		bancoCiudadCabildo.setCoordenada(coordenadaBancoCiudad);
		bancoCiudadCabildo.setCalle1("Cabildo");
		bancoCiudadCabildo.setCalle2("Congreso");

		// Mapa interactivo
		mapaInteractivo = new MapaPOI();
		mapaInteractivo.listaDePOIs.add(parada114DeCabildoYMonroe);
		mapaInteractivo.listaDePOIs.add(bancoCiudadCabildo);

		// CGP1
		cargaSUBE = new Servicio("cargar SUBE");
		Horario horario1 = new Horario("FRIDAY", "08:00", "13:00");
		Horario horario2 = new Horario("FRIDAY", "15:00", "20:00");
		cargaSUBE.addHorario(horario1);
		cargaSUBE.addHorario(horario2);
		cgp1.addServicio(cargaSUBE);
		cgp1.setRubro("Propositos generales");
		cgp1.setCoordenada(coordenadaParada114);
	}

	// Tests para Calculo de Cercanias
	@Test
	public void testParadaDeColectivoNoEstaCercaDeMiCoordenada() {
		Assert.assertEquals(parada114DeCabildoYMonroe.estasCercaDe(coordenadaMia), false);
	}

	@Test
	public void testUnPOIEstaAMenosDeXMetrosDeOtroPOI() {
		Assert.assertEquals(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe), true);
	}

	// Tests para Busqueda de Texto Libre
	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreJusto() {
		Assert.assertEquals(mapaInteractivo.buscar("Cabildo").size(), 2);
	}

	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreMasLargo() {
		Assert.assertEquals(mapaInteractivo.buscar("Avenida Cabildo").size(), 2);
	}

	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreMasChico() {
		Assert.assertEquals(mapaInteractivo.buscar("Cabil").size(), 2);
	}

	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreErroneo() {
		Assert.assertEquals(mapaInteractivo.buscar("Docabil").size(), 0);
	}

	// Tests de disponibilidad
	@Test
	public void testCgpDisponible() {
		Assert.assertTrue(cgp1.estoyDisponibleEn(LocalDateTime.of(2016, 1, 15, 10, 10, 30)));
		Assert.assertTrue(cgp1.estoyDisponibleEn(LocalDateTime.of(2016, 1, 15, 15, 10, 30)));
	}
	@Test
	public void testCgpNoDisponible() {
		Assert.assertFalse(cgp1.estoyDisponibleEn(LocalDateTime.of(2016, 1, 15, 14, 10, 30)));
		Assert.assertFalse(cgp1.estoyDisponibleEn(LocalDateTime.of(2016, 1, 16, 10, 10, 30)));
	}
}
