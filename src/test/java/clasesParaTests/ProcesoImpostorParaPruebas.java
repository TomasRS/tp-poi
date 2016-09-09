package clasesParaTests;

import java.io.IOException;

import ar.edu.TPPOI.Proceso;

public class ProcesoImpostorParaPruebas extends Proceso{
	
	private Integer contadorDeEjecucion;
	private Integer intentosAFallar;

	public ProcesoImpostorParaPruebas() {
		contadorDeEjecucion = 0;
	}

	@Override
	public void ejecutar() throws IOException {
		contadorDeEjecucion++;//incremento contador antes de fallar
		if (contadorDeEjecucion<=intentosAFallar){
			System.out.println(0/0);//fuerzo un error
		}
	}
	
	public void fallarHasta(Integer numeroDeReintento){
		this.intentosAFallar = numeroDeReintento; 
	}
	
	public Integer cantidadEjecucionesRealizadas(){
		return contadorDeEjecucion;
	}

}
