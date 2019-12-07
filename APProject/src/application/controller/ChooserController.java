package application.controller;

import application.model.CustomerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChooserController {

    @FXML
    private Button tundraButton;

    @FXML
    private Button eskimoButton;

    @FXML
    private Button stripedButton;

    @FXML
    private Button dottedButton;

    @FXML
    private Button camoflageButton;

    @FXML
    private Button zebraButton;

    @FXML
    private Button hexagonButton;

    @FXML
    private Button desertButton;

    @FXML
    void handle(ActionEvent event) throws Exception {
    	Parent root;
    	Stage stage;
    	CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	alotOfScrunch2019.patternSelection = "";
    	if(event.getSource()== tundraButton){
    		alotOfScrunch2019.patternSelection = "Tundra";
    		stage = (Stage) tundraButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	if(event.getSource()== eskimoButton){
    		alotOfScrunch2019.patternSelection = "Eskimo";
    		stage = (Stage)eskimoButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	if(event.getSource()== desertButton){
    		alotOfScrunch2019.patternSelection = "Desert";
    		stage = (Stage) desertButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	if(event.getSource()== stripedButton){
    		alotOfScrunch2019.patternSelection = "Striped";
    		stage = (Stage) stripedButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	if(event.getSource()== camoflageButton){
    		alotOfScrunch2019.patternSelection = "Camoflage";
    		stage = (Stage) camoflageButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	if(event.getSource()== hexagonButton){
    		alotOfScrunch2019.patternSelection = "Hexagon";
    		stage = (Stage) hexagonButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	if(event.getSource()== dottedButton){
    		alotOfScrunch2019.patternSelection = "Dotted";
    		stage = (Stage) dottedButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	if(event.getSource()== zebraButton){
    		alotOfScrunch2019.patternSelection = "Zebra";
    		stage = (Stage) zebraButton.getScene().getWindow();
            root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/DesignScene.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();  		
    	}
    	System.out.println(alotOfScrunch2019.patternSelection);
    	

    }

}

