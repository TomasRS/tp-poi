package ar.edu.TPPOI;

import java.util.List;
import java.io.*;
public class ProcActualizarLocalesComerciales extends Proceso{
	ResultadoDelProceso resultadoDeEjecucion;

	public ResultadoDelProceso getResultadoDeEjecucion() {
		return resultadoDeEjecucion;
	}

	public void setResultadoDeEjecucion(ResultadoDelProceso resultadoDeEjecucion) {
		this.resultadoDeEjecucion = resultadoDeEjecucion;
	}

	@SuppressWarnings("null")
	public void ejecutar() {

		try
		{
            BufferedReader br =new BufferedReader(new FileReader (("C:\\nuevasPalabrasClavesDeLocalesComerciales.txt")));
            String linea;
			List<String> tagsParaActualizar = null;
			while ((linea=br.readLine())!=null){
			int i=0;
			String param="[ ;]+"; 
			String [] localComercialVectorizado=linea.split(param);
			String nombreLocalComercial="";
			while (i<linea.length()){
				if (i==0){
					nombreLocalComercial=localComercialVectorizado[0];
					i++;
				}else{
					tagsParaActualizar.add(i-1, localComercialVectorizado[i]);			
				}
				i++;
			}			
			// Cierre del archivo
			br.close();
			mapa.actualizarLocalesComerciales(nombreLocalComercial,tagsParaActualizar, this);
		}
			}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
