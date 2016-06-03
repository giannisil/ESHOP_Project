package View;

import Controller.ProgramState;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author iliadis
 */

	
public class HeaderPanel extends JPanel{
	JLabel usernameLabel;
	JButton logoutButton;

	public HeaderPanel (){
		this.setLayout(new FlowLayout());
		this.setMaximumSize(new Dimension(800, 30));
		usernameLabel = new JLabel(ProgramState.getInstance().getCurrentUser().toString());
		logoutButton = new JButton("logout");
		logoutButton.setPreferredSize(new Dimension(100, 30));
		logoutButton.setActionCommand("logout");
		logoutButton.addActionListener(new ButtonClickListener(this)); 
		
		this.add(usernameLabel);
		this.add(logoutButton);
		
		this.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener{
		private JPanel relatedPanel;
		
		
		
		public ButtonClickListener (JPanel sourcePanel){ this.relatedPanel = sourcePanel; }
		
		public void actionPerformed(ActionEvent e) {
			try {
				ProgramState.getInstance().saveState();
				ProgramState.getInstance().getCurrentUser().logout();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(MainFrame.getInstance().getMainFrame(), "Error saving to database: "  + e1);
			}
		}		
	}
}
