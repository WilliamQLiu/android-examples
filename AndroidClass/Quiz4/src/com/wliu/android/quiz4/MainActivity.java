package com.wliu.android.quiz4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private Button incrementButton;
	private Button decrementButton;
	private Button resetCountButton;
	private Button actionDialButton;
	private Button actionCallButton;
	private int count = 0;
	private TextView myCountView;
	private static final String TAG = "MainActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	Log.i(TAG, "Check 1");
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    	Log.i(TAG, "Check 2");

        setTitle("Quiz4 - CSE Class");

        Log.i(TAG, "Check 3");
                        
        myCountView = (TextView) findViewById(R.id.myCountView);
    	Log.i(TAG, "Check 4");
        Log.i(TAG, "Check 5");
        myCountView.setTextSize(24);
    	Log.i(TAG, "Check 6");
        myCountView.setText("" + count);
        Log.i(TAG, "Check 7");
    	//setContentView(myCountView);
        

    	
        incrementButton = (Button) findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(this);
        
        decrementButton = (Button) findViewById(R.id.decrementButton);
        decrementButton.setOnClickListener(this);
        
        resetCountButton = (Button) findViewById(R.id.resetCountButton);
        resetCountButton.setOnClickListener(this);
        
        actionDialButton = (Button) findViewById(R.id.actionDialButton);
        actionDialButton.setOnClickListener(this);
        
        actionCallButton = (Button) findViewById(R.id.actionCallButton);
        actionCallButton.setOnClickListener(this);
        
    }

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.incrementButton:
			count++;
			break;
		case R.id.decrementButton:
			count--;
			break;
		case R.id.resetCountButton:
			count = 0;
			break;
		case R.id.actionDialButton:
			Intent intent = new Intent(Intent.ACTION_DIAL);
			startActivity(intent);
			break;
		case R.id.actionCallButton:
			Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:12345678901"));  // A permission error shows up as any other error
			startActivity(intent2);
			break;
		default:
			break;
		}
		
        //Log.i(TAG, "Check 8");
		myCountView.setText("" + count);
	}
}