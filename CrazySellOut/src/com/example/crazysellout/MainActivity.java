package com.example.crazysellout;

import com.example.crazysellout.StoreSide.StoreSideActivity;
import com.example.crazysellout.UserSide.UserSideActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

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
		//userside activity.
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

}
