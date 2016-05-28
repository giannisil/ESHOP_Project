
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
    }
    public DigCam (String Brand, int Zoom, float Price, int CamRes){
        super.hasScreen = true; 
        this.Brand      = Brand;
        this.Zoom       = Zoom;
        this.Price      = Price;
        this.CamRes     = CamRes;
    }
    
}
