package ar.edu.TPPOI;



public class ProcAgregarAccionesParaUsuarios extends ProcesoAltaBaja{
	
	public void run(){
		super.run();
		terminalesFiltradas.forEach(unaT->unaT.activarAcciones(acciones));	
	}


}
