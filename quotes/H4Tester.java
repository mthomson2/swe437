package quotes;

import static org.junit.Assert.*;

import org.junit.Test;

public class H4Tester {

	/**
     * Creates new form QuotesFrame
     */
    String quoteFileName = "quotes.xml";
    QuoteList quoteList;
    
    /**
	 * Create the application.
	 */
	public H4Tester() {
		QuoteSaxParser qParser = new QuoteSaxParser (quoteFileName);
		quoteList = qParser.getQuoteList();
	}
	
	@Test
	public void search1() {
		assertEquals(quoteList.search("molly", 0).getSize() != 0, true);
	}

}
