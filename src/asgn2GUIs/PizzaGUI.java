package asgn2GUIs;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a �dummy� class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature � as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	private PizzaRestaurant restaurant;
	JButton fileButton;
	JLabel label;
	JButton pickUpButton;
	String filename;
	JLabel exceptionLabel;
	File file;
	String[] customerColumnNames = {"Customer Name", "Mobile Number", "Type", "X Location", "Y Location", "Delivery Distance"};
	String[] pizzaColumnNames = {"Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit"};
	Customer getCustomerData;
	String[] currentCustomerData = new String[6];
	Pizza getPizzaData;
	String[] currentPizzaData = new String[5];
	DecimalFormat doubleFormat = new DecimalFormat("#.00");
	JTable customerInfo;
	JTable pizzaInfo;
	
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	
	public PizzaGUI(String title) {
		
		
		super(title);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create boarders
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 200, 200));
        contentPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        // Left container
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));    
        leftPanel.setAlignmentX(LEFT_ALIGNMENT);
        JPanel labelPanel = new JPanel();
        JPanel exceptionPanel = new JPanel();
        
        label = new JLabel("Select a log file to open", JLabel.LEFT);
        JPanel buttonLeftPanel = new JPanel();
        exceptionLabel = new JLabel("");
        fileButton = new JButton("Open");
        
        
		
        
        // Open file
        fileButton.addActionListener(new ActionListener()
        
        {
            public void actionPerformed(ActionEvent ae)
            {
            	// Open file chooser
            	final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(PizzaGUI.this);
				
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					filename = file.getAbsolutePath();
					
					
						try {
							restaurant.processLog(filename);
						} catch (CustomerException | PizzaException | LogHandlerException e) {
							
							// Display exception
						exceptionLabel.setText(e.toString());
						}
					
					// Create Tables to display data
					customerInfo = new JTable(6, restaurant.getNumCustomerOrders());
					pizzaInfo = new JTable(5, restaurant.getNumPizzaOrders());
					
					DefaultTableModel model = (DefaultTableModel) customerInfo.getModel();
					DefaultTableModel modelPizza = (DefaultTableModel) pizzaInfo.getModel();
					
					model.addRow(customerColumnNames);
				    modelPizza.addRow(pizzaColumnNames);
				    modelPizza.addRow(currentPizzaData);
					
					
					
					for(int customer = 0; customer < restaurant.getNumCustomerOrders(); customer++){
						
						try {
							getCustomerData = restaurant.getCustomerByIndex(customer);
						} catch (CustomerException e) {
							exceptionLabel.setText(e.toString());
						}
						
						// Put customer data into tables
						currentCustomerData[0] = getCustomerData.getName();
						currentCustomerData[1] = getCustomerData.getMobileNumber();
						currentCustomerData[2] = getCustomerData.getCustomerType();
						currentCustomerData[3] = Integer.toString(getCustomerData.getLocationX());
						currentCustomerData[4] = Integer.toString(getCustomerData.getLocationY());
						currentCustomerData[5] = doubleFormat.format(getCustomerData.getDeliveryDistance());

					    model.addRow(currentCustomerData);
					    
					   /* try {
							getPizzaData = restaurant.getPizzaByIndex(customer);
						} catch (PizzaException e) {
							exceptionLabel.setText(e.toString());
						}
							
					    // Pizza Data
					    currentPizzaData[0] = getPizzaData.getPizzaType();
						currentPizzaData[1] = Integer.toString(getPizzaData.getQuantity());
						currentPizzaData[2] = doubleFormat.format(getPizzaData.getOrderPrice());
						currentPizzaData[3] = doubleFormat.format(getPizzaData.getOrderCost());
						currentPizzaData[4] = doubleFormat.format(getPizzaData.getOrderProfit());
						
					    modelPizza.addRow(currentPizzaData);
						*/
					}
						
					
					JPanel tablePanel = new JPanel();
					tablePanel.setLayout(new GridLayout(7, 7, 10, 10));
					tablePanel.add(customerInfo);
					tablePanel.add(pizzaInfo);
					
					contentPane.add(tablePanel);
					
				} else if(returnVal==JFileChooser.CANCEL_OPTION) {
				}
				
				
					
				
            }
        });
        
        // Add elements to GUI
        labelPanel.add(label);
        exceptionPanel.add(exceptionLabel);
        buttonLeftPanel.add(fileButton);
        leftPanel.add(labelPanel);
        
        leftPanel.add(buttonLeftPanel);
        leftPanel.add(exceptionPanel);
        contentPane.add(leftPanel);

        /*JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 7, 10, 10));
       
                pickUpButton = new JButton("Pick Up");
                
                
                pickUpButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        JButton but = (JButton) ae.getSource();
                        label.setText(
                            but.getActionCommand() + "hello");                           
                    }
                });
                buttonPanel.add(pickUpButton);
            
        
        contentPane.add(pickUpButton);
*/
        // Display GUI
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}

	
	@Override
	public void run() {
		restaurant = new PizzaRestaurant();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
