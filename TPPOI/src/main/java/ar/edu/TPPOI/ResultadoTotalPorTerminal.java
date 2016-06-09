package ar.edu.TPPOI;

import java.time.LocalDateTime;


public class ResultadoTotalPorTerminal implements Accion{
	
	String nombreAccion ="resultadoPorTerminal";
	public Integer reporteDeResultadosTotalPorTerminal(Terminal unaTerminal){
		return unaTerminal.busquedasHechas.stream().mapToInt(unaB->unaB.getCantDeBusquedas()).sum();
	}

	@Override
	public String getNombreAccion() {
		return nombreAccion;
	}

	@Override
	public void mandarMail(Terminal unaTerminal) {
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

}
