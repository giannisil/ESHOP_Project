
package Controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author iliadis
 */
public abstract class User {
	private static final AtomicInteger instanceCounter = new AtomicInteger();
	private int userID;
	protected String username;
	protected String password;
	protected UserType userType;
	
	public User (){
		this.userID = User.instanceCounter.incrementAndGet();
	}
	
	void displayProductCategories(){
		
	} // TODO Design screen (2)
	
	public void logout() throws IOException{
		ProgramState.getInstance().saveState();
	}
	
	@Override
	public String toString(){
		return this.username;
	}
	
	public String 	 getUsername (){ return this.username; }
	public String 	 getPassword (){ return this.password; }
	public UserType  getUserType (){ return this.userType; }
	public int 		 getUserID	 (){ return this.userID;   }
	
}
