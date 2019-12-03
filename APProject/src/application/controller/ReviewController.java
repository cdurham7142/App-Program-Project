package application.controller;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * This class will represent the ReviewController which will implement the EventHandler
 * interface, and any events that occur when the user interacts with ReviewScene.fxml.
 *
 * @author Renae Bergen rui026
 * UTSA CS 3443 - Group Project
 * Fall 2019
 * 
 */
public class ReviewController {

    @FXML
    private ButtonBar ButtonBar;

    @FXML
    private Button Cancel;

    @FXML
    private Button Post;

    @FXML
    private TextField usernamebox;

    @FXML
    private TextArea reviewbox;

    @FXML
    private TextArea postfeed;

	 @FXML
	 private Button menuButton;

	 @FXML
	 private Button helpButton;

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
		 if(event.getSource()== helpButton){
			 stage = (Stage) helpButton.getScene().getWindow();
			 root = FXMLLoader.load(getClass().getResource("/application/view/FAQScene.fxml"));
			 Scene scene = new Scene(root);
			 stage.setScene(scene);
			 stage.show();
     		}
	 }//end of handle function
    
    @FXML
    void postButton(ActionEvent event) throws IOException {
    	String usernameinput = usernamebox.getText();
    	String userreview = reviewbox.getText();
    	
    	postfeed.appendText(usernameinput + "\n");
    	postfeed.appendText("-------------------------------------------------\n");
    	postfeed.appendText(userreview + "\n");
    	postfeed.appendText("-------------------------------------------------\n");
	postfeed.appendText("\n");
         
		/*
		 * try (BufferedWriter bw = new BufferedWriter(new FileWriter("reviews.txt",
		 * true))) { bw.write(usernamebox.getText()); bw.newLine();
		 * bw.write(reviewbox.getText()); } catch (IOException e) { e.printStackTrace();
		 * }
		 */
    	
    }//end of postButton function
    
    
    @FXML
    void cancelButton(ActionEvent event) throws IOException {
    	
    	usernamebox.clear();
    	reviewbox.clear();
    }//end of cancelButton function
    
  
    	
  


}
