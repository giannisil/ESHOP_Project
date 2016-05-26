
package eshop_project;

/**
 *
 * @author iliadis
 */
public class MobilePhone extends Product {
    private String OS;
    private String CPU;
    private int CamRes;
    public enum connectivity {3G , 4G
    }
public MobilePhone (){
        super.hasScreen = true;
}
public MobilePhone (String OS, String CPU, int CamRes, enum connectivity){
        super.hasScreen    = true;
        this.OS            = OS;
        this.CPU           = CPU;
        this.CamRes        = CamRes;
        this.connectivity  = connectivity;
    }
    
}
