package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.io.BufferedReader;

public class ProcActualizarLocalesComerciales extends Proceso{
	


	public void run() {
		Integer elementosAfectados=0;

		try
		{	
			this.lecturaDeArchivoCorrecta(elementosAfectados);
			
		}
			catch (Exception e)
					{
						this.accionesEnCasoDeError.forEach(unaA->unaA.ejecutarEnCasoDeFalla(this));	
					}		
	}
	
	public void lecturaDeArchivoCorrecta(Integer elementosAfectados) throws IOException{
	BufferedReader br =new BufferedReader(new FileReader ("nuevasPalabrasClavesDeLocalesComerciales.txt"));
    String linea;
	String [] comercialVectorizado;
	while ((linea=br.readLine())!=null){ 
		List<String> tagsParaActualizar = new ArrayList<>();
		comercialVectorizado=linea.split(";");
		String nombreLocalComercial ="";
		nombreLocalComercial=comercialVectorizado[0];
		String tagsVectorizados= comercialVectorizado[1];
		String [] tagsSpliteados=tagsVectorizados.split(" ");
		
		for(Integer i=0;i<tagsSpliteados.length;i++){
			tagsParaActualizar.add(tagsSpliteados[i]);
				}
						this.actualizarLocalesComerciales(nombreLocalComercial,tagsParaActualizar, elementosAfectados);								
	}
	br.close();
	}
		
	public void actualizarLocalesComerciales(String nombreLocalComercial, List<String> tagsParaActualizar, Integer elementosAfectados) {
		if (this.getMapa().listaDePOIs.stream().anyMatch(unP->unP.getNombre().equals(nombreLocalComercial))){
			POI unPOI=this.getMapa().obtenerPOI(nombreLocalComercial);
			this.actualizarTags(unPOI, tagsParaActualizar, elementosAfectados);
			
		}		
	}

	public void actualizarTags(POI unPOI, List<String> tagsParaActualizar, Integer elementosAfectados) {
		if (unPOI.getTags().equals(tagsParaActualizar)){
				}else{
					unPOI.setTags(tagsParaActualizar);
					elementosAfectados++;
				}
		ResultadoDelProceso resultado=new ResultadoDelProceso(LocalDate.now(),elementosAfectados,true);
		this.setResultadoDeEjecucionDelProceso(resultado);
	}
}

