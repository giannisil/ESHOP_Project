
package View;

/**
 *
 * @author iliadis
 */
import Controller.ProgramState;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
		mainFrame.setSize(800, 600);
		mainFrame.setResizable(false);
		mainFrame.setLayout(new BorderLayout());

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				try {
					ProgramState.getInstance().saveState();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(mainFrame, ex);
				}
				System.exit(0);
			}        
		});

		headerPanel	= new HeaderPanel();
		contentPanel	= new PasswordFormPanel();

		mainFrame.add(headerPanel, BorderLayout.NORTH);
		mainFrame.add(contentPanel);

		mainFrame.setVisible(true);
	}
	
	public JFrame getMainFrame (){ return this.mainFrame; }
	
	public void setContentPanel (JPanel updatedPanel){ this.contentPanel = updatedPanel; }
}
