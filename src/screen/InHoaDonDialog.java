package screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.print.Doc;
import javax.print.DocFlavor;

import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebView;
import models.CTHDBan;
import models.CTHDBanDAO;
import models.HDBan;
import models.HTMLPrinter;
import models.KhachHang;
import models.KhachHangDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

public class InHoaDonDialog extends JDialog {
	private static File input;
	private JEditorPane editorPane;
	private String tenCH;
	private String diaChiCH;
	private String maHD;
	private String ngayTao;
	/**
	 * Create the panel.
	 */
	//int maKH, float tongTien, float tienTra, JTable table
	public InHoaDonDialog(int maKH,HDBan hd,JTable table,float giamGia,float tienNo, float tienTra) {
		initComponent(maKH,hd, table, giamGia, tienNo, tienTra);
	}

	private void initComponent(int maKH,HDBan hd,JTable table,float giamGia,float tienNo, float tienTra) {
		// TODO Auto-generated method stub
		
			
			this.setBounds(0,0,675,514);
			getContentPane().setLayout(null);
			
			
			JButton btn = new JButton("In h\u00F3a \u0111\u01A1n");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
			               HTMLPrinter htmlPrinter = new HTMLPrinter();
			               htmlPrinter.printJEditorPane(editorPane, htmlPrinter.showPrintDialog());
			          } catch (Exception tce) {
			               tce.printStackTrace();
			          }     
				}
			});
			btn.setBounds(440,94,209,61);
			getContentPane().add(btn);
			
			JLabel lblNewLabel = new JLabel("Ti\u1EC1n tr\u1EA3 l\u1EA1i :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblNewLabel.setBounds(440, 10, 209, 31);
			getContentPane().add(lblNewLabel);
			
			JLabel label = new JLabel("0");
			label.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(440, 52, 209, 31);
			getContentPane().add(label);
			
			JButton btnThot = new JButton("Tho\u00E1t");
			btnThot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InHoaDonDialog.this.dispose();
				}
			});
			btnThot.setBounds(440, 303, 209, 61);
			getContentPane().add(btnThot);
			/*
			fxPanel = new JFXPanel();
			fxPanel.setBounds(10,11,417,455);
			getContentPane().add(fxPanel);
			*/
			editorPane = new JEditorPane();
			editorPane.setBounds(10,10,420,455);
			editorPane.setContentType("text/html;charset=utf-8");
			
			
			input = new File(".\\src\\screen\\firsts.html");
			Document doc = null;
				try {
					
					doc = Jsoup.parse(input, null);
					//Get element item:
					KhachHangDAO dao = new KhachHangDAO();
					KhachHang khachHang = dao.getKhachHang(maKH);
					
					doc.getElementById("maHD").text("M\u00E3 h\u00F3a \u0111\u01A1n: " 
													+Integer.toString(hd.getMaHDBan()));
					doc.getElementById("ngayTaoHD").text("Ng\u00E0y t\u1EA1o: "+hd.getNgayBan());
					doc.getElementById("tenKH").text("T\u00EAn kh\u00E1ch h\u00E0ng: "
													+khachHang.getTenKH());
					doc.getElementById("sdtKH").text("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i: "+ khachHang.getSdt());
					System.out.println(Float.toString(giamGia));
					doc.getElementById("chietKhau").text(Float.toString(giamGia));
					doc.getElementById("tienNo").text(Float.toString(tienNo));
					doc.getElementById("tienKhachDua").text(Float.toString(tienTra));
					
					//Them thong tin san pham o day:
					Element delete = doc.getElementById("item");
					Element e = delete.clone();
					delete.remove();
					//Get child of the element by element.child()
					float sum = 0;
					for(int i = 0; i<table.getRowCount(); i++) {
						float temp = Float.parseFloat((String)table.getValueAt(i, 3))*
								(int)table.getValueAt(i, 5);
						CTHDBan hdBan = new CTHDBan();
						Element copy = e.clone();
						//them ma hd vao cthdban:
						
						
						//hdban.masp o cot 1 :
						
						//ten sp:
						copy.child(0).text((String)table.getValueAt(i, 1));
						
						//gia ban:
						copy.child(1).text((String)table.getValueAt(i, 3));
						//them ca so luong ban vao hdban:
						
						
						copy.child(2).text(Integer.toString((int) table.getValueAt(i, 5)));
						copy.child(3).text(Float.toString(temp));
						
						CTHDBanDAO cthd = new CTHDBanDAO();
						hdBan.setMaSP(Integer.parseInt((String)table.getValueAt(i, 0)));
						hdBan.setMaHDBan(hd.getMaHDBan());
						hdBan.setSlBan((int) table.getValueAt(i, 5));
						
						cthd.addCTHDBan(hdBan);
						
						sum += temp;
						doc.getElementById("itemlist").appendChild(copy);
					}
					doc.getElementById("tongTienHang").text(Float.toString(sum));
					doc.getElementById("tienPhaiTra").text(Float.toString(sum+tienNo-giamGia));
					doc.getElementById("traLai").text(Float.toString(tienTra-(sum+tienNo-giamGia)));
					editorPane.setText(doc.toString());
					
					label.setText(Float.toString(tienTra-(sum+tienNo-giamGia)));
					
					//Sau tat ca gio phai them no vao ahihi:
					KhachHangDAO khdao = new KhachHangDAO();
					KhachHang kh = new KhachHang();
					kh.setMaKH(maKH);
					//check xem tien tra co lon hon 0 hay khong, neu co thi tien no se bang tien no cu 
					//tru di tien no da them vao hoa don, khong thi tien no se bang tien no cu cong voi 
					//so tien tra am ma khach tra
					if(Float.parseFloat(label.getText())<=0) {
						kh.setCongNo(Float.parseFloat(label.getText()));
					}
					else {
						kh.setCongNo(tienNo);
					}
					
					khdao.themNo(kh);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				getContentPane().add(editorPane);
			//
			//-----------Action------------------
			//
			
			//loadJavaFXScene();
	}
	/*
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
				
				print(webComponent);
			}
		});
	}
	*/
	/*
	public static void main(String[] args) {
		
		input = new File("C:\\\\Users\\\\Tuan Hiep Truong\\\\Desktop\\\\firsts.html");
		Document doc = null;
		try {
			doc = Jsoup.parse(input, null);
			//Element ban hang:
			Element e = doc.getElementById("item");
			
			Element tenSanPham = e.child(0);
			Element soLuong = e.child(1);
			Element donGia = e.child(2);
			Element thanhTien = e.child(3);
			
			System.out.println(tenSanPham.attributes().toString());
			System.out.println(soLuong.attributes().toString());
			System.out.println(donGia.text());
			System.out.println(thanhTien.text());
			
			Element copy = e.clone();
			copy.child(0).text("ten san pham");
			copy.child(1).text("so luong");
			copy.child(2).text("don gia");
			copy.child(3).text("thanh tien");
			
			doc.getElementById("itemlist").appendChild(copy);
			
			//PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
			/*
			PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
			for (int i = 0; i < services.length; i++) {
			   System.out.println(services[i].getName());
			}*/
			
			 /*
			PrintWriter writer = new PrintWriter(input,"UTF-8");
			writer.write(doc.html() ) ;
			writer.flush();
			writer.close();
			/*
			Element e11 = doc.getElementById("tenHang");
			Attributes t1 = e11.attributes();
			System.out.println(t1.toString());
			//write inner html
			e11.text("wont run ");
			//System.out.println(e11.text());
			
			Element st = e.clone();
			e.appendChild(st);
			
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
			 * 
			 */
			/*
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		/*
		JFrame j = new JFrame();
		j.setBounds(100,100,1000,1000);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		j.getContentPane().setLayout(null);
		*/
		
		//i.setVisible(true);
		//j.add(i);
			/*
	}
	*/
	 

}
