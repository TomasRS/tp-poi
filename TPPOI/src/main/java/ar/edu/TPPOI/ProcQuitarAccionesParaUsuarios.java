package ar.edu.TPPOI;

public class ProcQuitarAccionesParaUsuarios extends ProcesoAltaBaja {

	public void run(){
		super.run();
		terminalesFiltradas.forEach(unaT->this.desactivarCadaAccionPorTerminal(unaT));
	}
	
	public void desactivarCadaAccionPorTerminal(Terminal unaTerminal){
		acciones.forEach(unaA -> unaTerminal.desactivarAccion(unaA));
	}


}
