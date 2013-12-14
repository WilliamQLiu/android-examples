package com.williamqliu.learnandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

// Can only extend one class, can implement multiple classes
public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener {

	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread, setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
		
		// How to pull from Preferences
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name", "Will is ... ");
		String values = getData.getString("list", "4");
		// If Preferences - Value 1 is set, then will take the name from EditText 
		
		if(values.contentEquals("1")){
			question.setText(et);
		}
		
		// Comment out for Start Activity - does not work with Start Activity For Result Button
		//Bundle gotBasket = getIntent().getExtras();
		//gotBread = gotBasket.getString("key");  // gotBread looks through the gotBasket for "key"
		//question.setText(gotBread);  // Set the Text View to the passed data (bread)
	}

	private void initialize() {
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		selectionList.setOnCheckedChangeListener(this);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);
		finish();

	}

	// Will display what RadioGroup was pressed and out of those, which Radio
	// Button was pressed
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.rCrazy:
			setData = "Probably right!";
			break;
		case R.id.rSexy:
			setData = "Definitely right!";
			break;
		case R.id.rBoth:
			setData = "Yep!!";
			break;
		}
		test.setText(setData);
	}
	



	
}
