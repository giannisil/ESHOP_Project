/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Product;
import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public final class ProductCatalog {
    private static volatile ProductCatalog instance;
	private HashMap <Integer, Product> catalog;
	
	
	
	private ProductCatalog() {}
	
	public static ProductCatalog getInstance(){
        if (instance == null){
            synchronized (ProductCatalog.class){
                if (instance == null){
                    instance = new ProductCatalog();
                }
            }
        }
        return instance;
    }
	
	public void setInstance(ProductCatalog instance){
		ProductCatalog.instance = instance;
	}
	
	public void addProduct(Product product){
		this.catalog.put(product.getProductSerialNo(), product);
	}
	
	public boolean deleteProduct(Product product){
		if (this.catalog.remove(product.getProductSerialNo()) == null){
			return false;
		}
		return true;
	}
}

