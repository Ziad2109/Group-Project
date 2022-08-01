package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class StreamingServiceRandomizer {

    @FXML
    private ChoiceBox<?> yearReleasedChoiceBox;

    @FXML
    private ChoiceBox<?> viewTypeChoiceBox;

    @FXML
    private ChoiceBox<?> maturityRatingChoiceBox;

    @FXML
    private ChoiceBox<?> streamingServiceChoiceBox;

    @FXML
    private ChoiceBox<?> genreChoiceBox;

    @FXML
    void calculateOptions(ActionEvent event) {
    	Object yearReleased = yearReleasedChoiceBox.getValue();
    	System.out.println("Year of release: "+ yearReleased);
    	
    	Object viewType = viewTypeChoiceBox.getValue();
    	System.out.println("Movie or Tv Show: "+ viewType);
    	
    	Object maturityRating = maturityRatingChoiceBox.getValue();
    	System.out.println("Maturity rating selected: "+ maturityRating);
    	
    	Object streamingService = streamingServiceChoiceBox.getValue();
    	System.out.println("Prefered streaming service: "+ streamingService);
    	
    	Object genre = genreChoiceBox.getValue();
    	System.out.println("Genre selected: "+ genre);
    	
    	//System.out.println("Button was pressed");
    	

    }

}
