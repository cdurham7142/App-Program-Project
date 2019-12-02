package application.controller;
import application.model.CustomerData;
import application.model.Customers;
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
    	Customers currentCustomer = alotOfScrunch2019.getCustomerFromID(alotOfScrunch2019.ID);
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
    	Result.setText("");
    	Result.appendText( "Orders for: " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
    	Result.appendText( "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for(int i = 0; i <= currentCustomer.getOrderArrayList().size() - 1; i++)
		{
			Result.appendText("\nOrder ID: " + currentCustomer.getOrderArrayList().get(i).getOrderID());
			Result.appendText( "\n--------------------------------------------------------");
			Result.appendText( "\nOrder is currently in " + currentCustomer.getOrderArrayList().get(i).getCurrentLocation() + " stage at: " + currentCustomer.getOrderArrayList().get(i).getTime());
			Result.appendText( "\nThe size of the order is " + currentCustomer.getOrderArrayList().get(i).getQuantity());
			Result.appendText( "\nThe frabic type of the order is  " + currentCustomer.getOrderArrayList().get(i).getFabricType());
			Result.appendText( "\nThe material color of the order is " + currentCustomer.getOrderArrayList().get(i).getFabricColor());
			Result.appendText( "\nThe price of the order is");
			Result.appendText( "\nThe refund status of the order is ");
			Result.appendText( "\n--------------------------------------------------------");
		}
    }
    

}


