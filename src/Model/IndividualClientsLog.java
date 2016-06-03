
package Model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public final class IndividualClientsLog implements Serializable {
    private static volatile IndividualClientsLog instance;
    private HashMap<String, IndividualClientEntry> clientsLog;
	
    
    
    private IndividualClientsLog(){
		this.clientsLog = new HashMap();
	}
    
    public static IndividualClientsLog getInstance(){
        if (instance == null){
            synchronized (IndividualClientsLog.class){
                if (instance == null){
                    instance = new IndividualClientsLog();
                }
            }
        }
        return instance;
    }
	
	public void setInstance(IndividualClientsLog instance){
		IndividualClientsLog.instance = instance;
	}
}
