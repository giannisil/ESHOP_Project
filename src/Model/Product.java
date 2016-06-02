
package Model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author iliadis
 */
public abstract class Product {
	private static final AtomicInteger instanceCounter = new AtomicInteger();
    private String name;
    private String descr;
    private final int productSerialNo;
    private String brand;
    private int price;
    private int screensize;
    private String resolution;
    boolean hasScreen = false;
    
    public Product(){
        this.productSerialNo = Product.instanceCounter.incrementAndGet();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }
    
    public int getProductSerialNo (){ return this.productSerialNo; }

    public void setDescr (String descr) { this.descr = descr; }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
