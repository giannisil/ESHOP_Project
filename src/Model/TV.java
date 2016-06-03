
package Model;

/**
 *
 * @author iliadis
 */
public class TV extends Product {
    private String Brand;
    private String FrameRate;
    private float Price;
    
    public TV (){
        super.hasScreen = true;
		super.productType = ProductCategory.TV;
    }
    public TV (String Brand, String FrameRate, float Price){
        super.hasScreen     = true; 
		super.productType = ProductCategory.TV;
        this.Brand          = Brand;
        this.FrameRate      = FrameRate;
        this.Price          = Price;
    }
}
