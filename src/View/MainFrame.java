
package View;

/**
 *
 * @author iliadis
 */
import Controller.ProgramState;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class MainFrame {
	private static volatile MainFrame instance;
	private JFrame mainFrame;
	private JPanel headerPanel;
	private JPanel contentPanel;
	
	public MainFrame(){
	   prepareGUI();
	}
	
	public static MainFrame getInstance(){
        if (instance == null){
            synchronized (MainFrame.class){
                if (instance == null){
                    instance = new MainFrame();
                }
            }
        }
        return instance;
    }
	
	public static void main(String[] args){  
		MainFrame.getInstance();       
	}
	
	private void prepareGUI(){
      mainFrame = new JFrame("ESHOP_Project_Iliadis");
      mainFrame.setSize(960,400);
	  mainFrame.setResizable(false);
	  mainFrame.setLayout(new GridLayout(2, 1));
	  
	  mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });
	  
	  headerPanel	= new HeaderPanel();
	  contentPanel	= new PasswordFormPanel();
	  
	  mainFrame.add(headerPanel);
	  mainFrame.add(contentPanel);
	  
	  mainFrame.setVisible(true);
	}
	
	void setContentPanel(JPanel updatedPanel){
		this.contentPanel = updatedPanel;
	}
}
