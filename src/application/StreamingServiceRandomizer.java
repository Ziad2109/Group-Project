package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StreamingServiceRandomizer {

    @FXML
    private ChoiceBox<?> yearReleasedChoiceBox;

    @FXML
    private ChoiceBox<?> viewTypeChoiceBox;

    @FXML
    private ChoiceBox<?> maturityRatingChoiceBox;
    
    @FXML
    private Label threeRandomizedSuggestionsLabel;
    
    @FXML
    private ChoiceBox<?> streamingServiceChoiceBox;

    @FXML
    private ChoiceBox<?> genreChoiceBox;
    
    @FXML
    void calculateOptions(ActionEvent event) {
    	
    	String yearReleased = String.valueOf(yearReleasedChoiceBox.getValue());
    	System.out.println("Year of release: "+ yearReleased);
    	
    	String viewType = String.valueOf(viewTypeChoiceBox.getValue());
    	System.out.println("Movie or Tv Show: "+ viewType);
    	
    	String maturityRating = String.valueOf(maturityRatingChoiceBox.getValue());
    	System.out.println("Maturity rating selected: "+ maturityRating);
    	
    	String streamingService = String.valueOf(streamingServiceChoiceBox.getValue());
    	System.out.println("Prefered streaming service: "+ streamingService);
    	
    	String genre = String.valueOf(genreChoiceBox.getValue());
    	System.out.println("Genre selected: "+ genre);
    	
    	StreamDirectory value = new StreamDirectory();
    	//value =  Stream(String.valueOf(viewType), String.valueOf(yearReleased),String.valueOf(maturityRating), String.valueOf(genre), String.valueOf(streamingService));
    	if (streamingService.equals("Netflix"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre));
    	else if(streamingService.equals("Disney+"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre));
    	else if (streamingService.equals("Hulu"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre));
    	else
    		System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre));
    	// Display result in the window
    	threeRandomizedSuggestionsLabel.setText(String.format("Your three choices are: CSI Miami, NCIS, House"));
    	

    }

}
