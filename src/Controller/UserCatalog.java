package Controller;

import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public class UserCatalog {
	private static volatile UserCatalog instance;
	private HashMap<String, User> usersCatalog;
	
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
	User fetchUser (String username) {
		return this.usersCatalog.get(username);
	}
}
