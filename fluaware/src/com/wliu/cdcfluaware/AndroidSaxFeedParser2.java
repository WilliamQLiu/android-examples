package com.wliu.cdcfluaware;

/*
import java.util.ArrayList;
import java.util.List;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;


// Uses AndroidSaxFeedParser
public class AndroidSaxFeedParser2 extends BaseFeedParser {
	
	//static final String RSS = "rss";
	static final String FLUREPORT = "flureport";
	public AndroidSaxFeedParser2(String feedUrl) {
		super(feedUrl);
	}

	public List<Message> parse() {
		final Message currentMessage = new Message();
		RootElement root = new RootElement(FLUREPORT);
		final List<Message> messages = new ArrayList<Message>();
		//Element channel = root.getChild(CHANNEL);	// Was 'CHANNEL'
		Element timeperiod = root.getChild(TIMEPERIOD);	// Was 'CHANNEL'
		
		
		timeperiod.setEndElementListener(new EndElementListener(){  // Not normally in here, but doesn't cause crash
			public void end() {
				messages.get(0); // Number
				messages.get(1); // Year
				messages.get(2); // Subtitle
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
				//currentMessage.setLabel(body);
			}
		});
		
		try {
			Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8, root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return messages;
	}
}

*/
