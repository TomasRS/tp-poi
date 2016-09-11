package acciones;

import ar.edu.TPPOI.BusquedaHecha;
import ar.edu.TPPOI.Terminal;
import manejoErrores.EnvioDeMail;

public class Notificar implements Accion {

	long tiempoLimite;
	EnvioDeMail envioDeMail;

	public void ejecutarLuegoDeLaBusqueda(BusquedaHecha unaBusqueda, Terminal unaTerminal) {

		if (unaBusqueda.getTiempoDeBusqueda() > tiempoLimite) {
			envioDeMail.setTiempoLimite(tiempoLimite);
			envioDeMail.setTiempoBusqueda(unaBusqueda.getTiempoDeBusqueda());
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
