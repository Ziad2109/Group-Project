package application;

import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class SpecificationsController {

    @FXML
    private ChoiceBox<?> releaseYearChoiceBox;

    @FXML
    private ChoiceBox<?> typeChoiceBox;

    @FXML
    private ChoiceBox<?> maturityChoiceBox;

    @FXML
    private ChoiceBox<?> genreChoiceBox;
    
    @FXML
    private Label title;

    @FXML
    private Label year;

    @FXML
    private Label resultsLabel;

    @FXML
    private Label service;
    
    @FXML
    private Label specificationsErrorLabel;
    
    private void refresh() {
    	resultsLabel.setText("");
    	year.setText("");
    	title.setText("");
    	service.setText("");
    	specificationsErrorLabel.setText("");
    	
	}

    @FXML
    void createRecommendations(ActionEvent event) {
    	
    	refresh();
   	 	
    	/**
    	 * assign string variable to each user choice
    	 * 
    	 * print results of the users preferences
    	 * in console
    	 */
    	
    	
    	String yearReleased = String.valueOf(releaseYearChoiceBox.getValue());
    	String viewType = String.valueOf(typeChoiceBox.getValue());
    	String maturityRating = String.valueOf(maturityChoiceBox.getValue());
    	String genre = String.valueOf(genreChoiceBox.getValue());
    	
    	
    	if (typeChoiceBox.getValue() == null)
    		specificationsErrorLabel.setText("Specifiy media type");
    	
    	else if (genreChoiceBox.getValue() == null)
    		specificationsErrorLabel.setText("Specifiy genre");
    	
    	else if (maturityChoiceBox.getValue() == null)
    		specificationsErrorLabel.setText("Specifiy maturity level");
    	
    	else if (releaseYearChoiceBox.getValue() == null)
    		specificationsErrorLabel.setText("Specifiy year range");
    	
    	else {
    	
    	System.out.println("Movie or Tv Show: "+ viewType);
    	System.out.println("Year of release: "+ yearReleased);
    	System.out.println("Genre selected: "+ genre);
    	System.out.println("Maturity rating selected: "+ maturityRating);
    	
    	
    	String streamingService = SelectServiceController.tikChoice;
    	System.out.println("Streaming Service: "+ streamingService);
    	
    	StreamDirectory value = new StreamDirectory();	//Create new object of StreamDirectory class named "value"
    	
    	String filePath = ""; 
    	
    	//value =  Stream(String.valueOf(viewType), String.valueOf(yearReleased),String.valueOf(maturityRating), String.valueOf(genre), String.valueOf(streamingService));
    	if (SelectServiceController.tikChoice.equals("Netflix")) filePath = "src/application/Netflix.csv";
    	else if(SelectServiceController.tikChoice.equals("Disney+")) filePath = "src/application/Disney+.csv";
    	else if (SelectServiceController.tikChoice.equals("Hulu")) filePath = "src/application/Hulu.csv";
    	else if (SelectServiceController.tikChoice.equals("Prime")) filePath = "src/application/Amazon Prime.csv";
    		
    	System.out.println("Result: "+ value.FromDirectory(filePath,viewType,yearReleased,maturityRating,genre));
    	
    	ArrayList<String> titleList = value.getTitleList();
    	ArrayList<String> yearList = value.getYearList();
	    	
	   	
	 	
		 	if (titleList.isEmpty())  resultsLabel.setText("No results found, please adjust specifications");
		
		 	else {
		 		Random rand = new Random();
			 	int upperbound = titleList.size();
			 	int RandomIndex = rand.nextInt(upperbound);
		 		
			
				resultsLabel.setText(String.format(titleList.size()+ " Result Found"));
				
				title.setText(String.format(titleList.get(RandomIndex)));
				year.setText(String.format(yearList.get(RandomIndex)));
				service.setText(String.format("On " + streamingService));
		 	}
	    }
    }
}

