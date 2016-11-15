package web;

import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import ar.edu.TPPOI.MapaPOI;
import clasesParaTests.SoporteDeInstanciasParaTestsBuilder;
import spark.Spark;
import users.User;
import users.UserManager;

public class Server {
	
	static MapaPOI mapa;
	static SoporteDeInstanciasParaTestsBuilder soporte;
	
	public static void main(String[] args) {
		soporte = new SoporteDeInstanciasParaTestsBuilder();
		EntityTransaction tx = PerThreadEntityManagers.getEntityManager().getTransaction();
		tx.begin();
		mapa = soporte.mapa();
		Spark.port(9000);
		setUsers();
		Router.initialize(mapa);
		tx.commit();
		System.out.println("My server is ready!!");
	}
	
	private static void setUsers(){
		UserManager uMan = UserManager.getInstance();
		uMan.addUser(new User("admin", ""));
		uMan.addUser(new User("root", "pass"));
	}

}
