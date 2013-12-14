package com.wliu.android.quiz5;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {
	
	private Button countUpButton;
	private TextView lastCountTextView;
	private Button countDownButton;
	private Button aboutButton;
	private TextView countTextView;
	private Button resetButton;
	private TextView lastResetTextView;
	private Button showCalculatorButton;
	private int count=0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        countUpButton = (Button) findViewById(R.id.countUpButton);
        countUpButton.setOnClickListener(this);
        
        lastCountTextView = (TextView) findViewById(R.id.lastCountTextView);
        lastCountTextView.setOnClickListener(this);
        
        countDownButton = (Button) findViewById(R.id.countDownButton);
        countDownButton.setOnClickListener(this);
        
        aboutButton = (Button) findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(this);
        
        countTextView = (TextView) findViewById(R.id.countTextView);
        countTextView.setOnClickListener(this);
        
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        
        lastResetTextView = (TextView) findViewById(R.id.lastResetTextView);
        lastResetTextView.setOnClickListener(this);
        
        showCalculatorButton = (Button) findViewById(R.id.showCalculatorButton);
        showCalculatorButton.setOnClickListener(this);
        
        countTextView.setText("" + count);
                
    }

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.aboutButton:
			Intent aboutIntent = new Intent(this, AboutActivity.class);
			startActivity(aboutIntent);
			break;
		
		case R.id.countUpButton:
			count++;
			lastCountTextView.setText("Last Count: " + new java.util.Date().toString());
			countTextView.setText("" + count);
			break;
		
		case R.id.countDownButton:
			count--;
			lastCountTextView.setText("Last Count: " + new java.util.Date().toString());
			countTextView.setText("" + count);
			break;
		
		case R.id.resetButton:
			AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
			alert.setTitle("Confirm Reset");
			alert.setMessage("Are you sure you want to reset count?");
			alert.setPositiveButton(android.R.string.ok, 
				new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						Log.i("Demo", "which: " + which);
						count=0;
						lastResetTextView.setText("Last Reset: " + new java.util.Date().toString());
						countTextView.setText("" + count);
					}
				});
			alert.setNegativeButton(android.R.string.cancel, 
				new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						Log.i("Demo", "which: " + which);							
					}
				});
			alert.show();
			break;
			
		case R.id.showCalculatorButton:
			Intent calculatorIntent = new Intent();
			calculatorIntent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
			startActivity(calculatorIntent);
			break;
		
		default:
			break;
		}
		
	}
}