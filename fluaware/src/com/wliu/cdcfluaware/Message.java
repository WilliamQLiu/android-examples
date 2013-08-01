package com.wliu.cdcfluaware;

//import java.net.MalformedURLException;
//import java.net.URL;
//import java.text.ParseException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//public class Message implements Comparable<Message>{
public class Message{

	// Androidster
	//static SimpleDateFormat FORMATTER = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
	static SimpleDateFormat FORMATTER = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
	// Androidster: <lastBuildDate>Mon, 16 May 2011 03:48:56 +0100</lastBuildDate>
	// CDC XML <pubDate>Thu, 24 Mar 2011 16:30:00 EST</pubDate>

	
	private String title;
	private URL link;
	private String description;
	private Date date;
	//private URL enclosure;
	
	// Androidster
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title.trim();
	}
	public URL getLink() {
		return link;
	}
	public void setLink(String link) {
		try {
			this.link = new URL(link);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	//public URL getEnclosure() {		
	//	return enclosure;
	//}
	//public void setEnclosure(String enclosure) {
	//	try {
	//		this.enclosure = new URL(enclosure);
	//	} catch (MalformedURLException e) {
	//		throw new RuntimeException(e);
	//	}
	//}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description.trim();
	}
	//public String getDate() {
	//	return FORMATTER.format(this.date);
	//}
	/*
	public void setDate(String date) {
		// pad the date if necessary
		while (!date.endsWith("00")){
			date += "0";
		}
		try {
			this.date = FORMATTER.parse(date.trim());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}*/
	public void setDate(String date) {
		// pad the date if necessary
		while (!date.endsWith("00")){
			date += "0";
		}
		try {
			this.date = FORMATTER.parse(date.trim());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
		
	// Copy Function
	public Message copy(){
		Message copy = new Message();
		
		
		copy.title = title;
		copy.link = link;
		copy.description = description;
		copy.date = date;
		//copy.enclosure = enclosure;
		
		return copy;
	}
}
	