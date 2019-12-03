package application.controller;
import application.model.CustomerData;
import application.model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class JacobController
{
	   @FXML
	    private TextField userCity;

	    @FXML
	    private PasswordField userPassword;

	    @FXML
	    private Button trackButton;

	    @FXML
	    private Button helpButton;

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
	    private TextArea Result2;

	    @FXML
	    private Button menuButton;

	    @FXML
	    private TextField shippingAddress;

	    @FXML
	    private Button accountButton;

    @FXML
    void handle(ActionEvent event) throws Exception
    {
    	CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	System.out.println(alotOfScrunch2019.ID);
    	Stage stage;
    	Parent root;
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
    		Result.setText("");
    		Result.appendText( "Orders for: " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
    		Result.appendText( "\n+++++++++++++++++++++++++++++++++++++++++++++++++");
    		for(int i = 0; i <= currentCustomer.getOrderArrayList().size() - 1; i++)
    		{
    			Result.appendText("\nOrder ID: " + currentCustomer.getOrderArrayList().get(i).getOrderID());
    			Result.appendText( "\n-------------------------------------------------");
    			Result.appendText( "\nOrder Status: " + currentCustomer.getOrderArrayList().get(i).getCurrentLocation() + " at " + currentCustomer.getOrderArrayList().get(i).getTime());
    			Result.appendText( "\nOrder Quantity: " + currentCustomer.getOrderArrayList().get(i).getQuantity());
    			Result.appendText( "\nFabric Type: " + currentCustomer.getOrderArrayList().get(i).getFabricType());
    			Result.appendText( "\nFabric Color: " + currentCustomer.getOrderArrayList().get(i).getFabricColor());
    			Result.appendText( "\nOrder Price: ");
    			Result.appendText( "\nRefund Status: ");
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
    }
    

}


