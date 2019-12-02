package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DesignController {
	@FXML
    private Button backButton;

    //@FXML
    //private Button helpButton;
    
    @FXML
    private Button viewCreatorButton;

    @FXML
    void viewCreator(ActionEvent event) throws Exception
    {
    	Stage stage = (Stage) viewCreatorButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/application/view/ContactScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();	
    }
    
    @FXML
    void toMenu(ActionEvent event) throws Exception
    {  	
    	Stage stage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/application/view/MainScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}