package ar.edu.TPPOI;

import java.time.LocalDateTime;
//import java.util.List;
import java.util.stream.Collectors;

public class ResultadoPorBusqueda implements Accion{
	String nombreAccion ="resultadoPorBusqueda";
	


	public Integer resultadoPorBusqueda(String unTextoLibre, Terminal unaTerminal){
		return unaTerminal.busquedasHechas.stream().filter(unaB->unaB.frase.equals(unTextoLibre)).collect(Collectors.toList()).size();
		
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
