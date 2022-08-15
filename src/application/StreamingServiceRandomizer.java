package application;

import java.util.concurrent.ThreadLocalRandom;

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
    	
    	String genre = String.valueOf(genreChoiceBox.getValue());
    	System.out.println("Genre selected: "+ genre);
    	
    	String streamingService = String.valueOf(streamingServiceChoiceBox.getValue());
    	System.out.println("Prefered streaming service: "+ streamingService);
    	
    	
    	StreamDirectory value = new StreamDirectory();
    	ThreadLocalRandom random = ThreadLocalRandom. current(); 
    	int rand1;
    	int rand2;
    	int rand3;
    	//value =  Stream(String.valueOf(viewType), String.valueOf(yearReleased),String.valueOf(maturityRating), String.valueOf(genre), String.valueOf(streamingService));
    	if (streamingService.equals("Netflix")) {
        	value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre);
        	rand1 = random. nextInt(1, value.streaming.size());
        	rand2 = random. nextInt(1, value.streaming.size());
        	rand3 = random. nextInt(1, value.streaming.size());
        	System.out.println(value.streaming.size());
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre).get(rand2));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre).get(rand3));
    	}
    	else if(streamingService.equals("Disney+")) {
        	rand1 = random. nextInt(1, value.streaming.size());
        	rand2 = random. nextInt(1, value.streaming.size());
        	rand3 = random. nextInt(1, value.streaming.size());
    		System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
			System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre).get(rand2));
			System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre).get(rand3));
    	}
    	else if (streamingService.equals("Hulu")) {
        	rand1 = random. nextInt(1, value.streaming.size());
        	rand2 = random. nextInt(1, value.streaming.size());
        	rand3 = random. nextInt(1, value.streaming.size());
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre).get(rand2));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre).get(rand3));
    	}
    	else {
        	rand1 = random. nextInt(1, value.streaming.size());
        	rand2 = random. nextInt(1, value.streaming.size());
        	rand3 = random. nextInt(1, value.streaming.size());
    		System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
			System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre).get(rand2));
			System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre).get(rand3));
    	}
    	// Display result in the window
//    	threeRandomizedSuggestionsLabel.setText(String.format("Your three choices are: CSI Miami, NCIS, House"));
    	//threeRandomizedSuggestionsLabel.setText(String.format("Your three choices are: CSI Miami, NCIS, House"));
    	

    }

}
