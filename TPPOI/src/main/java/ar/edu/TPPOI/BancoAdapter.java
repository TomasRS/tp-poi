package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uqbar.geodds.Point;

import com.google.gson.Gson;

public class BancoAdapter implements SistemaExternoAdapterInterface {

	BancoExternoImpostor bancoExternoImpostor;

	public BancoAdapter(BancoExternoImpostor unSistemaConsultaDeBancosExterno) {
		bancoExternoImpostor = unSistemaConsultaDeBancosExterno;
	}

	public List<POI> buscar(String unTextoLibre, String otroTextoLibre) {
		Gson gson = new Gson();
		String JSON = this.bancoExternoImpostor.buscar(unTextoLibre, otroTextoLibre);
		BancoJSON[] bancosJSON = gson.fromJson(JSON, BancoJSON[].class);
		if (bancosJSON == null) {
			List<POI> listaVaciaDePOIs = new ArrayList<>();
			return listaVaciaDePOIs;
		} else
			return this.generarNuevasSucursales(bancosJSON);
	}

	private List<POI> generarNuevasSucursales(BancoJSON[] unosBancosJSON) {
		List<POI> sucursalBanco = new ArrayList<>();
		Arrays.stream(unosBancosJSON).forEach(unBancoJSON -> sucursalBanco.add(this.nuevaSucursal(unBancoJSON)));
		return sucursalBanco;
	}

	private SucursalBanco nuevaSucursal(BancoJSON unBancoJSON) {
		Point coordenadaSucursalBanco = new Point(unBancoJSON.getX(), unBancoJSON.getY());
		SucursalBanco sucursalBanco = new SucursalBanco(unBancoJSON.getBanco(), unBancoJSON.getSucursal(),
				coordenadaSucursalBanco, new Direccion());
		unBancoJSON.getServicios().remove("");
		unBancoJSON.getServicios().forEach(
				unNombreServicio -> sucursalBanco.agregarServicio(Servicio.nuevoServicioBanco(unNombreServicio)));
		return sucursalBanco;
	}

	@Override
	public List<CentroDTO> buscar(String unTextoLibre) {
		// TODO Auto-generated method stub
		return null;
	}

}
