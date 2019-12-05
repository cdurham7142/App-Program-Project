package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class will represent the MainController which will implement the EventHandler
 * interface, and any events that occur when the user interacts with MainScene.fxml.
 *
 * @author Gabby Mariello vsc775 
 * UTSA CS 3443 - Group Project
 * Fall 2019
 * 
 */
public class MainController {

    @FXML
    private Button checkoutButton;

    @FXML
    private Button serviceButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button logoutButton;
    
    @FXML
    private Button featuredButton;

    @FXML
    private Button contactButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button designButton;

    @FXML
    private Button reviewButton;

    @FXML
    void handle(ActionEvent event) throws Exception{
    	Stage stage;
    	Parent root;
    	if(event.getSource()== helpButton){
        	stage = (Stage) helpButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/FAQScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== logoutButton){
        	stage = (Stage) logoutButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/LoginScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== serviceButton){
        	stage = (Stage) serviceButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/InfoScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== checkoutButton){
        	stage = (Stage) checkoutButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/CheckoutScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== featuredButton){
        	stage = (Stage) featuredButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/FeaturedScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== contactButton){
        	stage = (Stage) contactButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/ContactScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== designButton){
        	stage = (Stage) designButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== updateButton){
        	stage = (Stage) updateButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/InfoScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
    	if(event.getSource()== reviewButton){
        	stage = (Stage) reviewButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/ReviewScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        	}
        	

    }


}
