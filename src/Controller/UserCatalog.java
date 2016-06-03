package Controller;

import java.util.HashMap;

import Model.ProductCatalog;
import java.io.Serializable;

/**
 *
 * @author iliadis
 */
public class UserCatalog implements Serializable{
	private static volatile UserCatalog instance;
	private HashMap<Integer, User> usersCatalog;
	
	
	
	private UserCatalog() {}
	
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
}
