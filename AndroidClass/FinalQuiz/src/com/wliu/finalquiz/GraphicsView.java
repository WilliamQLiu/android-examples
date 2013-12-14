package com.wliu.finalquiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class GraphicsView extends View {

	public static final String TAG = "Test";
	/** Called when the activity is first created. */
	
	
	public GraphicsView(Context context){
		super(context);
		Log.i(TAG, "Info 1");
	}
	
	protected void onDraw(Canvas canvas){

		Log.i(TAG, "Info 2");

		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawLine(0.0f, 0.0f, getWidth(), getHeight(), paint);
		paint.setColor(Color.GREEN);
		canvas.drawLine(0f, getHeight(), 100.0f, 100.0f, paint);
		String s = "getWidth(): " + getWidth() + ", getHeight(): " + getHeight();
		canvas.drawText(s, 100.0f, 100.0f, paint);
		
		Log.i(TAG, "Info 3");
		
	}

}
