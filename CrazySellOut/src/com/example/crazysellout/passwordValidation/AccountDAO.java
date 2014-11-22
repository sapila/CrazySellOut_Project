package com.example.crazysellout.passwordValidation;

import java.io.IOException;

import com.example.crazysellout.AccountData;
import com.example.crazysellout.LogInActivity;

public class AccountDAO {
	
	public boolean isDAOActive(){
		
		//an to LogInActivity.accountsDbFile exei orisei tote i basi iparxei
		if(LogInActivity.accountsDbFile != null)
		{
			return true;
			
		}else{
			
			return false;
		}
	}
	
	public boolean accountExistsInDAO(AccountData account) throws IOException{
		
		AccountTXTReader txtDbReader = new AccountTXTReader(LogInActivity.accountsDbFile);
		if(txtDbReader.accountExistsInDAO(account))
		{
			return true;
		}else{
			return false;
		}
	}
	
	public String getAccountType(AccountData account) throws IOException{
		
		AccountTXTReader txtDbReader = new AccountTXTReader(LogInActivity.accountsDbFile);
		return txtDbReader.getAccountType(account);
	}
	
	
	
}
