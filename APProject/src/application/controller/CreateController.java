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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateController {

	 @FXML
	    private Button menuButton;

	    @FXML
	    private Button helpButton;
	    
	    @FXML
	    private Button confirmButton;
	    
	    @FXML
	    private TextField firstName;

	    @FXML
	    private TextField lastName;

	    @FXML
	    private TextField userPassword;

	    @FXML
	    private TextField phoneNumber;
	    
	    @FXML
	    private TextField shippingAddress;

	    @FXML
	    private TextField userID;
	    
	    @FXML
	    private Label errorMessage;

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
    	if(event.getSource()== helpButton){
        	stage = (Stage) helpButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/FAQScene.fxml"));
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
			if(fName.isEmpty() || lName.isEmpty() || pNumber.isEmpty() || ID.isEmpty() || Password.isEmpty())
			{
				errorMessage.setText("All fields are required");
			}
			else
			{
				Customers customer = new Customers(fName, lName, pNumber, ID, Password);
				alotOfScrunch2019.addCustomer(customer);
				errorMessage.setText("Account created!");
			}
        }
        		

    }

}
