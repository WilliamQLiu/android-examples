package com.wliu.cdcfluaware;

/*
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



// Used for SaxFeedParser, not for AndroidSaxFeedParser

// The constructor for the RSS Parser
    public class RssHandler extends DefaultHandler{
	//private List<Message> messages;
	//private Message currentMessage;
	//private StringBuilder builder;
    	
    public List<Message> messages;
    public Message currentMessage;
    public StringBuilder builder;
    	
	
    //Will
    //private boolean rss_tag = false;
    //private boolean channel_tag = false;
    //private boolean title_tag = false;
    //private boolean description_tag = false;
    //private boolean pubDate_tag = false;
    //private boolean enclosure_tag = false;
    
    //End Will
	
	// Returns the feed as a List Message
	public List<Message> getMessages(){
		return this.messages;
	}
	
	// When Parser reaches a tag, the following method gets called, providing the characters between the opening and the closing tag
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		builder.append(ch, start, length);
		
	}

	//getSubtitle & setSubtitle
	//getAbbrev & setAbbrev
	//getColor and setColor
	

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        super.endElement(uri, localName, name);
        //if (this.currentMessage != null){
            //Log.v("RSSHandler ", "Message not Null");
        	//if(localName.equalsIgnoreCase("flureport")){
        	//	this.flureport_tag = false;
        	//}
        	
        	//else if(localName.equals("timeperiod")){
        	//	this.timeperiod_tag = false;
        	//}
        	//if(localName.equalsIgnoreCase("rss")){
        	//}
        	//else if (localName.equalsIgnoreCase("channel")){
        	//}
        
        	if(localName.equalsIgnoreCase("item")){
        		messages.add(currentMessage);
        	}
        
        	else if(localName.equalsIgnoreCase("title")){
        		//this.title_tag = false;
        		currentMessage.setTitle(builder.toString());
        		//currentMessage.setAbbrev(builder.toString());
        		//Log.v("RSSHandler ", "ABBREV - Add New Message (endElement)");
        	}
        	else if(localName.equalsIgnoreCase("description")){
        		//this.description_tag = false;
        		currentMessage.setDescription(builder.toString());
        		//Log.v("RSSHandler ", "COLOR - Add New Message (endElement)");
        		
        	}
        	else if(localName.equalsIgnoreCase("link")){
        		currentMessage.setLink(builder.toString());
        	}
        	else if(localName.equalsIgnoreCase("pubDate")){
        		//this.pubDate_tag = false;
        		//currentMessage.setDate(builder.toString());
        	}
        	
    }
    }
        	/*
        	if (localName.equalsIgnoreCase(ABBREV)){
        		currentMessage.setAbbrev(builder.toString());
                Log.v("RSSHandler ", "ABBREV - setAbbrev");
        	}
         	else if (localName.equalsIgnoreCase(COLOR)){ // Was 'DESCRIPTION'
                currentMessage.setColor(builder.toString());
                Log.v("RSSHandler ", "COLOR - setColor");
            }
        	else if (localName.equalsIgnoreCase(LABEL)){  // Was 'PUB_DATE'
                currentMessage.setLabel(builder.toString());
                Log.v("RSSHandler ", "LABEL - setLabel");
            }
        	//else if (localName.equalsIgnoreCase(STATE)){  // Was 'ITEM'
                //messages.add(currentMessage);
                //Log.v("RSSHandler ", "STATE - Add New Message (endElement)");
            //}
                   	
        //}
    }
	
		// Start a new Message and String Builder
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		messages = new ArrayList<Message>();
		builder = new StringBuilder();
	}

	//public void endDocument() throws SAXException {
		// Nothing to do at end of document
	//}


	// Called on opening tags like <tag>, can provide attributes when xml is like <tag attribute = "attributeValue">
    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
    	super.startElement(uri, localName, name, attributes);
    	if(localName.equalsIgnoreCase("channel")){
    		this.currentMessage = new Message();
			//this.messages.add(currentMessage.copy());
    	}
    	//else if(localName.equalsIgnoreCase("enclosure")){
    	//	String attrValue = attributes.getValue("url");
    	//	Log.v("URL is: ", attrValue);
    	//}
    	
        
        //if(localName.equalsIgnoreCase(TIMEPERIOD)){
        //    this.currentMessage = new Message();
        //    Log.v("RSSHandler ", "TIMEPERIOD - Add New Message");
        //}
        
    }
		
}

*/

