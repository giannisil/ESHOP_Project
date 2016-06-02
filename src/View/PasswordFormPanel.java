package View;

import Controller.ProgramState;
import Controller.UserCatalog;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *
 * @author iliadis
 */
public class PasswordFormPanel extends JPanel{
	JPanel			usernamePanel;
	JLabel			usernameLabel;
	JTextField		usernameField;
	JPanel			passwordPanel;
	JLabel			passwordLabel;
	JPasswordField	passwordField;
	JButton			submitButton;
	JLabel			errorLabel;

	public PasswordFormPanel(){
		this.setLayout(new FlowLayout());
		usernamePanel = new JPanel();
		usernamePanel.setLayout(new FlowLayout());
		usernameField = new JTextField();
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new FlowLayout());
		passwordField = new JPasswordField();
		errorLabel = new JLabel("Incorrect username and/or password. ");
		errorLabel.setVisible(false);
		submitButton = new JButton("Submit");
		submitButton.setActionCommand("Submit_Credentials");
		submitButton.addActionListener(
				new PasswordFormPanel.ButtonClickListener(usernameField.getText(), 
				new String(this.passwordField.getPassword()), 
				errorLabel));
		
		usernamePanel.add(usernameLabel = new JLabel("Username: "));
		this.usernameField.setPreferredSize(new Dimension(200, 30));
		usernamePanel.add(usernameField);
		
		passwordPanel.add(passwordLabel = new JLabel("Password: "));
		this.passwordField.setPreferredSize(new Dimension(200, 30));
		passwordPanel.add(passwordField);
		
		this.add(usernamePanel);
		this.add(passwordPanel);
		this.add(submitButton);	
		this.add(errorLabel);
		
		this.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{
		String username, password;
		JLabel errorLabel;
		
		public ButtonClickListener( String username, String password, JLabel errorLabel){
			this.username	= username;
			this.password	= password;
			this.errorLabel = errorLabel;
		}
		public void actionPerformed(ActionEvent e) {
			if (ProgramState.getInstance().validateCredentials(this.username, this.password)){
				ProgramState.getInstance().setCurrentUser(UserCatalog.getInstance().fetchUser(this.username)); // Fetch User object with the validated username and set it as current user
//				MainFrame.getInstance().setContentPanel(new ProductCategoryPanel()); // TODO implement class ProductCategoryPanel
			}
			else {
				this.errorLabel.setBackground(new Color((float)1.0, (float)0.0, (float)0.0));
				this.errorLabel.setVisible(true);
			}
		}		
	}
	
}
