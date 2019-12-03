package application.controller;

import application.model.CustomerData;
import application.model.Order;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Calendar;

public class DesignController {
	@FXML
    private Button backButton;

    @FXML
    private Button orderButton;
    
    @FXML
    private Button viewCreatorButton;
    
    @FXML
    private TextField orderQuantityField;

    @FXML
    private TextField orderColorField;
    
    @FXML
    private TextField orderPattern;
    
    @FXML
    private TextField orderMaterialField;

    @FXML
    private CheckBox mediumChecked;

    @FXML
    private CheckBox LargeChecked;
    
    @FXML
    private CheckBox smallChecked;
    Order ord = new Order(null, null, null, null, null, null, null);
    

    
    @FXML
    void viewCreator(ActionEvent event) throws Exception {
    	Stage stage = (Stage) viewCreatorButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/application/view/InfoScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();	
    }
    
    @FXML
    void toMenu(ActionEvent event) throws Exception {  	
    	Stage stage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/application/view/MainScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void order(ActionEvent event) throws Exception {  	
    	
		ord.setTime(Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + (Calendar.getInstance().get(Calendar.AM_PM) == Calendar.AM ? "am" : "pm"));
		ord.setQuantity(orderQuantityField.getText());
		ord.setFabricColor(orderColorField.getText());
		ord.setFabricType(orderPattern.getText());
		ord.setCurrentLocation("Pending");
		ord.setOrderID(String.format("%06d", (int)(Math.random() * 1000000)));
		ord.setScrunchSize("Large");
		CustomerData.getCustomerFromID(CustomerData.ID).addOrder(ord);
    	CustomerData.writeOrdersFile("data/orderInfo.csv");
    	toMenu(null);
    }
    @FXML
    void Large(ActionEvent event) throws Exception {  
    	ord.setScrunchSize("Small");
    }
    @FXML
    void Medium(ActionEvent event) throws Exception {  
    	ord.setScrunchSize("Medium");
    }
    @FXML
    void Small(ActionEvent event) throws Exception { 
    	ord.setScrunchSize("Large");
    }
}