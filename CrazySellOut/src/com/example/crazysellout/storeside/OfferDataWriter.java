package com.example.crazysellout.storeside;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.example.crazysellout.Offer;

public class OfferDataWriter {
	
	public void addOffer(Offer newOffer)
	{
		try{
			
			FileOutputStream fout = new FileOutputStream("res/drawable/offers", true);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(newOffer);
			
			oos.close();
		}
		catch(Exception e){
			
			
		}
	}

}
