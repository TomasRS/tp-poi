package users;

import java.util.List;

import javax.persistence.TypedQuery;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class UserManager {
	
	private static UserManager instance;
	public List<User> users;
	
	private UserManager(){
		TypedQuery<User> q =PerThreadEntityManagers.getEntityManager().createQuery("SELECT u FROM User u", User.class);
		users = q.getResultList();
	}
	
	public void addUser(User user){
		PerThreadEntityManagers.getEntityManager().persist(user);
		users.add(user);
	}
	
	public static UserManager getInstance(){
		if (instance==null){
			instance = new UserManager();
		}
		return instance;
	}
	
	public boolean anyMatch(String aName, String aPass){
		System.out.println("Buscando en:");
		users.stream().forEach(aUser->System.out.println(aUser.toString()));
		return users.stream().anyMatch(aUser->aUser.match(aName, aPass));
	}
}
