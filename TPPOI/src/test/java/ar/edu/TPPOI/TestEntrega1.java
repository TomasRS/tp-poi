package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

public class TestEntrega1 {

	Point coordenadaMia;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	Point coordenadaParada114;
	SucursalBanco bancoCiudadCabildo;
	Point coordenadaBancoCiudad;
	MapaPOI mapaInteractivo;
	CGP cgp1 = new CGP();
	Servicio cargaSUBE;
	Servicio prestamo;
	LocalComercial starbucks;

	@Before
	public void init() {

		// Mi coordenada - Abasto Shopping
		coordenadaMia = new Point(-58.41059446334839, -34.60421247366349);
		// Parada 114 de Cabildo y Monroe
		parada114DeCabildoYMonroe = new ParadaDeColectivo();
		coordenadaParada114 = new Point(-58.459845185279846, -34.558164509672146);
		parada114DeCabildoYMonroe.setCoordenada(coordenadaParada114);
		parada114DeCabildoYMonroe.setCalle1("Monroe");
		parada114DeCabildoYMonroe.setCalle2("Cabildo");

		// Banco Ciudad de Cabildo y Congreso
		prestamo = new Servicio("prestamo");
		bancoCiudadCabildo = new SucursalBanco();
		coordenadaBancoCiudad = new Point(-58.46362049999999, -34.5545459);
		bancoCiudadCabildo.setCoordenada(coordenadaBancoCiudad);
		bancoCiudadCabildo.setCalle1("Cabildo");
		bancoCiudadCabildo.setCalle2("Congreso");
		Horario horarioBanco1 = new Horario("MONDAY", "10:00", "15:00");
		Horario horarioBanco2 = new Horario("TUESDAY", "10:00", "15:00");
		Horario horarioBanco3 = new Horario("WEDNESDAY", "10:00", "15:00");
		Horario horarioBanco4 = new Horario("THURSDAY", "10:00", "15:00");
		Horario horarioBanco5 = new Horario("FRIDAY", "10:00", "15:00");

		bancoCiudadCabildo.addHorarioBancario(horarioBanco1);
		bancoCiudadCabildo.addHorarioBancario(horarioBanco2);
		bancoCiudadCabildo.addHorarioBancario(horarioBanco3);
		bancoCiudadCabildo.addHorarioBancario(horarioBanco4);
		bancoCiudadCabildo.addHorarioBancario(horarioBanco5);

		// Mapa interactivo
		mapaInteractivo = new MapaPOI();
		mapaInteractivo.listaDePOIs.add(parada114DeCabildoYMonroe);
		mapaInteractivo.listaDePOIs.add(bancoCiudadCabildo);

		// CGP1
		cargaSUBE = new Servicio("cargar SUBE");
		Horario horario1 = new Horario("FRIDAY", "08:00", "13:00");
		Horario horario2 = new Horario("FRIDAY", "15:00", "20:00");
		List<Point> puntos = new ArrayList<>();
		puntos.add(new Point(-58.411898, -34.597984));
		puntos.add(new Point(-58.426446, -34.597878));
		puntos.add(new Point(-58.433334, -34.602696));
		puntos.add(new Point(-58.430051, -34.615469));
		puntos.add(new Point(-58.427899, -34.622162));
		puntos.add(new Point(-58.412372, -34.620890));
		Polygon poligonoCGP = new Polygon(puntos);

		cargaSUBE.addHorario(horario1);
		cargaSUBE.addHorario(horario2);
		cgp1.addServicio(cargaSUBE);
		cgp1.setRubro("Propositos generales");
		cgp1.setPoligono(poligonoCGP);

		// LOCAL
		starbucks = new LocalComercial();
		Horario horarioStarbucks1 = new Horario("MONDAY", "10:00", "20:00");
		Horario horarioStarbucks2 = new Horario("TUESDAY", "10:00", "20:00");
		Horario horarioStarbucks3 = new Horario("WEDNESDAY", "10:00", "20:00");
		Horario horarioStarbucks4 = new Horario("THURSDAY", "10:00", "20:00");
		Horario horarioStarbucks5 = new Horario("FRIDAY", "10:00", "20:00");
		Horario horarioStarbucks6 = new Horario("SATURDAY", "10:00", "20:00");

		starbucks.addHorarioDeAtencion(horarioStarbucks1);
		starbucks.addHorarioDeAtencion(horarioStarbucks2);
		starbucks.addHorarioDeAtencion(horarioStarbucks3);
		starbucks.addHorarioDeAtencion(horarioStarbucks4);
		starbucks.addHorarioDeAtencion(horarioStarbucks5);
		starbucks.addHorarioDeAtencion(horarioStarbucks6);

	}

	// Tests para Calculo de Cercanias
	@Test
	public void testParadaDeColectivoNoEstaCercaDeMiCoordenada() {
		Assert.assertEquals(parada114DeCabildoYMonroe.estasCercaDe(coordenadaMia), false);
	}

	@Test
	public void testUnPOIEstaAMenosDeXMetrosDeOtroPOI() {
		Assert.assertEquals(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe), true);
	}

	/*@Test
	public void testPuntoDentroDeLaCGP() {
		Assert.assertTrue(cgp1.estasCercaDe(coordenadaMia));
	}*/

	@Test
	public void testPuntoAfueraDeLaCGP() {
		Assert.assertFalse(cgp1.estasCercaDe(coordenadaParada114));
	}

	// Tests para Busqueda de Texto Libre
	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreJusto() {
		Assert.assertEquals(mapaInteractivo.buscar("Cabildo").size(), 2);
	}

	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreMasLargo() {
		Assert.assertEquals(mapaInteractivo.buscar("Avenida Cabildo").size(), 2);
	}

	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreMasChico() {
		Assert.assertEquals(mapaInteractivo.buscar("Cabil").size(), 2);
	}

	@Test
	public void testBuscarPOIsEnBaseAUnTextoLibreErroneo() {
		Assert.assertEquals(mapaInteractivo.buscar("Docabil").size(), 0);
	}

	// Tests de disponibilidad
	@Test
	public void testCgpDisponible() {
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), cargaSUBE));
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 15, 10, 30)), cargaSUBE));
	}

	@Test
	public void testCgpNoDisponible() {
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 14, 10, 30)), cargaSUBE));
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), cargaSUBE));
	}

	@Test
	public void testParadaDeColectivoDisponible() {
		Assert.assertTrue(parada114DeCabildoYMonroe.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), null));
	}

	@Test
	public void testBancoDisponible() {
		Assert.assertTrue(bancoCiudadCabildo.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), prestamo));
	}

	@Test
	public void testLocalDisponible() {
		Assert.assertTrue(starbucks.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), null));
	}

}
