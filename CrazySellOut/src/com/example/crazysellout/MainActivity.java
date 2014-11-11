package com.example.crazysellout;


import java.io.IOException;
import java.io.InputStream;

import com.example.crazysellout.UserSide.UserSideActivity;
import com.example.crazysellout.passwordValidation.AccountTXTReader;
import com.example.crazysellout.storeside.StoreSideActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
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
	
	public void submitPassword(View view){
		AccountTXTReader atr = new AccountTXTReader();
		InputStream iStream = this.getResources().openRawResource(R.drawable.store_accounts);
		
		try {
			atr.readDataFile(iStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
