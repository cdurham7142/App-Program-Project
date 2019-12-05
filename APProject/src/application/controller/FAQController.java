package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class will represent the FAQController which will implement the EventHandler
 * interface, and any events that occur when the user interacts with FAQScene.fxml.
 *
 * @author Gabby Mariello vsc775
 * UTSA CS 3443 - Group Project
 * Fall 2019
 * 
 */
public class FAQController {

    @FXML
    private Button menuButton;

    @FXML
    void handle(ActionEvent event) throws Exception {
    	Parent root;
    	Stage stage;
    	if(event.getSource()== menuButton){
        	stage = (Stage) menuButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/MainScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}

    }

}
