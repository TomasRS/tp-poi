package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.io.BufferedReader;

public class ProcActualizarLocalesComerciales extends Proceso{
	ResultadoDelProceso resultadoDeEjecucion;

	public ResultadoDelProceso getResultadoDeEjecucion() {
		return resultadoDeEjecucion;
	}

	public void setResultadoDeEjecucion(ResultadoDelProceso resultadoDeEjecucion) {
		this.resultadoDeEjecucion = resultadoDeEjecucion;
	}


	public void run() {
		try
		{	
			this.lecturaDeArchivoCorrecta();
			
		}
			catch (Exception e)
					{
						this.accionesEnCasoDeError.forEach(unaA->unaA.ejecutarEnCasoDeFalla(this));	
					}

		
	}
	
	public void lecturaDeArchivoCorrecta() throws IOException{
	BufferedReader br =new BufferedReader(new FileReader ("C:\\nuevasPalabrasClavesDeLocalesComerciales.txt"));
    String linea;
	List<String> tagsParaActualizar = new ArrayList<>();
	while ((linea=br.readLine())!=null){ 
		String [] comercialVectorizado=linea.split(";");
		String nombreLocalComercial ="";
		nombreLocalComercial=comercialVectorizado[0];
		System.out.println(nombreLocalComercial);
		String tagsVectorizados= comercialVectorizado[1];
		String [] tagsSpliteados=tagsVectorizados.split(" ");
		for(Integer i=0;i<tagsSpliteados.length;i++){
			tagsParaActualizar.add(tagsSpliteados[i]);		
		}
			this.actualizarLocalesComerciales(nombreLocalComercial,tagsParaActualizar);	
	}
	br.close();
	}
	
	public void actualizarLocalesComerciales(String nombreLocalComercial, List<String> tagsParaActualizar) {
		POI unPOI=this.getMapa().obtenerPOI(nombreLocalComercial);
		this.actualizarTags(unPOI, tagsParaActualizar);
			}

	public void actualizarTags(POI unPOI, List<String> tagsParaActualizar) {
		Integer elementosAfectados=0;
		if (unPOI.getTags().equals(tagsParaActualizar)){
				}else{
					elementosAfectados++;			
					unPOI.setTags(tagsParaActualizar);
					System.out.println(unPOI.getTags());
				}
		ResultadoDelProceso resultado=new ResultadoDelProceso(LocalDate.now(),elementosAfectados,true);
		this.setResultadoDeEjecucion(resultado);
	}
}
