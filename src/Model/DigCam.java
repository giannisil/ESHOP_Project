
package Model;

/**
 *
 * @author iliadis
 */
public class DigCam extends Product {
    private String Brand;
    private int Zoom;
    private float Price;
    private int CamRes;
    
    public DigCam (){
        super.hasScreen = true;
		super.productType = ProductCategory.DIGICAM;
    }
    public DigCam (String Brand, int Zoom, float Price, int CamRes){
        super.hasScreen = true; 
		super.productType = ProductCategory.DIGICAM;
        this.Brand      = Brand;
        this.Zoom       = Zoom;
        this.Price      = Price;
        this.CamRes     = CamRes;
    }
    
}
