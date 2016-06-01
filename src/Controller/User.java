
package Controller;

/**
 *
 * @author iliadis
 */
public abstract class User {
	private static int userCount = 0;
	private int userID;
	protected String username;
	protected String password;
	protected UserType userType;
	
	public User (){
		this.userID = ++User.userCount;
	}
	
	void displayProductCategories(){} // Design screen (2)
	
	public boolean logout(){
		if (ProgramState.getInstance().saveState()){
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString(){
		return this.username;
	}
	
	String 	 getUsername (){ return this.username; }
	String 	 getPassword (){ return this.password; }
	UserType getUserType (){ return this.userType; }
	
}
