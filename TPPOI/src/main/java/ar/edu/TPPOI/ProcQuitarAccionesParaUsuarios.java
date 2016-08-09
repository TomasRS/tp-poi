package ar.edu.TPPOI;

public class ProcQuitarAccionesParaUsuarios extends ProcesoAltaBaja {

	public void run(){
		super.run();
		terminalesFiltradas.forEach(unaT->unaT.desactivarAcciones(acciones));	
	}

}
