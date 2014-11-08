package com.example.crazysellout.StoreSide;

import com.example.crazysellout.R;
import com.example.crazysellout.R.layout;
import com.example.crazysellout.R.menu;


import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;


public class StoreSideActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_side);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.store_side, menu);
		return true;
	}

	
}
