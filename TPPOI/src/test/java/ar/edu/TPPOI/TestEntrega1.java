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

	Point coordenadaMia, coordenadaCercaParada114,coordenadaCercaBancoCiudad, coordenadaStarbucks, coordenadaCercaStarbucks;
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

	@Before
	public void init() {

		// Mi coordenada - Abasto Shopping
		coordenadaMia = new Point(-58.42059446334839, -34.60421247366349);
		// Parada 114 de Cabildo y Monroe
		coordenadaParada114 = new Point(-58.459845185279846, -34.558164509672146);
		coordenadaCercaParada114 = new Point(-58.459845186279846, -34.558169509672146);
		
		parada114DeCabildoYMonroe = new ParadaDeColectivo("114", coordenadaParada114);
		
		//Borrar cuando tomy haga el cambio de DatosPOI, etc
		Direccion direccionParada114 = new Direccion();
		direccionParada114.setCalles("Monroe", "Cabildo");
		parada114DeCabildoYMonroe.setDireccion(direccionParada114);
		
		//--------------------------------------------------------------
		
		
		// Banco Ciudad de Cabildo y Congreso
		//Seteo los dias de atencion
		
		prestamo = Servicio.nuevoServicioBanco("prestamo");
		coordenadaBancoCiudad = new Point(-58.46362049999999, -34.5545459);
		coordenadaCercaBancoCiudad = new Point(-58.46362069999999, -34.5545479);
	
		bancoCiudadCabildo = new SucursalBanco("Banco Ciudad", coordenadaBancoCiudad, 50);
		bancoCiudadCabildo.agregarServicio(prestamo);
	
		//Borrar cuando tomy haga el cambio de DatosPOI, etc
		Direccion direccionBancoCiudad = new Direccion();
		direccionBancoCiudad.setCalles("Cabildo", "Congreso");
		bancoCiudadCabildo.setDireccion(direccionBancoCiudad);
		
		//--------------------------------------------------------------

		
		// CGP1
		List<Horario> horarios = new ArrayList<>();
		horarios.add(new Horario("FRIDAY", "08:00", "13:00"));
		horarios.add(new Horario("FRIDAY", "15:00", "20:00"));
		cargaSUBE = new Servicio("cargar SUBE", horarios);
		List<Point> puntos = new ArrayList<>();
		puntos.add(new Point(-58.411898, -34.597984));
		puntos.add(new Point(-58.426446, -34.597878));
		puntos.add(new Point(-58.433334, -34.602696));
		puntos.add(new Point(-58.430051, -34.615469));
		puntos.add(new Point(-58.427899, -34.622162));
		puntos.add(new Point(-58.412372, -34.620890));
		Polygon poligonoCGP = new Polygon(puntos);

		cgp1 = new CGP("Comuna 5", "Propositos generales", poligonoCGP);
		cgp1.agregarServicio(cargaSUBE);
		//--------------------------------------------------------------
		
		// ----------------------------LOCAL------------------------------
		coordenadaStarbucks = new Point(-58.413718, -34.593303);
		coordenadaCercaStarbucks = new Point(-58.414099, -34.593686);
		List<Horario> horarios2 = new ArrayList<>();
		horarios2.add(new Horario("MONDAY", "10:00", "20:00"));
		horarios2.add(new Horario("TUESDAY", "10:00", "20:00"));
		horarios2.add(new Horario("WEDNESDAY", "10:00", "20:00"));
		horarios2.add(new Horario("THURSDAY", "10:00", "20:00"));
		horarios2.add(new Horario("FRIDAY", "10:00", "20:00"));
		horarios2.add(new Horario("SATURDAY", "10:00", "20:00"));
		
		starbucks = LocalComercial.nuevoLocal("Starbucks", coordenadaStarbucks, 50, horarios2, "Cafeteria");
		//--------------------------------------------------------------
		
		// Mapa interactivo
		mapaInteractivo = new MapaPOI();
		mapaInteractivo.listaDePOIs.add(parada114DeCabildoYMonroe);
		mapaInteractivo.listaDePOIs.add(bancoCiudadCabildo);
		mapaInteractivo.listaDePOIs.add(cgp1);
		mapaInteractivo.listaDePOIs.add(starbucks);
		//--------------------------------------------------------------
	}

	// Tests para Calculo de Cercanias
	@Test
	public void testStarbucksNoEstaCercaDeMiCoordenada() {
		Assert.assertEquals(starbucks.estasCercaDe(coordenadaMia), false);
	}

	@Test
	public void testStarbucksEstaCercaDeCoordenadaCercaStarbucks() {
		Assert.assertEquals(starbucks.estasCercaDe(coordenadaCercaStarbucks), true);
	}
	
	@Test
	public void testParadaDeColectivoNoEstaCercaDeMiCoordenada() {
		Assert.assertEquals(parada114DeCabildoYMonroe.estasCercaDe(coordenadaMia), false);
	}
	
	@Test
	public void testBancoCiudadCabildoNoEstaCercaDeMiCoordenada() {
		Assert.assertEquals(bancoCiudadCabildo.estasCercaDe(coordenadaMia), false);
	}

	@Test
	public void testBancoCiudadCabildoEstaCercaDeCoordenadaCercaBancoCiudad() {
		Assert.assertEquals(bancoCiudadCabildo.estasCercaDe(coordenadaCercaBancoCiudad), true);
	}

	@Test
	public void testUnPOIEstaAMenosDe1000MetrosDeOtroPOI() {
		Assert.assertEquals(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe),true);
	}

	@Test
	public void testUnPOINoEstaAMenosDe300MetrosDeOtroPOI() {
		Assert.assertEquals(bancoCiudadCabildo.estasAMenosDeXMetrosDe(300, parada114DeCabildoYMonroe),false);
	}

	@Test
	public void testPuntoDentroDeLaCGP() {
		Assert.assertEquals(cgp1.estasCercaDe(coordenadaMia),true);
	}

	@Test
	public void testPuntoAfueraDeLaCGP() {
		Assert.assertEquals(cgp1.estasCercaDe(coordenadaParada114),false);
	}

	// Tests para Busqueda de Texto Libre
	@Test
	public void testEncuentraDosPOIsEnBaseAUnTextoLibreJusto() {
		Assert.assertEquals(mapaInteractivo.buscar("Cabildo").size(), 2);
	}

	@Test
	public void testEncuentraDosPOIsEnBaseAUnTextoLibreMasLargo() {
		Assert.assertEquals(mapaInteractivo.buscar("Avenida Cabildo").size(), 2);
	}

	@Test
	public void testEncuentraDosPOIsEnBaseAUnTextoLibreMasChico() {
		Assert.assertEquals(mapaInteractivo.buscar("Cabil").size(), 2);
	}

	@Test
	public void testNoEncuentraPOIsEnBaseAUnTextoLibreErroneo() {
		Assert.assertEquals(mapaInteractivo.buscar("Docabil").size(), 0);
	}
	
	@Test
	public void testEncuentraNombreServicioSUBE() {
		Assert.assertEquals(mapaInteractivo.buscar("SUBE").size(),1);
	}

	// Tests de disponibilidad
	@Test
	public void testElCGPDisponibleParaCargarSube() {
		Assert.assertEquals(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), cargaSUBE), true);
		Assert.assertEquals(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 15, 10, 30)), cargaSUBE), true);
	}

	@Test
	public void testCGPNoDispponibleParaCargarSube() {
		Assert.assertEquals(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 14, 10, 30)), cargaSUBE), false);
		Assert.assertEquals(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), cargaSUBE), false);
	}

	@Test(expected = NoExisteServicioAsociadoException.class)
	public void testCgpSinServicioAsociado() {
		cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), prestamo);
	}

	@Test
	public void testParadaDeColectivoDisponible() {
		Assert.assertEquals(parada114DeCabildoYMonroe.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), null), true);
	}

	@Test
	public void testBancoDisponible() {
		Assert.assertEquals(bancoCiudadCabildo.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), prestamo), true);
	}

	@Test
	public void testLocalDisponible() {
		Assert.assertEquals(starbucks.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), null),true);
	}

}
