package ar.edu.TPPOI;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class BancoAdapterTest {

	SoporteDeInstanciasParaTestsBuilder soporteDeInstanciasParaTestsBuilder;

	@Before
	public void init() {
		soporteDeInstanciasParaTestsBuilder = new SoporteDeInstanciasParaTestsBuilder();
	}

	@Test
	public void busquedaConCoincidenciaDevuelveDosSucursalesBanco() {

		List<POI> listaDePOIs = soporteDeInstanciasParaTestsBuilder.bancoAdapter().buscar("Banco de la Plaza",
				"extracciones");
		Assert.assertEquals(listaDePOIs.size(), 2);
		Assert.assertEquals(listaDePOIs.get(0).printString(),
				"Banco de la Plaza" + "Bancos" + "500" + new Point(-35.9338322, 72.348353).toString() + "Avellaneda");
		Assert.assertEquals(listaDePOIs.get(1).printString(),
				"Banco de la Plaza" + "Bancos" + "500" + new Point(-35.9345681, 72.344546).toString() + "Caballito");
	}

	@Test
	public void busquedaSinCoincidenciaDeSucursalesBanco() {
		Assert.assertEquals(soporteDeInstanciasParaTestsBuilder.bancoAdapter().buscar("Banco de la Plaza", "").size(),
				0);
	}

}
