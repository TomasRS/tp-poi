package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

public interface Accion{
	
	public abstract String getNombreAccion();

	public abstract void mandarMail(Terminal terminal);

	public abstract void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados, Terminal terminal);

	public abstract Integer cantidadDeBusquedasPorFecha(LocalDateTime unaFecha, Terminal terminal) ;

	public abstract Integer resultadoPorBusqueda(String unTextoLibre, Terminal terminal);

	public abstract Integer resultadosTotales(List<Terminal> terminales);
	
}