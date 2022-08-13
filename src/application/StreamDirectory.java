package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 
//import java.nio.charset.StandardCharsets; 
//import java.nio.file.Files; 
//import java.nio.file.Path; 
//import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List; 

/**
* Simple Java program to read CSV file in Java. In this program we will read 
* list of streaming stored in CSV file as comma separated values. * 
* @author WINDOWS 8 
* 
*/ 

public class StreamDirectory{ 
	
	public List<Stream> FromDirectory(String fileName, String type, String year, String rating, String genre) {
		List<Stream> streaming = new ArrayList<>();
		
		
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
				String line = reader.readLine();
				int count = 0;
				//loop through csv file to read movies and shows
				while(line!=null){
					
					String[] details = line.split(",");
					if (details.length==0) {
						
					}
					//only adds the movies/shows that meet the choices requirements
					else if (details[1].equals(type)) {
							if (details[4].equals(rating)) {
								if (details[5].equals(genre)) {
									Stream movie = createStream(details);
									streaming.add(movie);
									count++;
								}
							}
						}
					//we only want 3 choices so loop is broken when count is 3
					if (count == 6)break;
					line = reader.readLine();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return streaming; 
	}

	private static Stream createStream(String[] metadata) { 
		String type = metadata[1]; 
		String title = metadata[2]; 
		String year = metadata[3];
		String rating = metadata[4];
		String genre = metadata[5];
		String streamingService = metadata[6];
		
		// create and return book of this metadata
		return new Stream(type, title, year, rating, genre, streamingService); 
	}
}

class Stream { 
	private String type; 
	private String title; 
	private String year;
	private String rating;
	private String genre;
	private String streamingService;

	public Stream(String type, String title, String year, String rating, String genre, String streamingService) {
		this.type = type;
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.genre = genre;
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
		return genre;
	}

	public void setCategory(String genre) {
		this.genre = genre;
	}

	public String getStreamingService() {
		return streamingService;
	}

	public void setStreamingService(String streamingService) {
		this.streamingService = streamingService;
	}

	@Override 
	public String toString() {
		return "Choice title is : "+title+", its is a : "+genre+", it came out in "+year+", on "+streamingService+"."; 

	} 

}
