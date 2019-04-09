package qlbh.tam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import qlbh.entity.SanPham;
import qlbh.jdbc.Connect;

import java.awt.Scrollbar;
import javax.swing.JToolBar;
import java.awt.TextField;

public class History extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<SanPham> ds = null;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public History() {
		setTitle("QLBH");
		
		//ds = new Connect().getDsSP();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 800, 600);
		contentPane.add(tabbedPane);
		
		Panel panel = new Panel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(151, 29, 208, 27);
		panel.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 77, 373, 414);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Ch\u1ECDn ng\u00E0y");
		lblNewLabel.setBounds(75, 29, 70, 27);
		panel.add(lblNewLabel);
		
		Button button = new Button("Find");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("Mã SP\tTên SP\tSố lượng\tLọai SP\n");
				ArrayList<SanPham> ds = new ArrayList<SanPham>();
			//	ds = new Connect().getDsSP();
				try {
				for(SanPham sp : ds) {
					System.out.println(sp.getMaSP()+"\t"+sp.getTenSP()+"\t"+sp.getSoluong()+"\t"+sp.getLoaiSP());
					String a = sp.getMaSP()+"\t"+sp.getTenSP()+"\t"+sp.getSoluong()+"\t"+sp.getLoaiSP();
				}
				}catch(NullPointerException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(378, 29, 70, 27);
		panel.add(button);
		
		Panel panel_1 = new Panel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(30, 25, 434, 468);
		panel_1.add(table);
		
		
		
		
		
	}
	public JTable getTable() {
		return table;
	}
}
