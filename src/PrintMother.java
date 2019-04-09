import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;

public class PrintMother {
	public static void main(String[] args) {
		/*if(Desktop.isDesktopSupported()) {
			Desktop desk = Desktop.getDesktop();
			if(desk.isSupported(Desktop.Action.PRINT)) {
				try {
					desk.print(new File("C:\\\\Users\\\\Tuan Hiep Truong\\\\Desktop\\\\firsts.html"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		 JEditorPane editorPane = new JEditorPane();
		    editorPane.setEditable(false);
		    //URL urlToPage = new File("/home/me/Temp/page.html").toURI().toURL();
		    editorPane.setContentType("text/html");  
		    //editorPane.print(null, null, false, PrintServiceLookup.lookupDefaultPrintService(), null, false);
		}
	}
}
