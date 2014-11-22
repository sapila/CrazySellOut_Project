package com.example.crazysellout.UserSide;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.crazysellout.R;
import com.example.crazysellout.R.layout;
import com.example.crazysellout.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class UserSideActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_side);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_side, menu);
		return true;
	}
	
	public void showOffersOnclick(View view) throws ClientProtocolException, IOException
	{
		   HttpClient httpclient=new DefaultHttpClient(); 
		   HttpPost httppost=new  HttpPost("http://83.212.119.6/phpTest.php");
		   HttpResponse response = httpclient.execute(httppost);
		   String str =  EntityUtils.toString(response.getEntity());
   
		  TextView tv = (TextView)findViewById(R.id.textView1);
		  tv.setText(str);
    	
		
	}

}
