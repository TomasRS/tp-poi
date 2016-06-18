package ar.edu.TPPOI;

public class Notificar implements Accion{

	boolean mailEnviado;
	long tiempoLimite;
	
	public void ejecutar(String unTextoLibre, Integer cantPOIs, long tiempoDeBusqueda, Terminal unaTerminal){
		
		this.mailEnviado = false; //si se cambia el tiempoLimite en Runtime, mailEnviado podía quedar en true de la busqueda anterior
		
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
	
	public boolean getMailEnviado(){
		return mailEnviado;
	}
}
