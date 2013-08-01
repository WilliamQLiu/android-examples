package com.wliu.cdcfluaware;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


//'Section Two' is for "How to Fight the Flu - 3 Simple Steps"
public class SectionTwo extends Activity implements OnClickListener{

	
	MediaPlayer mPlayer;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sectiontwo);
		
		// Setup tabhost
		TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
		tabHost.setup();

		// Setup Tab 1
		TabSpec spec1=tabHost.newTabSpec("Step 1");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("",getResources().getDrawable(R.drawable.section2tab1));
		//spec1.setIndicator("Step 1",getResources().getDrawable(R.drawable.section1tab1));
		//spec1.setIndicator("Step 1");

		// Setup Tab 2
		TabSpec spec2=tabHost.newTabSpec("Step 2");
		spec2.setContent(R.id.tab2);
		//spec2.setIndicator("STEP 2",getResources().getDrawable(R.drawable.section2tab2_wash));
		spec2.setIndicator("", getResources().getDrawable(R.drawable.section2tab2wash));
		//spec2.setIndicator("STEP 2");
		
		// Setup Tab 3
		TabSpec spec3=tabHost.newTabSpec("Step 3");
		spec3.setContent(R.id.tab3);
		spec3.setIndicator("",getResources().getDrawable(R.drawable.section2tab3));
		//spec3.setIndicator("STEP 3");

		// Add tabs
		tabHost.getTabWidget().setDividerDrawable(R.drawable.line);
		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		
		///
		mPlayer = MediaPlayer.create(this, R.raw.washhands);
    	//mPlayer = MediaPlayer.create(this, R.raw.washhands);

    	/*try {
			mPlayer.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Button myButton = (Button)findViewById(R.id.button1);
        myButton.setOnClickListener(this);
		Button myButton2 = (Button)findViewById(R.id.button2);
        myButton2.setOnClickListener(this);
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
    	
		switch (v.getId()){
		case R.id.button1:  // Play button
			try {
				
				//mPlayer = MediaPlayer.create(this, R.raw.washhands);
				mPlayer.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mPlayer.start();
			break;
		case R.id.button2:  // Stop button
			try{
			mPlayer.stop();
			mPlayer.reset();
			mPlayer.release();
			mPlayer = MediaPlayer.create(this, R.raw.washhands);
			} catch(IllegalStateException e){
				//
			}
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
		mPlayer.stop();
		mPlayer.reset();
		mPlayer.release();
		mPlayer = MediaPlayer.create(this, R.raw.washhands);

	    // The activity is no longer visible (it is now "stopped")
	            
	}

	@Override
	protected void onDestroy() {
	    super.onDestroy();
		mPlayer.stop();
		mPlayer.reset();
		mPlayer.release();

    
	    // The activity is about to be destroyed.
	    
	}
}


	/*
	public void onClick(View v) {
		// TODO Auto-generated method stub
		MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.washhands);

		switch (v.getId()){
		case R.id.button1:	
			try {
				mPlayer.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mPlayer.start();
		break;
		default:	// Do nothing
		break;
		}
		
	}
}
	/*
		
		Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, SectionTwoOne.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("artists").setIndicator("Artists", res.getDrawable(R.drawable.icon)).setContent(intent);
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, SectionTwoOne.class);
	    spec = tabHost.newTabSpec("albums").setIndicator("Albums", res.getDrawable(R.drawable.icon)).setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, SectionTwoOne.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Songs", res.getDrawable(R.drawable.icon)).setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(2);
	    */

/*

private void onPlay(boolean start) {
       if (start) {
           startPlaying();
       } else {
           stopPlaying();
       }
   }

   private void startPlaying() {
       mPlayer = new MediaPlayer();
       try {
           mPlayer.setDataSource(mFileName);
           mPlayer.prepare();
           mPlayer.start();
       } catch (IOException e) {
           Log.e(LOG_TAG, "prepare() failed");
       }
   }

   private void stopPlaying() {
       mPlayer.release();
       mPlayer = null;
   }

   class PlayButton extends Button {
       boolean mStartPlaying = true;

       OnClickListener clicker = new OnClickListener() {
           public void onClick(View v) {
               onPlay(mStartPlaying);
               if (mStartPlaying) {
                   setText("Stop playing");
               } else {
                   setText("Start playing");
               }
               mStartPlaying = !mStartPlaying;
           }
       };

       public PlayButton(Context ctx) {
           super(ctx);
           setText("Start playing");
           setOnClickListener(clicker);
       }
   }

   @Override
   public void onPause() {
       super.onPause();
       if (mRecorder != null) {
           mRecorder.release();
           mRecorder = null;
       }

       if (mPlayer != null) {
           mPlayer.release();
           mPlayer = null;
       }
   }*/
