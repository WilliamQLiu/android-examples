package com.wliu.finalquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class GraphicsActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    GraphicsView graphicsView = new GraphicsView(this);
	    setContentView(graphicsView);
	    }
	
    public boolean onTouchEvent(MotionEvent event){
    	finish();
    	return true;
	}

}
