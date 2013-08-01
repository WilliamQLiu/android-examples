package com.wliu.cdcfluaware;


/*
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.wliu.cdcfluaware.R;

public class ParsingXML extends Activity{
		
        @Override
        public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.sectiontest);
                
                TextView myText = (TextView) findViewById(R.id.textView1);

		try{
			//URL url = new URL("http://www.anddev.org/images/tut/basic/parsingxml/example.xml");
			URL url = new URL("http://www.cdc.gov/flu/weekly/flureport.xml");
			//	static String feedUrlInfluenzaPodcasts = "http://www2c.cdc.gov/podcasts/searchandcreaterss.asp?topic=flu"; // RSS Feed of Influenza Podcasts
			//	static String feedUrl = "http://www.cdc.gov/flu/weekly/flureport.xml";
			//static String feedUrlInFluenzaUpdates = "http://www2c.cdc.gov/podcasts/createrss.asp?t=r&c=20"; // RSS Feed of Influenza updates
			
		
		
		// Get a SAX Parser from the SAXParserFactory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		
		// Get the XMLReader of the SAXParser we created
		XMLReader xr = sp.getXMLReader();
		
		// Create a new ContentHandler and apply it to the XML-Reader
		ExampleHandler myExampleHandler = new ExampleHandler();
		xr.setContentHandler(myExampleHandler);
		
		// Parse the XML-data from our URL
		xr.parse(new InputSource(url.openStream()));
		// Parsing has finished
		
		// Our ExampleHandler now provides the parsed data to us
		ParsedExampleDataSet parsedExampleDataSet = myExampleHandler.getParsedData();
		
		// Set the result to be displayed in our GUI
		myText.setText(parsedExampleDataSet.toString());
		}
		
		catch (Exception e){
		  // Display an error
		}
		//this.setContentView(myText);
		
		


	}
        
}*/