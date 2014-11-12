package com.example.crazysellout;


import java.io.IOException;
import java.io.InputStream;

import com.example.crazysellout.UserSide.UserSideActivity;
import com.example.crazysellout.passwordValidation.AccountTXTReader;
import com.example.crazysellout.storeside.StoreSideActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity {
	
	//inputStream tou arxeiou p exei ta account kai einai stic gia na mei to 
	//pername sinexeia apo sinartisi se sinartisi
	public static InputStream accountsDbFile = null; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//On button click event (Show Offers Button) starts the userSide activity.
	public void showOffersOnClick(View view){
		
		//Intent, function that initializes to intent variable the opening of the 
		//user side activity.
		Intent intent = new Intent(this, UserSideActivity.class);
		//starts the new UserSideActivity
		startActivity(intent);
		
	}
	
	//Starts StoreSideActivity on SubmitOffer button press
	public void submitOffersOnclick (View view)
	{
		Intent intent = new Intent(this, StoreSideActivity.class);
		startActivity(intent);
			
	}
	
	public void submitPassword(View view) throws IOException{
		
		//set the inputStream datamember gia na einai prosbasimo kai apo alles klaseis xwris na to pernaw san orisma
		this.accountsDbFile = this.getResources().openRawResource(R.drawable.store_accounts);
		
		//peroume ta data apo ta editText tou view
		EditText usernameEditText = (EditText)findViewById(R.id.editText1);
		EditText passwordEditText = (EditText)findViewById(R.id.editText2) ;
		
		//fortonoume ta data sto antikeimeno
		AccountData inputAccount = new AccountData();
		inputAccount.username = usernameEditText.getText().toString();
		inputAccount.password = passwordEditText.getText().toString();
		
		//pername to inputAccount ston controller gia to logIn
		LogInViewController viewController = new LogInViewController();
		String logInType = viewController.logIn(inputAccount,this);  //epistrefei an egine kanonika log in i ipirxe kapoio problima
		
		if(logInType == "error") //throws error message //if log is not successful
		{
			
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(this, viewController.logInErrorMessage, duration);
			toast.show();
			
			
			
			
		}else{ 
			
			if(logInType == "user")
			{
				Intent intent = new Intent(this, UserSideActivity.class);
				//starts the new UserSideActivity
				startActivity(intent);
				
			} else{
				
				//Starts StoreSideActivity
				Intent intent = new Intent(this, StoreSideActivity.class);
				startActivity(intent);
			}
			
		}
		
		/*AccountTXTReader atr = new AccountTXTReader();
		InputStream iStream = this.getResources().openRawResource(R.drawable.store_accounts);

		//You must always call the method that reads the file before you
		//do any of the checks in AccountTXTReader.
		try {
			atr.readDataFile(iStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//check if the account exists and print it to log cat
		AccountData acd = new AccountData();
		acd.username = "gkaleri12";
		acd.password = "123456akfb";
		boolean check = atr.accountExistsInDAO(acd);
		System.out.println("Check Result : "+check);
	    
		String acType = atr.getAccountType(acd);
		System.out.println("Account Type : "+acType);*/
		
	}
	

}
