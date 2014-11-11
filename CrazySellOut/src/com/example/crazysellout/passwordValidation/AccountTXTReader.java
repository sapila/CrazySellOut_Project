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
	
	public boolean accountExistsInDAO(AccountData account){
		for(int i=0; i<fileOnTable.length; i++){
			if((fileOnTable[i].contains(account.username)) && ((fileOnTable[i].contains(account.password))))
				return true;	
		}
		
		return false;
	}
	
	public String getAccountType(AccountData account){
		
		return "";	
	}
	
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
	
	public void textIndexOnTable(String indexOnString){
		fileOnTable = indexOnString.split("\n");
	}
	
}
