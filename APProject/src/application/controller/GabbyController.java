package application.controller;
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
import application.model.CustomerData;

/**
 * This class will represent the GabbyController which will implement the EventHandler
 * interface, and any events that occur when the user interacts with MainScene.fxml and
 * the CreateScene.fxml.
 *
 * @author Gabby Mariello vsc775
 * UTSA CS 3443 - Group Project
 * Fall 2019
 * 
 */
public class GabbyController{
    @FXML
    private Label userIdError;

    @FXML
    private Label userPasswordError;

    @FXML
    private TextField userID;
    
    @FXML
    private Button loginButton;

    @FXML
    private Button createButton;
    
    @FXML
    private PasswordField userPassword;
    
    @FXML
    void Login(ActionEvent event) throws Exception {
    	Parent root;
    	Stage stage;
    	String Password = userPassword.getText();
    	int i = 0;
    	CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	alotOfScrunch2019.ID = userID.getText();
    	userIdError.setText("Unknown user ID or Password");
    	if(event.getSource()==loginButton){
    		for(int j=0; j < alotOfScrunch2019.customerArrayList.size(); j++)
    		{
    			if(alotOfScrunch2019.ID.equals(alotOfScrunch2019.customerArrayList.get(j).getUserID()) && Password.equals(alotOfScrunch2019.customerArrayList.get(j).getUserPassword())){
    				i = 1;
    				break;
    			}
    		}
    		if(i == 1)
    		{
    			stage = (Stage) loginButton.getScene().getWindow();
    			root = FXMLLoader.load(getClass().getResource("/application/view/MainScene.fxml"));
    			Scene scene = new Scene(root);
    	        stage.setScene(scene);
    	        stage.show();
    		}
    	}
    	else{
    		stage = (Stage) createButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/application/view/CreateScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    	}	
        
    }
    
}
