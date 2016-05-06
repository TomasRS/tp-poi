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
import org.uqbar.geodds.Polygon;

public class TestEntrega1 {
	
	LocalComercial cineAbasto;
	MapaPOI barrioAbasto;
	Point coordenadaCineAbasto;
	Direccion direccionCineAbasto;
	

	Point coordenadaMia, coordenadaCercaParada114, coordenadaCercaBancoCiudad, coordenadaStarbucks,
			coordenadaCercaStarbucks, coordenadaSportClub;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	Point coordenadaParada114;
	SucursalBanco bancoCiudadCabildo;
	Point coordenadaBancoCiudad;
	MapaPOI mapaInteractivo;
	CGP cgp1;
	Servicio cargaSUBE;
	Servicio prestamo;
	Servicio cortePelo;
	LocalComercial starbucks;
	LocalComercial sportclub;

	@Before
	public void init() {

		// Mi coordenada - Abasto Shopping
		coordenadaMia = new Point(-58.42059446334839, -34.60421247366349);

		// Parada 114 de Cabildo y Monroe
		coordenadaParada114 = new Point(-58.459845185279846, -34.558164509672146);
		coordenadaCercaParada114 = new Point(-58.459845186279846, -34.558169509672146);
		Direccion direccionParada114 = new Direccion();
		direccionParada114.setCalles("Monroe", "Cabildo");

		parada114DeCabildoYMonroe = new ParadaDeColectivo("114", coordenadaParada114, direccionParada114);

		// Banco Ciudad de Cabildo y Congreso
		prestamo = Servicio.nuevoServicioBanco("prestamo");
		coordenadaBancoCiudad = new Point(-58.46362049999999, -34.5545459);
		coordenadaCercaBancoCiudad = new Point(-58.46362069999999, -34.5545479);
		Direccion direccionBancoCiudad = new Direccion();
		direccionBancoCiudad.setCalles("Cabildo", "Congreso");

		bancoCiudadCabildo = new SucursalBanco("Banco Ciudad", coordenadaBancoCiudad, direccionBancoCiudad);
		bancoCiudadCabildo.agregarServicio(prestamo);

		// CGP1
		List<Horario> horarios = new ArrayList<>();
		horarios.add(new Horario(DayOfWeek.FRIDAY, LocalTime.of(8, 00), LocalTime.of(13, 00)));
		horarios.add(new Horario(DayOfWeek.FRIDAY, LocalTime.of(15, 00), LocalTime.of(20, 00)));
		cargaSUBE = new Servicio("cargar SUBE", horarios);
		Direccion direccionCGP = new Direccion("Corrientes", 500);
		List<Point> puntos = new ArrayList<>();
		puntos.add(new Point(-58.411898, -34.597984));
		puntos.add(new Point(-58.426446, -34.597878));
		puntos.add(new Point(-58.433334, -34.602696));
		puntos.add(new Point(-58.430051, -34.615469));
		puntos.add(new Point(-58.427899, -34.622162));
		puntos.add(new Point(-58.412372, -34.620890));
		Polygon poligonoCGP = new Polygon(puntos);

		cgp1 = new CGP("Comuna 5", "Propositos generales", poligonoCGP, direccionCGP);
		cgp1.agregarServicio(cargaSUBE);
		// --------------------------------------------------------------

		// ----------------------------LOCAL------------------------------
		coordenadaStarbucks = new Point(-58.413718, -34.593303);
		coordenadaCercaStarbucks = new Point(-58.414099, -34.593686);

		LocalTime horaInicio = LocalTime.of(10, 00);
		LocalTime horaFin = LocalTime.of(20, 00);

		List<Horario> horarios2 = new ArrayList<>();
		horarios2.add(new Horario(DayOfWeek.MONDAY, horaInicio, horaFin));
		horarios2.add(new Horario(DayOfWeek.TUESDAY, horaInicio, horaFin));
		horarios2.add(new Horario(DayOfWeek.WEDNESDAY, horaInicio, horaFin));
		horarios2.add(new Horario(DayOfWeek.THURSDAY, horaInicio, horaFin));
		horarios2.add(new Horario(DayOfWeek.FRIDAY, horaInicio, horaFin));
		horarios2.add(new Horario(DayOfWeek.SATURDAY, horaInicio, horaFin));

		Direccion direccionStarbucks = new Direccion("Coronel Diaz", 1400);

		starbucks = LocalComercial.nuevoLocalConRubroCafeteria("Starbucks", coordenadaStarbucks, horarios2,
				direccionStarbucks);
		// --------------------------------------------------------------
		
		// ----------------------------GIMNASIO SPORTCLUB------------------
		coordenadaSportClub = new Point(-58.4627205, -34.5436991);

		LocalTime horaInicioGym = LocalTime.of(7, 00);
		LocalTime horaFinGym = LocalTime.of(22, 00);

		List<Horario> horariosGym = new ArrayList<>();
		horariosGym.add(new Horario(DayOfWeek.MONDAY, horaInicioGym, horaFinGym));
		horariosGym.add(new Horario(DayOfWeek.TUESDAY, horaInicioGym, horaFinGym));
		horariosGym.add(new Horario(DayOfWeek.WEDNESDAY, horaInicioGym, horaFinGym));
		horariosGym.add(new Horario(DayOfWeek.THURSDAY, horaInicioGym, horaFinGym));
		horariosGym.add(new Horario(DayOfWeek.FRIDAY, horaInicioGym, horaFinGym));
		horariosGym.add(new Horario(DayOfWeek.SATURDAY, horaInicioGym, horaFinGym));

		Direccion direccionSportClub = new Direccion("Avenida Libertador", 7395);

		sportclub = LocalComercial.nuevoLocal("SportClub", coordenadaSportClub, 15,
				horariosGym, "Gimnasio", direccionSportClub);
		
		sportclub.setTag("fitness");
		sportclub.setTag("musculacion");
		sportclub.setTag("spinning");
		
		//Cine Abasto
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
				

		// Mapa interactivo
		mapaInteractivo = new MapaPOI();
		mapaInteractivo.listaDePOIs.add(parada114DeCabildoYMonroe);
		mapaInteractivo.listaDePOIs.add(bancoCiudadCabildo);
		mapaInteractivo.listaDePOIs.add(cgp1);
		mapaInteractivo.listaDePOIs.add(starbucks);
		mapaInteractivo.listaDePOIs.add(sportclub);
		mapaInteractivo.listaDePOIs.add(cineAbasto);
		// --------------------------------------------------------------
	}

	// Tests para Calculo de Cercanias
	@Test
	public void testStarbucksNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(starbucks.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testStarbucksEstaCercaDeCoordenadaCercaStarbucks() {
		Assert.assertTrue(starbucks.estasCercaDe(coordenadaCercaStarbucks));
	}

	@Test
	public void testParadaDeColectivoNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(parada114DeCabildoYMonroe.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testBancoCiudadCabildoNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(bancoCiudadCabildo.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testBancoCiudadCabildoEstaCercaDeCoordenadaCercaBancoCiudad() {
		Assert.assertTrue(bancoCiudadCabildo.estasCercaDe(coordenadaCercaBancoCiudad));
	}

	@Test
	public void testUnPOIEstaAMenosDe1000MetrosDeOtroPOI() {
		Assert.assertTrue(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe));
	}

	@Test
	public void testUnPOINoEstaAMenosDe300MetrosDeOtroPOI() {
		Assert.assertFalse(bancoCiudadCabildo.estasAMenosDeXMetrosDe(300, parada114DeCabildoYMonroe));
	}

	@Test
	public void testPuntoDentroDeLaCGP() {
		Assert.assertTrue(cgp1.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testPuntoAfueraDeLaCGP() {
		Assert.assertFalse(cgp1.estasCercaDe(coordenadaParada114));
	}

	// Tests para Busqueda de Texto Libre
	@Test
	public void testEncuentraPorNombreDeParadaDeColectivo(){
		Assert.assertEquals(mapaInteractivo.buscar("114").size(), 1);
	}
	
	@Test
	public void testEncuentraPorRubroDeLocales(){
		Assert.assertEquals(mapaInteractivo.buscar("Cafeteria").size(), 1);
	}
	
	@Test
	public void testEncuentraPorPalabraClave(){
		Assert.assertEquals(mapaInteractivo.buscar("fitness").size(), 1);
	}

	@Test
	public void testEncuentraNombreServicioSUBE() {
		Assert.assertEquals(mapaInteractivo.buscar("SUBE").size(), 1);
	}


	// Tests de disponibilidad
	@Test
	public void testElCGPDisponibleParaCargarSube() {
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), cargaSUBE));
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 15, 10, 30)), cargaSUBE));
	}

	@Test
	public void testCGPNoDispponibleParaCargarSube() {
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 14, 10, 30)), cargaSUBE));
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), cargaSUBE));
	}

	@Test(expected = NoExisteServicioAsociadoException.class)
	public void testCgpSinServicioAsociado() {
		cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), prestamo);
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
		Assert.assertTrue(starbucks.estaDisponible(LocalDateTime.of(2016, 1, 14, 10, 10, 30)));
	}
	
	//Tests para agregar y quitar POIs
	@Test
		public void testBarrioAbastoAgregoCineAbasto() {
			Assert.assertTrue(mapaInteractivo.getListaDePOIs().contains(cineAbasto));
		}
	@Test
	public void testBarrioAbastoQuitoCineAbasto() {
		mapaInteractivo.borrarPOI(cineAbasto);
		Assert.assertFalse(mapaInteractivo.getListaDePOIs().contains(cineAbasto));
	}
	
	//Test para cambiar nombres
		@Test
	public void testStarbuckCambiaAStarbacks(){
			starbucks.setNombre("starbacks");
		Assert.assertTrue(starbucks.getNombre().equals("starbacks"));
	}
		@Test
		public void testBancoCiudadPasaASerBancoDeLaCiudad(){
			bancoCiudadCabildo.setNombre("bancoDeLaCiudad");
			Assert.assertTrue(bancoCiudadCabildo.getNombre().equals("bancoDeLaCiudad"));
		}

}
