package com.williamqliu.learnandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener{

	EditText sendET;
	Button start, startFor;
	TextView gotAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		sendET = (EditText) findViewById(R.id.etSend);
		start = (Button) findViewById(R.id.bSA);
		startFor = (Button) findViewById(R.id.bSAFR);
		gotAnswer = (TextView) findViewById(R.id.tvGot);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()){
		
		// Button to Start Activity - want to pass data
		case R.id.bSA:
			String bread = sendET.getText().toString();  // Our EditText converted to String
			Bundle basket = new Bundle();
			basket.putString("key", bread);  // Putting String into Basket - putString(key, value), key is the file name and value is what we're passing
			Intent a = new Intent(Data.this, OpenedClass.class);  // Say where our data is from and going to
			a.putExtras(basket);  // Putting this Bundle of data with the Activity
			startActivity(a);
			break;
		case R.id.bSAFR:
			Intent i = new Intent(Data.this, OpenedClass.class);			
			startActivityForResult(i, 0);
			break;
		}
		
	}

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK){
			Bundle basket = data.getExtras();  // Get bundle of data
			String s = basket.getString("answer");  // Reference our key
			gotAnswer.setText(s);  // Set text
		}
	}
	
	
	

}
