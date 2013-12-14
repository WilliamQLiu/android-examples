package com.wliu.finalquiz;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        String[] rowNames = { "Flashlight", "About - Alert Dialog", "Hello Toast", "Count", "Graphics"};
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rowNames);
        
        getListView().setAdapter(aa);
        getListView().setBackgroundColor(0xffff0000); // Alpha, Red, Green, Blue
        
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id){
    	super.onListItemClick(l, v, position, id);
    	Intent intent;
    	switch(position){
    	case 0:
    		intent = new Intent(this, FlashLightActivity.class);
    		startActivity(intent);
    		break;
    	case 1:  // AboutActivity - About Me
    		intent = new Intent(this, AboutActivity.class);
    		startActivity(intent);
    		break;
    	case 2:  // Creating a Toast within the case
    		Context context = getApplicationContext();
    		CharSequence text = "Hello toast!";
    		int duration = Toast.LENGTH_LONG;
    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
    		// Shorter Version of Toast
    		// Toast.makeText(MainActivity.this, "This is my toast", Toast.LENGTH_LONG).show();
    		break;
    	case 3:  // CountActivity
    		intent = new Intent(this, CountActivity.class);
    		startActivity(intent);
    		break;
    	case 4:  // GraphicsActivity	   		
    		intent = new Intent(this, GraphicsActivity.class);
    		startActivity(intent);
    		break;
    	default:
    		break;
    	
    	}
    }
}