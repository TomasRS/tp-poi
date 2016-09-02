package ar.edu.TPPOI;

import java.util.ArrayList;


public class UsuariosElegidosPorAdmin extends Criterio {

	ArrayList<Terminal> terminalesElegidasPorAdmin= new ArrayList<>();
	public ArrayList<Terminal> getTerminalesElegidasPorAdmin() {
		return terminalesElegidasPorAdmin;
	}
	public void agregarTerminalesElegidasPorAdmin(Terminal terminalElegidasPorAdmin) {
		this.terminalesElegidasPorAdmin.add(terminalElegidasPorAdmin);
	}
	
	public ArrayList<Terminal> filtrarTerminales(ArrayList<Terminal> terminales) {
	return terminalesElegidasPorAdmin;
	}


}
