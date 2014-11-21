package com.example.crazysellout.UserSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.crazysellout.Offer;

//Class that, reads the file of the data.
public class OfferDataReader {
	String[] fileOnTable;
	
	Offer ReadOffer(int indexLine){
		Offer offers = new Offer();
		
		offers.StoreName = fileOnTable[0];
		offers.ProductCategory = fileOnTable[2];
		offers.ProductName = fileOnTable[3];
		offers.ProductPrice = fileOnTable[4];
		offers.ProductDescription = fileOnTable[5];
		
		return offers;
	}
	
	//initialize txt reader with the input stream to set fileOnTable
	public OfferDataReader(InputStream iStream) throws IOException {
		super();
		this.readDataFile(iStream);
	}
	
	//Method that reads the text file from resources and 
	public void readDataFile(InputStream iStream) throws IOException {
		//String that gets each line of the text file in a while loop
		String stringContainer = null;
		String strW= null;
			
		//Variable in which the contex of the file will be stored
		StringBuffer strBuffer = new StringBuffer();
		
		//Reads each line from the file.
		BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
		
		while ((stringContainer = reader.readLine()) != null) {
			strBuffer.append(stringContainer + "\n");
		}
			
		while ((strW = reader.readLine()) != null) {
				strBuffer.append(strW + " ");
		}	
	}
	
	//Method that separates the string buffer to lines, and saves
	//on a table so that they can be identified as an account.
	public void textIndexOnTable(String indexOnString){
		fileOnTable = indexOnString.split("\r\n|\r|\n");
	}
	
	public void lineInWords(String indexOnString){
		fileOnTable = indexOnString.split(" ");
	}
}