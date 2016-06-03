
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
import java.io.Serializable;

/**
 *
 * @author iliadis
 */
public class ProgramState  implements Serializable{
	private static volatile ProgramState instance;
	private User currentUser;

	
	private ProgramState(){
		this.currentUser = UserCatalog.getInstance().createUser("Default User", "1234", UserType.CLIENT);
//		System.out.println("Is User catalog populated? -> "+UserCatalog.getInstance().hasUsers()); //TODO remove DEBUG
        this.loadState();
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
	    ObjectOutputStream oosUC = new ObjectOutputStream(new FileOutputStream("./db_files/UserCatalog.db"));
	    oosUC.writeObject(UserCatalog.getInstance());
	    oosUC.close();
	    
	    ObjectOutputStream oosCCL = new ObjectOutputStream(new FileOutputStream("./db_files/CompanyClientsLog.db"));
	    oosCCL.writeObject(CompanyClientsLog.getInstance());
	    oosCCL.close();
	    
	    ObjectOutputStream oosICL = new ObjectOutputStream(new FileOutputStream("./db_files/IndividualClientsLog.db"));
	    oosICL.writeObject(IndividualClientsLog.getInstance());
	    oosICL.close();
	    
	    ObjectOutputStream oosOC = new ObjectOutputStream(new FileOutputStream("./db_files/OrderCatalog.db"));
	    oosOC.writeObject(OrderCatalog.getInstance());
	    oosOC.close();
	    
	    ObjectOutputStream oosPC = new ObjectOutputStream(new FileOutputStream("./db_files/ProductCatalog.db"));
	    oosPC.writeObject(ProductCatalog.getInstance());
	    oosPC.close();
	}
	
	public void loadState (){
		   ObjectInputStream oisUC;
			try {
			   oisUC = new ObjectInputStream(new FileInputStream("./db_files/UserCatalog.db"));
			   try {
					UserCatalog.getInstance().setInstance(((UserCatalog) oisUC.readObject()));
//					System.out.println("Is User catalog populated? -> "+UserCatalog.getInstance().hasUsers()); //TODO remove DEBUG
//					System.out.println("User Catalog printout:\n"+UserCatalog.getInstance()); //TODO remove DEBUG
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			    try {
					oisUC.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// OK
			} catch (IOException e) {
				e.printStackTrace();
			}

		   ObjectInputStream oisCCL;
		   try {
			   oisCCL = new ObjectInputStream(new FileInputStream("./db_files/CompanyClientsLog.db"));
			   try {
					CompanyClientsLog.getInstance().setInstance(((CompanyClientsLog) oisCCL.readObject()));
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				try {
					oisCCL.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// OK
			} catch (IOException e) {
				e.printStackTrace();
			}
		

		   ObjectInputStream oisICL;
		   try {
				oisICL = new ObjectInputStream(new FileInputStream("./db_files/IndividualClientsLog.db"));
				try {
					IndividualClientsLog.getInstance().setInstance(((IndividualClientsLog) oisICL.readObject()));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				oisICL.close();
		   } catch (FileNotFoundException e) {
				// OK
		   } catch (IOException e) {
				e.printStackTrace();
		   }

		   ObjectInputStream oisOC;
		   try {
				oisOC = new ObjectInputStream(new FileInputStream("./db_files/OrderCatalog.db"));
				try {
					OrderCatalog.getInstance().setInstance(((OrderCatalog) oisOC.readObject()));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				oisOC.close();
		   } catch (FileNotFoundException e) {
				// OK
		   } catch (IOException e) {
				e.printStackTrace();
		   }

		   ObjectInputStream oisPC;
		   try {
				oisPC = new ObjectInputStream(new FileInputStream("./db_files/ProductCatalog.db"));
				try {
					ProductCatalog.getInstance().setInstance(((ProductCatalog) oisPC.readObject()));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				oisPC.close();
		   } catch (FileNotFoundException e) {
				// OK
		   } catch (IOException e) {
				e.printStackTrace();
		   }
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
