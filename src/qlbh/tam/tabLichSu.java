package qlbh.tam;

import javax.swing.JButton;
import javax.swing.JPanel;

import qlbh.swing.LichSuNhap;
import qlbh.swing.LichSuBan;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tabLichSu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LichSuNhap ls;
	LichSuBan lsb;
	/**
	 * Create the panel.
	 */
	public void showlsn() {
		ls = new LichSuNhap();
		this.add(ls);
		lsb.setVisible(false);
		ls.setVisible(true);
		
	}
	
	public void showlsb() {
		lsb = new LichSuBan();
		this.add(lsb);
		ls.setVisible(false);
		lsb.setVisible(true);
		System.out.println("show tabls");		
	}
	public tabLichSu() {
		//setLayout(new CardLayout(0, 0));
		setLayout(null);
		setBounds(0,0,1000,600);
		//ls = new LichSu();
	//	lsb = new LichSuBan();
		
		//lsb.setVisible(true);
		//ls.setVisible(true);*/
		JButton btBan = new JButton();
		btBan.setText("Lich sử bán");
		btBan.setBounds(500, 50, 100, 40);
		this.add(btBan);
		
		JButton btNhap = new JButton();
		btNhap.setText("Lich sử Nhập");
		btNhap.setBounds(700, 50, 100, 40);
		this.add(btNhap);
		
		btNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showlsn();
				//add(ls);
				//ls.setVisible(true);
			}
		});
		
		
		btBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showlsb();
				//add(lsb);
				//lsb.setVisible(true);
			}
		});
		
	}
	

}
