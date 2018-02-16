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
		String searchString = ("Seho");
		quoteList.search(searchString, 0);
		// Expecting 4 search results for author Molly 
//		for (int i = 0; i < 3; i++) {
//			assertEquals(
//					quoteList.getQuote(quoteList.getSize() - 1 - i).getAuthor().contains(searchString) ||
//					quoteList.getQuote(quoteList.getSize() - 1 - i).getAuthor().contains(searchString.toLowerCase()),
//					true);
//		}
		
		// Will fail if check beyond 4 (since there was only 3 quotes with Molly as author)
		assertEquals(
				quoteList.getQuote(quoteList.getSize() - 1 - 1).getAuthor().contains(searchString) ||
				quoteList.getQuote(quoteList.getSize() - 1 - 1).getAuthor().contains(searchString.toLowerCase()),
				true);
		System.out.println(quoteList.getQuote(quoteList.getSize() - 1 - 4));
		System.out.println(quoteList.getQuote(quoteList.getSize() - 1 - 3));
		System.out.println(quoteList.getQuote(quoteList.getSize() - 1 - 2));
		System.out.println(quoteList.getQuote(quoteList.getSize() - 1 - 1));
		System.out.println(quoteList.getQuote(quoteList.getSize() - 1 - 0));
	}
	
//	@Test
//	public void search2() {
//		String searchString = ("Ubuntu");
//		quoteList.search(searchString, 1);
//		// Expecting one result
//		assertEquals(
//				quoteList.getQuote(quoteList.getSize() - 1).getQuoteText().contains(searchString) ||
//				quoteList.getQuote(quoteList.getSize() - 1).getQuoteText().contains(searchString.toLowerCase()),
//				true);
//		
//		// Will fail if we check for more than one result
//		assertEquals(
//				quoteList.getQuote(quoteList.getSize() - 2).getQuoteText().contains(searchString) ||
//				quoteList.getQuote(quoteList.getSize() - 2).getQuoteText().contains(searchString.toLowerCase()),
//				false);
//	}
	
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
	
	

}
