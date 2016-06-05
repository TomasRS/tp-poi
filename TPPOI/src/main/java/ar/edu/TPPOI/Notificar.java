package ar.edu.TPPOI;

public class Notificar extends Accion {

	boolean mailEnviado;
	
	public void mandarMail(){
		
		if (this.getActivado()){
			this.mailEnviado = true;
		}
	}
	
	public boolean getMailEnviado(){
		return mailEnviado;
	}
}
