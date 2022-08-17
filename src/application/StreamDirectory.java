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

public class StreamDirectory{ 
	private ArrayList<String> titleList = new ArrayList<>();
	
	/**
	 * Getter for the titleList instance variable
	 * @returns titleList
	 */
	public ArrayList<String> getTitleList() { 
		return titleList;
		}
	
	private ArrayList<String> yearList = new ArrayList<>();
	
	/**
	 * Getter for the yearList instance variable
	 * @returns yearList
	 */
	public ArrayList<String> getYearList() {
		return yearList;
		}
	
	private int getLowerYear(String range) {
        String[] items = range.split("-");
        try {
            return Integer.parseInt(items[0]);
        } catch (Exception e) {
            if (items[0].equals("pre")) {
            	return 0;
            }
            return 2011;
        }
    }

    private int getUpperYear(String range) {
        String[] items = range.split("-");
        
        try {
            Integer.parseInt(items[0]);
            return Integer.parseInt(items[1]);
        } catch (Exception e) {
        	if (items[0].equals("pre")) {
            	return 1979;
            }
            return 9999;
        }
    }
	public List<Stream> FromDirectory(String fileName, String type, String year, String rating, String genre) {
		List<Stream> streaming = new ArrayList<>();
		
		
		
		int lowerYear = getLowerYear(year);
        int upperYear = getUpperYear(year);
        System.out.println(lowerYear);
        System.out.println(upperYear);
        
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
				String line = reader.readLine();
				titleList.clear(); // empties the resultsList everytime the user presses the button
				yearList.clear(); // emptiers the yearLisr
				
				while(line!=null){
					
					String[] details = line.split(",");
					
					if (year == null) break;
					
					if (details.length==0) {
						
					}
					//only adds the movies/shows that meet the choices requirements
					else if (details[1].equals(type)) {
						int currentYear = Integer.parseInt(details[3]);
						if	(currentYear >= lowerYear && currentYear <= upperYear) {
							if (details[4].equals(rating)) {
								if (details[5].equals(genre)) {
									Stream movie = createStream(details);
									streaming.add(movie);
									titleList.add(details[2]);
									yearList.add(details[3]);
								}
							}
						}	
					}
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
