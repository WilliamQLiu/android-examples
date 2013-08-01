package com.wliu.cdcfluaware;
public abstract class FeedParserFactory {
	//static String feedUrl = "http://www.androidster.com/android_news.rss";
	//static String feedUrlCDCXML = "http://www.cdc.gov/flu/weekly/flureport.xml";
	static String feedUrl = "http://www.cdc.gov/flu/weekly/flureport.xml";

	
	//RSS Feed of Influenza pages through content syndication
	//static String feedUrl = "http://t.cdc.gov/feed.aspx?tpc=26829&days=90";
	
	//RSS Feed of Influenza updates
	static String feedUrlInFluenzaUpdates = "http://www2c.cdc.gov/podcasts/createrss.asp?t=r&c=20";
	//Works
	
	//RSS Feed of Influenza podcasts
	static String feedUrlInfluenzaPodcasts = "http://www2c.cdc.gov/podcasts/searchandcreaterss.asp?topic=flu";
	//static String feedUrl = "http://www2c.cdc.gov/podcasts/searchandcreaterss.asp?topic=flu";
	// Works
		
	//RSS Feed of CDC Features pages through content syndication
	//static String feedUrl = "http://t.cdc.gov/feed.aspx?tpc=26816&fromdate=1/1/2011";
	
	//JSON Feed of Influenza pages through content syndication
	//static String feedUrl = "http://t.cdc.gov/feed.aspx?tpc=26829&days=90&fmt=json";
		
	//JSON Feed of CDC Features pages through content syndication
	//static String feedUrl = "http://t.cdc.gov/feed.aspx?tpc=26816&fromdate=1/1/2011&fmt=json";
	
	/*
	public static FeedParser getParser(){
		return getParser(ParserType.ANDROID_SAX);	// FeedParser is using AndroidSaxFeedParser for X Feed
	}
	*/
	
	public static FeedParser getParser(ParserType type){
		switch (type){
			//case SAX:
				//return new SaxFeedParser(feedUrlInFluenzaUpdates);
			//case DOM:
				//return new DomFeedParser(feedUrl);
			case ANDROID_SAX:
				return new AndroidSaxFeedParser(feedUrlInfluenzaPodcasts);
			//	return new AndroidSaxFeedParser(feedUrl);
			//case XML_PULL:
				//return new XmlPullFeedParser(feedUrl);
			//case CDC_XML:
				//return new AndroidSaxFeedParser2(feedUrl);
			default: return null;
		}
	}
}
