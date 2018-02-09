package quotes;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.*;
 
class processXML 
{ 
    public void process(String author, String quote) throws Exception, DOMException,ParserConfigurationException { 
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance(); 
        DocumentBuilder db = dbf.newDocumentBuilder(); 
 
        Document dct=db.parse(new File("/home/molly/Documents/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml")); 
 
        Element child1 = dct.createElement("quote"); 
 
        Element root = dct.getDocumentElement(); 
        root.appendChild(child1); 
 
        String authorText = dct.createTextNode(author); 
        root.getLastChild().appendChild(author); 
 
        //Document mainDoc = db.newDocument();
        Document mainDoc = db.parse(new File("/home/molly/Documents/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml"));
        if (mainDoc.getDocumentElement() == null){
            Element root1 = mainDoc.createElement("quote-list"); 
            mainDoc.appendChild(root1);
        }       
        mainDoc.getDocumentElement().appendChild(mainDoc.importNode(root, true));       
 
        Transformer transformer = TransformerFactory.newInstance().newTransformer(); 
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
        StreamResult result = new StreamResult(new FileWriter("/home/molly/Documents/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml")); 
        DOMSource source = new DOMSource(mainDoc); 
        transformer.transform(source, result); 
        System.out.println("File saved!"); 
    } 
} 