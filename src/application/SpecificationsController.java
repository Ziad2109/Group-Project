package application;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

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
    private Label title;

    @FXML
    private Label genre;

    @FXML
    private Label year;

    @FXML
    private Label resultsLabel;

    @FXML
    private Label service;
    
   

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
    	
    	List<String> results = StreamDirectory.getResults();
    	List<String> yearValue = StreamDirectory.getYear();
    	
    	
    	//value =  Stream(String.valueOf(viewType), String.valueOf(yearReleased),String.valueOf(maturityRating), String.valueOf(genre), String.valueOf(streamingService));
    	if (streamingService.equals("Netflix"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre));
    	else if(streamingService.equals("Disney+"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre));
    	else if (streamingService.equals("Hulu"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre));
    	else if (streamingService.equals("Prime"))
    		System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre));

    	
    	if (results.isEmpty()) resultsLabel.setText("No results found, please adjust specifications");
    	
    	else {
    		resultsLabel.setText(String.format(results.size()+ " Result Found"));
    		title.setText(String.format(results.get(Random(results.size()))));
    		results.remove(1);
    		year.setText(String.format(yearValue.get(Random(yearValue.size()))));
    		 
    		
    	}
    }



	private int Random(int size) {
		// TODO Auto-generated method stub
		return 0;
	}
    

}
