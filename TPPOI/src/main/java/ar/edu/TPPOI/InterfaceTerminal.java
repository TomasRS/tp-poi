package ar.edu.TPPOI;

import java.time.LocalDateTime;

public interface InterfaceTerminal {
	
	void mandarMail();
	int cantidadDeBusquedasPorFecha(LocalDateTime fecha);
	void registrar();
	void buscar(String unTextoLibre);
	boolean superaTiempoLimite();
	
}
