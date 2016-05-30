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
}
