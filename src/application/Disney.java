package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Disney {

	public static void main(String[] args) {
		List<RetrieveData> streaming = FromDirectory("src/application/Directory/Disney.csv");
		
		for (RetrieveData b : streaming) { 
			System.out.println(b); 
		} 


	
	
}