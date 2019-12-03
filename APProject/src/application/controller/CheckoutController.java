package application.controller;

import application.model.CustomerData;
import application.model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CheckoutController {

	 @FXML
	    private Button menuButton;

	    @FXML
	    private Button helpButton;
	    
	    @FXML
	    private Button checkoutButton;
	    
	    @FXML
	    private TextArea returnArea;

    @FXML
    void handle(ActionEvent event) throws Exception {
    	Parent root;
    	Stage stage;
    	CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	Customers currentCustomer = alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID);
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
    }

}
