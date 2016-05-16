
package eshop_project;

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
    }
    public PC (String CPU, int memSize, String GPU, String OS){
        super.hasScreen     = true;
        this.CPU            = CPU;
        this.memSize        = memSize;
        this.GPU            = GPU;
        this.OS             = OS;
    }    
}
