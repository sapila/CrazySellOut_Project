package com.example.crazysellout.storeside;

import com.example.crazysellout.Offer;

public class InputFormatValidator {
	String errorMessage;
	
	//elenxos ama to inputOffer exei to sostoFormat
	public boolean isOfferValid(Offer inputOffer)
	{
		if(containsOnlyNymbersAndDot(inputOffer.productPrice) && containtOnlyChars(inputOffer.productCategory)){
			return true;
		}else{
			return false;
		 }
	}
	
	public boolean containtOnlyChars(String stringForTest)
	{
		
		return false;//ebala false apla gia na min girnaei error sto demo run
	}
	
	public boolean containsOnlyNymbersAndDot(String stringForTest)
	{
		
		try{  
			// Ελέγχω αν το όρισμα της συνάρτησης είναι double αριθμός.  
			double d = Double.parseDouble(stringForTest);  
		  }catch(NumberFormatException nfe){  
		   	return false;  
		  }  
		  return true;  
	}
	
}
