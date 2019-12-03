package application.controller;

import application.model.CustomerData;
import application.model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class CheckoutController {

	 @FXML
	    private Button menuButton;
	 
	 @FXML
	    private Button showButton;

	    @FXML
	    private Button helpButton;
	    
	    @FXML
	    private Button checkoutButton;
	    
	    @FXML
	    private TextArea returnArea;
	    
	    @FXML
	    private TextField orderID;
	    
	    @FXML
	    private Label errorMessage;
	    
	    CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	Customers currentCustomer = alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID);

    @FXML
    void handle(ActionEvent event) throws Exception {
    	Parent root;
    	Stage stage;
    	
    	if(event.getSource()== menuButton){
        	stage = (Stage) menuButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/MainScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== helpButton){
        	stage = (Stage) helpButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/FAQScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== checkoutButton){
    		String ID = orderID.getText();
			errorMessage.setText("Order Placed!");
			errorMessage.setTextFill(Paint.valueOf("#0eea2b"));
			for(int i = 0; i <= currentCustomer.getOrderArrayList().size() - 1; i++)
    		{
				if(ID.equals(currentCustomer.getOrderArrayList().get(i).getOrderID()))
				{
					currentCustomer.getOrderArrayList().get(i).setCurrentLocation("Processing");
					alotOfScrunch2019.writeCustomersFile("data/orderInfo.csv");
					break;
				}
    		}
    		
    	}
    		if(event.getSource()== showButton){
    			returnArea.setText( "Orders for: " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
        		returnArea.appendText( "\n+++++++++++++++++++++++++++++++++++++++++++++++++");
        		for(int i = 0; i <= currentCustomer.getOrderArrayList().size() - 1; i++)
        		{
        			if(currentCustomer.getOrderArrayList().get(i).getCurrentLocation().equals("Pending"))
        			{
        			returnArea.appendText("\nOrder ID: " + currentCustomer.getOrderArrayList().get(i).getOrderID());
        			returnArea.appendText( "\n-------------------------------------------------");
        			returnArea.appendText( "\nOrder Quantity: " + currentCustomer.getOrderArrayList().get(i).getQuantity());
        			returnArea.appendText( "\nFabric Type: " + currentCustomer.getOrderArrayList().get(i).getFabricType());
        			returnArea.appendText( "\nFabric Color: " + currentCustomer.getOrderArrayList().get(i).getFabricColor());
        			returnArea.appendText( "\nScrunchie Size: " + currentCustomer.getOrderArrayList().get(i).getScrunchSize());
        			int priceSize = 0;
        			if(currentCustomer.getOrderArrayList().get(i).getScrunchSize().equals("Large"))
        				priceSize = 3;
        			if(currentCustomer.getOrderArrayList().get(i).getScrunchSize().equals("Medium"))
        				priceSize = 2;
        			if(currentCustomer.getOrderArrayList().get(i).getScrunchSize().equals("Small"))
        				priceSize = 1;
        			int quantity = Integer.parseInt(currentCustomer.getOrderArrayList().get(i).getQuantity());
        			int totalPrice = (3 + priceSize) * quantity; 
        			returnArea.appendText( "\nOrder Price:  " + totalPrice);
        			returnArea.appendText( "\n--------------------------------------------------------");
        			}
        		}
    			
    		}
    }
    void Print(ActionEvent event) throws Exception {
		
	 }//end of handle function

}
