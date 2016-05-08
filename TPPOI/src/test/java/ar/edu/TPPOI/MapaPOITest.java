package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapaPOITest {

	LocalComercial cineAbasto;
	MapaPOI mapaInteractivo;

	@Before
	public void init() {

		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		cineAbasto = soporteParaTests.cineAbasto();
		mapaInteractivo = soporteParaTests.mapa();
	}

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
	public void testEncuentraPorDosPalabrasClave() {
		Assert.assertEquals(mapaInteractivo.buscar("fitness", "musculacion").size(), 1);
	}

	@Test
	public void testNoEncuentraPorDosPalabrasClave() {
		Assert.assertEquals(mapaInteractivo.buscar("fitness", "SUBE").size(), 0);
	}

	@Test
	public void testEncuentraNombreServicioSUBE() {
		Assert.assertEquals(mapaInteractivo.buscar("SUBE").size(), 1);
	}

	@Test
	public void testBarrioAbastoAgregoCineAbasto() {
		mapaInteractivo.agregarPOI(cineAbasto);
		Assert.assertTrue(mapaInteractivo.getListaDePOIs().contains(cineAbasto));
	}

	@Test
	public void testBarrioAbastoQuitoCineAbasto() {
		mapaInteractivo.agregarPOI(cineAbasto);
		mapaInteractivo.borrarPOI(cineAbasto);
		Assert.assertFalse(mapaInteractivo.getListaDePOIs().contains(cineAbasto));
	}
}
