package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import externos.BancoAdapter;
import externos.CGPAdapter;

public class MapaPOITest {

	LocalComercial cineAbasto;
	MapaPOI mapaInteractivo;
	BancoAdapter bancoAdapter;
	CGPAdapter cgpAdapter;

	@Before
	public void init() {

		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		cineAbasto = soporteParaTests.cineAbasto();
		mapaInteractivo = soporteParaTests.mapa();
		bancoAdapter = soporteParaTests.bancoAdapter();
		cgpAdapter = soporteParaTests.CGPAdapter();
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
	public void testBuscarCGPBalvaneraEnSistemaExterno(){
		Assert.assertEquals(cgpAdapter.buscar("Balvanera").size(), 1);
	}
	
	@Test
	public void testBuscarCGPJuninEnSistemaExterno(){
		Assert.assertEquals(cgpAdapter.buscar("Junin").size(), 1);
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
	public void testQueSeAgregueUnCGPQueNoExiste() {
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 5);
		mapaInteractivo.buscar("Balvanera");
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 6);
	}
	
	@Test
	public void testQueSeAgregueSoloUnCGPQueNoExiste() {
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 5);
		mapaInteractivo.buscar("Balvanera");
		mapaInteractivo.buscar("Junin");
		Assert.assertEquals(mapaInteractivo.getListaDePOIs().size(), 6);
	}

	@Test
	public void testQueEncuentreUnCGPQueYaAgregado() {
		mapaInteractivo.buscar("Balvanera");
		Assert.assertEquals(mapaInteractivo.busquedaLocal("asesoramiento", "").size(), 1);
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
