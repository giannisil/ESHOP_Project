
package View;

import Model.ProductCategory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
public class ProductCategoriesPanel extends JPanel{
	JPanel  categoryButtonsPanel;
	JLabel	eshopLabel;
	JButton PCButton;
	JButton mobilePhoneButton;
	JButton DigiCamButton;
	JButton printerButton;
	JButton TVButton ;
	JButton tabletButton;
	
	
	
	public ProductCategoriesPanel(){
		this.setLayout(new BorderLayout());
		categoryButtonsPanel = new JPanel(new GridLayout(2, 3));
		eshopLabel = new JLabel("Uber e-Shop y'all :]", JLabel.CENTER);
		PCButton = new JButton("PC");
		PCButton.addActionListener(new ButtonClickListener(ProductCategory.PC));
		mobilePhoneButton = new JButton("Mobile Phone");
		mobilePhoneButton.addActionListener(new ButtonClickListener(ProductCategory.MOBILE_PHONE));
		DigiCamButton = new JButton("Digi Cam ");
		DigiCamButton.addActionListener(new ButtonClickListener(ProductCategory.DIGICAM));
		printerButton = new JButton("Printer");
		printerButton.addActionListener(new ButtonClickListener(ProductCategory.PRINTER));
		TVButton = new JButton("TV");
		TVButton.addActionListener(new ButtonClickListener(ProductCategory.TV));
		tabletButton = new JButton("Tablet");
		tabletButton.addActionListener(new ButtonClickListener(ProductCategory.TABLET));
		
		this.add(eshopLabel, BorderLayout.NORTH);
		this.add(categoryButtonsPanel, BorderLayout.CENTER);
		categoryButtonsPanel.add(PCButton); //TODO add icons
		categoryButtonsPanel.add(mobilePhoneButton);
		categoryButtonsPanel.add(DigiCamButton);
		categoryButtonsPanel.add(printerButton);
		categoryButtonsPanel.add(TVButton);
		categoryButtonsPanel.add(tabletButton);
		
		this.setVisible(true);
	}
	
	
	
	private class ButtonClickListener implements ActionListener{
		ProductCategory buttonProductCategory;


		private ButtonClickListener(ProductCategory productCategory) {
			this.buttonProductCategory = productCategory;
		}
		
		public void actionPerformed(ActionEvent e) {
			switch (this.buttonProductCategory){
				case PC:			MainFrame.getInstance().setContentPanel(new PC_CatalogPanel());
				case MOBILE_PHONE:	MainFrame.getInstance().setContentPanel(new MOBILE_PHONE_CatalogPanel());
				case DIGICAM:		MainFrame.getInstance().setContentPanel(new DIGICAM_CatalogPanel());
				case PRINTER:		MainFrame.getInstance().setContentPanel(new PRINTER_CatalogPanel());
				case TV:			MainFrame.getInstance().setContentPanel(new TV_CatalogPanel());
				case TABLET:		MainFrame.getInstance().setContentPanel(new TABLET_CatalogPanel());
			}
		}
	}
}
