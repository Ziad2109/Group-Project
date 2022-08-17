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
    	/**
    	 * method to refresh all the labels in the FXML file
    	 * to an empty string
    	 */
    	resultsLabel.setText("");
    	year.setText("");
    	title.setText("");
    	service.setText("");
    	specificationsErrorLabel.setText("");
    	
	}
    
    private void SetErrorLabel (String text) {
    	specificationsErrorLabel.setText("Please specifify " + text);
    }

    @FXML
    void createRecommendations(ActionEvent event) {
    	
    	refresh(); //call refresh method
   	 	
    	/**
    	 * gets values from the user 
    	 * 
    	 */
    	String yearReleased = String.valueOf(releaseYearChoiceBox.getValue());
    	String viewType = String.valueOf(typeChoiceBox.getValue());
    	String maturityRating = String.valueOf(maturityChoiceBox.getValue());
    	String genre = String.valueOf(genreChoiceBox.getValue());
    	
    	
    	if (typeChoiceBox.getValue() == null) 
    		//checks if the typeChoiceBox is empty
    		SetErrorLabel ("media type");
    	
    	else if (genreChoiceBox.getValue() == null)
    		//checks if the genreChoiceBox is empty
    		SetErrorLabel ("genre");
    	
    	else if (maturityChoiceBox.getValue() == null)
    		//checks if the maturityChoiceBox is empty
    		SetErrorLabel ("media type");
    	
    	else if (releaseYearChoiceBox.getValue() == null)
    		//checks if the releaseYearChoiceBox is empty & changes
    		SetErrorLabel ("year range");
    	
    	else { 
    		
    		refresh();
    	
	    	System.out.println("Movie or Tv Show: "+ viewType);
	    	System.out.println("Year of release: "+ yearReleased);
	    	System.out.println("Genre selected: "+ genre);
	    	System.out.println("Maturity rating selected: "+ maturityRating);
	    	
	    	
	    	String streamingService = SelectServiceController.tikChoice;
	    	System.out.println("Streaming Service: "+ streamingService);
	    	
	    	StreamDirectory value = new StreamDirectory();	//Create new object of StreamDirectory class named "value"
	    	
	    	String filePath = ""; 
	    	
	    	
	    	if (SelectServiceController.tikChoice.equals("Netflix")) filePath = "src/application/Netflix.csv";
	    	else if(SelectServiceController.tikChoice.equals("Disney+")) filePath = "src/application/Disney+.csv";
	    	else if (SelectServiceController.tikChoice.equals("Hulu")) filePath = "src/application/Hulu.csv";
	    	else if (SelectServiceController.tikChoice.equals("Prime")) filePath = "src/application/Amazon Prime.csv";
	    	
	    	/**
	    	 * 
	    	 * 
	    	 */
	    	System.out.println("Result: "+ value.FromDirectory(filePath,viewType,yearReleased,maturityRating,genre));
	    	
	    	ArrayList<String> titleList = value.getTitleList();
	    	ArrayList<String> yearList = value.getYearList();
	    	
	    	/**
	    	 * use of conditions to read titleList from StreamDirectory  
	    	 * if titleList is empty: true -> it will display an error message that there are no results
	    	 * else -> count the number or elements in the arraylist using titlelist.size and display number or results
	    	 * 			adjust labels to display a results
	    	 */

			 if (titleList.isEmpty())  resultsLabel.setText("No results found, please adjust specifications"); 
			
			 else {
			 	Random rand = new Random();
				 int upperbound = titleList.size();
				 int RandomIndex = rand.nextInt(upperbound);
				 
				 /**
				  * a new concept i learned: getting a random number
				  * to run a random 
				  * 
				  */
				
				resultsLabel.setText(String.format(titleList.size()+ " Result Found"));
					
				title.setText(String.format(titleList.get(RandomIndex))); // the randomIndex integer picks a random integer using the random class
				year.setText(String.format(yearList.get(RandomIndex))); // year label is adjusted to get the same random index as the title
				service.setText(String.format("On " + streamingService)); // streaming service label is according to first class
		 	}
	
	    }
    }
}
