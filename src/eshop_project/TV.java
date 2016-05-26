
package eshop_project;

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
    }
    public TV (String Brand, String FrameRate, float Price){
        this.Brand           = Brand;
        this.FrameRate       = FrameRate;
        this.Price       = Price;
        this.hasScreen    =true; 
    }
}
