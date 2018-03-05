package quotes;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import quotes.Quote;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/// @author Eric Lee (02/01/2018)
/// Modified by Molly Thomson (02/04/2018)
public class QuotesApp {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuotesApp window = new QuotesApp();
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
     * Creates new form QuotesFrame
     */
    String quoteFileName = "F:\\csprograms\\eclipse-work\\quotes\\src\\quo.xml";
    QuoteList quoteList;

    //QuotesFrame e
    public void setRanQuote(){
        //This function sets random quote.
       Quote quo = new Quote();
       quo = quoteList.getRandomQuote();
       quo.getAuthor();
       randomText.setText(""+ quo.getQuoteText() + '\n' + "-"+quo.getAuthor()+"-");
    }//end of setRanQuote

	/**
	 * Create the application.
	 */
	public QuotesApp() {
		
		initialize();
		QuoteSaxParser qParser = new QuoteSaxParser (quoteFileName);
		quoteList = qParser.getQuoteList();
		setRanQuote();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		frame.setBounds(100, 100, 675, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titleText = new JLabel("The GMU Quote Generator");
		titleText.setFont(new Font("Liberation Serif", Font.BOLD, 24));
		titleText.setBounds(155, 12, 365, 68);
		frame.getContentPane().add(titleText);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 77, 687, 20);
		frame.getContentPane().add(separator);
		
		JLabel labelRandomQuote = new JLabel("Random Quote of the Day:");
		labelRandomQuote.setBounds(29, 92, 193, 34);
		frame.getContentPane().add(labelRandomQuote);
		
		randomText = new JTextArea();
		randomText.setEditable(false);
		randomText.setBounds(29, 124, 611, 68);
		randomText.setLineWrap(true);
		frame.getContentPane().add(randomText);
		
		btnRandomQuote = new JButton("Get Another Random Quote");
		btnRandomQuote.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRandomQuote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRandomQuoteActionPerformed(e);
			}
		});
		
		btnRandomQuote.setBounds(29, 204, 238, 25);
		frame.getContentPane().add(btnRandomQuote);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 253, 687, 20);
		frame.getContentPane().add(separator_1);
		
		textField = new JTextField();
		textField.setBounds(142, 285, 498, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel labelSearch = new JLabel("Search: ");
		labelSearch.setFont(new Font("Dialog", Font.BOLD, 14));
		labelSearch.setBounds(29, 294, 70, 15);
		frame.getContentPane().add(labelSearch);
		
		JLabel lblScope = new JLabel("Scope: ");
		lblScope.setFont(new Font("Dialog", Font.BOLD, 14));
		lblScope.setBounds(29, 344, 70, 15);
		frame.getContentPane().add(lblScope);
		
		rdbtnQuote = new JRadioButton("Quote");
		rdbtnQuote.setBounds(142, 340, 76, 23);
		frame.getContentPane().add(rdbtnQuote);
		
		rdbtnAuthor = new JRadioButton("Author");
		rdbtnAuthor.setBounds(243, 340, 84, 23);
		frame.getContentPane().add(rdbtnAuthor);
		
		rdbtnBoth = new JRadioButton("All");
		rdbtnBoth.setBounds(471, 340, 149, 23);
		frame.getContentPane().add(rdbtnBoth);
		
		rdbtnKeyword = new JRadioButton("Keyword");
		rdbtnKeyword.setBounds(347, 340, 84, 23);
		frame.getContentPane().add(rdbtnKeyword);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAuthor);
		group.add(rdbtnQuote);
		group.add(rdbtnBoth);
		group.add(rdbtnKeyword);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(399, 371, 84, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		frame.getContentPane().add(btnSearch);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		btnReset.setBounds(503, 371, 84, 25);
		frame.getContentPane().add(btnReset);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBounds(0, 422, 687, 20);
		frame.getContentPane().add(separator_2);
		
		JLabel lblRecentSearches = new JLabel("Recent Searches");
		lblRecentSearches.setBounds(29, 437, 133, 34);
		frame.getContentPane().add(lblRecentSearches);
		
		JTextArea authorText = new JTextArea();
		authorText.setBackground(UIManager.getColor("Menu.background"));
		authorText.setEditable(false);
		authorText.setText("Lee and Thomson 2018");
		authorText.setBounds(39, 642, 157, 20);
		frame.getContentPane().add(authorText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(39, 470, 554, 86);
		frame.getContentPane().add(scrollPane);
		
		recentText = new JTextArea();
		scrollPane.setViewportView(recentText);
		recentText.setEditable(false);
		
		btnAddANewquote = new JButton("Add a NewQuote ");
		btnAddANewquote.setBounds(39, 595, 193, 25);
		frame.getContentPane().add(btnAddANewquote);
		
		
		
		btnAddANewquote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddQuoteActionPerformed(e);
			}
		});
		
	}
	
	private void btnRandomQuoteActionPerformed(ActionEvent evt) {
           setRanQuote();
    }
	
	private void btnSearchActionPerformed(ActionEvent evt) {
		
		if (textField.getText() != null && !textField.getText().equals("")){  // Received a search request
      
			int searchScopeInt = QuoteList.SearchBothVal; // Default
      
        if (rdbtnQuote.isSelected()){
            
            searchScopeInt = QuoteList.SearchTextVal;
        
        } else if(rdbtnAuthor.isSelected()){
            
            searchScopeInt = QuoteList.SearchAuthorVal;
        
        } else if (rdbtnKeyword.isSelected()) {
        	
        	System.out.println("This is selected");
        	searchScopeInt = QuoteList.SearchKeyword;
        
        }else if(rdbtnBoth.isSelected()){
            
            searchScopeInt = QuoteList.SearchBothVal;
        
        }else if(!rdbtnQuote.isSelected() && !rdbtnAuthor.isSelected() && !rdbtnBoth.isSelected() && !rdbtnKeyword.isSelected()){
            
            recentText.setText("Please select one of scops to search quotes.");
        
        }//end of if-else 
        

        QuoteList searchRes = quoteList.search (textField.getText(), searchScopeInt);
        Quote quoteTmp;
      
            if (searchRes.getSize() == 0){
                
            	recentText.setText("Your search -" + textField.getText() + "- did not match any quotes.");
               
            } else {
               
            	//recentText.setText("");
                for (int i = 0; i < searchRes.getSize() ; i++){
                    quoteTmp = searchRes.getQuote(i);
                                       
                    if(quoteTmp.getKeyword().equalsIgnoreCase("")) {
                    	recentText.append("" + quoteTmp.getQuoteText() + '\n' + "-" + quoteTmp.getAuthor() + "-\n"
                        		+ "Keyword: No keyword" + "\n");
                    }
                    
                    recentText.append("" + quoteTmp.getQuoteText() + '\n' + "-" + quoteTmp.getAuthor() + "-\n"
                    		+ "Keyword = " + quoteTmp.getKeyword() + "\n");
                }//end of for-loop
   
            }//end of inner if-else
			}//end of if 
           
    }
	
	private void btnResetActionPerformed(ActionEvent evt) {
		recentText.setText("");
		textField.setText("");
        rdbtnAuthor.setSelected(false);
        rdbtnBoth.setSelected(false);
        rdbtnQuote.setSelected(false);
    }
	
	private void btnAddQuoteActionPerformed(ActionEvent evt) {
		createNewQuoteFrame();
	}
	
	private void createNewQuoteFrame() {
		QuoteAdd addQuote = new QuoteAdd();
		addQuote.frame.setVisible(true);
	}
	
	private JFrame frame;
	private JLabel titleText;
	private JTextField textField;
	private JTextArea randomText;
	private JButton btnSearch;
	private JButton btnReset;
	private JButton btnAddANewquote;
	private JRadioButton rdbtnQuote;
	private JRadioButton rdbtnAuthor;
	private JRadioButton rdbtnBoth;
	private JRadioButton rdbtnKeyword;
	private JButton btnRandomQuote;
	private JTextArea recentText;
}