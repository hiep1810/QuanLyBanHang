package models;

import java.awt.GraphicsEnvironment;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.application.Platform;
import javafx.collections.ObservableSet;
import javafx.embed.swing.JFXPanel;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class PrintHowTo {
	static JFXPanel fxPanel;
	 static File file;
	public static void main(String[] args) {
		 JTextPane jtp = new JTextPane();
		 jtp.setContentType("text/html");
		 file = new File("C:\\\\Users\\\\Tuan Hiep Truong\\\\Desktop\\\\firsts.html");
		 Document doc = null;
		try {
			doc = Jsoup.parse(file,null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fxPanel = new JFXPanel();
		JFrame jframe = new JFrame();
		jframe.setLayout(null);
		jframe.setBounds(0,0,100,100);
		loadJavaFXScene();
		
	}
static private void loadJavaFXScene() {
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				BorderPane borderPane = new BorderPane();
				WebView webComponent = new WebView();
				
				webComponent.getEngine().load(file.toURI().toString());
				//webComponent.getEngine().load("https://www.google.com.vn");
				borderPane.setCenter(webComponent);
				Scene scene = new Scene(borderPane);
				fxPanel.setScene(scene);
				webComponent.autosize();
				/*
				PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
				 DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
				 PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
				 PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
				 PrintService service = ServiceUI.printDialog(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(), 200, 200,
				                       printService, defaultService, flavor, pras);
				 
				 Printer myPrinter;
				 ObservableSet<Printer> printers = Printer.getAllPrinters();
				 for(Printer printer : printers) {
					
				 }
				 */
				WebEngine webEngine = webComponent.getEngine();
				  PrinterJob job = PrinterJob.createPrinterJob();
				  job.showPrintDialog(null);
				    if (job != null) {
				    	
				        webEngine.print(job);
				        job.endJob();
				    }
				
			}
		});
	}
}
