
package Controller;

/**
 *
 * @author iliadis
 */
public class Client extends User{
	private ShoppingCart cart;
	
	public Client (){
		super.userType = UserType.CLIENT;
	}
	public void displayProductCatalog(enum SortBy);
	public boolean logout();
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
