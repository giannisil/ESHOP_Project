
package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.CompanyClientsLog;
import Model.IndividualClientsLog;
import Model.OrderCatalog;
import Model.ProductCatalog;

/**
 *
 * @author iliadis
 */
public class ProgramState {
	private static volatile ProgramState instance; //TODO add atributes
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
    
    /**
     * Saves current ProgramState to database
     * 
     * Specifically saves: UserCatalog, CompanyClientsLog, IndividualClientsLog, 
     * OrderCatalog, ProductCatalog.
     * 
     * @return true if successful, false if not
     */
	public void saveState () throws IOException{		
	    ObjectOutputStream oosUC = new ObjectOutputStream(new FileOutputStream("UserCatalog.db"));
	    oosUC.writeObject(UserCatalog.getInstance());
	    oosUC.close();
	    
	    ObjectOutputStream oosCCL = new ObjectOutputStream(new FileOutputStream("CompanyClientsLog.db"));
	    oosCCL.writeObject(CompanyClientsLog.getInstance());
	    oosCCL.close();
	    
	    ObjectOutputStream oosICL = new ObjectOutputStream(new FileOutputStream("IndividualClientsLog.db"));
	    oosICL.writeObject(IndividualClientsLog.getInstance());
	    oosICL.close();
	    
	    ObjectOutputStream oosOC = new ObjectOutputStream(new FileOutputStream("OrderCatalog.db"));
	    oosOC.writeObject(OrderCatalog.getInstance());
	    oosOC.close();
	    
	    ObjectOutputStream oosPC = new ObjectOutputStream(new FileOutputStream("ProductCatalog.db"));
	    oosPC.writeObject(ProductCatalog.getInstance());
	    oosPC.close();
	}
	
	public void loadState (){
		   ObjectInputStream oisUC;
			try {
				oisUC = new ObjectInputStream(new FileInputStream("UserCatalog.db"));
			   try {
					UserCatalog.getInstance().setInstance(((UserCatalog) oisUC.readObject()));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    try {
					oisUC.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		   ObjectInputStream oisCCL = new ObjectInputStream(new FileInputStream("CompanyClientsLog.db"));
		   CompanyClientsLog.getInstance().setInstance(((CompanyClientsLog) oisCCL.readObject()));
		   oisCCL.close();

		   ObjectInputStream oisICL = new ObjectInputStream(new FileInputStream("IndividualClientsLog.db"));
		   IndividualClientsLog.getInstance().setInstance(((IndividualClientsLog) oisICL.readObject()));
		   oisICL.close();

		   ObjectInputStream oisOC = new ObjectInputStream(new FileInputStream("OrderCatalog.db"));
		   OrderCatalog.getInstance().setInstance(((OrderCatalog) oisOC.readObject()));
		   oisOC.close();

		   ObjectInputStream oisPC = new ObjectInputStream(new FileInputStream("ProductCatalog.db"));
		   ProductCatalog.getInstance().setInstance(((ProductCatalog) oisPC.readObject()));
		   oisPC.close();
	}
	
	public boolean validateCredentials (String username, String password){
		if ((currentUser.getUsername() == username) && (currentUser.getPassword() == password)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public User getCurrentUser  (){
		return this.currentUser;
	}
	public void setCurrentUser(User updatedUser){
		this.currentUser = updatedUser;
	}
	
}
