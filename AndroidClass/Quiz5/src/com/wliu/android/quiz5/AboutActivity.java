package com.wliu.android.quiz5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends Activity implements OnClickListener {

	private TextView aboutTextView;
	private Button okButton;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.about);
	    
	    aboutTextView = (TextView) findViewById(R.id.aboutTextView);
	    aboutTextView.setText("Quiz 5 by William Liu \n Version 1.0 \n Copyright 2010");
	    
	    okButton = (Button) findViewById(R.id.okButton);
	    okButton.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
		case R.id.okButton:
			finish();
			return;
			default:
			break;
			
		}
		
	}

}
