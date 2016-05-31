package View;

import Controller.ProgramState;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author iliadis
 */

	
public class HeaderPanel extends JPanel{
	JLabel usernameLabel;
	JButton logoutButton;

	public HeaderPanel (){
		this.setLayout(new GridLayout(1, 3));
		usernameLabel = new JLabel(ProgramState.getInstance().getCurrentUser().toString(), JLabel.LEFT);
		logoutButton = new JButton("logout");
		logoutButton.setActionCommand("logout");
		logoutButton.addActionListener(new ButtonClickListener()); 
		
		this.add(usernameLabel);
		this.add(logoutButton);
		
		this.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ProgramState.getInstance().getCurrentUser().logout();
		}		
	}
}
