package ar.edu.TPPOI;

import java.time.LocalDateTime;

public interface InterfaceTerminal {
	
	public void mandarMail();
	public int cantidadDeBusquedasPorFecha(LocalDateTime fecha);
	public void registrar();
	public void buscar(String unTextoLibre);
	public boolean superaTiempoLimite();
}
