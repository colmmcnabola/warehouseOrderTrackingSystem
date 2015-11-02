package warehouseOrderTrackingSystem;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GUI extends JFrame {
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel productLabel;
	private JLabel statusLabel;
	private JLabel customerLabel;
	private JPanel controlPanel;
	private JPanel customerPanel;
	private JPanel stockPanel;
	private JPanel orderPanel;
	private JPanel productPanel;
	private JTextArea productList;
	
	
	public GUI(){
		prepareGUI();
	}
	
	public static void main (String [] args){
		GUI sd = new GUI();
		sd.mainMenu();
	}			
	
	//setting of the GUI size and layout
	private void prepareGUI(){
		mainFrame = new JFrame ("Warehouse Order tracking System");
		mainFrame.setSize(900, 900);
		mainFrame.setLayout(new GridLayout (3,1));
		headerLabel = new JLabel ("", JLabel.CENTER);
		headerLabel.setFont(new Font("Calibri Light", Font.PLAIN, 35));
		
		
		
		customerLabel = new JLabel ("Hello");
		productLabel = new JLabel("HELLO");
		
		
		
		
		//exiting of the system when the 'x' button is pressed. 
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		
		controlPanel = new JPanel (); 
		controlPanel.setLayout(new FlowLayout());
		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		
		//creating of a customer panel and setting of the size 
		customerPanel = new JPanel();
		customerPanel.setLayout(new GridLayout(2,4));
		
		//creating of a stock panel and setting of the size
		stockPanel = new JPanel ();
		stockPanel.setLayout(new GridLayout(2,4));
		
		//creation of the orders panel and the setting of the size
		orderPanel = new JPanel();
		orderPanel.setLayout(new GridLayout(2,4));
		
		//creation of the products panel and the setting of the size
		productPanel = new JPanel();
		productPanel.setLayout(new GridLayout(2,4));
		
		mainFrame.setVisible(true);
	}
	
	private void mainMenu(){
		//header label for the home screen
		headerLabel.setText("Warehouse Order Tracking System");
		
		//creating of new buttons on the main screen
		JButton createNewCustOrderButton = new JButton ("Create New Customer Order");
		JButton createNewOrderButton = new JButton ("Create New Purchase Order");
		JButton viewOrdersButton = new JButton ("View Current Orders");
		JButton viewProductsButton = new JButton("View Products");
		JButton exitMainMenuButton = new JButton ("Exit");
		
		//setting of the command for each of the buttons created above
		createNewCustOrderButton.setActionCommand("Create New Customer Order");
		createNewOrderButton.setActionCommand("Create New Purchase Order");
		viewOrdersButton.setActionCommand("View Current Orders");
		viewProductsButton.setActionCommand("Products");
		exitMainMenuButton.setActionCommand("Exit");
		
		createNewCustOrderButton.addActionListener(new BCL());
		createNewOrderButton.addActionListener(new BCL());
		viewOrdersButton.addActionListener(new BCL());
		viewProductsButton.addActionListener(new BCL());
		exitMainMenuButton.addActionListener(new BCL());
		
		controlPanel.add(createNewCustOrderButton);
		controlPanel.add(createNewOrderButton);
		controlPanel.add(viewOrdersButton);
		controlPanel.add(viewProductsButton);
		controlPanel.add(exitMainMenuButton);
		mainFrame.setVisible(true);
		
	}
	
	private class BCL implements ActionListener{
		@Override
		public void actionPerformed (ActionEvent ae){
			String command = ae.getActionCommand();
			switch (command){
			case "Customer Orders": 
				break;
			case "Stock Orders":
				break;
			case "Current Orders":
				currentOrders();
				break;
			case "Products":
				viewProducts();
				break;
			case "Exit":
				break;
			
			}
		}
	}
	private void currentOrders(){
		mainFrame.remove(controlPanel);
		mainFrame.remove(stockPanel);
		mainFrame.remove(orderPanel);
		mainFrame.remove(productPanel);
		mainFrame.add(customerPanel);
		
		
		headerLabel.setText("Current Orders");
		
	}
	
	private void viewProducts (){
		mainFrame.remove(controlPanel);
		mainFrame.remove(stockPanel);
		mainFrame.remove(orderPanel);
		mainFrame.remove(customerPanel);
		
		productList = new JTextArea();
		
		productPanel.add(productList);
		mainFrame.add(productPanel);
		
		headerLabel.setText("Current Products");
		
		
		// Get all products from array and display to GUI
		ArrayList<Product> products = databaseConnection.readAllProducts();
		
		String output = "\n";
		
		for(int i = 0; i < products.size(); i++){
			output += products.get(i).getproductId() + "\t" +products.get(i).getProductName() + "\t\t" +products.get(i).getProductLoc() + "\t\t" +products.get(i).getProductQuantRemain() + "\n" ;
		}
		
		productList.setText(output);
		productList.revalidate();
		JButton backToHome = new JButton ("Home");
		backToHome.setActionCommand("Home");
		backToHome.addActionListener(new BCL());
		backToHome.setFont(new Font("Calibri Light", Font.PLAIN, 35));
		customerPanel.add(backToHome);
		mainFrame.revalidate();
	}
}
