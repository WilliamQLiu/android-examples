package com.wliu.cdcfluaware;

/*
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
 
public class ExampleHandler extends DefaultHandler{
 
        // ===========================================================
        // Fields
        // ===========================================================
       
	
        //private boolean in_outertag = false;
        //private boolean in_innertag = false;
        //private boolean in_mytag = false;
        
        
        //Will
        //private boolean flureport_tag = false;
        //private boolean timeperiod_tag = false;
        //private boolean state_tag = false;
        private boolean abbrev_tag = false;
        private boolean color_tag = false;
        //End Will
       
        private ParsedExampleDataSet myParsedExampleDataSet = new ParsedExampleDataSet();
 
        // ===========================================================
        // Getter & Setter
        // ===========================================================
 
        public ParsedExampleDataSet getParsedData() {
                return this.myParsedExampleDataSet;
        }
 
        // ===========================================================
        // Methods
        // ===========================================================
        @Override
        public void startDocument() throws SAXException {
                this.myParsedExampleDataSet = new ParsedExampleDataSet();
        }
 
        @Override
        public void endDocument() throws SAXException {
                // Nothing to do
        }
 
        //Gets be called on opening tags like:
        // * <tag>
        // * Can provide attribute(s), when xml was like:
        // * <tag attribute="attributeValue">


        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        	if (localName.equals("flureport")) {
                //this.flureport_tag = true;
                }
        	else if (localName.equals("timeperiod")) {
                //this.timeperiod_tag = true;
                String attrValue = atts.getValue("subtitle");
                //int i = Integer.parseInt(attrValue);
                //myParsedExampleDataSet.setExtractedInt(i);
                //myParsedExampleDataSet.setExtractedString(attrValue);  
                
                // Set extracted timeperiod
                myParsedExampleDataSet.setTimePeriodString(attrValue);
        	}
        	else if (localName.equals("state")) {
                //this.state_tag = true;
        	}
        	else if (localName.equals("abbrev")){
        		this.abbrev_tag = true;
        	}
        	else if (localName.equals("color")) {
        		this.color_tag = true;
        	}

        	
        	
        	//	if (localName.equals("outertag")) {
            //            this.in_outertag = true;
            //    }else if (localName.equals("innertag")) {
            //            this.in_innertag = true;
            //    }else if (localName.equals("mytag")) {
            //            this.in_mytag = true;
            //    }else if (localName.equals("tagwithnumber")) {
            //            // Extract an Attribute
            //            String attrValue = atts.getValue("thenumber");
            //            int i = Integer.parseInt(attrValue);
            //            myParsedExampleDataSet.setExtractedInt(i);
            //    }
        	
        }
       
        //** Gets be called on closing tags like:
        // * </tag> 
        @Override
        public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
                
        	if (localName.equals("flureport")) {
                //this.flureport_tag = false;
                }
        	else if (localName.equals("timeperiod")) {
                //this.timeperiod_tag = false;
                }
        	else if (localName.equals("state")) {
                //this.state_tag = false;
        	}
        	else if (localName.equals("abbrev")){
        		this.abbrev_tag = false;
        	}
        	else if (localName.equals("color")) {
        		this.color_tag = false;
        	}
        	
        	
        	///*if (localName.equals("outertag")) {
                        this.in_outertag = false;
                }else if (localName.equals("innertag")) {
                        this.in_innertag = false;
                }else if (localName.equals("mytag")) {
                        this.in_mytag = false;
                }else if (localName.equals("tagwithnumber")) {
                        // Nothing to do here
            //    }
        }
       
        ///** Gets be called on the following structure:
         //* <tag>characters</tag>
        @Override
    public void characters(char ch[], int start, int length) {
            if(this.abbrev_tag){
            	//myParsedExampleDataSet.setExtractedString(new String(ch, start, length));  
            	myParsedExampleDataSet.setAbbrevString(new String(ch, start, length)); // set extracted abbrev
            }
            else if(this.color_tag){
            	//myParsedExampleDataSet.setExtractedString(new String(ch, start, length));  
            	myParsedExampleDataSet.setColorString(new String(ch, start, length)); // set extracted color
            }
        	
        	/*
            //  if(this.in_mytag){
            //    myParsedExampleDataSet.setExtractedString(new String(ch, start, length));
        	//
        	
        }
    }
    }
*/