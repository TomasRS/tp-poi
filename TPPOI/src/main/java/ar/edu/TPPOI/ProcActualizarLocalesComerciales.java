package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ProcActualizarLocalesComerciales extends Proceso{
	


	public void run() {
		this.instanciarResultadoDeEjecucion();

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
						this.actualizarLocalesComerciales(nombreLocalComercial,tagsParaActualizar);								
	}
	br.close();
	}
		
	public void actualizarLocalesComerciales(String nombreLocalComercial, List<String> tagsParaActualizar) {
		if (this.getMapa().listaDePOIs.stream().anyMatch(unP->unP.getNombre().equals(nombreLocalComercial))){
			POI unPOI=this.getMapa().obtenerPOI(nombreLocalComercial);
			this.actualizarTags(unPOI, tagsParaActualizar);
			
		}		
	}

	public void actualizarTags(POI unPOI, List<String> tagsParaActualizar) {
		if (unPOI.getTags().equals(tagsParaActualizar)){
				}else{
					unPOI.setTags(tagsParaActualizar);
					this.sumarElementosAfectados(1);
				}
		
		}
}

