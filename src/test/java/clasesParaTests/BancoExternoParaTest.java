package clasesParaTests;

import externos.BancoExternoInterface;

public class BancoExternoParaTest implements BancoExternoInterface {

	public String buscar(String textoLibre) {

		String[] output = textoLibre.split(",");
		
		if (output.length!=2){
			return null;
		} else if (
			output[0].toLowerCase().equalsIgnoreCase("Banco de la Plaza")
			&&output[1].toLowerCase().equalsIgnoreCase("extracciones")) {
			return "[{ 'banco': 'Banco de la Plaza'," + "'x': -35.9338322," + "'y': 72.348353,"
					+ "'sucursal': 'Avellaneda'," + "'gerente': 'Javier Loeschbor',"
					+ "'servicios': [ 'cobro cheques', 'depósitos', 'extracciones', 'transferencias', 'créditos', '', '', '' ]"
					+ "}," + "{  'banco': 'Banco de la Plaza'," + "'x': -35.9345681," + "'y': 72.344546,"
					+ "'sucursal': 'Caballito'," + "'gerente': 'Fabián Fantaguzzi',"
					+ "'servicios': [ 'depósitos', 'extracciones', 'transferencias', 'seguros', '', '', '', '' ]" + "}"
					+ "]";
		}
		return null;
	}
}