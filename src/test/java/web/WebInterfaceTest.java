package web;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import ar.edu.TPPOI.MapaPOI;
import clasesParaTests.SoporteDeInstanciasParaTestsBuilder;
import spark.Spark;
import users.User;
import users.UserManager;

public class WebInterfaceTest extends AbstractPersistenceTest implements WithGlobalEntityManager{
	
	EntityManager entityManager;
	MapaPOI mapa;
	SoporteDeInstanciasParaTestsBuilder soporte;
	
	@Before
	public void init(){
		entityManager = PerThreadEntityManagers.getEntityManager();
		soporte = new SoporteDeInstanciasParaTestsBuilder();
		mapa = soporte.mapa();
		setUsers();
	}
	
	@Test
	public void serverTest(){
		Spark.port(9000);
		setUsers();
		Router.initialize(mapa);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setUsers(){
		UserManager uMan = UserManager.getInstance();
		uMan.addUser(new User("admin", ""));
		uMan.addUser(new User("root", "pass"));
	}
}
