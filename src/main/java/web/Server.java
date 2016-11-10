package web;

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
		mapa = soporte.mapa();
		Spark.port(9000);
		setUsers();
		Router.initialize(mapa);
	}
	
	private static void setUsers(){
		UserManager uMan = UserManager.getInstance();
		uMan.addUser(new User("admin", ""));
		uMan.addUser(new User("root", "pass"));
	}

}
