
package Model;

/**
 *
 * @author iliadis
 */
public class Tablet extends Product {
    private String OS;
    private String CPU;
    private int Memory;
    private String Brand;
    
    public Tablet (){
        super.hasScreen = true;
    }
    public Tablet (String OS, String CPU, int Memory, String Brand){
        super.hasScreen   = true; 
        this.OS           = OS;
        this.CPU          = CPU;
        this.Memory       = Memory;
        this.Brand        = Brand;
    
    }  
    
}
