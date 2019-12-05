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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Calendar;

/**
 * This class will represent the DesignController which will implement the EventHandler
 * interface, and any events that occur when the user interacts with DesignScene.fxml.
 *
 * @author Colin Durham sif159
 * UTSA CS 3443 - Group Project
 * Fall 2019
 * 
 */
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
    private ColorPicker userColor;
    
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
		ord.setFabricColor(userColor.getId());
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
    	mediumChecked.setDisable(true);
    	LargeChecked.setDisable(true);
    }
    @FXML
    void Medium(ActionEvent event) throws Exception {  
    	ord.setScrunchSize("Medium");
    	LargeChecked.setDisable(true);
    	smallChecked.setDisable(true);
    }
    @FXML
    void Small(ActionEvent event) throws Exception { 
    	ord.setScrunchSize("Large");
    	mediumChecked.setDisable(true);
    	LargeChecked.setDisable(true);
    }
}
