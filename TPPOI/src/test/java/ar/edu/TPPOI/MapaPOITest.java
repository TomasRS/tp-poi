package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import externos.BancoAdapter;

public class MapaPOITest {

	LocalComercial cineAbasto;
	MapaPOI mapaInteractivo;
	BancoAdapter bancoAdapter;

	@Before
	public void init() {

		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		cineAbasto = soporteParaTests.cineAbasto();
		mapaInteractivo = soporteParaTests.mapa();
		bancoAdapter = soporteParaTests.bancoAdapter();
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
	public void testBuscarBancoPlazaExtraccionesEnSistemaExterno() {
		Assert.assertEquals((bancoAdapter.buscar("Banco de la Plaza", "extracciones")).size(), 2);
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

	@Test
	public void testObtenerDosPOISucursalBancoDesdeSistemaExterno() {
		Assert.assertEquals(mapaInteractivo.buscarEnSistemasExternos("Banco de la Plaza", "extracciones").size(), 2);
	}

	@Test
	public void testQueSeAgreguenDosSucursalesBancoQueNoExisten() {
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 5);
		mapaInteractivo.buscar("Banco de la Plaza", "extracciones");
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 7);
	}

	@Test
	public void testQueNoSeAgreguenDosSucursalesBancoQueExisten() {
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 5);
		mapaInteractivo.buscar("Banco de la Plaza", "extracciones");
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 7);
		Assert.assertEquals(mapaInteractivo.busquedaLocal("Banco de la Plaza", "Caballito").size(), 1);
		Assert.assertEquals(mapaInteractivo.busquedaLocal("Banco de la Plaza", "Avellaneda").size(), 1);
		mapaInteractivo.buscar("Banco de la Plaza", "extracciones");
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 7);
	}
	
}
