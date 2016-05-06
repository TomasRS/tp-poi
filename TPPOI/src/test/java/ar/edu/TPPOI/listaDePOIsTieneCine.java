package ar.edu.TPPOI;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
public class listaDePOIsTieneCine {

	private LocalComercial cineAbasto;
	private MapaPOI barrioAbasto;
	private Point coordenadaCineAbasto;
	private Direccion direccionCineAbasto;
	
	
	@Before
	public void init(){
	coordenadaCineAbasto = new Point (-34.6033055,-58.411887);
	direccionCineAbasto = new Direccion ("Av Corrientes", 3247);
	LocalTime horaInicioCine= LocalTime.of(10, 00);
	LocalTime horaFinCine = LocalTime.of(23, 00);
	List<Horario> horariosCine = new ArrayList<>();
	horariosCine.add(new Horario(DayOfWeek.MONDAY, horaInicioCine, horaFinCine));
	horariosCine.add(new Horario(DayOfWeek.TUESDAY, horaInicioCine, horaFinCine));
	horariosCine.add(new Horario(DayOfWeek.WEDNESDAY, horaInicioCine, horaFinCine));
	horariosCine.add(new Horario(DayOfWeek.THURSDAY, horaInicioCine, horaFinCine));
	horariosCine.add(new Horario(DayOfWeek.FRIDAY, horaInicioCine, horaFinCine));
	horariosCine.add(new Horario(DayOfWeek.SATURDAY, horaInicioCine, horaFinCine));
	horariosCine.add(new Horario(DayOfWeek.SUNDAY, horaInicioCine, horaFinCine));
	cineAbasto =new LocalComercial("cineAbasto", coordenadaCineAbasto,800, horariosCine, "cine",direccionCineAbasto);
	barrioAbasto = new MapaPOI();
	barrioAbasto.agregarPOI(cineAbasto);
	}
	@Test
	public void testBarrioAbastoAgregoCineAbasto() {
		Assert.assertTrue(barrioAbasto.getListaDePOIs().contains(cineAbasto));
	}

}
