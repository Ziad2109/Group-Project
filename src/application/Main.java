package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/StreamSearch.fxml"));
			Scene scene = new Scene(root,400,400);
			VBox root = loader.load(new FileInputStream("src/application/StreamingServiceRandomizerView.fxml"));
			Scene scene = new Scene(root,581,220);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Streaming Service Randomizer");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
