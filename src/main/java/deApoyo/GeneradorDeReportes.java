package deApoyo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ar.edu.TPPOI.BusquedaHecha;
import ar.edu.TPPOI.Terminal;

import java.time.LocalDate;

public class GeneradorDeReportes {
	
	public  Integer generarReportePorFecha(LocalDate unaFecha, List<BusquedaHecha> busquedasHechas){
		Integer cantBusquedas = busquedasHechas.stream()
							  				   .filter(unaBusqueda -> unaBusqueda.getFecha().equals(unaFecha))
							  				   .collect(Collectors.toList())
							  				   .size();
		
		return cantBusquedas;
							  
	}
	
	public List<Integer> generarReportePorBusqueda(List<BusquedaHecha> busquedasHechas){
		List<Integer> resultadosParciales = busquedasHechas.stream()
														   .map(unaB -> unaB.getCantDeResultados())
														   .collect(Collectors.toList());
		
		return resultadosParciales;
	}
	
	public Map<Terminal, Integer> generarReportesTotales(List<Terminal> terminales){
		Map<Terminal, Integer> terminalesConResultTotales = new HashMap<>();
		
		terminales.forEach(unaT -> cantTotalPorTerminal(unaT, terminalesConResultTotales));
		
		return terminalesConResultTotales;
	}
	
	private  void cantTotalPorTerminal(Terminal unaTerminal, Map<Terminal, Integer> unDiccionario){
		Integer resultTotal = unaTerminal.generarReportePorBusqueda().stream().mapToInt(Integer::intValue).sum();
		
		unDiccionario.put(unaTerminal, resultTotal);
	}
}
