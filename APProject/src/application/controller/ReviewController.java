package application.controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
	 }//end of handle method
    
    	   @FXML
	   void postButton(ActionEvent event) throws IOException {
	    	//first part -> writes user input to file
	    	String line = usernamebox.getText() + "\n---------------------------------------------------\n" 
	    	+ reviewbox.getText() + "\n---------------------------------------------------\n" + "\n";
	       
	       FileWriter file_writer;
	       try {
	           file_writer = new FileWriter("reviews.txt",true);
	           BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
	           buffered_Writer.write(line);
	           buffered_Writer.flush();
	           buffered_Writer.close();

	       } catch (IOException e) {
	           System.out.println("Add line failed!!" +e);
	       }//end of write to file part
	       
	       //second part-> reads file input to textarea box
	       try
	       {
	               BufferedReader file = new BufferedReader(new FileReader("reviews.txt"));
	               String l;
	               String input = "";
	               while ((l = file.readLine()) != null) 
	               {
	            	   if(l != null) {
	            	   postfeed.appendText(l + "\n");
	                   //postfeed.setText(l);
	                   //System.out.println(l);
	            	   }
	            	   input += l + '\n';
	               }
	               FileOutputStream File = new FileOutputStream("reviews.txt");
	               File.write(input.getBytes());
	               File.flush();
	               file.close();
	               File.close();

	       } catch (Exception e){
	               System.out.println("Problem reading file.");
	       }//end of read to textarea part
	   }//end of postButton method

    @FXML
    void cancelButton(ActionEvent event) throws IOException {
    	
    	usernamebox.clear();
    	reviewbox.clear();
    }//end of cancelButton method
}//end of ReviewController class
