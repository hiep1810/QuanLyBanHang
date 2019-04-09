
import java.awt.GraphicsEnvironment;
import java.io.FileInputStream;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.*;
import javax.print.attribute.standard.Copies;
import javax.print.event.*;

public class PrintingServiceDemo {
   public static void main(String[] args) throws PrintException,
         IOException{

		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

      PrintService ps=PrintServiceLookup.lookupDefaultPrintService();
      DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		 PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		 PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		 PrintService service = ServiceUI.printDialog(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(), 200, 200,
		                       printService, defaultService, flavor, pras);
		 
      DocPrintJob job=service.createPrintJob();
      job.addPrintJobListener(new PrintJobAdapter() {
      public void printDataTransferCompleted(PrintJobEvent event){
         System.out.println("data transfer complete");
      }
      public void printJobNoMoreEvents(PrintJobEvent event){
            System.out.println("received no more events");
         }
      });
      FileInputStream fis=new FileInputStream("C:\\\\\\\\Users\\\\\\\\Tuan Hiep Truong\\\\\\\\Desktop\\\\\\\\firsts.html");
      Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
      
      // Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.JPEG, null);
      PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
      attrib.add(new Copies(1));
      job.print(doc, attrib);
   }
}