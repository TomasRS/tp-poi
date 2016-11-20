package criteriosFiltradoTerminales;

import java.util.ArrayList;
import java.util.List;

import ar.edu.TPPOI.Terminal;

public class UsuariosElegidosPorAdmin extends Criterio {

	List<Terminal> terminalesElegidasPorAdmin = new ArrayList<>();

	public List<Terminal> getTerminalesElegidasPorAdmin() {
		return terminalesElegidasPorAdmin;
	}

	public void agregarTerminalesElegidasPorAdmin(Terminal terminalElegidasPorAdmin) {
		this.terminalesElegidasPorAdmin.add(terminalElegidasPorAdmin);
	}

	public List<Terminal> filtrarTerminales(List<Terminal> terminales) {
		return terminalesElegidasPorAdmin;
	}

}
