package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcesoAltaBaja extends Proceso {
	ArrayList<Accion> acciones = new ArrayList<>();
	RepositorioDeTerminales repTerminales;
	ArrayList<Terminal> terminalesFiltradas=new ArrayList<>();
	
	public RepositorioDeTerminales getRepTerminales() {
		return repTerminales;
	}

	Criterio criterio;


	public List<Accion> getAcciones() {
		return acciones;
	}


	public void setAcciones(List<Accion> acciones) {
		acciones.addAll(acciones);
	}


	public Criterio getCriterio() {
		return criterio;
	}


	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}


	@Override
	public void run() {
			terminalesFiltradas.addAll(this.getCriterio().filtrarTerminales(this.getRepTerminales().getTerminales()));		
	}

}
