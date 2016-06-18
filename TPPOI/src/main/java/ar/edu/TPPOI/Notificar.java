package ar.edu.TPPOI;

public class Notificar implements Accion{

	boolean mailEnviado;
	long tiempoLimite;
	
	public void ejecutar(String unTextoLibre, Integer cantPOIs, long tiempoDeBusqueda, Terminal unaTerminal){
		
		if(tiempoDeBusqueda > tiempoLimite){
			this.enviarMail();
		}
	}
	
	//-------------------------------------------------------
	
	public void setTiempoLimite(long unTiempoLimite){
		this.tiempoLimite = unTiempoLimite;
	}
	
	public void enviarMail(){
		this.mailEnviado = true;
	}
}
