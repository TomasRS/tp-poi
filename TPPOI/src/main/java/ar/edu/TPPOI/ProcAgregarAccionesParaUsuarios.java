package ar.edu.TPPOI;



public class ProcAgregarAccionesParaUsuarios extends ProcesoAltaBaja{
	
	public void run(){
		super.run();
		terminalesFiltradas.forEach(unaT->this.activarCadaAccionPorTerminal(unaT));
	}
	
	public void activarCadaAccionPorTerminal(Terminal unaTerminal){
		acciones.forEach(unaA -> unaTerminal.activarAccion(unaA));
	}


}
