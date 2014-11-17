package com.example.crazysellout;

import java.util.ArrayList;
import java.util.List;

import com.example.crazysellout.Interfaces.IOffersDAO;
import com.example.crazysellout.UserSide.OfferDataReader;
import com.example.crazysellout.storeside.OfferDataWriter;

//Class which communicates with the file (AT THE MOMENT TXT FILE) that contains the data.
public class OffersDAO implements IOffersDAO {

	@Override
	public boolean isDAOActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Offer> getOffersList() {
		List<Offer> offerList = new ArrayList<Offer>();
	//	OfferDataReader odr = new OfferDataReader(LogInActivity.accountsDbFile);
		
		return offerList;
	}

	@Override
	public void addOfferToDAO(Offer newOffer) {
		OfferDataWriter odw = new OfferDataWriter();
		odw.addOffer(newOffer);
	}

}
