package com.example.crazysellout;

import java.io.IOException;

import android.content.Context;

import com.example.crazysellout.passwordValidation.AccountDAO;

public class LogInViewController {

	String logInErrorMessage = "";
	
	//check if DAOexists if account exists in DAO and return accountType
	//else returns error to the controller and sets the logInErrorMassege
	public String logIn(AccountData inputAccount,Context context) throws IOException
	{
		AccountDAO acDAO = new AccountDAO();
		String error = "error"; 
		
		if(acDAO.isDAOActive()) //if DAO is Active 
		{
				if(acDAO.accountExistsInDAO(inputAccount)) //if account exist in DAO
				{
					
					//anagkastiki epanafortosi tou arxeiou
					LogInActivity.accountsDbFile = context.getResources().openRawResource(R.drawable.store_accounts);
					return acDAO.getAccountType(inputAccount); //return accountType
					
				}else{
					this.logInErrorMessage = "Wrong account information. \n Check username or password.";
					return error;
				}
	
		}else{
			this.logInErrorMessage = "Database not accessible";
			return error;
		}
		
		
	}
	public String getLogInErrorMessage()
	{
		
		return this.logInErrorMessage;
	}
}
