package web;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import users.User;
import users.UserManager;

public class WebInterfaceTest extends AbstractPersistenceTest implements WithGlobalEntityManager{
	
	EntityManager entityManager;
	
	@Before
	public void init(){
		entityManager = PerThreadEntityManagers.getEntityManager();
		setUsers();
	}
	
	private void setUsers(){
		UserManager uMan = UserManager.getInstance();
		uMan.addUser(new User("admin", ""));
		uMan.addUser(new User("root", "pass"));
	}
}
