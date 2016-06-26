package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;

public class ProcActualizarLocalesComerciales extends Proceso{
	ResultadoDelProceso resultadoDeEjecucion;

	public ResultadoDelProceso getResultadoDeEjecucion() {
		return resultadoDeEjecucion;
	}

	public void setResultadoDeEjecucion(ResultadoDelProceso resultadoDeEjecucion) {
		this.resultadoDeEjecucion = resultadoDeEjecucion;
	}

	
	
	public void ejecutar() {

		try
		{
			BufferedReader br =new BufferedReader(new FileReader ("C:\\nuevasPalabrasClavesDeLocalesComerciales.txt"));
            String linea;
			List<String> tagsParaActualizar = new ArrayList<>();
			while ((linea=br.readLine())!=null){ 
				String [] comercialVectorizado=linea.split(";");
				String nombreLocalComercial ="";
				nombreLocalComercial=comercialVectorizado[0];
				String tagsVectorizados= comercialVectorizado[1];
				String [] tagsSpliteados=tagsVectorizados.split(" ");
				for(Integer i=0;i<tagsSpliteados.length;i++){
					tagsParaActualizar.add(tagsSpliteados[i]);		
				}
					mapa.actualizarLocalesComerciales(nombreLocalComercial,tagsParaActualizar, this);	
			}
			br.close();
		}
			catch (Exception e)
					{
						this.accionesEnCasoDeError.forEach(unaA->unaA.ejecutarEnCasoDeFalla(this));	
					}
				
	}
}
