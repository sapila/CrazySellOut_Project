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
		
		System.out.println(logInType);
		
		if(logInType == "error") //throws error message //if log is not successful
		{
			
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(this, viewController.logInErrorMessage, duration);
			toast.show();

		}else{ 
			
			if(logInType.equals("user"))
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

	}

}
