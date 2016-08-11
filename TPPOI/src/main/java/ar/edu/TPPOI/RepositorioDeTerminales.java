package ar.edu.TPPOI;

import java.util.ArrayList;

public class RepositorioDeTerminales {

	 ArrayList<Terminal> terminales = new ArrayList<Terminal>();
	
	
	public void agregarTerminal(Terminal terminal) {
		this.terminales.add(terminal);
	}
	
	public ArrayList<Terminal> getTerminales(){
		return terminales;
	}

}
