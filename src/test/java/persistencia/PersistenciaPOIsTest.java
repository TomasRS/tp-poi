package persistencia;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.util.List;
import ar.edu.TPPOI.MapaPOI;
import clasesParaTests.SoporteDeInstanciasParaTestsBuilder;
import deApoyo.Comparador;
import pois.CGP;
import pois.LocalComercial;
import pois.POI;
import pois.ParadaDeColectivo;
import pois.SucursalBanco;

public class PersistenciaPOIsTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
	SoporteDeInstanciasParaTestsBuilder soporteTest;
	ParadaDeColectivo parada114Lugano;
	LocalComercial lcStarbucks;
	SucursalBanco bancoCiudad;
	CGP cgpC5;
	EntityManager entityManager;
	MapaPOI mapa, otroMapa;
	
	
	@Before
	public void init(){
		entityManager = PerThreadEntityManagers.getEntityManager();
		soporteTest = new SoporteDeInstanciasParaTestsBuilder();
		parada114Lugano = soporteTest.paradaDeColectivo114DeLugano();
		lcStarbucks = soporteTest.starbucksCoronelDiaz1400();
		bancoCiudad = soporteTest.bancoCiudadCabildoYCongreso();
		cgpC5 = soporteTest.cgpComuna5();
		mapa = new MapaPOI();//soporteTest.mapa();
		persistirTodosLosPois();
		otroMapa = new MapaPOI();
	}

	public void persistirTodosLosPois(){
		mapa.agregarPOI(parada114Lugano);
		mapa.agregarPOI(lcStarbucks);
		mapa.agregarPOI(cgpC5);
		mapa.agregarPOI(bancoCiudad);
	}

	@Test
	public void traerParadaColectivo114(){
		ParadaDeColectivo paradaObtenida = (ParadaDeColectivo) otroMapa.buscar("114").get(0);
		Assert.assertTrue(Comparador.mismoPOI(parada114Lugano,paradaObtenida));
	}
	
	@Test
	public void traerLocalComercialStarbucks(){
		LocalComercial localObtenido = (LocalComercial) otroMapa.buscar("Cafeteria").get(0);
		Assert.assertTrue(Comparador.mismoLocalComercial(lcStarbucks, localObtenido));
	}
	
	@Test
	public void traerCGP5(){
		CGP cgpObtenido = (CGP) otroMapa.buscar("Almagro").get(0);
		Assert.assertTrue(Comparador.mismoPOI(cgpC5, cgpObtenido));
	}
	
	@Test
	public void traerBancoCiudad(){
		SucursalBanco bancoObtenido = (SucursalBanco) otroMapa.buscar("Banco Ciudad").get(0);
		Assert.assertTrue(Comparador.mismoPOI(bancoCiudad, bancoObtenido));
	}
	
	@Test
	public void importarPoisAlMapaPOI(){
		Assert.assertEquals(4, otroMapa.getListaDePOIs().size());
	}
	
	@Test
	public void encuentraLocalComercialEnElMapaPOI(){
		Assert.assertTrue(Comparador.mismoPOI(lcStarbucks, otroMapa.buscarPoi(lcStarbucks)));
	}
	
	@Test
	public void nombreDeLocalComercialEnElMapaPOIEstaOK(){
		Assert.assertEquals(lcStarbucks.getNombre(), otroMapa.buscarPoi(lcStarbucks).getNombre());
	}
	
}
