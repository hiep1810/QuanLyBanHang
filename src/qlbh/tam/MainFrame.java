package qlbh.tam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import qlbh.swing.LichSuNhap;
import qlbh.swing.LichSuBan;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.CardLayout;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel tab1;
	private JPanel tab2;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
				for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					if("Windows".equals(info.getName())) {
						
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					MainFrame frame = new MainFrame();
					
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocation(150, 50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
		
	public void showPanelLsNhap() {
		LichSuNhap ls = new LichSuNhap();
		ls.setVisible(true);
		tab1.add(ls);
	}
	
	public void showPanelLsBan() {
		LichSuBan lsb = new LichSuBan();
		lsb.setVisible(true);
		tab1.add(lsb);
	}
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new CardLayout(0, 0));
		contentPane.setLayout(null);

		LeftPanel lp = new LeftPanel();
		this.add(lp);
		lp.setVisible(true);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(200,0,1000,600);
		contentPane.add(tabbedPane, "name_12194399994184");
		
		/*tab1 = new JPanel();
		tab1.setLayout(new CardLayout(0,0));
		tab1.setVisible(true);
		showPanelLsNhap();
		tabbedPane.addTab("Lich sử", tab1);*/
		tabLichSu ls = new tabLichSu();
		ls.setVisible(true);
		tabbedPane.addTab("Lich sử", ls);
		
		
		LichSuBan lsb = new LichSuBan();
		lsb.setVisible(true);
		tabbedPane.addTab("Thống kê", lsb);
		
		
	
	}
}
