package quotes;

import static org.junit.Assert.*;
import org.junit.Test;

public class H6Tester {

	/**
     * 
     */
    String quoteFileName = "quotes.xml";
    QuoteList quoteList;
    
    /**
	 * Create the application.
	 */
    
    /*
     * 
     * As a search user, I should be able to select Keyword as a search option.
	   As a search user, I should be able to select an All option for the search criteria to include author, quote, and keywords. 
		As a quote adding user, I should be able to define keywords for a specific quote through the Add Quote frame.
		As a quote adding user, I should not be able to define a keyword with more than 3 words.
		As a quote adding user, I should not be allowed to define more than 5 keywords per quote.
		As a quote adding user, I should be able to separate each keyword with commas. 
		As a quote adding user, I should be able to define zero keywords for a quote

     * 
     * 
     */
	public H6Tester() {

		QuoteSaxParser qParser = new QuoteSaxParser (quoteFileName);
		quoteList = qParser.getQuoteList();
		
		
	}
	
	@Test
	public void keyword_Test() {
	//case 1: user can select keyword as a search option.
	//There are only 4 "Unknown" keywords in xml.
	try {
	String keyword = ("Unknown");	
	QuoteList returnQuote = quoteList.search(keyword, 3);
	Quote quoteTmp;
	int count = 0;
	for (int i = 0; i < returnQuote.getSize() ; i++){
        
		quoteTmp = returnQuote.getQuote(i);
                           
        if(quoteTmp.getKeyword().equals(keyword)) {
        	count ++;
        };
    }//end of for-loop
		System.out.println(count);
		assertEquals(4, count);
	} catch (Exception e) {}
	}
	
	@Test 
	public void allOption_Test() {
		//case 2: All option for the search criteria to include author, quote, and keywords.
		try {
		String str = ("swe");	
		QuoteList returnQuote = quoteList.search(str, 2);
	
		int count = 0;
		for (int i = 0; i < returnQuote.getSize() ; i++){
		        	count ++;
	    }//end of for-loop
			
	    assertEquals(count == 4, true);
		} catch (Exception e) {}
	}
	
	@Test
	public void numberOfKeyword_Test() {
		//case 3:should not be able to define a keyword with more than 3 words.
	
		String keywords = ("hello everyone nice to meet you");
		QuoteAdd qAdd = new QuoteAdd();
		assertEquals(qAdd.checkkeywords(keywords), false);
	}
	
	@Test
	public void numberOfKeyword2_Test() {
		//case 3:should not be able to define a keyword with more than 3 words.
	
		String keywords = ("hello everyone");
		QuoteAdd qAdd = new QuoteAdd();
		assertEquals(qAdd.checkkeywords(keywords), true);
	}
	
	@Test
	public void maxKeyword_Test() {
		//case 4: not be able to define a keyword with more than 5 words.
		
		String keywords = ("We, are, the, champian, !, !");
		QuoteAdd qAdd = new QuoteAdd();
		assertEquals(qAdd.checkkeywords(keywords), false);
	}
	
	@Test
	public void commas_Test() {
		//case 5:
	}
	
	@Test
	public void noKeyword_Test() {
		//case 6: should be able to define zero keywords for a quote
		//calling evaluation methods to determine that zero keywords is valid or not.
		String author = ("Swe Test");
		String quote = ("This is the last test case");
		String keywords = ("");
		QuoteAdd qAdd = new QuoteAdd();
		assertEquals(qAdd.checkkeywords(keywords) && qAdd.checkAuthor(author) && qAdd.checkQuote(quote), true);
	}
	
	@Test
	public void quoteKeyword_Test() {
		String author = "Molly";
		String quoteText = "Why is everything so hard.";
		String keyword = "too short";
		
		Quote quote = new Quote(author, quoteText, keyword);
		assertEquals(quote.getKeyword(), keyword);
	}
	
	public void quoteKeyword_Test2() {
		String author = "Molly";
		String quoteText = "Why is everything so hard.";
		String keyword = "too short";
		
		Quote quote = new Quote(author, quoteText, keyword);
		quote.setKeyword("mango");
		assertEquals(quote.getKeyword(), "mango");
	}
}