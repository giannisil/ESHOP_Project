
package Model;

import java.util.List;

/**
 *
 * @author iliadis
 */
public class ShoppingCart {	
	private List <ProductEntry> cart;
	private float totalCartPrice;
	
	
	public Order Checkout(){
		return new Order(); // TODO replace return value with actual order
	}
	public void addProductEntry(Product product, int amount){}
}
