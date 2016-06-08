package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

public class ObtenerReporte implements Accion {

	
	public Integer cantidadDeBusquedasPorFecha(LocalDateTime fecha, Terminal unaTerminal){
		return unaTerminal.busquedasPorFecha.get(fecha);
	}

	@Override
	public String getNombreAccion() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados,
			Terminal terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer resultadoPorBusqueda(String unTextoLibre, Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer resultadosTotales(List<Terminal> terminales) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mandarMail(Terminal terminal) {
		// TODO Auto-generated method stub
		
	}

	
}
