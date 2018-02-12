package quotes;
//
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class QuoteAdd {

	/**
	 *      Created by Molly
     *          Modified by Eric         
	 */
         
    String author, quotes; //input string values 
    ProcessXML add;// add quotes and author into xml file.
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuoteAdd window = new QuoteAdd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuoteAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		frame.setBounds(100, 100, 675, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setVisible(true);
		
		JLabel titleText = new JLabel("Add A New Quote");
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setFont(new Font("Liberation Serif", Font.BOLD, 24));
		titleText.setBounds(195, 12, 285, 68);
		frame.getContentPane().add(titleText);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 77, 687, 20);
		frame.getContentPane().add(separator);
		
		JLabel labelAuthor = new JLabel("Author: ");
		labelAuthor.setBounds(33, 109, 70, 15);
		frame.getContentPane().add(labelAuthor);
		
		JLabel labelQuote = new JLabel("Quote:");
		labelQuote.setBounds(33, 170, 70, 15);
		frame.getContentPane().add(labelQuote);
		
		authorText = new JTextField();
		authorText.setBounds(121, 109, 517, 19);
		frame.getContentPane().add(authorText);
		authorText.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 170, 517, 175);
		frame.getContentPane().add(scrollPane);
		
		quoteText = new JTextArea();
		scrollPane.setViewportView(quoteText);
		
                
        /*
            add Clean button 
        */
        btnClean = new JButton("Clean");
        btnClean.setBounds(400, 357, 117, 25);
        frame.getContentPane().add(btnClean);       
        btnClean.addActionListener(new java.awt.event.ActionListener() {
        //button action listener. 
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCleanActionPerformed(evt);
        }});
        
        /*
            Add button will submit the information the the XML Parser
        */
		btnAddNew = new JButton("Add");
		btnAddNew.setBounds(521, 357, 117, 25);
		frame.getContentPane().add(btnAddNew);       
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                btnAddActionPerformed(evt);
            } catch (Exception ex) {
                Logger.getLogger(QuoteAdd.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});

        quoteText.setText(
            "Author Name Rules" + '\n' + 
            "1. First and Last names must begin with upper case." + '\n' + 
            "2. Author name cannot include punctuation mark except period(.)" + '\n' + 
            "Quotes Rules" + '\n' + 
            "1. The first character must be upper case." + '\n' +  
            "2. Quotes can include punctuation mark.");
                                
        
        }
	
         private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //When clean botton is click, then clear textArea and unselected all radio button.
        
            authorText.setText("");
            quoteText.setText("");
        }//end of clean button                                        
        
    	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
            //Add new quote and author in quote-list, which is xml file.
            
                boolean checkAuthor = false;
                boolean checkQuote = false;
                
                    author = authorText.getText();//get author name from textfield
                    quotes = quoteText.getText();//get quotes from textArea
                    Quote quoteAuthor = new Quote(author, quotes);
                    
                    if(author.length()==0 || quotes.length() == 0){
                        //case 1: checkign inputs are empty or not. 
                        quoteText.setText("------Error------" +'\n' +"Please fill out both author and qutes.");
                        checkAuthor = false;
                        checkQuote = false;
                    
                    } else{
                        //case 2: if inputs are not empty, then determine that author and quotes are vailed or not. 
                        
                        checkAuthor = checkAuthor(author);//call checkAuthor method to check author string
                        checkQuote = checkQuote(quotes);//call checkQuote method to check quote string. 
                          
                        if(checkQuote && checkAuthor){
                        //case 3: If author name and quotes satisfy the integrity of the data file,
                        //then call add method in ProcessXML class to add autoer and qutoes into XML file.
                            add = new ProcessXML();//initialize add value
                            Quote quoteAuthor = new Quote(quoteAuthor);
                            add.process(quoteAuthor);//passing author and quotes into ProcessXML.
                            quoteText.setText("Your quote has been saved!!");
                
                        } else {
                            //case 4: if author string does not satisfy, then print out error message in quoteText area. 
                            if(!checkAuthor) {
                                quoteText.setText("-------Error------" +'\n' +"Please check Author name. First name and Last name must beging with upper case.");
                            
                            } else if(!checkQuote) {
                                //case 5: if quotes string does not satisfy, then print out error message in quoteText area. 
                                quoteText.setText("Please check quote. Quote must begin with upper case");
                            }
                        
                            //case 6: if both of them are faild, then print out error message. 
                            quoteText.setText("-------Error------" +'\n' + "Please check author and quote. Both of them don't satisfy the rule.");
                        }//end of inner if-statement.
                    }//end of outter if-statement
    		
    	}//end of button method.
        
        public boolean checkGrammer(String str, int index){
        //This is checking grammers such as . , ; , ! etc.   
        //case 7: check punctuation mark. Only allow below marks. 
            boolean check = false;
            char t1 = '.';
            char t2 = ',';
            char t3 = ';';
            char t4 = ':';
            char t5 = '!';
            char t6 = 39; // (') symbol
            
            if(t1 ==str.charAt(index)||t2 == str.charAt(index)|| t3 == str.charAt(index)
                ||t4 == str.charAt(index) || t5 == str.charAt(index) || t6 == str.charAt(index)){
                check = true;
            }else{
                check = false;
            }
            return check;
        }//end of checkGrammer.
        
        public boolean checkUpperCase(String str){
        //check the first character is uppercase or not. 
            boolean check = false;
          
            if(!Character.isUpperCase(str.charAt(0))){
            //Chekcing the first charater 
                quoteText.setText("Error: The first character must begin with upper case.");//Testing line. 
                return check;
            }else{
                return true;
            }
            
        }//end of checkUpperCase
        
        public boolean checkLastName(String str, int index){

            if(Character.isSpaceChar(str.charAt(index-1)) 
                    && !Character.isUpperCase(str.charAt(index))){
                //if previous char is white space, then next char must be uppercase
                //e.g Jone jone (x) => Jone Jone
                quoteText.setText("Error: Last name must begin with uppercase.");
                return false;
            }else     
                return true;
            
            
        }//end of checkLastName
        
        public boolean checkAuthor(String str){
        //chekcing author name is vaild or not. 
            int i = str.length();
            char period = '.';
            boolean checkAuthor = false;
            
            checkAuthor = checkUpperCase(str);//check the first char is upper case or not. 
            
            if(!checkAuthor){
                //The first char is not upper case. 
                return false;
            }
            
            for(int index = 0; index < i ; index++) {
                
                if(index > 0){
                    checkAuthor = checkLastName(str, index);//check the first char of last name is upper case or not.
                    if(!checkAuthor){
                        System.out.println("Last name is not upper case.");
                    }
                }//end of for-loop
            
                if(!Character.isLetter(str.charAt(index))){
                //When input is not chracter, this if-statement checks that 
                //input is white space or period.
                    if(Character.isSpaceChar(str.charAt(index)) || (str.charAt(index)==period)){
                
                        checkAuthor = true;
                
                    }else{
                    
                        checkAuthor= false;
                        break;
                    }//innder if-else statement
                }else{
                                  
                    checkAuthor = true;
                }//out if-statement.   
            }
            return checkAuthor;
           
        }//end of checkAuthor
    
    public boolean checkQuote(String str){
    //checking quote are vaild or not. 
        int i = str.length();//get string lenght.
        boolean checkQuote = false;
        
        for(int index = 0; index < i; index++){
           //using the loop to access each char in string, then 
           //use isLetter() method to check char is alpabet or not. 
            if(!Character.isLetter(str.charAt(index))){
                
                if(Character.isSpaceChar(str.charAt(index)) || checkGrammer(str ,index)){
                    //check if there is space or puchation makr
                    //if its either space or puchuation mark, then return ture. 
                    //otherwise, return false. 
                    checkQuote = true;
            
                }else{
                
                checkQuote= false;
                break;
                }
            }else{
                checkQuote = true;
            }
        }//end of for-loop
       
        return checkQuote;
    }//end of chekcQuote
    
	protected JFrame frame;
	private JTextField authorText;
	private javax.swing.JTextArea quoteText;
    private JButton btnAddNew; 
    private JButton btnClean;
}
