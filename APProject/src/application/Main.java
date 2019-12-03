package application;	
import application.model.CustomerData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application 
{
	public void start(Stage primaryStage) 
	{
		try 
		{
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/application/view/LoginScene.fxml"));
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
    	CustomerData alotOfScrunch2019 = CustomerData.getInstance();
    	alotOfScrunch2019.loadCustomersFile("data/customerInfo.csv");
    	alotOfScrunch2019.loadOrdersFile("data/orderInfo.csv");
		launch(args);
	}
	
}
