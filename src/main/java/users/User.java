package users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id @GeneratedValue
	private long id;
	
	private String name;
	private String password;
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public boolean match(String otherName, String otherPass){
		return name.contentEquals(otherName)&&password.contentEquals(otherPass);
	}
	
	public String toString(){
		return String.format("User:%s\nPass:%s", name, password);
	}
	
}
