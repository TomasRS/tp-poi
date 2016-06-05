package ar.edu.TPPOI;

import java.time.LocalDateTime;

public abstract class Accion implements InterfaceTerminal{
	
	boolean habilitado;
	InterfaceTerminal terminalConocida;
	
	public void setActivado(boolean flag){
		this.habilitado = flag;
	}
	
	public boolean getActivado(){
		return habilitado;
	}
	
	//Metodos default para cuando Almacenar, Notificar u ObtenerReporte no deben hacer nada
	//Los que hacen acciones se redefinen en las clases correspondientes
	
	public void registrar(){
		
	}
	
	public void mandarMail(){
		
	}
	
	public int cantidadDeBusquedasPorFecha(LocalDateTime fecha){
	
		return 0;
	}
	
	public void buscar(String unTextoLibre){
		
	}
	
	public boolean superaTiempoLimite(){
		
		return false;
	}
}
