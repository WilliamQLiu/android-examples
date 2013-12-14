package com.williamqliu.learnandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

// public means this class is accessible by other classes
// When you extend a class (i.e. Activity class), you can use the class
public class Splash extends Activity{

	MediaPlayer ourSong;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		// Get ready to play Music, need to setup first
		ourSong = MediaPlayer.create(Splash.this, R.raw.zoidbergsound);
		
		// Will use our preferences to determine whether to play loading music or not
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);  // Need key/filepath of "checkbox" (see under Prefs XML), default = true
		if(music==true)
			ourSong.start();  // Starts the song, but don't want it to carry over to next class - under onPause, kill

		
		Thread timer = new Thread(){
			public void run(){
				try{
					//Sleep for 5 seconds
					sleep(1000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					// Create intent to open action
					Intent openMainActivity = new Intent("com.williamqliu.learnandroid.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();  // Song is released when paused
		finish();  // Finishes activity
	}

	
	
}
