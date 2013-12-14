package com.williamqliu.learnandroid;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener{
	
	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	final static int cameraData = 0;
	Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		
		// Setup bitmap to be icon
		InputStream is = getResources().openRawResource(R.drawable.icon);
		bmp = BitmapFactory.decodeStream(is);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById (R.id.ivReturnedPic);
		ib = (ImageButton) findViewById (R.id.ibTakePic);
		b = (Button) findViewById (R.id.bSetWall);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
	}
	
	// Determine what was clicked
	public void onClick(View v){
		switch(v.getId()){
		case R.id.bSetWall:  // Set wallpaper
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.ibTakePic: // Take Picture
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  // Referring to the action name
			startActivityForResult(i, cameraData);  // Get data back (picture taken)
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){  // Just for safety
			Bundle extras = data.getExtras();  // Collect the extras from the data
			bmp = (Bitmap) extras.get("data");  // Key reference 'data'
			iv.setImageBitmap(bmp);
		}
	}
	
	

}
