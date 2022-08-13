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
    	
    	Object yearReleased = yearReleasedChoiceBox.getValue();
    	System.out.println("Year of release: "+ yearReleased);
    	
    	Object viewType = viewTypeChoiceBox.getValue();
    	System.out.println("Movie or Tv Show: "+ viewType);
    	
    	Object maturityRating = maturityRatingChoiceBox.getValue();
    	System.out.println("Maturity rating selected: "+ maturityRating);
    	
    	String streamingService = String.valueOf(streamingServiceChoiceBox.getValue());
    	System.out.println("Prefered streaming service: "+ streamingService);
    	
    	Object genre = genreChoiceBox.getValue();
    	System.out.println("Genre selected: "+ genre);
    	
    	StreamDirectory value = new StreamDirectory();
    	//value =  Stream(String.valueOf(viewType), String.valueOf(yearReleased),String.valueOf(maturityRating), String.valueOf(genre), String.valueOf(streamingService));
    	if (streamingService.equals("Netflix"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv"));
    	else if(streamingService.equals("Disney+"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv"));
    	else if (streamingService.equals("Hulu"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv"));
    	else
    		System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv"));
    	//treeRandomizedChoices = String[] myStringArray = {"a", "b", "c"};
    	//System.out.println("Your three choices are: CSI Miami, NCIS, House" );
    	// Display result in the window
    	threeRandomizedSuggestionsLabel.setText(String.format("Your three choices are: CSI Miami, NCIS, House"));
    	

    }

}