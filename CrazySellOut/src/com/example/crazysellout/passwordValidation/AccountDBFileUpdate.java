package com.example.crazysellout.passwordValidation;

import java.io.IOException;
import java.io.InputStream;

import com.example.crazysellout.AccountData;

public class AccountDBFileUpdate {
	String[] fileOnTable;
	
	//Constructor
	public AccountDBFileUpdate(InputStream iStream) throws IOException {
		super();
		
		//Calling the class AccountTXTReader that reads the text file
		//and return a table with all the rows of the text.
		AccountTXTReader atxtr = new AccountTXTReader(iStream);
		fileOnTable = atxtr.fileOnTable;
	}
	
	public String accountFileUpdate(AccountData newaccount){
		addNewRowOnTable(newaccount);
		
		//Prints the content of the file (with the new row)
		//it is used only for check.
		for(int i=0;i<fileOnTable.length; i++)
			System.out.println(fileOnTable[i]);
		
		return "";
	}
	
	//Method that inserts the new account data to the data member 'fileOnTable'
	public void addNewRowOnTable(AccountData newaccount){
		String username = newaccount.username;
		String password = newaccount.password;
		String actype = newaccount.accountType;

		String combinedElements = actype + " " + username + " " + password;
		String fileToString = "";
		
		for(int i=0; i<fileOnTable.length; i++){
			fileToString += fileOnTable[i] + "\n";
		}
		fileToString += combinedElements + "\n";
		
		splitDataToTable(fileToString);
	}
	
	public void splitDataToTable(String stringData){
		fileOnTable = stringData.split("\r\n|\r|\n");
	}

	
}
