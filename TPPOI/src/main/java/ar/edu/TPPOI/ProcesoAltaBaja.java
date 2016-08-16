package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcesoAltaBaja extends Proceso {
	ArrayList<Accion> acciones = new ArrayList<>();
	RepositorioDeTerminales repTerminales;
	ArrayList<Terminal> terminalesFiltradas = new ArrayList<>();
	Criterio criterio;
	
	public RepositorioDeTerminales getRepTerminales() {
		return repTerminales;
	}

	public void setRepTerminales(RepositorioDeTerminales repTerminales) {
		this.repTerminales = repTerminales;
	}

	public ArrayList<Terminal> getTerminalesFiltradas(){
		return terminalesFiltradas;
	}


	public List<Accion> getAcciones() {
		return acciones;
	}


	public void agregarAccion(Accion accion) {
		acciones.add(accion);
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
