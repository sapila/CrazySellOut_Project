package com.example.crazysellout.UserSide;

import java.io.FileReader;
import java.util.List;

import com.example.crazysellout.Offer;
import com.example.crazysellout.Interfaces.IOffersDAO;

public class UserSideViewController implements IOffersDAO{
	
	//This method communicates with the model and bring the data 
	//and returns the offers to the UserSideActivity.
	public String GetOffers()
	{
		
		return "";
	}

	@Override
	public boolean isDAOActive() throws Exception 
	{
		FileReader fr;
				
		try {
			fr = new FileReader("myfile.txt");
		}
				
		catch(IOException exc) {
			System.out.println("Can not open file!");
			return false;
		}
		BufferReader bf = new BufferedReader(fr);
		
		getOffersList();		
		
			
	}

	@Override
	 public List<Offer> getOffersList() 
	{
		
		OfferDataReader odr = new OfferDataReader();
		List <Offer> offer1 = (List<Offer>) new Offer();
		offer1 = (List<Offer>) odr.ReadOffer();
		return offer1;
	}

	@Override
	public void addOfferToDAO(Offer newOffer) {
		// TODO Auto-generated method stub
		
	}
	
}
