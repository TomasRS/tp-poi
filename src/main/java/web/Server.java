package web;

import javax.persistence.EntityTransaction;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import ar.edu.TPPOI.MapaPOI;
import spark.Spark;
import users.User;
import users.UserManager;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		setUsers();
		Router.initialize(new MapaPOI());
	}
	
	private static void setUsers(){
		UserManager uMan = UserManager.getInstance();
		uMan.addUser(new User("admin", ""));
		uMan.addUser(new User("root", "pass"));
	}

}
