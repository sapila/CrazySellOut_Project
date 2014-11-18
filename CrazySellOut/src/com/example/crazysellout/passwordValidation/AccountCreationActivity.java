package com.example.crazysellout.passwordValidation;

import java.io.InputStream;

import com.example.crazysellout.R;
import com.example.crazysellout.R.layout;
import com.example.crazysellout.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AccountCreationActivity extends Activity {

	//inputStream tou arxeiou p exei ta account kai einai stic gia na mei to 
	//pername sinexeia apo sinartisi se sinartisi
	public static InputStream accountsDbFile = null; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_creation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_creation, menu);
		return true;
	}

	public void submitAccountEvent(View view){
		//set the inputStream datamember gia na einai prosbasimo kai apo alles klaseis xwris na to pernaw san orisma
		this.accountsDbFile = this.getResources().openRawResource(R.drawable.store_accounts);
		
		//Setting up the data
		EditText acName = (EditText)findViewById(R.id.editText1);
		EditText password = (EditText)findViewById(R.id.editText2);
		EditText reTypedPassword = (EditText)findViewById(R.id.editText3);
		RadioButton radioBtn1 = (RadioButton) findViewById(R.id.radio0);
		RadioButton radioBtn2 = (RadioButton) findViewById(R.id.radio1);
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1); 
		
		//Gets the selected radio button by id
		int selected = radioGroup.getCheckedRadioButtonId();
		//Checks on the radio group which radio button was selected
		RadioButton rBtnSelected = (RadioButton) findViewById(selected);
		String radioBtnText = rBtnSelected.getText().toString();
		
		//Converts the input data given by the user to string
		String acNameString = acName.getText().toString();
		String paswd = password.getText().toString();
		String rpaswd = reTypedPassword.getText().toString();
		
		
	}
}
