package ar.edu.TPPOI;

import java.time.LocalDateTime;
//import java.util.List;

public class Notificar implements Accion {
	String nombreAccion="notificar";

	public void mandarMail(Terminal unaTerminal){
			unaTerminal.setMailEnviado(true);
	}
	
	public String getNombreAccion() {
		return nombreAccion;
	}
	

	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados,
			Terminal terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer cantidadDeBusquedasPorFecha(LocalDateTime unaFecha, Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer resultadoPorBusqueda(String unTextoLibre, Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer reporteDeResultadosTotalPorTerminal(Terminal unaTerminal) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*@Override
	public Integer resultadosTotales(List<Terminal> terminales) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
