
package Controller;

import Model.OrderCatalog;
import Model.OrderState;
import Model.Product;
import Model.OrderCatalog.OrderEntry;
import Model.ProductCatalog;

/**
 *
 * @author iliadis
 */
public class Admin extends User{
	
	
	public Admin (String username, String password){
		super();
		super.userType = UserType.ADMIN;
		super.username = username;
		super.password = password;
	}
	
	public User createUser(String username, String password, UserType userType){
		User user;
		
		if 		(userType == UserType.ADMIN) { user = new Admin(username, password);  } // TODO make sure new user is in UserCatalog
		else								 { user = new Client(username, password); } // TODO same here
		
		return user;
	}
	
	public void  addProductToCatalog(Product product){
		ProductCatalog.getInstance().addProduct(product);
	}
	
	public boolean deleteProductFromCatalog(Product product){
		return ProductCatalog.getInstance().deleteProduct(product);
	}
	
	public void updateOrderState(OrderState orderState, OrderEntry order){
		OrderCatalog.getInstance().updateOrderState(orderState, order);
	}
	
	public void displayClientLog(){}
	
	public void displayOrders(){}		
}
