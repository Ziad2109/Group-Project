package application;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
    	title.setText("");
    	year.setText("");
    	resultsLabel.setText("");
    	
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
    	System.out.println("Prefered streaming service: "+ streamingService);

    	
    	StreamDirectory value = new StreamDirectory();
    	
    	List<String> results = StreamDirectory.getResults();
    	List<String> yearValue = StreamDirectory.getYear();
    	
    	
    	ThreadLocalRandom random = ThreadLocalRandom. current(); 
    	int rand1;
    	int n = 3;
    	//value =  Stream(String.valueOf(viewType), String.valueOf(yearReleased),String.valueOf(maturityRating), String.valueOf(genre), String.valueOf(streamingService));
    	if (streamingService.equals("Netflix")) {
        	System.out.println(value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre));
        	if (value.streaming.isEmpty());
        	else {
        		if (value.streaming.size()<3) {
        			n = value.streaming.size();
        		}
        	for(int i = 0;i<n;i++) {
            	rand1 = random. nextInt(1, value.streaming.size());
        		resultsLabel.setText(String.format(results.size()+ " Result Found"));
        		title.setText(String.format(results.get(rand1)));
        		results.remove(1);
        		year.setText(String.format(yearValue.get(rand1)));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Netflix.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
        	}
        	}
    	}
    	else if(streamingService.equals("Disney+")) {
    		service.setText("On Disney+");
        	value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre);
        	if (value.streaming.isEmpty());
        	else {
        		if (value.streaming.size()<3) {
        			n = value.streaming.size();
        		}
        	for(int i = 0;i<n;i++) {
            	rand1 = random. nextInt(1, value.streaming.size());
        		resultsLabel.setText(String.format(results.size()+ " Result Found"));
        		title.setText(String.format(results.get(rand1)));
        		results.remove(1);
        		year.setText(String.format(yearValue.get(rand1)));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Disney+.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
        	}
        	}
    	}
    	else if (streamingService.equals("Hulu")) {
    		service.setText("Hulu");
        	value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre);
        	if (value.streaming.isEmpty());
        	else {
        		if (value.streaming.size()<3) {
        			n = value.streaming.size();
        		}
        	for(int i = 0;i<n;i++) {
            	rand1 = random. nextInt(1, value.streaming.size());
        		resultsLabel.setText(String.format(results.size()+ " Result Found"));
        		title.setText(String.format(results.get(rand1)));
        		results.remove(1);
        		year.setText(String.format(yearValue.get(rand1)));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Hulu.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
        	}
        	}
    	}
    	else {
    		service.setText("Amazon Prime");
        	value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre);
        	if (value.streaming.isEmpty());
        	else {
        		if (value.streaming.size()<3) {
        			n = value.streaming.size();
        		}
        	for(int i = 0;i<n;i++) {
            	rand1 = random. nextInt(1, value.streaming.size());
        		resultsLabel.setText(String.format(results.size()+ " Result Found"));
        		title.setText(String.format(results.get(rand1)));
        		results.remove(1);
        		year.setText(String.format(yearValue.get(rand1)));
    		System.out.println("Result: "+ value.FromDirectory("src/application/Amazon Prime.csv",viewType,yearReleased,maturityRating,genre).get(rand1));
        	}
        	}
    	}
    	
    	if (results.isEmpty()) resultsLabel.setText("No results found, please adjust specifications");
    }



	private int Random(int size) {
		// TODO Auto-generated method stub
		return 0;
	}
    

}
