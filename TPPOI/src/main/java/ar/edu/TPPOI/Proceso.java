package ar.edu.TPPOI;

import java.time.LocalDateTime;

public abstract class Proceso {

	LocalDateTime fechaYHora;
	ManejoDeResultado accionEnCasoDeError; //el proceso es el que conoce la accion a hacer en caso de que el mismo falle.
}
