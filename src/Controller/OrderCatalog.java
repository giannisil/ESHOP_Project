
package Controller;

import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public class OrderCatalog {
	private HashMap<int , OrderEntry> catalog; 
	private OrderCatalog() {
	}
	
	public static OrderCatalog getInstance() {
		return OrderCatalogHolder.INSTANCE;
	}
	
	private static class OrderCatalogHolder {

		private static final OrderCatalog INSTANCE = new OrderCatalog();
	}
}
