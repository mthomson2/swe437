package quotes;

import java.io.*;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;

/**
 * SAX parser
 * @author Mongkoldech Rajapakdee & Jeff Offutt
 *         Date: Nov 2009
 */
public class QuoteSaxParser
{
   private QuoteSaxHandler handler;

public QuoteSaxParser (String fileName)
{
   try
   {
       
      //Just replace the path.
      File quoteFile = new File ("/home/molly/Desktop/new/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml");

      handler = new QuoteSaxHandler();
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser =  factory.newSAXParser();
      saxParser.parse (quoteFile, handler);
   } catch (Exception e)
   {
      e.printStackTrace();
   }
}

public QuoteList getQuoteList()
{
   return handler.getQuoteList();
}
}
