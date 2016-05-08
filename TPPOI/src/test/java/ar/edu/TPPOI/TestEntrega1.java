package ar.edu.TPPOI;

import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class TestEntrega1 {

	LocalComercial cineAbasto;
	Point coordenadaMia, coordenadaCercaParada114, coordenadaCercaBancoCiudad, coordenadaStarbucks,
			coordenadaCercaStarbucks;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	SucursalBanco bancoCiudadCabildo;
	MapaPOI mapaInteractivo;
	CGP cgp1;
	Servicio cargaSUBE;
	Servicio prestamo;
	LocalComercial starbucks;
	LocalComercial sportclub;
	SoporteDeInstanciasParaTestsBuilder soporteParaTests;

	@Before
	public void init() {

		soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		coordenadaMia = soporteParaTests.miCoordenaAbasto();
		coordenadaCercaBancoCiudad = new Point(-58.46362069999999, -34.5545479);
		coordenadaCercaParada114 = new Point(-58.459845186279846, -34.558169509672146);
		coordenadaCercaStarbucks = new Point(-58.414099, -34.593686);

		parada114DeCabildoYMonroe = soporteParaTests.paradaDeColectivo114DeCabildoYMonroe();
		prestamo = soporteParaTests.prestamo();
		bancoCiudadCabildo = soporteParaTests.bancoCiudadCabildoYCongreso();
		cgp1 = soporteParaTests.cgpComuna5();
		starbucks = soporteParaTests.starbucksCoronelDiaz1400();
		sportclub = soporteParaTests.sportClubLibertador7395();
		cineAbasto = soporteParaTests.cineAbasto();
		mapaInteractivo = soporteParaTests.mapa();
		// --------------------------------------------------------------
	}

	// Tests para Calculo de Cercanias
	@Test
	public void testStarbucksNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(starbucks.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testStarbucksEstaCercaDeCoordenadaCercaStarbucks() {
		Assert.assertTrue(starbucks.estasCercaDe(coordenadaCercaStarbucks));
	}

	@Test
	public void testParadaDeColectivoNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(parada114DeCabildoYMonroe.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testBancoCiudadCabildoNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(bancoCiudadCabildo.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testBancoCiudadCabildoEstaCercaDeCoordenadaCercaBancoCiudad() {
		Assert.assertTrue(bancoCiudadCabildo.estasCercaDe(coordenadaCercaBancoCiudad));
	}

	@Test
	public void testUnPOIEstaAMenosDe1000MetrosDeOtroPOI() {
		Assert.assertTrue(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe));
	}

	@Test
	public void testUnPOINoEstaAMenosDe300MetrosDeOtroPOI() {
		Assert.assertFalse(bancoCiudadCabildo.estasAMenosDeXMetrosDe(300, parada114DeCabildoYMonroe));
	}

	@Test
	public void testPuntoDentroDeLaCGP() {
		Assert.assertTrue(cgp1.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testPuntoAfueraDeLaCGP() {
		Assert.assertFalse(cgp1.estasCercaDe(parada114DeCabildoYMonroe.getCoordenada()));
	}

	// Tests para Busqueda de Texto Libre
	@Test
	public void testEncuentraPorNombreDeParadaDeColectivo() {
		Assert.assertEquals(mapaInteractivo.buscar("114").size(), 1);
	}

	@Test
	public void testEncuentraPorRubroDeLocales() {
		Assert.assertEquals(mapaInteractivo.buscar("Cafeteria").size(), 1);
	}

	@Test
	public void testEncuentraPorPalabraClave() {
		Assert.assertEquals(mapaInteractivo.buscar("fitness").size(), 1);
	}

	@Test
	public void testEncuentraNombreServicioSUBE() {
		Assert.assertEquals(mapaInteractivo.buscar("SUBE").size(), 1);
	}

	// Tests de disponibilidad
	@Test
	public void testElCGPDisponibleParaCargarSube() {
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), cargaSUBE));
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 15, 10, 30)), cargaSUBE));
	}

	@Test
	public void testCGPNoDispponibleParaCargarSube() {
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 14, 10, 30)), cargaSUBE));
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), cargaSUBE));
	}

	@Test(expected = NoExisteServicioAsociadoException.class)
	public void testCgpSinServicioAsociado() {
		cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), prestamo);
	}

	@Test
	public void testParadaDeColectivoDisponible() {
		Assert.assertTrue(parada114DeCabildoYMonroe.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), null));
	}

	@Test
	public void testBancoDisponible() {
		Assert.assertTrue(bancoCiudadCabildo.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), prestamo));
	}

	@Test
	public void testLocalDisponible() {
		Assert.assertTrue(starbucks.estaDisponible(LocalDateTime.of(2016, 1, 14, 10, 10, 30)));
	}

	// Tests para agregar y quitar POIs
	@Test
	public void testBarrioAbastoAgregoCineAbasto() {
		Assert.assertTrue(mapaInteractivo.getListaDePOIs().contains(cineAbasto));
	}

	@Test
	public void testBarrioAbastoQuitoCineAbasto() {
		mapaInteractivo.borrarPOI(cineAbasto);
		Assert.assertFalse(mapaInteractivo.getListaDePOIs().contains(cineAbasto));
	}

	// Test para cambiar nombres
	@Test
	public void testStarbuckCambiaAStarbacks() {
		starbucks.setNombre("starbacks");
		Assert.assertTrue(starbucks.getNombre().equals("starbacks"));
	}

	@Test
	public void testBancoCiudadPasaASerBancoDeLaCiudad() {
		bancoCiudadCabildo.setNombre("bancoDeLaCiudad");
		Assert.assertTrue(bancoCiudadCabildo.getNombre().equals("bancoDeLaCiudad"));
	}

	/*
	 * @Test public void encontrarBancoMacroEnComponenteExterno() {
	 * Assert.assertTrue(mapaInteractivo.buscarCGP("Banco Macro")); }
	 */

}
