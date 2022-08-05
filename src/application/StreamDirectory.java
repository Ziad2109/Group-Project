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
		List<Stream> streaming = readstreamingFromCSV("streaming.txt"); 

		// let's print all the person read from CSV file 
		for (Stream b : streaming) { 
			System.out.println(b); 
		} 
	}


	private static List<Stream> readstreamingFromCSV(String fileName) { 
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
		String title = metadata[0]; 
		int price = Integer.parseInt(metadata[1]); 
		String author = metadata[2]; 
		
		// create and return book of this metadata
		return new Stream(title, price, author); 
	}
}

class Stream { 
	private String title; 
	private int price; 
	private String author; 

	public Stream(String title, int price, String author) { 
		this.title = title; 
		this.price = price; 
		this.author = author; 
	} 

	public String getName() { 
		return title; 
	} 

	public void setName(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() { 
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override 
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + "]"; 

	} 

}
