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
		if (veces == 0){
			unProceso.setAccionEnCasoDeError(new NoRealizarAccion());
		} else {
			ReintentarNVeces reintento = new ReintentarNVeces();
			reintento.setVeces(veces - 1);
			unProceso.setAccionEnCasoDeError(reintento);
		}
		System.out.printf("Falta %d intentos\n", veces);
		unProceso.run();
	}

}
