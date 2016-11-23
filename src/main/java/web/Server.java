package web;

import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import acciones.Almacenar;
import ar.edu.TPPOI.MapaPOI;
import ar.edu.TPPOI.Terminal;
import clasesParaTests.SoporteDeInstanciasParaTestsBuilder;
import deApoyo.RepositorioDeTerminales;
import spark.Spark;
import users.User;
import users.UserManager;

public class Server {
	
	static MapaPOI mapa;
	static SoporteDeInstanciasParaTestsBuilder soporte;
	
	public static void main(String[] args) {
		soporte = new SoporteDeInstanciasParaTestsBuilder();
		mapa = soporte.mapa();
		EntityTransaction tx = PerThreadEntityManagers.getEntityManager().getTransaction();
		tx.begin();
		Spark.port(9000);
		setUsers();
		setTerminales();
		Router.initialize(mapa);
		tx.commit();
		System.out.println("My server is ready!!");
	}
	
	private static void setUsers(){
		soporte.cgpComuna5();
		UserManager uMan = UserManager.getInstance();
		uMan.addUser(new User("admin", ""));
		uMan.addUser(new User("root", "pass"));
	}
	
	private static void setTerminales(){
		Terminal t1 = new Terminal();
		t1.setDescripcion("terminal 1");
		t1.setMapa(mapa);
		t1.activarAccion(new Almacenar());
		t1.buscar("algo");
		RepositorioDeTerminales.agregarTerminal(t1);
	}

}
