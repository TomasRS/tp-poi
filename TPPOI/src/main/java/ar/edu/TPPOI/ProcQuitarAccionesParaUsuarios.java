package ar.edu.TPPOI;

public class ProcQuitarAccionesParaUsuarios extends ProcesoAltaBaja {

	public void ejecutar(){
		this.filtrarTerminales();
		terminalesFiltradas.forEach(unaT->this.desactivarCadaAccionPorTerminal(unaT));
	}
	
	public void desactivarCadaAccionPorTerminal(Terminal unaTerminal){
		acciones.forEach(unaA -> unaTerminal.desactivarAccion(unaA));
	}


}
