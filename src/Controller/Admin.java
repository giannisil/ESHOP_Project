
package Controller;

/**
 *
 * @author iliadis
 */
public class Admin extends User{
	
	public User createUSer(String username, String password);
	public boolean logout();
	public boolean addProductToCatalog(Product);
	public boolean deleteProductFromCatalog(Product);
	public boolean updateOrderState(OrderState,Order);
	public void displayClientLog();
	public void displayOrders();
	
	
	
	
	
}
