
package Model;

/**
 *
 * @author iliadis
 */
public class PC extends Product {
    private String CPU;
    private int memSize;
    private String GPU ;
    private String OS;
    
    public PC (){
        super.hasScreen = true;
		super.productType = ProductCategory.PC;
    }
    public PC (String CPU, int memSize, String GPU, String OS){
        super.hasScreen     = true;
		super.productType = ProductCategory.PC;
        this.CPU            = CPU;
        this.memSize        = memSize;
        this.GPU            = GPU;
        this.OS             = OS;
    }    
}
