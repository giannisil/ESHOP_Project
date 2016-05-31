
package Controller;

/**
 *
 * @author iliadis
 */
public abstract class User {
	private static int userCount = 0;
	private int userID;
	private String username;
	private String password;
	UserType userType;
	
	public User (){
		this.userID = ++User.userCount;
	}
	
	void displayProductCategories(){} // Design screen (2)
	public boolean logout(){}
	
	@Override
	public String toString(){
		return this.username;
	}
	
	String getUsername(){ return this.username; }
	String getPassword(){ return this.password; }
	
}
