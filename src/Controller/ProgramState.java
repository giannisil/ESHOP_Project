
package Controller;

/**
 *
 * @author iliadis
 */
public class ProgramState {
	private static volatile ProgramState instance; //TODO add atributes
		private ProductCatalog productCatalog;

	private ProgramState(){}
    public static ProgramState getInstance(){
        if (instance == null){
            synchronized (ProgramState.class){
                if (instance == null){
                    instance = new ProgramState();
                }
            }
        }
        return instance;
    }
	
}
