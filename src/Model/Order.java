
package Model;

import java.util.List;

/**
 *
 * @author iliadis
 */
public class Order {
	private ShoppingCart relatedCart;
	static int ordersCount;
	private int orderSerialNo;
	private ClientEntry relatedClient;
	private List<ProductEntry> cart;
	private ClientType clientType;
	private OrderState orderState;
}
