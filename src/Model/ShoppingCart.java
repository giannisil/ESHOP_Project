
package Model;

import java.util.List;

import Controller.Client;
import Controller.User;
import Model.OrderCatalog.OrderEntry;

/**
 *
 * @author iliadis
 */
public class ShoppingCart {	
	private List <ShoppingCartEntry> cart;
	private float totalCartPrice;
	private Client relatedClient;
	
	
	
	public ShoppingCart (Client cartOwner){
		this.relatedClient = cartOwner;
	}
	
	public OrderEntry checkout(){
		return OrderCatalog.getInstance().createNewOrderEntry(this);
	}
	
	public void addProductEntry(Product product, int amount){
		ShoppingCartEntry cartEntry = new ShoppingCartEntry(product, amount);
		cart.add(cartEntry);
	}
	
	public boolean removeCartEntry (ShoppingCartEntry cartEntry){
		return this.cart.remove(cartEntry);
	}
	
	public Client getRelatedClient (){
		return this.relatedClient;
	}
	
	

	/**
	 *
	 * @author iliadis
	 */
	
	public class ShoppingCartEntry {
		Product product;
		int amount;
		
		
		public ShoppingCartEntry (Product product, int amount){
			this.product = product;
			this.amount  = amount;
		}
	}
}
