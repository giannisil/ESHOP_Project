/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ProgramState;
import java.awt.*;
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
		this.setLayout(new GridLayout(4, 1));
		usernamePanel = new JPanel();
		usernamePanel.setLayout(new FlowLayout());
		usernameField = new JTextField();
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new FlowLayout());
		passwordField = new JPasswordField();
		submitButton = new JButton("Submit");
		submitButton.setActionCommand("Submit_Credentials");
		submitButton.addActionListener(
				new PasswordFormPanel.ButtonClickListener(usernameField.getText(), 
				new String(this.passwordField.getPassword()), 
				errorLabel));
		errorLabel = new JLabel("Incorrect username and/or password. ");
		errorLabel.setVisible(false);
		
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameField);
		
		passwordPanel.add(passwordLabel);
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
				MainFrame.getInstance().setContentPanel(new ProductCategoryPanel());
			}
			else {
				this.errorLabel.setVisible(true);
			}
		}		
	}
	
}
