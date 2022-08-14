package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class SpecificationsController {

    @FXML
    private ChoiceBox<?> releaseChoiceBox;

    @FXML
    private ChoiceBox<?> typeChoiceBox;

    @FXML
    private ChoiceBox<?> maturityChoiceBox;

    @FXML
    private ChoiceBox<?> genreChoiceBox;

    @FXML
    void createRecommendations(ActionEvent event) {
    	
    	
    	String yearReleased = String.valueOf(releaseChoiceBox.getValue());
    	System.out.println("Year of release: "+ yearReleased);
    	
    	String viewType = String.valueOf(typeChoiceBox.getValue());
    	System.out.println("Movie or Tv Show: "+ viewType);
    	
    	String maturityRating = String.valueOf(maturityChoiceBox.getValue());
    	System.out.println("Maturity rating selected: "+ maturityRating);
    	
    	String genre = String.valueOf(genreChoiceBox.getValue());
    	System.out.println("Genre selected: "+ genre);
    	
    	//
    	//streamingService = tixbox choice
    	
    	
    	
    	String streamingService = SelectServiceController.tikChoice;
    	
    	StreamDirectory value = new StreamDirectory();
    	
    	//value =  Stream(String.valueOf(viewType), String.valueOf(yearReleased),String.valueOf(maturityRating), String.valueOf(genre), String.valueOf(streamingService));
    	if (streamingService.equals("Netflix"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre));
    	else if(streamingService.equals("Disney+"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre));
    	else if (streamingService.equals("Hulu"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre));
    	else if (streamingService.equals("Prime"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre));
    }

}
