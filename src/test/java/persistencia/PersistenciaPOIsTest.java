package persistencia;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import java.util.List;
import ar.edu.TPPOI.MapaPOI;
import clasesParaTests.SoporteDeInstanciasParaTestsBuilder;
import deApoyo.Comparador;
import pois.CGP;
import pois.LocalComercial;
import pois.POI;
import pois.ParadaDeColectivo;
import pois.SucursalBanco;

public class PersistenciaPOIsTest {
	static SoporteDeInstanciasParaTestsBuilder soporteTest;
	static ParadaDeColectivo parada114Lugano;
	static LocalComercial lcStarbucks;
	static SucursalBanco bancoCiudad;
	static CGP cgpC5;
	static EntityManager entityManager;
	static EntityTransaction tx;
	static MapaPOI mapa;
	
	
	@BeforeClass
	public static void init(){
		soporteTest = new SoporteDeInstanciasParaTestsBuilder();
		parada114Lugano = soporteTest.paradaDeColectivo114DeLugano();
		lcStarbucks = soporteTest.starbucksCoronelDiaz1400();
		bancoCiudad = soporteTest.bancoCiudadCabildoYCongreso();
		cgpC5 = soporteTest.cgpComuna5();
		mapa = new MapaPOI();//soporteTest.mapa();
		persistirTodosLosPois();
		mapa.cargarDeDB();
	}
	
	public static void persistirParadaDeColectivo114(){
		mapa.agregarPOI(parada114Lugano);
	}
	
	public static void persistirLocalComercialStarbucks(){
		mapa.agregarPOI(lcStarbucks);
	}
	
	public static void persistirCGP5(){
		mapa.agregarPOI(cgpC5);
	}
	
	public static void persistirSucursalBancoCiudad(){
		mapa.agregarPOI(bancoCiudad);
	}

	@Test
	public void traerParadaColectivo114(){
		ParadaDeColectivo paradaObtenida = entityManager.find(ParadaDeColectivo.class, 1l);
		Assert.assertTrue(Comparador.mismoPOI(parada114Lugano,paradaObtenida));
	}
	
	@Test
	public void traerLocalComercialStarbucks(){
		LocalComercial localObtenido = entityManager.find(LocalComercial.class, 2l);
		Assert.assertTrue(Comparador.mismoLocalComercial(lcStarbucks, localObtenido));
	}
	
	@Test
	public void traerCGP5(){
		CGP cgpObtenido = entityManager.find(CGP.class, 3l);
		Assert.assertTrue(Comparador.mismoPOI(cgpC5, cgpObtenido));
	}
	
	@Test
	public void traerBancoCiudad(){
		SucursalBanco bancoObtenido = entityManager.find(SucursalBanco.class, 4l);
		Assert.assertTrue(Comparador.mismoPOI(bancoCiudad, bancoObtenido));
	}
	
	public static void persistirTodosLosPois(){
		persistirParadaDeColectivo114();
		persistirLocalComercialStarbucks();
		persistirCGP5();
		persistirSucursalBancoCiudad();
	}
	
	@Test
	public void importarPoisAlMapaPOI(){
		mapa.cargarDeDB();
		Assert.assertEquals(4, mapa.getListaDePOIs().size());
	}
	
	@Test
	public void encuentraLocalComercialEnElMapaPOI(){
		mapa.cargarDeDB();
		Assert.assertEquals(lcStarbucks,mapa.buscarPoi(lcStarbucks));
	}
	
	@Test
	public void nombreDeLocalComercialEnElMapaPOIEstaOK(){
		mapa.cargarDeDB();
		Assert.assertEquals(lcStarbucks.getNombre(),mapa.buscarPoi(lcStarbucks).getNombre());
	}
	
	@After
	public void clear(){
		mapa.getListaDePOIs().clear();
//		tx.rollback();
	}
	
}
