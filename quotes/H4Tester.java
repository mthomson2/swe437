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
	public void search1a() {
		String searchString = ("Molly");
		QuoteList returnQuote = quoteList.search(searchString, 0);
		
		// Expecting 3 search results for author Molly 
		for (int i = 0; i < returnQuote.getSize(); i++) {
			assertEquals(
					returnQuote.getQuote(returnQuote.getSize() - 1 - i).getAuthor().contains(searchString) ||
					returnQuote.getQuote(returnQuote.getSize() - 1 - i).getAuthor().contains(searchString.toLowerCase()),
					true);
		}
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void search1b() {
		String searchString = ("Molly");
		QuoteList returnQuote = quoteList.search(searchString, 0);
		
		// Will fail if check beyond 4 (since there was only 3 quotes with Molly as author)
		assertEquals(
				returnQuote.getQuote(quoteList.getSize() - 1 - 3).getAuthor().contains(searchString) ||
				returnQuote.getQuote(quoteList.getSize() - 1 - 3).getAuthor().contains(searchString.toLowerCase()),
				false);
	}
	
	@Test
	public void search2a() {
		String searchString = ("Ubuntu");
		QuoteList returnQuote = quoteList.search(searchString, 1);
		// Expecting one result
		assertEquals(
				returnQuote.getQuote(returnQuote.getSize() - 1).getQuoteText().contains(searchString) ||
				returnQuote.getQuote(returnQuote.getSize() - 1).getQuoteText().contains(searchString.toLowerCase()),
				true);

	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void search2b() {
		String searchString = ("Ubuntu");
		QuoteList returnQuote = quoteList.search(searchString, 1);
		
		// Will fail if we check for more than one result
		assertEquals(
				returnQuote.getQuote(returnQuote.getSize() - 2).getQuoteText().contains(searchString) ||
				returnQuote.getQuote(returnQuote.getSize() - 2).getQuoteText().contains(searchString.toLowerCase()),
				false);
	}
	
//	public void search3() {
//		String searchString = ("Molly");
//		quoteList.search(searchString, 2);
//		// Expecting four results
//		for(int i = 0; i < 4; i++) {
//		assertEquals(
//				quoteList.getQuote(quoteList.getSize() - 1 - i).getQuoteText().contains(searchString) ||
//				quoteList.getQuote(quoteList.getSize() - 1).getQuoteText().contains(searchString.toLowerCase()) ||
//				quoteList.getQuote(quoteList.getSize() - 1 - i).getAuthor().contains(searchString) ||
//				quoteList.getQuote(quoteList.getSize() - 1 - i).getAuthor().contains(searchString.toLowerCase()),
//				true);
//		}
//		
//		// Will fail if we check for more than four results
//		assertEquals(
//				quoteList.getQuote(quoteList.getSize() - 6).getQuoteText().contains(searchString) ||
//				quoteList.getQuote(quoteList.getSize() - 6).getQuoteText().contains(searchString.toLowerCase()) ||
//				quoteList.getQuote(quoteList.getSize() - 6).getAuthor().contains(searchString) ||
//				quoteList.getQuote(quoteList.getSize() - 6).getAuthor().contains(searchString.toLowerCase()),
//				false);
//	}
	
//	@Test
//	public void search4() {
//		//store size of the arrayList
//		//call search (0, 3)
//		//check list size
//		int size = quoteList.getSize();//store size of arrayList.
//		quoteList.search("Richard", 3);
//		assertEquals(size==quoteList.getSize(), true);
//		quoteList.search("John",3);
//		assertEquals(size == quoteList.getSize(), true);
//		quoteList.search("Eschew obfuscation!", 3);
//		assertEquals(size == quoteList.getSize(), true);
//
//	}
	
	

}
