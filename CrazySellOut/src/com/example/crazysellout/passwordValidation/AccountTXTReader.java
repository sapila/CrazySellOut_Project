package com.example.crazysellout.passwordValidation;

import android.accounts.Account;

public class AccountTXTReader {
	String logInDBFilePath;
	
	public boolean dbFileExists(){
		
		return false;
	}
	
	public boolean accountExistsInDAO(Account account){
	
		return false;
	}
	
	public String getAccountType(Account account){
		
		return "";	
	}
	
	
	
}
