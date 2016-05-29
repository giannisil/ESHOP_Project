/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import java.util.HashMap;

/**
 *
 * @author iliadis
 */
public class ProductCatalog {
	private HashMap <int, Product> catalog;
	private ProductCatalog() {
	}
	
	public static ProductCatalog getInstance() {
		return ProductCatalogHolder.INSTANCE;
	}
	
	private static class ProductCatalogHolder {

		private static final ProductCatalog INSTANCE = new ProductCatalog();
	}
}
