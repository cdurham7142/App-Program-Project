package application.controller;

import application.model.CustomerData;
import application.model.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    private static Order order;
    
    @FXML
    private TextField orderQuantityField;

    @FXML
    private TextField orderColorField;
    
    @FXML
    private TextField orderPatternField;
    
    @FXML
    private TextField orderFabricField;
    
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
    void updateOrder(ActionEvent event) throws Exception {  	
    	Order ord = getOrder();
    	ord.setTime(Calendar.getInstance().get(Calendar.HOUR) + " " + Calendar.getInstance().get(Calendar.AM_PM));
    	if (event.getSource() == orderQuantityField)
    		ord.setQuantity(orderQuantityField.getText());
    	else if (event.getSource() == orderColorField)
    		ord.setFabricColor(orderColorField.getText());
    	else if (event.getSource() == orderFabricField)
    		ord.setFabricType(orderFabricField.getText());
    	else if (event.getSource() == orderButton) {
    		ord.setCurrentLocation("Pending");
    		ord.setOrderID(String.format("%06d", Math.random() * 1000000));
    		CustomerData.getInstance().customerArrayList.get(0).addOrder(ord);
    		return;
    	}
    	ord.setCurrentLocation("Ordering");
    }
    
    Order getOrder() {
    	if (order == null)
    		return new Order("", "", "", "", "", "");
    	return order;
    }
}