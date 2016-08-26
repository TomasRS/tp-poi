package ar.edu.TPPOI;

public class ReintentarNVeces extends ManejoDeResultado{

	private Integer veces;

	public Integer getVeces() {
		return veces;
	}

	public void setVeces(Integer veces) {
		this.veces = veces;
	}
	
	
	public void ejecutarEnCasoDeFalla(Proceso unProceso) {
		if (veces == 1){//no realiza ningun manejo en el ultimo reintento
			unProceso.setAccionEnCasoDeError(new NoRealizarAccion());
		} else {
			ReintentarNVeces reintento = new ReintentarNVeces();
			reintento.setVeces(veces - 1);
			unProceso.setAccionEnCasoDeError(reintento);
		}
		unProceso.run();
	}

}
