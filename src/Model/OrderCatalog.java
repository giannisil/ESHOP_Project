
package Model;

import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public final class OrderCatalog {
    private static volatile OrderCatalog instance;
    private HashMap<Integer, OrderEntry> catalog; 
        
	private OrderCatalog(){}
    public static OrderCatalog getInstance(){
        if (instance == null){
            synchronized (OrderCatalog.class){
                if (instance == null){
                    instance = new OrderCatalog();
                }
            }
        }
        return instance;
    }
}
