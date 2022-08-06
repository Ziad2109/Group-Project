package application;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List; 

/**
* Simple Java program to read CSV file in Java. In this program we will read 
* list of streaming stored in CSV file as comma separated values. * 
* @author WINDOWS 8 
* 
*/ 

public class StreamDirectory { 
	
	public static void main(String[] args) { 
		List<Stream> streaming = readstreamingFromCSV("Directory.csv");
		// let's print all the person read from CSV file
	}


	public static List<Stream> readstreamingFromCSV(String fileName) { 
		List<Stream> streaming = new ArrayList<>(); 
		Path pathToFile = Paths.get(fileName); 

		// create an instance of BufferedReader 
		// using try with resource, Java 7 feature to close resources 
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 

			// read the first line from the text file 
			String line = br.readLine(); 

			// loop until all lines are read 
			while (line != null) { 

				// use string.split to load a string array with the values from 
				// each line of 
				// the file, using a comma as the delimiter 
				String[] attributes = line.split(","); 

				Stream book = createStream(attributes); 

				// adding book into ArrayList 
				streaming.add(book);

				// read next line before looping 
				// if end of file reached, line would be null 
				line = br.readLine();
			} 
		} catch (IOException ioe) { 
			ioe.printStackTrace(); 
		} 
		return streaming;
	} 

	private static Stream createStream(String[] metadata) { 
		String type = metadata[1]; 
		String title = metadata[2]; 
		String year = metadata[3];
		String rating = metadata[4];
		String category = metadata[5];
		String streamingService = metadata[6];
		
		// create and return book of this metadata
		return new Stream(type, year, rating, category, streamingService); 
	}
}

class Stream { 
	private String type; 
	private String title; 
	private String year;
	private String rating;
	private String category;
	private String streamingService;

	public Stream(String type, String year, String rating, String category, String streamingService) {
		
		
		for (Stream b : StreamDirectory.readstreamingFromCSV("Directory.csv")) { 
			System.out.println(b);
		} 
		
		this.type = type;
		this.year = year;
		this.rating = rating;
		this.category = category;
		this.streamingService = streamingService;

	}

	public String getName() { 
		return title;
	}

	public void setName(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getYear() { 
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStreamingService() {
		return streamingService;
	}

	public void setStreamingService(String streamingService) {
		this.streamingService = streamingService;
	}

	@Override 
	public String toString() {
		return "Movie type is : "+type+", year: "+year; 

	} 

}
