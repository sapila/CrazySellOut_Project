package com.example.crazysellout.passwordValidation;
import com.example.crazysellout.AccountData;

import android.accounts.Account;


public class LogInInputValidator {
	public String errorMessage="";
	String[] restrictedSymbols = {"!","@","#","$","%","^","&","*","(",")","-","+","*","/"};
	
	//Method that calls the rest of the account checks and reports its
	//results to AccountCreationActivity.
	public boolean isLogInValid(AccountData account){
		boolean check = true;
		
		boolean usernameValid = isUsernameValid(account.username);
		if(usernameValid == false){
			errorMessage += "The user name you gave is invalid!\n\n";
			check = false;
		}
		boolean passwordValid = isPasswordValid(account.password);
		if(passwordValid == false){
			errorMessage += "The password you just gave is invalid!";
			check = false;
		}
		return check;
	}
	
	//Method that checks the integrity of the user name.
	public boolean isUsernameValid(String username){
		boolean check = true;

		for(int i=0; i<restrictedSymbols.length; i++){
			if(username.contains(restrictedSymbols[i]))
				check = false;
		}
		
		if(username.contains(" "))
			check = false;
		
		if(username.equals(""))
			check = false;
		
		return check;
	}
	
	//Method that checks the integrity of the the password.
	public boolean isPasswordValid(String password){
		boolean check = true;

		for(int i=0; i<restrictedSymbols.length; i++){
			if(password.contains(restrictedSymbols[i]))
				check = false;
		}
		
		if(password.contains(" "))
			check = false;
		
		if(password.equals(""))
			check = false;
		
		return check;
	}
	
	public String getErrorMessage(){
		
		return "";
	} 
	
	//Method that checks if the password and the re typed password are the same.
	public boolean passwordReTypeValidation(String passwd, String rePasswd){
		boolean check = false;
		
		if(passwd.equalsIgnoreCase(rePasswd)){
			check = true;
		}
	
		return check;
	}
	
}
