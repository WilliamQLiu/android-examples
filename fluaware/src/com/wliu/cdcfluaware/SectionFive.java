package com.wliu.cdcfluaware;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

//'Section Five' is for "Additional Resources - Visit the CDC Web Site"
public class SectionFive extends Activity implements OnClickListener {

	private RelativeLayout section1;	// Section 1
	private RelativeLayout section2;	// Section 2
	private RelativeLayout section3;	// Section 3
	private RelativeLayout section4;	// Section 4


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sectionfive);

        section1 = (RelativeLayout) findViewById(R.id.RelativeLayout01);
        section1.setOnClickListener(this);
        //section1.getBackground().setColorFilter(Color.GREEN, Mode.MULTIPLY);
        section2 = (RelativeLayout) findViewById(R.id.RelativeLayout02);
        section2.setOnClickListener(this);
        section3 = (RelativeLayout) findViewById(R.id.RelativeLayout03);
        section3.setOnClickListener(this);
        section4 = (RelativeLayout) findViewById(R.id.RelativeLayout04);
        section4.setOnClickListener(this);

		
	}
	
	// Implementing Clicking
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.RelativeLayout01:  // Go to Web Site
			try{
				Toast.makeText(getApplicationContext(), "Loading CDC's web site", Toast.LENGTH_SHORT).show();
				Uri uri = Uri.parse("http://www.cdc.gov");
				Intent myIntent5 = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(myIntent5);
			}catch (Throwable t){
				Toast.makeText(getApplicationContext(), "Error Loading, check Internet connection ", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.RelativeLayout02:  // Call the CDC's Info Line
		case 1:  // Call the CDC  1-800-232-4636
			Toast.makeText(getApplicationContext(), "Calling the CDC's Information Line", Toast.LENGTH_SHORT).show();
			try {
			    Intent callIntent = new Intent(Intent.ACTION_CALL);
			    callIntent.setData(Uri.parse("tel:18002324636"));
			    startActivity(callIntent);
			} catch (ActivityNotFoundException activityException) {
			    //Log.e("Call failed", "Call failed", e);
				Toast.makeText(getApplicationContext(), "Call Failed, Please Try Again", Toast.LENGTH_LONG).show();
		    }
			break;
		case R.id.RelativeLayout03:  // Subscribe for Text Messages
			Toast.makeText(getApplicationContext(), "Subscribing to CDC Text Messages", Toast.LENGTH_SHORT).show();
			SmsManager sm = SmsManager.getDefault();
			sm.sendTextMessage("87000", null, "HEALTH", null, null);
			break;
		case R.id.RelativeLayout04:   // Unsubscribe from Text Messages
			Toast.makeText(getApplicationContext(), "Unsubscribing to CDC Text Messages", Toast.LENGTH_SHORT).show();
			SmsManager sm2 = SmsManager.getDefault();
			sm2.sendTextMessage("87000", null, "STOP", null, null);
			break;
		default:	// Do nothing
			break;
		}
		
	}
		
	/*
	final CharSequence[] items = {"Visit the CDC Web Site (http://www.cdc.gov)", "Call the CDC (1-800-CDC-INFO)", "Subscribe to Text Messages from the CDC", "Unsubscribe to Text Messages from the CDC"};

	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	builder.setCancelable(true);	// Allow AlertDialog to be canceled
	builder.setIcon(R.drawable.icon);
	builder.setTitle("For Additional Resources, would you like to...");
	
	builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener(){

		public void onClick(DialogInterface dialog, int item) {
			// TODO Auto-generated method stub
	        //Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
			
			switch(item){
				case 0:  // Web Site
				Toast.makeText(getApplicationContext(), "Loading CDC's web site", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
				Uri uri = Uri.parse("http://www.cdc.gov");
				Intent myIntent5 = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(myIntent5);
				break;
				case 1:  // Call the CDC  1-800-232-4636
				Toast.makeText(getApplicationContext(), "Calling the CDC", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
				try {
				    Intent callIntent = new Intent(Intent.ACTION_CALL);
				    callIntent.setData(Uri.parse("tel:18002324636"));
				    startActivity(callIntent);
				} catch (ActivityNotFoundException activityException) {
				    //Log.e("Call failed", "Call failed", e);
					Toast.makeText(getApplicationContext(), "Call Failed", Toast.LENGTH_SHORT).show();
			    }
				break;
				case 2:  // Subscribe for for text messages
				Toast.makeText(getApplicationContext(), "Subscribing to CDC Text Messages", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
				SmsManager sm = SmsManager.getDefault();
				sm.sendTextMessage("87000", null, "HEALTH", null, null);
				break;
				case 3:  // Unsubscribe from text messages
				Toast.makeText(getApplicationContext(), "Unsubscribing to CDC Text Messages", Toast.LENGTH_SHORT).show();
				dialog.dismiss();
				SmsManager sm2 = SmsManager.getDefault();
				sm2.sendTextMessage("87000", null, "STOP", null, null);
				break;
				default: // Default
				dialog.dismiss();
				break;
			}
		}
	});
	
	
	/*
	// Setup Go Button
	builder.setPositiveButton("GO", new DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			dialog.dismiss();
			
		}
	});*/
	/*
	// Setup Cancel Button
	builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			dialog.dismiss();
			
		}
	});
	
	AlertDialog alert = builder.create();
	alert.show();
	}
	*/
	

}
