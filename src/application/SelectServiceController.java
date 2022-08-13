package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SelectServiceController implements Initializable{
	
	private Stage stage;
	private Scene scene;

    @FXML
    private CheckBox huluCheckBox;

    @FXML
    private ImageView primeImage;

    @FXML
    private ImageView huluImage;

    @FXML
    private CheckBox netflixCheckBox;

    @FXML
    private CheckBox primeCheckBox;

    @FXML
    private ImageView netflixImage;

    @FXML
    private ImageView disneyImage;

    @FXML
    private CheckBox disneyCheckBox;
    
    @Override 
    public void initialize (URL url, ResourceBundle rb) {
    	
    	Image disneyLogo = new Image (getClass().getResourceAsStream("/resources/disney-icon.png"));
    	disneyImage.setImage(disneyLogo);
    	
    	Image netflixLogo = new Image (getClass().getResourceAsStream("/resources/netflix-icon.png"));
    	netflixImage.setImage(netflixLogo);
    	
    	Image primeLogo = new Image (getClass().getResourceAsStream("/resources/prime-icon.png"));
    	primeImage.setImage(primeLogo);
    	
    	Image huluLogo = new Image (getClass().getResourceAsStream("/resources/hulu-icon.png"));
    	huluImage.setImage(huluLogo);
    }
    
    public void switchToSpecifications (ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/fxmlFiles/SpecificationsView.fxml"));
    	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene (root);
    	stage.setScene(scene);
    	stage.show();
    	
    }

	public Stage applicationStage;

    @FXML
    void serviceSelected(ActionEvent event) throws IOException {
    	
    	if (!netflixCheckBox.isSelected() 
    		&& !disneyCheckBox.isSelected()
    		&& !primeCheckBox.isSelected()
    		&& !huluCheckBox.isSelected()) {
    		;
    	} else {
    		if (netflixCheckBox.isSelected()&& !disneyCheckBox.isSelected()
    	    		&& !primeCheckBox.isSelected()
    	    		&& !huluCheckBox.isSelected()) {
    			;
    			Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/SpecificationsView.fxml"));
            	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            	scene = new Scene (root);
            	stage.setScene(scene);
            	stage.show();
    		}
    		if (disneyCheckBox.isSelected()&& !netflixCheckBox.isSelected()
    	    		&& !primeCheckBox.isSelected()
    	    		&& !huluCheckBox.isSelected()) {
    			;
    			Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/SpecificationsView.fxml"));
            	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            	scene = new Scene (root);
            	stage.setScene(scene);
            	stage.show();
    		}
    		if (primeCheckBox.isSelected()&& !disneyCheckBox.isSelected()
    	    		&& !netflixCheckBox.isSelected()
    	    		&& !huluCheckBox.isSelected()) {
    			;
    			Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/SpecificationsView.fxml"));
            	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            	scene = new Scene (root);
            	stage.setScene(scene);
            	stage.show();
    		}
    		if (huluCheckBox.isSelected()&& !disneyCheckBox.isSelected()
    	    		&& !primeCheckBox.isSelected()
    	    		&& !netflixCheckBox.isSelected()) {
    			;
    			Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/SpecificationsView.fxml"));
            	stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            	scene = new Scene (root);
            	stage.setScene(scene);
            	stage.show();
    		}
    		
    		/**
    		 * I learned this code from Bro Code on YouTube
    		 * @link https://www.youtube.com/watch?v=hcM-R-YOKkQ
    		 * 
    		 * @throws IOException -- 
    		 */
    		
    	}
 
    }

}
