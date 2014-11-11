package com.example.crazysellout.passwordValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.example.crazysellout.AccountData;

import android.accounts.Account;


public class AccountTXTReader{
	String logInDBFilePath;
	
	public boolean dbFileExists(){
		
		return false;
	}
	
	public boolean accountExistsInDAO(AccountData account){
		
		
		return false;
	}
	
	public String getAccountType(AccountData account){
		
		return "";	
	}
	
	public String readDataFile(InputStream iStream) throws IOException {
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

		return strBuffer.toString();
	}
	
	
}
