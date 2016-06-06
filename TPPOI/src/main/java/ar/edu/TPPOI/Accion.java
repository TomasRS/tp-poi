package ar.edu.TPPOI;

public abstract class Accion{
	
	boolean habilitado;
	
	public void setActivado(boolean flag){
		this.habilitado = flag;
	}
	
	public boolean getActivado(){
		return habilitado;
	}	
}