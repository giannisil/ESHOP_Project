
package Controller;

/**
 *
 * @author iliadis
 */
public class Client extends User{
	private ShoppingCart cart;
	
	private Client (){}
	public Client (String username, String password){
		super.userType = UserType.CLIENT;
		super.username = username;
		super.password = password;
	}
	public void displayProductCatalog(enum SortBy);
	public boolean addProductToCart(Product, int amount){
		this.cart.add(Product,amount)		
	}
	public void displayCart();
	public boolean removeProductFromCart(Product);
	public Order submitOrder();
	public boolean cancelOrder(Order);
	public void displayOrders();
	private void displayOrderState(Order);
	
}
