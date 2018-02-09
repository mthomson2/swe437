package quotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.SwingConstants;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class QuotesAdd {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuotesAdd window = new QuotesAdd();
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
	public QuotesAdd() {
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
		
		JTextArea quoteText = new JTextArea();
		scrollPane.setViewportView(quoteText);
		
		JButton btnAddNew = new JButton("Add");
		btnAddNew.setBounds(521, 357, 117, 25);
		frame.getContentPane().add(btnAddNew);
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnAddActionPerformed(e);
				} catch (ParserConfigurationException | SAXException | IOException | TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//frame.setVisible(true);
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		String author = authorText.getText();
		String quote = quoteText.getText();
		addXML(author, quote);
	}
	
//	protected void addXML(String author, String quote) throws ParserConfigurationException, SAXException, IOException, TransformerException {
//		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//        Document document = documentBuilder.parse("/home/molly/Documents/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml");
//        Element root = document.getDocumentElement();
//
//        Collection<Quote> quotes = new ArrayList<Quote>();
//        quotes.add(new Quote());
//
//        for (Quote quo : quotes) {
//            // server elements
//            Element newQuote = document.createElement("quote");
//
//            Element quotetext = document.createElement("quote-text");
//            (quotetext).appendChild(document.createTextNode(quo.getQuoteText()));
//            (newQuote).appendChild(quotetext);
//
//            Element authortext = document.createElement("author");
//            (authortext).appendChild(document.createTextNode(quo.getAuthor()));
//            (newQuote).appendChild(authortext);
//
//            root.appendChild(newQuote);
//        }
//
//        DOMSource source = new DOMSource(document);
//
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        StreamResult result = new StreamResult("/home/molly/Documents/Spring2018/swe437/hw2/quotes/src/quotes/quo.xml");
//        transformer.transform(source, result);
//	}
	
	protected JFrame frame;
	private JTextField authorText;
	private JTextArea quoteText;
}
