package ar.edu.TPPOI;

public class Notificar implements Accion {

	long tiempoLimite;
	EnvioDeMail envioDeMail;

	public void ejecutarLuegoDeLaBusqueda(BusquedaHecha unaBusqueda, Terminal unaTerminal) {

		if (unaBusqueda.tiempoDeBusqueda > tiempoLimite) {
			envioDeMail.setTiempoLimite(tiempoLimite);
			envioDeMail.setTiempoBusqueda(unaBusqueda.tiempoDeBusqueda);
			envioDeMail.enviarMail();
		}
	}

	public void setTiempoLimite(long unTiempoLimite) {
		this.tiempoLimite = unTiempoLimite;
	}

	public Notificar(EnvioDeMail unEnvioDeMail) {
		this.envioDeMail = unEnvioDeMail;
	}

}
