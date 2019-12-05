package application.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class will represent the ChooserController which will implement the EventHandler
 * interface, and any events that occur when the user interacts with MainScene.fxml.
 *
 * @authors: Jacob De Los Santos bfn715
 * 	     Colin Durham sif159
 * UTSA CS 3443 - Group Project
 * Fall 2019
 * 
 */
public class ChooserController {

	private final static String[] names = {"Eskimo","Camoflage","Stripped","Silk","Desert","Ogee","Zebra","Swirl","Hexagon"};
    @FXML
    private static GridPane grid;
    
    private static boolean loadedImages = false;
    
    @FXML
    private Button confirmButton;

    @FXML
    void onConfirm(ActionEvent event) throws Exception {
    	Stage stage = (Stage) confirmButton.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("/application/view/MainScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void loadImages() {
    	if (loadedImages)
    		return;
    	File[] files = new File("scrunchies").listFiles();
    	List<Image> iArr = new ArrayList<Image>();
    	for (File file : files)
    		iArr.add(new Image(file.getAbsolutePath()));
    	for (int i = 0; i < files.length; i++)
    		grid.addRow(i, new ImageView(iArr.get(i)), new Label(names[i]));
    	loadedImages = true;
    }

}
