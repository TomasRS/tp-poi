package ar.edu.TPPOI;

public abstract class ManejoDeResultado {


	public abstract void ejecutarEnCasoDeFalla(Proceso unProceso);

	

	public boolean noAceptaCombinarManejos() {
		return false;
	};
}
