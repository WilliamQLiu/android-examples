package com.demo.android.flashlight;


import android.app.Activity;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.hardware.Camera;


public class FlashLightActivity extends Activity {

	//Tag testing: private static final String TAG = "Flashlight";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        //Testing Tags
        //Tag testing: Log.i(TAG, "Info");
        //Tag testing: Log.w(TAG, "Warn");
        //Tag testing: Log.e(TAG, "Error");
        //Tag testing: Log.d(TAG, "Debug");
        //Tag testing: Log.v(TAG, "Verbose");
       
        Camera mCamera = Camera.open();
        Camera.Parameters params = mCamera.getParameters();
        
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        
        
        //setParameters(Camera.Parameters.FLASH_MODE_TORCH);
       
        
        //Set Background Color to White
        View view = new View(this);
        view.setBackgroundColor(Color.WHITE);

        // Get rid of title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        //Increase to max brightness
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = 1;
        getWindow().setAttributes(lp);
        
        setContentView(view);
        
        
//		Testing PowerManager Class        
//      PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//      PowerManager.WakeLock w1 = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Wake Lock tag");
        
        

    }
    
}