
package eshop_project;

/**
 *
 * @author iliadis
 */
public abstract class Product {
    private String name;
    private String descr;
    private static int productSerialNo = 0;
    private int ProductCode;
    private String brand;
    private int price;
    private int screensize;
    private String resolution;
    boolean hasScreen = false;
    
    public Product(){
        this.ProductCode = ++Product.productSerialNo; 
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

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getProductCode() {
        return ProductCode;
    }

    public void setProductCode(int ProductCode) {
        this.ProductCode = ProductCode;
    }

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
