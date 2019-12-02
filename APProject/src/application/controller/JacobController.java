package application.controller;
import application.model.CustomerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
public class JacobController
{
	 @FXML
	    private Button menuButton;
	 @FXML
	    private Button helpButton;

    @FXML
    private TextArea Result;

    @FXML
    void handle(ActionEvent event) throws Exception
    {
    	CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	System.out.println(alotOfScrunch2019.ID);
    	Stage stage;
    	Parent root;
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
        		
            
		//for(int j=0; j < alotOfScrunch2019.customerArrayList.size(); j++)
		//{
			//if(globalID.equals(alotOfScrunch2019.customerArrayList.get(j).getUserID()));
				//Result.appendText(alotOfScrunch2019.customerArrayList.get(j).getFirstName());
		//}
    }
    

}


