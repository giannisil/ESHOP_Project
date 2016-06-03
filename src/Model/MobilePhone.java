
package Model;

/**
 *
 * @author iliadis
 */
public class MobilePhone extends Product {
    private String OS;
    private String CPU;
    private int CamRes;
    private Connectivity connectivity;
	
    public MobilePhone (){
        super.hasScreen = true;
		super.productType = ProductCategory.MOBILE_PHONE;
    }
    
    public MobilePhone (String OS, String CPU, int CamRes, Connectivity connectivity){
        super.hasScreen    = true;
		super.productType = ProductCategory.MOBILE_PHONE;
        this.OS            = OS;
        this.CPU           = CPU;
        this.CamRes        = CamRes;
        this.connectivity  = connectivity;
    }
    
}
