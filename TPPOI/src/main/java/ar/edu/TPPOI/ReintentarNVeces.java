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
		unProceso.setAccionEnCasoDeError(new NoRealizarAccion());
		for (Integer i=0; i<this.veces; i++){
			System.out.printf("Reintento %d \n", i+1);
			unProceso.run();
		}
	}

}
