package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FromDirectory {
	
	public List<RetrieveData> FromDirectory(String fileName) {
		List<RetrieveData> streaming = new ArrayList<>();
		
		
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
				String line = reader.readLine();
				
				for (int i = 0; i < 20; i++){
					
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
