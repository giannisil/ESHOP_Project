 
package Model;

import java.util.List;

/**
 *
 * @author iliadis
 * 
 * @param ordersCount A shared counter of OrderCount instances among all 
 * them
 */
public class OrderEntry {
	private static int ordersCount = 0;
	private int orderSerialNo;
	private ShoppingCart relatedCart;
	private ClientEntry relatedClient;
	private ClientType clientType;
	private OrderState orderState;
	
	public OrderEntry (){
		this.orderSerialNo = ++OrderEntry.ordersCount;
	}
}
