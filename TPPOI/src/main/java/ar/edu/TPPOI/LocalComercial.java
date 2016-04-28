package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.geodds.Point;

public class LocalComercial extends POI {
	private List<Horario> horarios = new ArrayList<Horario>();

	public static LocalComercial nuevoLocalConRubroLibreriaEscolar(String unNombre, Point unaCoordenada,
			List<Horario> unosHorarios, Direccion unaDireccion) {
		return new LocalComercial(unNombre, unaCoordenada, 500, unosHorarios, "LibreriaEscolar", unaDireccion);
	}

	public static LocalComercial nuevoLocalConRubroKioscoDiarios(String unNombre, Point unaCoordenada,
			List<Horario> unosHorarios, Direccion unaDireccion) {
		return new LocalComercial(unNombre, unaCoordenada, 200, unosHorarios, "Kiosco Diarios", unaDireccion);
	}

	public static LocalComercial nuevoLocalConRubroCafeteria(String unNombre, Point unaCoordenada,
			List<Horario> unosHorarios, Direccion unaDireccion) {
		return new LocalComercial(unNombre, unaCoordenada, 50, unosHorarios, "Cafeteria", unaDireccion);
	}
	
	public static LocalComercial nuevoLocal(String unNombre, Point unaCoordenada, Integer unRadioCercania,
			List<Horario> unosHorarios, String unRubro, Direccion unaDireccion) {
		return new LocalComercial(unNombre, unaCoordenada, unRadioCercania, unosHorarios, unRubro, unaDireccion);
	}

	private LocalComercial(String unNombre, Point unaCoordenada, Integer unRadioCercania, List<Horario> unosHorarios,
			String unRubro, Direccion unaDireccion) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.horarios.addAll(unosHorarios);
		this.rubro = unRubro;
		this.direccion = unaDireccion;
	}
	
	public boolean coincideConAtributo(String unTextoLibre){
		return this.rubro.equals(unTextoLibre);
	}
	
	public boolean estaDisponible(LocalDateTime unMomento) {
		return (new ExisteHorarioDisponibleEnHorarios(this.horarios, unMomento)).validar();
	}

}