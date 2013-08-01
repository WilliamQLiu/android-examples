package com.wliu.cdcfluaware;

import android.net.Uri;

import android.os.Bundle;
//'Section Three' is for "Flu News - Listen to Podcasts"

import java.util.ArrayList;
import java.util.List;



import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SectionThree extends ListActivity {

	public List<Message> messages;
	//private List<Message> messages;  // Working
    //private TextView text1;
	

	@Override
    public void onCreate(Bundle icicle) {
		
        setContentView(R.layout.sectionsix);
        super.onCreate(icicle);

		
        //setContentView(R.layout.row);
        //text1 = (TextView) findViewById(R.id.TextView01);
        //text1 = (TextView) findViewById(R.id.textView1);
        
        loadFeed(ParserType.ANDROID_SAX);  // Load 
        //loadFeed(ParserType.SAX);  // Load 
        

        
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		//Intent viewMessage = new Intent(Intent.ACTION_VIEW, Uri.parse(messages.get(position).getLink().toExternalForm()));
		String myString = messages.get(position).getLink().toString();	// Raw Data (e.g., http://www2c.cdc.gov/podcasts/download.asp?af=h&f=10109), we want http://www2c.cdc.gov/podcasts/player.asp?f=8520
		String part1 = myString.substring(0, 43);  // Gets http://www2c.cdc.gov/podcasts/download.asp?
		String part2 = myString.substring(48);  // Gets remaining after "f="...
		//Toast.makeText(getApplicationContext(), part1 + part2, Toast.LENGTH_SHORT).show();
		myString = part1 + part2;
		
    	//Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(myString));  // Working
		Intent intent = new Intent(Intent.ACTION_VIEW).setDataAndType(Uri.parse(myString), "audio/*");

		startActivity(intent);

	
	}
	
	

	// Feed for RSS
	private void loadFeed(ParserType type){
		try{
	    	FeedParser parser = FeedParserFactory.getParser(ParserType.ANDROID_SAX);	// Was this
    		//FeedParser parser = FeedParserFactory.getParser(ParserType.SAX);
	    	messages = parser.parse();
	    	
	    	// DISPLAY - Set up List, gets ready to display to layout
	    	List<String> titles = new ArrayList<String>(messages.size());
	    	
	    	
	    	// Shows no line between each object
    		//getListView().setDivider(null)
	    	//List<String> fluactivity = new ArrayList<String>(messages.size());
	    	
	    	for (Message msg : messages){
	    		
	    		titles.add("\nPodcast: " + msg.getTitle() + "\n\nDescription: " + msg.getDescription() + "\n");

	    	}
	    	
	    	// Original - Working
	    	//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, titles);
	    	//this.setListAdapter(adapter);
	    	
	    	setListAdapter(new ArrayAdapter<String>(this, R.layout.row, titles));

    	} catch (Throwable t){
    		//Log.e("Error on Feed",t.getMessage(),t);
    		Toast.makeText(SectionThree.this, "Podcasts failed to load.  Please check your Internet connection and retry.", Toast.LENGTH_LONG).show();
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

}
	