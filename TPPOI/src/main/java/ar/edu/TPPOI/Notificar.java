package ar.edu.TPPOI;

import javax.mail.MessagingException;

public class Notificar implements Accion{

	boolean mailEnviado;
	long tiempoLimite;
	EnvioDeMail envioDeMail;
	
	public void ejecutar(BusquedaHecha unaBusqueda, Terminal unaTerminal){
		
		this.mailEnviado = false; //si se cambia el tiempoLimite en Runtime, mailEnviado pod�a quedar en true de la busqueda anterior
		
		if(unaBusqueda.tiempoDeBusqueda > tiempoLimite){
			this.enviarMail();
			try {
				envioDeMail.generateAndSendEmail(tiempoLimite, unaBusqueda.tiempoDeBusqueda);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public Notificar(EnvioDeMail unEnvioDeMail){
		this.envioDeMail = unEnvioDeMail;
	}
	

 
	
}
