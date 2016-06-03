
package Model;

/**
 *
 * @author iliadis
 */
public class Printer extends Product{
    private String brand;
    private String type;
    private float price;
    
    
	
	public Printer (){
		super.productType = ProductCategory.PRINTER;
	}
	
    public Printer (String brand, String type, float price){
		super.productType = ProductCategory.PRINTER;
        this.brand         = brand;
        this.type          = type;
        this.price         = price;
    }
        
}
