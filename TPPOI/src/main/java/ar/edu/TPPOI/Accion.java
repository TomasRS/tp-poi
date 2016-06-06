package ar.edu.TPPOI;

import java.time.LocalDateTime;

public abstract class Accion{
	
	boolean habilitado;
	
	public void setActivado(boolean flag){
		this.habilitado = flag;
	}
	
	public boolean getActivado(){
		return habilitado;
	}	
}