package ar.edu.TPPOI;



public class ProcAgregarAccionesParaUsuarios extends ProcesoAltaBaja{
	
	public void ejecutar(){
		
		this.terminales().forEach(unaT->this.activarCadaAccionPorTerminal(unaT));
	}
	
	public void activarCadaAccionPorTerminal(Terminal unaTerminal){
		acciones.forEach(unaA -> unaTerminal.activarAccion(unaA));
	}


}
