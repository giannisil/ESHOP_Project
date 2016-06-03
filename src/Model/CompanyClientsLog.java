
package Model;

import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public final class CompanyClientsLog {
    private static volatile CompanyClientsLog instance;
	private HashMap<String, IndividualClientEntry> clientsLog;

	
	
	private CompanyClientsLog(){}
	
    public static CompanyClientsLog getInstance(){
        if (instance == null){
            synchronized (CompanyClientsLog.class){
                if (instance == null){
                    instance = new CompanyClientsLog();
                }
            }
        }
        return instance;
    }
	
	public void setInstance(CompanyClientsLog instance){
		CompanyClientsLog.instance = instance;
	}
    
}
