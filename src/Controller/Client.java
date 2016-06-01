
package Controller;

import Model.ClientEntry;
import Model.OrderCatalog.OrderEntry;
import Model.Product;
import Model.ShoppingCart;
import Model.ShoppingCart.ShoppingCartEntry;

/**
 *
 * @author iliadis
 */
public class Client extends User{
	private ShoppingCart cart;
	private ClientEntry clientCredentials;
	
	
	
	private Client (){}
	
	public Client (String username, String password){
		super();
		super.userType = UserType.CLIENT;
		super.username = username;
		super.password = password;
	}
	
	public void displayProductCatalog(SortBy sortedBy){}
	
	public void addProductToCart(Product product, int amount){
		this.cart.addProductEntry(product, amount);
	}
	
	public void displayCart(){}
	
	public boolean removeProductEntryFromCart(ShoppingCartEntry cartEntry){
		return this.cart.removeCartEntry(cartEntry);
	}
	
	public OrderEntry checkout(){
		return this.cart.checkout();
	}
	
	public void cancelOrder(OrderEntry order){
		order.cancelOrder();
	}
	
	public void displayOrders(){}
	
	private void displayOrderState(OrderEntry order){}
	
	public ClientEntry getClientCredentials (){
		return this.clientCredentials;
	}
}