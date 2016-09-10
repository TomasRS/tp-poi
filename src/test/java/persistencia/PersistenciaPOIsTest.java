package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import clasesParaTests.SoporteDeInstanciasParaTestsBuilder;
import pois.CGP;
import pois.LocalComercial;
import pois.ParadaDeColectivo;
import pois.SucursalBanco;

public class PersistenciaPOIsTest {
	SoporteDeInstanciasParaTestsBuilder soporteTest;
	ParadaDeColectivo parada114Lugano;
	LocalComercial lcStarbucks;
	SucursalBanco bancoCiudad;
	CGP cgpC5;
	EntityManager entityManager;
	EntityTransaction tx;
	
	
	@Before
	public void init(){
		soporteTest = new SoporteDeInstanciasParaTestsBuilder();
		parada114Lugano = soporteTest.paradaDeColectivo114DeLugano();
		lcStarbucks = soporteTest.starbucksCoronelDiaz1400();
		bancoCiudad = soporteTest.bancoCiudadCabildoYCongreso();
		cgpC5 = soporteTest.cgpComuna5();
		entityManager = PerThreadEntityManagers.getEntityManager();
		tx = entityManager.getTransaction();
	}

	@Test
	public void persistirParadaDeColectivo(){
		tx.begin();
		parada114Lugano.setTag("economico");
		entityManager.persist(parada114Lugano.getDireccion());
		entityManager.persist(parada114Lugano);
		tx.commit();
	}
	
	@Test
	public void persistirLocalComercial(){
		tx.begin();
		entityManager.persist(lcStarbucks.getDireccion());
		entityManager.persist(lcStarbucks);
		tx.commit();
	}
	
	@Test
	public void persistirCGP(){
		tx.begin();
		entityManager.persist(cgpC5.getDireccion());
		entityManager.persist(cgpC5);
		tx.commit();
	}
	
	@Test
	public void persistirSucursalBanco(){
		tx.begin();
		entityManager.persist(bancoCiudad.getDireccion());
		entityManager.persist(bancoCiudad);
		tx.commit();
	}

}
