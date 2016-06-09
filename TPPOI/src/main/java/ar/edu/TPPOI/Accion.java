package ar.edu.TPPOI;

import java.time.LocalDateTime;
//import java.util.List;

public interface Accion{
	
	public  String getNombreAccion();

	public void mandarMail(Terminal terminal);

	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados, Terminal terminal);

	public Integer cantidadDeBusquedasPorFecha(LocalDateTime unaFecha, Terminal terminal) ;

	public Integer resultadoPorBusqueda(String unTextoLibre, Terminal terminal);

	public Integer reporteDeResultadosTotalPorTerminal(Terminal unaTerminal) ;
	
}