package quotes;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
 
class ProcessXML 
{ 
    public void process(String author, String quotes, String keyword) throws Exception, DOMException,ParserConfigurationException { 
       
         
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance(); 
        DocumentBuilder db = dbf.newDocumentBuilder(); 
        Document dct=db.parse(new File("/home/molly/Desktop/new/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml")); 
        Element root = dct.getDocumentElement();//get main root, quote-list
        Element root2 = dct.createElement("quote");//get sub root
        Element authorEle = dct.createElement("author");//get child root
        Element keywordEle = dct.createElement("keyword");//get child root
        Element quoteEle = dct.createElement("quote-text");//get child root 
        
        //System.out.println("root" + root.getTagName());//it prints out quote-list. 
        
        //quote-List -> quote -> quote-text = author.
        //root = quote-list
        //subroot = quote 
        //child1 = quote-text
        //child2 = author
        Text quoteText = dct.createTextNode(quotes);
        Text authorText = dct.createTextNode(author);
        Text keywordText = dct.createTextNode(keyword);
        
        keywordEle.appendChild(keywordText);
        quoteEle.appendChild(quoteText);//add text into child
        authorEle.appendChild(authorText);//add text into child
        
        root2.appendChild(quoteEle);//connect to sub root
        root2.appendChild(authorEle);//connect to sub root
        root2.appendChild(keywordEle);//append keyword.
        root.appendChild(root2);//connect to root
        root.appendChild(root2);//connect to root
        root.appendChild(root2);//connect to root.
        
       // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(dct);
        StreamResult result = new StreamResult(new File("/home/molly/Desktop/new/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml"));
        transformer.transform(source, result);
        //System.out.println("File saved!"); //testing statement.
    
        
    }//end of process 
    
}//end of class 