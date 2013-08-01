package com.wliu.cdcfluaware;
import java.util.List;

// Used in BaseFeedParser, FeedParserFactory, MessageList, SectionThree classes
public interface FeedParser {
	List<Message> parse();
}

