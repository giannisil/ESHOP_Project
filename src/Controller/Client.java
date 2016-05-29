
package Controller;

/**
 *
 * @author iliadis
 */
public class Client {
	private ShoppingCart cart;
	
	public void displayProductCatalog(enum SortBy);
	public boolean logout();
	public boolean addProductToCart(Product, int amount){
		this.cart.add(Product,amount)		
	}
	public void displayCart();
	public boolean removeProductFromCart(Product);
	public Order submitOrder();
	public void displayOrderState(Order);
	public boolean cancelOrder(Order);
	public void displayOrders();
	
}
