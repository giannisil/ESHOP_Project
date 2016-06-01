
package Model;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

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
	
	public void setInstance(OrderCatalog instance){
		OrderCatalog.instance = instance;
	}
    
    public OrderEntry createNewOrderEntry(ShoppingCart cart){
    	OrderEntry order = new OrderEntry(cart);
    	this.catalog.put(order.getOrderSerialNo(), order);
    	return order;
    }
    
    public void updateOrderState (OrderState orderState, OrderEntry order){
    	order.orderState = orderState;
    }
    

	/**
	 *
	 * @author iliadis
	 * 
	 * @param ordersCount A shared counter of OrderCount instances among all 
	 * them
	 */
	public static class OrderEntry {
		private static final AtomicInteger ordersCounter = new AtomicInteger();
		private final int orderSerialNo;
		private ShoppingCart relatedCart;
		private ClientEntry relatedClient;
		private ClientType clientType;
		private OrderState orderState;
		
		
		
		public OrderEntry (ShoppingCart cart){
			this.orderState = OrderState.SUBMISSION;
			this.orderSerialNo = this.ordersCounter.incrementAndGet();
			this.relatedCart = cart;
			this.relatedClient = cart.getRelatedClient().getClientCredentials();
		}
		
		public void cancelOrder(){
			this.orderState = OrderState.CANCELED;
		}
		
		int getOrderSerialNo(){
			return this.orderSerialNo;
		}
	}
}
