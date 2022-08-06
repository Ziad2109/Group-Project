package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Directory {

	public static void main(String[] args) {
		List<RetrieveData> streaming = fromDirectory("src/application/Directory.csv");
		
		for (RetrieveData b : streaming) { 
			System.out.println(b); 
		} 
	
	}
	
	public static List<RetrieveData> fromDirectory(String fileName) {
		List<RetrieveData> streaming = new ArrayList<>();
			
		String path = "src/application/Directory.csv";
		
		
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
				String line = reader.readLine();
				
				for (int i = 0; i < 400; i++){
					
					String[] details = line.split(",");
					RetrieveData movie = createMetadata(details);
					streaming.add(movie);
					
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


	private static RetrieveData createMetadata(String[] data) {
		 String ID = data [0];
		 String type = data [1];
		 String title = data [2];
		 String year = data [3];
		 String rating = data [4];
		 String genre = data [5];
		 String service = data [6];
		
		return new RetrieveData(ID, type, title, year, rating, genre, service);
	}
}



 
class RetrieveData {
	private String ID;
	private String type;
	private String title;
	private String year;
	private String rating;
	private String genre;
	private String service;

	public RetrieveData(String ID, 
				String type, 
				String title, 
				String year, 
				String rating,
				String genre,
				String service) {
		this.setID(ID);
		this.setType(type);
		this.setTitle(title);
		this.setYear(year);
		this.setRating(rating);
		this.setGenre(genre);
		this.setService(service);
		
		
		
		}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	
	@Override 
	public String toString() {
		return "["+ ID + " ," + type + " ," + title + " ," + year + " ," + rating + " ," + genre + " ," + service +"]"; 

	}
}

	/**	
class Stream {
	
	private String ID;
	private String type;
	private String title;
	private String year;
	private String rating;
	private   String service;
	
}
	
	public Directory(String mID, 
			String mType, 
			String mTitle, 
			String mYear, 
			String mRating,
			String mService) {
		ID = mID;
		type = mType;
		title = mTitle;
		year = mYear;
		rating = mRating;
		service = mService;
		
	}
	
	void getRating () {
	
	}
	
}
*/