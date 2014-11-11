package com.example.crazysellout.storeside;

import com.example.crazysellout.Offer;

public class InputFormatValidator {
	String errorMessage;
	
	//elenxos ama to inputOffer exei to sostoFormat
	public boolean isOfferValid(Offer inputOffer)
	{
		
		return false;//ebala false apla gia na min girnaei error sto demo run
	}
	
	public boolean containtOnlyChars(String stringForTest)
	{
		
		return stringForTest.matches("[a-zA-Z]+");//elegxei ean to string periexei mono xarakthres kai epistrefei true h false
	}
	
	public boolean containsOnlyNymbersAndDot(String stringForTest)
	{
		
		return false;//ebala false apla gia na min girnaei error sto demo run
	}
	
}
