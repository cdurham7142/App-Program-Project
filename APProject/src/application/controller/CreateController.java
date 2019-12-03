package application.controller;

import application.model.CustomerData;
import javafx.scene.paint.Paint;
import application.model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateController {

	 @FXML
	    private Button menuButton;

	    
	    @FXML
	    private Button confirmButton;
	    
	    @FXML
	    private TextField firstName;

	    @FXML
	    private TextField lastName;

	    @FXML
	    private PasswordField userPassword;

	    @FXML
	    private TextField phoneNumber;
	    
	    @FXML
	    private TextField shippingAddress;

	    @FXML
	    private TextField userID;
	    
	    @FXML
	    private Label errorMessage;
	    
	    @FXML
	    private TextField userCity;
	    
	    @FXML
	    private TextField userState;

    @FXML
    void handle(ActionEvent event) throws Exception {
    	Parent root;
    	Stage stage;
    	if(event.getSource()== menuButton){
        	stage = (Stage) menuButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/LoginScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()==confirmButton){
    		CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    		String fName = firstName.getText();
			String lName = lastName.getText();
			String pNumber  = phoneNumber.getText();
			String ID = userID.getText();
			String Password = userPassword.getText();
			String shipAddress =shippingAddress.getText();
			String city = userCity.getText();
			String state = userState.getText();
			Customers currentCustomer = alotOfScrunch2019.getCustomerFromID(ID);
			if(fName.isEmpty() || lName.isEmpty() || pNumber.isEmpty() || ID.isEmpty() || Password.isEmpty() || shipAddress.isEmpty())
			{
				errorMessage.setText("All fields are required");
				errorMessage.setTextFill(Paint.valueOf("#e82f0d"));
			}
			try{
				if(currentCustomer.getUserID().equals(ID))
					{
						errorMessage.setText("User already exits!");
						errorMessage.setTextFill(Paint.valueOf("#e82f0d"));
					}
			}
			catch (Exception e)
			{
				Customers customer = new Customers(fName, lName, pNumber, ID, Password, shipAddress, city, state);
				alotOfScrunch2019.addCustomer(customer);
				CustomerData.writeCustomersFile("data/customerInfo.csv");
				errorMessage.setText("Account created!");
				errorMessage.setTextFill(Paint.valueOf("#0eea2b"));
				firstName.clear();
				lastName.clear();
				phoneNumber.clear();
				userID.clear();
				userPassword.clear();
				shippingAddress.clear();
				userCity.clear();
				userState.clear();
				
			}
        }
        		

    }

}
