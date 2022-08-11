package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class SelectServiceController {

    @FXML
    private CheckBox netflixCheckBox;

    @FXML
    private CheckBox huluCheckBox;

    @FXML
    private CheckBox primeCheckBox;

    @FXML
    private CheckBox disneyCheckBox;

    @FXML
    void serviceSelected(ActionEvent event) {
    	if (netflixCheckBox.isSelected()) {
    		
    	}
    	
    	if (huluCheckBox.isSelected()) {
    		
    	}
    	
    	if (primeCheckBox.isSelected()) {
    		
    	}
    	
    	if (disneyCheckBox.isSelected()) {
    		
    	}

    }

}
