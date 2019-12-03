package application.controller;
import application.model.CustomerData;
import application.model.Customers;
import application.model.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
public class JacobController
{
	   @FXML
	    private TextField userCity;
	   
	   @FXML
	    private TextField orderID;
	   
	   @FXML
	    private TextArea returnArea;

	    @FXML
	    private PasswordField userPassword;

	    @FXML
	    private Button trackButton;

	    @FXML
	    private Button helpButton;
	    
	    @FXML
	    private Button confirmButton;

	    @FXML
	    private TextField userID;

	    @FXML
	    private TextArea accountArea;

	    @FXML
	    private Button changeButton;

	    @FXML
	    private TextArea Result;

	    @FXML
	    private TextField firstName;

	    @FXML
	    private TextField phoneNumber;

	    @FXML
	    private TextField userState;

	    @FXML
	    private TextField lastName;

	    @FXML
	    private Button menuButton;

	    @FXML
	    private TextField shippingAddress;

	    @FXML
	    private Button accountButton;
	    
	    @FXML
	    private Label errorMessage;

    @FXML
    void handle(ActionEvent event) throws Exception
    {
    	Stage stage;
    	Parent root;
    	CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	Customers currentCustomer = alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID);
    	if(event.getSource()== menuButton){
        	stage = (Stage) menuButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/MainScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== helpButton){
        	stage = (Stage) helpButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/FAQScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== trackButton){
    		Result.setText( "Orders for: " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
    		Result.appendText( "\n+++++++++++++++++++++++++++++++++++++++++++++++++");
    		for(int i = 0; i <= currentCustomer.getOrderArrayList().size() - 1; i++)
    		{
    			Result.appendText("\nOrder ID: " + currentCustomer.getOrderArrayList().get(i).getOrderID());
    			Result.appendText( "\n-------------------------------------------------");
    			Result.appendText( "\nOrder Status: " + currentCustomer.getOrderArrayList().get(i).getCurrentLocation() + " at " + currentCustomer.getOrderArrayList().get(i).getTime());
    			Result.appendText( "\nOrder Quantity: " + currentCustomer.getOrderArrayList().get(i).getQuantity());
    			Result.appendText( "\nFabric Type: " + currentCustomer.getOrderArrayList().get(i).getFabricType());
    			Result.appendText( "\nFabric Color: " + currentCustomer.getOrderArrayList().get(i).getFabricColor());
    			Result.appendText( "\nScrunchie Size: " + currentCustomer.getOrderArrayList().get(i).getScrunchSize());
    			Result.appendText( "\n--------------------------------------------------------");
    		}
    	}
    	if(event.getSource()== accountButton){
    		accountArea.setText("\nInformation for user " + currentCustomer.getUserID() + " is: ");
    		accountArea.appendText( "\n++++++++++++++++++++++++++++++++++++++++++++++++");
    		accountArea.appendText("\nFirst Name: " + currentCustomer.getFirstName());
    		accountArea.appendText("\nLast Name: " + currentCustomer.getLastName());
    		accountArea.appendText("\nPhone Number: "+ currentCustomer.getPhoneNumber());
    		accountArea.appendText("\nShipping Address: "+ currentCustomer.getShippingAddress());
    		accountArea.appendText("\nState: "+ currentCustomer.getUserSate());
    		accountArea.appendText("\nCity: "+ currentCustomer.getUserCity());
    	}
    	
    	if(event.getSource()== confirmButton){
    		CustomerData alotOfScrunchRefund2019 = CustomerData.getInstance();
    		String userOrderID = orderID.getText();
    		
    		for(int i = 0; i <= currentCustomer.getOrderArrayList().size() - 1; i++)
    		{
    			if(currentCustomer.getOrderArrayList().get(i).getOrderID().equals(userOrderID))
    			{
    				if(currentCustomer.getOrderArrayList().get(i).getCurrentLocation().equals("Processing"))
    				{
    					Order refundOrder = new Order(currentCustomer.getOrderArrayList().get(i).getCurrentLocation(), currentCustomer.getOrderArrayList().get(i).getTime(), currentCustomer.getOrderArrayList().get(i).getQuantity(), currentCustomer.getOrderArrayList().get(i).getFabricColor(), currentCustomer.getOrderArrayList().get(i).getFabricType(),  userOrderID, currentCustomer.getOrderArrayList().get(i).getScrunchSize());
    					returnArea.setText("Order" + userOrderID + " was sucessfully returned!");
    					alotOfScrunchRefund2019.getCustomerArrayList().get(i).getOrderArrayList().add(refundOrder);
    					currentCustomer.getOrderArrayList().remove(i);
    					alotOfScrunchRefund2019.writeOrdersFile("data/refundInfo.csv");
    				}
    				else if(currentCustomer.getOrderArrayList().get(i).getCurrentLocation().equals("Shipping") || currentCustomer.getOrderArrayList().get(i).getCurrentLocation().equals("Handling"))
    				{
    					returnArea.setText("Order " + userOrderID + " is not eligible for a refund!\n Please refer to the help FAQ for more information.");
    				}
    			}
    			else
				{
						returnArea.setText(userOrderID + " could not be found");
				}
    		}
    	}
    	if(event.getSource()==changeButton){
    		String fName = firstName.getText();
			String lName = lastName.getText();
			String pNumber  = phoneNumber.getText();
			String ID = userID.getText();
			String Password = userPassword.getText();
			String shipAddress =shippingAddress.getText();
			String city = userCity.getText();
			String state = userState.getText();
			if(fName.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setFirstName(fName);
			}
			if(lName.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setLastName(lName);
			}
			if(pNumber.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setPhoneNumber(pNumber);
			}
			if(ID.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setUserID(ID);
			}
			if(Password.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setUserPassword(Password);
			}
			if(shipAddress.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setShippingAddress(shipAddress);
			}
			if(city.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setUserCity(city);
			}
			if(state.isEmpty() == false)
			{
				alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID).setUserState(state);
			}
			alotOfScrunch2019.writeCustomersFile("data/customerInfo.csv");
			firstName.clear();
			lastName.clear();
			phoneNumber.clear();
			userID.clear();
			userPassword.clear();
			shippingAddress.clear();
			userCity.clear();
			userState.clear();
			errorMessage.setText("Account settings changed!");
			errorMessage.setTextFill(Paint.valueOf("#0eea2b"));
        }
    }
}


