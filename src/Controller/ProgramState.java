
package Controller;

/**
 *
 * @author iliadis
 */
public class ProgramState {
	private static volatile ProgramState instance; //TODO add atributes
	private Model.ProductCatalog productCatalog;
	private User currentUser;

	
	private ProgramState(){
		this.currentUser = new Client("Default User", "1234");
	}
    public static ProgramState getInstance(){
        if (instance == null){
            synchronized (ProgramState.class){
                if (instance == null){
                    instance = new ProgramState();
                }
            }
        }
        return instance;
    }
	private boolean saveState(){}
	private boolean loadState(){}
	
	public boolean validateCredentials(String username, String password){
		if ((currentUser.getUsername() == username) && (currentUser.getPassword() == password)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public User getCurrentUser(){
		return this.currentUser;
	}
	public void setCurrentUser(User updatedUser){
		this.currentUser = updatedUser;
	}
	
}
