
package Controller;

/**
 *
 * @author iliadis
 */
public class ProgramState {
	private static volatile ProgramState instance; //TODO add atributes
		private Model.ProductCatalog productCatalog;

	private ProgramState(){}
	private boolean saveState(){}
	private boolean loadState(){}
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
