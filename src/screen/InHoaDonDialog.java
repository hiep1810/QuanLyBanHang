package screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

public class InHoaDonDialog extends JDialog implements Printable {
	static File input;
	private static JFXPanel fxPanel;
	private String tenCH;
	private String diaChiCH;
	private String maHD;
	private String ngayTao;
	/**
	 * Create the panel.
	 */
	public InHoaDonDialog() {
		initComponent();
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		
			
			this.setBounds(0,0,749,514);
			getContentPane().setLayout(null);
			
			
			JButton btn = new JButton("In h\u00F3a \u0111\u01A1n");
			btn.setBounds(514,174,200,61);
			getContentPane().add(btn);
			
			JLabel lblNewLabel = new JLabel("Ti\u1EC1n tr\u1EA3 l\u1EA1i :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblNewLabel.setBounds(483, 32, 256, 31);
			getContentPane().add(lblNewLabel);
			
			JLabel label = new JLabel("0");
			label.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(483, 74, 256, 31);
			getContentPane().add(label);
			
			JButton btnThot = new JButton("Tho\u00E1t");
			btnThot.setBounds(514, 405, 200, 61);
			getContentPane().add(btnThot);
			
			fxPanel = new JFXPanel();
			fxPanel.setBounds(10,11,417,455);
			getContentPane().add(fxPanel);
			
			input = new File("C:\\\\Users\\\\Tuan Hiep Truong\\\\Desktop\\\\firsts.html");
			Document doc = null;
				try {
					
					doc = Jsoup.parse(input, null);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//
			//-----------Action------------------
			//
			
			loadJavaFXScene();
	}
	
	static private void loadJavaFXScene() {
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				BorderPane borderPane = new BorderPane();
				WebView webComponent = new WebView();
				
				webComponent.getEngine().load(input.toURI().toString());
				//webComponent.getEngine().load("https://www.google.com.vn");
				borderPane.setCenter(webComponent);
				Scene scene = new Scene(borderPane);
				fxPanel.setScene(scene);
				webComponent.autosize();
			}
		});
	}
	/*
	public static void main(String[] args) {
		/*
		input = new File("C:\\\\Users\\\\Tuan Hiep Truong\\\\Desktop\\\\firsts.html");
		Document doc = null;
		try {
			doc = Jsoup.parse(input, null);
			Element e = doc.getElementById("item");
			Element e1 = e.child(0);
			Element e2 = e.child(1);
			
			Attributes t = e1.attributes();
			System.out.println(t.toString());
			System.out.println(e2.attributes().toString());
			
			Element e11 = doc.getElementById("tenHang");
			Attributes t1 = e11.attributes();
			System.out.println(t1.toString());
			//write inner html
			e11.text("wont run ");
			System.out.println(e11.text());
			
			Element st = e.clone();
			e.appendChild(st);
			/*
			Element div = doc.select("div").first();
			System.out.println(div.toString());
			// <div></div>
			div.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
			div.prepend("<p>First</p>");
			div.append("<p>Last</p>");
			
			
			//overwrite to html file:
			PrintWriter writer = new PrintWriter(input,"UTF-8");
			//doc.body().append("hello") ;
			writer.write(doc.html() ) ;
			writer.flush();
			writer.close();
			//Element st = 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		*/
		/*
		
		JFrame j = new JFrame();
		j.setBounds(100,100,1000,1000);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		j.getContentPane().setLayout(null);
		
		InHoaDonPanel i = new InHoaDonPanel();
		i.setVisible(true);
		//j.add(i);
		*/

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
	}
	
			
			
	

}
