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

		String storeName=null;
		String productCategory=null;
		String productName=null;
		String productPrice=null;
		String productDescription=null;
		
		offers.StoreName = storeName;		
		offers.ProductCategory = productCategory;
		offers.ProductName = productName;
		offers.ProductPrice = productPrice;
		offers.ProductDescription = productDescription;
		
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
			
		//Variable in which the contex of the file will be stored
		StringBuffer strBuffer = new StringBuffer();
		
		//Reads each line from the file.
		BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
		
		while ((stringContainer = reader.readLine()) != null) {
			strBuffer.append(stringContainer + "\n" );
		}
		iStream.close();
		textIndexOnTable(strBuffer.toString());
	}
	
	//Method that separates the string buffer to lines, and saves
	//on a table so that they can be identified as an account.
	public void textIndexOnTable(String indexOnString){
		fileOnTable = indexOnString.split("\r\n|\r|\n");
	}
	
	//Method that breaks each line of the table in offers
	public void SplitLines (String splitLinesOnTable){
		fileOnTable = splitLinesOnTable.split(" ");
	}
}