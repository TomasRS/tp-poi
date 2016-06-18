package ar.edu.TPPOI;

public interface Accion {

	public abstract void ejecutar(String unTextoLibre, Integer cantPOIs, long tiempoDeBusqueda, Terminal unaTerminal);
}
