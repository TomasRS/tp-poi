package ar.edu.TPPOI;

public class Notificar implements Accion{

	boolean mailEnviado;
	long tiempoLimite;
	
	public void ejecutar(BusquedaHecha unaBusqueda, Terminal unaTerminal){
		
		this.mailEnviado = false; //si se cambia el tiempoLimite en Runtime, mailEnviado pod�a quedar en true de la busqueda anterior
		
		if(unaBusqueda.tiempoDeBusqueda > tiempoLimite){
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
