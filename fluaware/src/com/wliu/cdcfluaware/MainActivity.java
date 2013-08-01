package com.wliu.cdcfluaware;


import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{


	private RelativeLayout section1;	// Section 1
	private RelativeLayout section2;	// Section 2
	private RelativeLayout section3;	// Section 3
	private RelativeLayout section4;	// Section 4
	private RelativeLayout section5;	// Section 5
	public List<Message> messages;
	private ProgressDialog dialog;
	private Handler mHandler = new Handler();
 
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        
        // Setup & Load
        setContentView(R.layout.main);
        
        section1 = (RelativeLayout) findViewById(R.id.section1RelativeLayout);
        section1.setOnClickListener(this);
        section2 = (RelativeLayout) findViewById(R.id.section2RelativeLayout);
        section2.setOnClickListener(this);
        section3 = (RelativeLayout) findViewById(R.id.section3RelativeLayout);
        section3.setOnClickListener(this);
        section4 = (RelativeLayout) findViewById(R.id.section4RelativeLayout);
        section4.setOnClickListener(this);
        section5 = (RelativeLayout) findViewById(R.id.section5RelativeLayout);
        section5.setOnClickListener(this);
       
    }
    
	// Implementing Clicking
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		case R.id.section1RelativeLayout:  // What is the Flu - Learn Flu Facts
			//Toast.makeText(this, "Section 1", Toast.LENGTH_SHORT).show();
			Intent myIntent = new Intent(MainActivity.this, SectionOne.class);
			MainActivity.this.startActivity(myIntent);
			break;
		case R.id.section2RelativeLayout:  // How to Fight the Flu - Instructions
			Intent myIntent2 = new Intent(MainActivity.this, SectionTwo.class);
			MainActivity.this.startActivity(myIntent2);
			break;
		case R.id.section3RelativeLayout:  // Flu News - Podcasts
			
		
			dialog = ProgressDialog.show(MainActivity.this, "", "Loading, Please wait...", true);
			//dialog.setIndeterminate(true);
			dialog.setCancelable(true);
			
			new Thread(new Runnable(){
				public void run(){

					mHandler.post(new Runnable(){
						public void run(){
							try{
								
								Intent myIntent3 = new Intent(MainActivity.this, SectionThree.class);  // Working
								MainActivity.this.startActivity(myIntent3);	// Working
								
							}catch (Throwable t){
		    				Toast.makeText(MainActivity.this, "Error Loading, check Internet connection ", Toast.LENGTH_SHORT).show();

		    				}
    				
						}
						
					});
					dialog.dismiss();
					
				}
			}).start();
		
			break;
		case R.id.section4RelativeLayout:   // Flu Vaccine Locator - Find a nearby clinic
			Intent myIntent4 = new Intent(MainActivity.this, SectionFour.class);
			MainActivity.this.startActivity(myIntent4);
			break;
		case R.id.section5RelativeLayout:	// Additional Resources - Link to CDC Web Site
			Intent myIntent5 = new Intent(MainActivity.this, SectionFive.class);
			MainActivity.this.startActivity(myIntent5);
			break;

		default:	// Do nothing
			break;
		}
		
	}
	
	
	@Override
	public void onResume()
	{
		super.onResume();
		
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
	}
	
    @Override
    protected void onStart() {
        super.onStart();
     }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
                
    }
	
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add("Art by Dora Chin | Code by William Liu");
		// Display in menu
	return true;
	}
	
}
