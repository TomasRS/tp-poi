package ar.edu.TPPOI;

import java.util.ArrayList;

public class RepositorioDeTerminales {

	public ArrayList<Terminal> getTerminales() {
		return terminales;
	}
	
	public void setTerminales(ArrayList<Terminal> terminales) {
		this.terminales = terminales;
	}
	ArrayList<Terminal> terminales;
	public void agregarTerminal(Terminal terminal) {
		this.getTerminales().add(terminal);
	}

}
