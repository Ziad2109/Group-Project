package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Directory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "src/application/Directory.csv";
		String line = "";
		
		try {
			try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
				while((line = reader.readLine()) != null) {
					System.out.println(line);
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
