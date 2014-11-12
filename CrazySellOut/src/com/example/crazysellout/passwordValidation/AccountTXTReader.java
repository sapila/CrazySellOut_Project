package com.example.crazysellout.passwordValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.example.crazysellout.AccountData;

import android.accounts.Account;
import android.util.Log;
import android.widget.Toast;


public class AccountTXTReader{
	String[] fileOnTable;
	
	//Method that checks if the account exists on the file.
	public boolean accountExistsInDAO(AccountData account){
		
		for(int i=0; i<fileOnTable.length; i++){
			if((fileOnTable[i].contains(account.username)) && ((fileOnTable[i].contains(account.password))))
				return true;	
		}
		
		return false;
	}
	
	//Method that finds the row which contains the same account name 
	//an password and return the account type. If the check doesnt find
	//anything it return empty "".
	public String getAccountType(AccountData account){
		String accountType="";
		
		for(int i=0; i<fileOnTable.length; i++){
			if((fileOnTable[i].contains(account.username)) && ((fileOnTable[i].contains(account.password))))
				accountType = splitAccountType(fileOnTable[i]);
		}
		
		return accountType;	
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
	
	//Method that splits a certain account to 3 pieces and 
	//return the first part (account type).
	public String splitAccountType(String accountRow){
		String[] rowSeparated = accountRow.split(" ");
		String firstPart = rowSeparated[0];
		return firstPart;
	}
	
}
