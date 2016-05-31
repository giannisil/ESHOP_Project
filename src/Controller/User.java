
package Controller;

/**
 *
 * @author iliadis
 */
public abstract class User {
	private String username;
	private String password;
	UserType userType;
	
	void displayProductCategories(){} // Design screen (2)
	public boolean logout(){}
	
	@Override
	public String toString(){
		return this.username;
	}
	
	String getUsername(){ return this.username; }
	String getPassword(){ return this.password; }
	
}
