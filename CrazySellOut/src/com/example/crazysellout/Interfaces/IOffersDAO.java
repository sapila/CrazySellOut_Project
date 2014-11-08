package com.example.crazysellout.Interfaces;

import java.util.List;

import com.example.crazysellout.Offer;

//Interface for the DAO communication.
public interface IOffersDAO {
	
	boolean isDAOActive();
	List <Offer> getOffersList();
	void addOfferToDAO(Offer newOffer);
}
