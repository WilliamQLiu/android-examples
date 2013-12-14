package com.wliu.finalquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;


public class AboutActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
		AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this);
		builder.setTitle("About this App");
		builder.setMessage("This starts the About Activity.  This app was created by William Liu on 10/28/2010");
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
				
			}
		});
		builder.create();
		builder.show();
		
	}

}
