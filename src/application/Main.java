package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/SelectServiceView.fxml"));

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
// Netflix data base from https://www.kaggle.com/datasets/shivamb/netflix-shows
// Disney data base from https://www.kaggle.com/datasets/shivamb/disney-movies-and-tv-shows
// Prime Video data base from https://www.kaggle.com/datasets/shivamb/amazon-prime-movies-and-tv-shows
// Hulu data base from https://www.kaggle.com/datasets/shivamb/hulu-movies-and-tv-shows
