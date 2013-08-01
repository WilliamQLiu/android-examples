package com.wliu.cdcfluaware;


import java.util.ArrayList;
import java.util.List;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

// Uses AndroidSaxFeedParser
public class AndroidSaxFeedParser extends BaseFeedParser {
	
	static final String RSS = "rss";
	public AndroidSaxFeedParser(String feedUrl) {
		super(feedUrl);
	}

	public List<Message> parse() {
		final Message currentMessage = new Message();
		RootElement root = new RootElement(RSS);
		final List<Message> messages = new ArrayList<Message>();
		
		Element channel = root.getChild(CHANNEL);	// Was Channel
		Element item = channel.getChild(ITEM);
		item.setEndElementListener(new EndElementListener(){
			public void end() {
				messages.add(currentMessage.copy());
			}
		});
		item.getChild(TITLE).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setTitle(body);
			}
		});
		item.getChild(DESCRIPTION).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setDescription(body);
			}
		});
		item.getChild(LINK).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setLink(body);
			}
		});
		//item.getChild(PUB_DATE).setEndTextElementListener(new EndTextElementListener(){
		//	public void end(String body) {
		//		currentMessage.setDate(body);
		//	}
		//});
				
		//item.getChild("enclosure", "url").setEndTextElementListener(new EndTextElementListener(){
		//	public void end(String body){
		//		currentMessage.setEnclosure(body);
		//	}
		//});
		
		//Element enclosureURL = new RootElement("url", "enclosure");
		//enclosureURL.setEndElementListener(new EndTextElementListener()){
			
		
		
		
		//item.getChild(ENCLOSURE).setEndTextElementListener(new EndTextElementListener(){
		//	public void end(String body) {
		//		currentMessage.setEnclosure(body);
		//	}
		//});
		
		try {
			Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			//throw new RuntimeException(e);
		}
		return messages;
	}
	
	
}


/*
	//static final String RSS = "rss";
	static final String FLUREPORT = "flureport";
	public AndroidSaxFeedParser(String feedUrl) {
		super(feedUrl);
	}

	public List<Message> parse() {
		final Message currentMessage = new Message();
		RootElement root = new RootElement(FLUREPORT);
		final List<Message> messages = new ArrayList<Message>();
		//Element channel = root.getChild(CHANNEL);	// Was 'CHANNEL'
		Element timeperiod = root.getChild(TIMEPERIOD);	// Was 'CHANNEL'
		
		// Test
		//root.getChild(TIMEPERIOD).setEndTextElementListener(new EndTextElementListener(){
		//	public void end(String body){
		//		currentMessage.setTimePeriod(body);
		//	}
		//});
		// End Test
		
		timeperiod.setEndElementListener(new EndElementListener(){  // Not normally in here, but doesn't cause crash
			public void end() {
				messages.add(currentMessage.copy());
			}
		});

		Element state = timeperiod.getChild(STATE);	// Was 'ITEM'
		state.setEndElementListener(new EndElementListener(){
			public void end() {
				messages.add(currentMessage.copy());
			}
		});
		state.getChild(ABBREV).setEndTextElementListener(new EndTextElementListener(){	// Was 'TITLE'
			public void end(String body) {
				currentMessage.setAbbrev(body);
			}
		});
		state.getChild(COLOR).setEndTextElementListener(new EndTextElementListener(){  // Was 'LINK'
			public void end(String body) {
				//currentMessage.setLink(body); // Was 'setLink(body)'
				currentMessage.setColor(body);	
			}
		});
		state.getChild(LABEL).setEndTextElementListener(new EndTextElementListener(){  // Was 'DESCRIPTION'
			public void end(String body) {
				currentMessage.setLabel(body);
			}
		});
		//state.getChild(PUB_DATE).setEndTextElementListener(new EndTextElementListener(){  // Was 'PUB_DATE'
		//	public void end(String body) {
		//		currentMessage.setDate(body);
		//	}
		//});
		try {
			Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return messages;
	}
}

*/


// Working Version
/*
//Uses AndroidSaxFeedParser
public class AndroidSaxFeedParser extends BaseFeedParser {
	
	static final String RSS = "rss";
	public AndroidSaxFeedParser(String feedUrl) {
		super(feedUrl);
	}

	public List<Message> parse() {
		final Message currentMessage = new Message();
		RootElement root = new RootElement(RSS);
		final List<Message> messages = new ArrayList<Message>();
		Element channel = root.getChild(CHANNEL);	// Was Channel
		Element item = channel.getChild(ITEM);
		item.setEndElementListener(new EndElementListener(){
			public void end() {
				messages.add(currentMessage.copy());
			}
		});
		item.getChild(TITLE).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setTitle(body);
			}
		});
		item.getChild(DESCRIPTION).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setDescription(body);
			}
		});
		item.getChild(LINK).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setLink(body);
			}
		});
		
		
		item.getChild(PUB_DATE).setEndTextElementListener(new EndTextElementListener(){
			public void end(String body) {
				currentMessage.setDate(body);
			}
		});
		
		
		//item.getChild(ENCLOSURE).setEndTextElementListener(new EndTextElementListener(){
		//	public void end(String body) {
		//		currentMessage.setEnclosure(body);
		//	}
		//});
		
		try {
			Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return messages;
	}
	
	
}*/