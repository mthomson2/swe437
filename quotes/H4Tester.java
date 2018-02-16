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
		String searchString = ("Molly");
		quoteList.search(searchString, 0);
		// Expecting 3 search results for author Molly 
		for (int i = 0; i < 3; i++) {
			assertEquals(
					quoteList.getQuote(quoteList.getSize() - 1 - i).getAuthor().contains(searchString) ||
					quoteList.getQuote(quoteList.getSize() - 1 - i).getAuthor().contains(searchString.toLowerCase()),
					true);
		}
		
		// Will fail if check beyond 3 (since there was only 3 quotes with Molly as author)
		assertEquals(
				quoteList.getQuote(quoteList.getSize() - 1 - 4).getAuthor().contains(searchString) ||
				quoteList.getQuote(quoteList.getSize() - 1 - 4).getAuthor().contains(searchString.toLowerCase()),
				false);
	}
	
	@Test
	public void search2() {
		assertEquals(quoteList.search("molly", 1).getSize() == 0, true);
		//assertEquals(quoteList.search(""))
	}

}
