package ar.edu.TPPOI;

import java.time.LocalDate;

public class ResultadoDelProceso {
	
	Integer cantidadDeElementosAfectados;
	LocalDate fechaYHoraEjecucion;
	boolean resultadoDeLaEjecucion;

	
	public ResultadoDelProceso(LocalDate fecha, Integer elementosAfectados, boolean resultadoDeLaEjecucion) {
		this.setCantidadDeElementosAfectados(elementosAfectados);
		this.setFechaYHoraEjecucion(fecha);
		this.setResultadoDeLaEjecucion(resultadoDeLaEjecucion);
	}
	public Integer getCantidadDeElementosAfectados() {
		return cantidadDeElementosAfectados;
	}
	public void setCantidadDeElementosAfectados(Integer cantidadDeElementosAfectados) {
		this.cantidadDeElementosAfectados = cantidadDeElementosAfectados;
	}
	public LocalDate getFechaYHoraEjecucion() {
		return fechaYHoraEjecucion;
	}
	public void setFechaYHoraEjecucion(LocalDate fechaYHoraEjecucion) {
		this.fechaYHoraEjecucion = fechaYHoraEjecucion;
	}
	public boolean isResultadoDeLaEjecucion() {
		return resultadoDeLaEjecucion;
	}
	public void setResultadoDeLaEjecucion(boolean resultadoDeLaEjecucion) {
		this.resultadoDeLaEjecucion = resultadoDeLaEjecucion;
	}
	
	public void agregarElementoAfectado(){
		cantidadDeElementosAfectados++;
	}
	
	
}
