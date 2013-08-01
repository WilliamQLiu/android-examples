package com.wliu.cdcfluaware;

/*
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;


import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

//public class MessageList extends ListActivity implements OnClickListener {

public class MessageList extends ListActivity{
	
	private List<Message> messages;
	
	// Layout
	private ProgressBar progress_bar;  // Progress bar
	private TextView loadingTextView;	// Loading TextView
	
	
	
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // setContentView(R.layout.main);  - Working
        // loadFeed(ParserType.ANDROID_SAX);
      

        // Setup & Load
        setContentView(R.layout.sectionthree);
        loadingTextView = (TextView) findViewById(R.id.loadingTextView);
        progress_bar = (ProgressBar) findViewById(R.id.progressBar1);

        
        loadFeed(ParserType.ANDROID_SAX);
        
        // Finish Loading
        // Make Progress Bar Invisible
        progress_bar.setVisibility(ProgressBar.INVISIBLE);
        loadingTextView.setText("Complete");
        
    }
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, ParserType.ANDROID_SAX.ordinal(), ParserType.ANDROID_SAX.ordinal(), R.string.android_sax);
		// menu.add(Menu.NONE, ParserType.SAX.ordinal(), ParserType.SAX.ordinal(), R.string.sax);
		// menu.add(Menu.NONE, ParserType.DOM.ordinal(), ParserType.DOM.ordinal(), R.string.dom);
		// menu.add(Menu.NONE, ParserType.XML_PULL.ordinal(), ParserType.XML_PULL.ordinal(), R.string.pull);
		return true;
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		super.onMenuItemSelected(featureId, item);
		ParserType type = ParserType.values()[item.getItemId()];
		ArrayAdapter<String> adapter = 	(ArrayAdapter<String>) this.getListAdapter();
		if (adapter.getCount() > 0){
			adapter.clear();
		}
		this.loadFeed(type);
		return true;
	}
	
	

	
	//@Override
	//protected void onListItemClick(ListView l, View v, int position, long id) {
	//	super.onListItemClick(l, v, position, id);
	//	Intent viewMessage = new Intent(Intent.ACTION_VIEW, Uri.parse(messages.get(position).getLink().toExternalForm()));
	//	this.startActivity(viewMessage);
	//}
	
	
	private void loadFeed(ParserType type){

    	try{
    		Log.i("AndroidNews", "ParserType="+type.name());
	    	FeedParser parser = FeedParserFactory.getParser(type);
	    	long start = System.currentTimeMillis();
	    	messages = parser.parse();
	    	long duration = System.currentTimeMillis() - start;
	    	Log.i("AndroidNews", "Parser duration=" + duration);
	    	String xml = writeXml();
	    	Log.i("AndroidNews", xml);
	    	
	    	// DISPLAY - Set up List, gets ready to display to layout
	    	List<String> abbrev = new ArrayList<String>(messages.size());
	    	for (Message msg : messages){
	    		//titles.add(msg.getTitle()); // Original with 'titles' instead of 'abbrev'
	    		//abbrev.add(msg.getAbbrev());  // Get State
	    		//abbrev.add(msg.getColor());	// Get Color
	    		
	    		abbrev.add("State: " + msg.getAbbrev() + " = " + msg.getColor() + " " + msg.getTimePeriod());
	    		
	    	}
	    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, abbrev);
	    	this.setListAdapter(adapter);
    	} catch (Throwable t){
    		Log.e("AndroidNews",t.getMessage(),t);
    	}
    }
    
	
	private String writeXml(){
		XmlSerializer serializer = Xml.newSerializer();
		StringWriter writer = new StringWriter();
		try {
			serializer.setOutput(writer);
			serializer.startDocument("UTF-8", true);
			serializer.startTag("", "messages");
			serializer.attribute("", "number", String.valueOf(messages.size()));
			
			for (Message msg: messages){
			//	serializer.startTag("", "message");
			//	serializer.attribute("", "date", msg.getDate());
			//	serializer.startTag("", "title");
			//	serializer.text(msg.getTitle());
			//	serializer.endTag("", "title");
			//	serializer.startTag("", "url");
			//	serializer.text(msg.getLink().toExternalForm());
			//	serializer.endTag("", "url");
			//	serializer.startTag("", "body");
			//	serializer.text(msg.getDescription());
			//	serializer.endTag("", "body");
			//	serializer.endTag("", "message");
			//}
			//for (Message msg: messages){
			//	serializer.startTag("", "message");
				
				
				//Test
			//	serializer.startTag("", "timeperiod");	// Testing
			//	serializer.getFeature("number");
			//	Log.i("Will News", "Get Feature " + serializer.getFeature("number"));
			//	serializer.text(msg.getTimePeriod());
			//	serializer.endTag("", "timeperiod");				
			//	//End Test
			
				
				//serializer.attribute("", "date", msg.getDate());
				serializer.startTag("", "abbrev");	// Was 'Title'
				serializer.text(msg.getAbbrev());
				serializer.endTag("", "abbrev");
				serializer.startTag("", "color");	// Was 'URL'
				serializer.text(msg.getColor());
				serializer.endTag("", "color");
				serializer.startTag("", "label");	// Was 'Description'
				serializer.text(msg.getLabel());
				serializer.endTag("", "label");
				serializer.endTag("", "message");
			}			
			serializer.endTag("", "messages");
			serializer.endDocument();
			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
*/