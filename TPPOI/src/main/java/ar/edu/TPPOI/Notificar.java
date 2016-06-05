package ar.edu.TPPOI;

public class Notificar extends Accion {

	protected boolean mailEnviado = false;
	
	public void mandarMail(){
		
		this.mailEnviado = true;
	}
}
