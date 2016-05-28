
package Model;

import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public final class IndividualClientsLog {
    private static volatile IndividualClientsLog instance;
	private HashMap<String, IndividualClientEntry> clientsLog;
	
    private IndividualClientsLog(){}
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
}
