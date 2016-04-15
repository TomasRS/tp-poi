package ar.edu.TPPOI;

import java.util.Date;

public class Horario {
private Date horaInicio;
public Date getHoraInicio() {
	return horaInicio;
}
public void setHoraInicio(Date horaInicio) {
	this.horaInicio = horaInicio;
}
public Date getHoraFin() {
	return horaFin;
}
public void setHoraFin(Date horaFin) {
	this.horaFin = horaFin;
}
private Date horaFin;

public boolean estaEnLaFranja(Date unaHora){
	if (unaHora.after(horaInicio) && unaHora.before(horaFin)){
		return true;
	}else{
		return false;
	}
}

}
