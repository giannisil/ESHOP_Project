package Controller;

import java.util.HashMap;

import Model.ProductCatalog;
import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author iliadis
 */
public class UserCatalog implements Serializable{
	private static volatile UserCatalog instance;
	private HashMap<Integer, User> usersCatalog;
	
	
	
	private UserCatalog() {
		this.usersCatalog = new HashMap();
	}
	
    public static UserCatalog getInstance(){
        if (instance == null){
            synchronized (UserCatalog.class){
                if (instance == null){
                    instance = new UserCatalog();
                }
            }
        }
        return instance;
    }
    
    public User createUser (String username, String password, UserType userType){
    	User user;
    	if (userType == UserType.ADMIN){
    		user = new Admin(username, password);
    	}
    	else {
    		user = new Client(username, password);
    	}
    	
    	this.usersCatalog.put(user.getUserID(), user);
    	return user;
    }
	
	public void setInstance(UserCatalog instance){
		UserCatalog.instance = instance;
	}
    
	public User fetchUser (String username) {
		return this.usersCatalog.get(username);
	}
	
	boolean hasUsers(){ return !this.usersCatalog.isEmpty();}
	
	@Override
	public String toString(){
		String output = new String();
		
		for (User user : this.usersCatalog.values()) {
			output += user + "\n";
		}
		
		return output;
	}
}
