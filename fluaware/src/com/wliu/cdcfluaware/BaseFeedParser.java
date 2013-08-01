package com.wliu.cdcfluaware;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


// Stores the feedUrl and uses it to open a java.io.InputStream.  If anything goes wrong, it simply throws a RuntimeException so that the application simply fails quickly
public abstract class BaseFeedParser implements FeedParser {

	static final String CHANNEL = "channel";
	static final String PUB_DATE = "pubDate";
	static final String DESCRIPTION = "description";
	static final String LINK = "link";
	static final String TITLE = "title";
	static final String ITEM = "item";

		
	private final URL feedUrl;

	// In order to do anything with the XML document, you have to read the information in it (parsing)  - this is setting up the feed
	
	protected BaseFeedParser(String feedUrl){
		try {
			this.feedUrl = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	protected InputStream getInputStream() {
		try {
			return feedUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}