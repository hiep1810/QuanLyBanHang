package khachhang;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame f = new JFrame();
    	f.setBounds(10,10,1000,1000);
    	f.setVisible(true);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	QLKhachHang panel = new QLKhachHang();
    	panel.setBounds(5,5,995,995);
    	f.add(panel);
    	
	}
	

}
