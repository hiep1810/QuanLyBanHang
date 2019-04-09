package qlbh.tam;

import javax.swing.*;

import qlbh.swing.DangNhap;
import qlbh.swing.LichSuNhap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {
    public LeftPanel(){
        setLayout(new GridLayout(10,1));
        setBounds(0,0,200,600);

        JPanel title = new JPanel();
        title.setBounds(0,0,200,10);
        this.add(title);
        JLabel lbT = new JLabel("Danh má»¥c");
        title.add(lbT);
        JButton btLichSub = new JButton("Lich sá»­ bÃ¡n");
        btLichSub.setBounds(0,10,200,30);
        this.add(btLichSub);
        btLichSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabLichSu tb = new tabLichSu();
                tb.setVisible(true);
                LichSuNhap ls = new LichSuNhap();
                ls.setVisible(true);
                tb.add(ls);
            }
        });

        JButton btLichSun = new JButton("Lich sá»­ nháº­p");
        btLichSun.setBounds(0,40,200,30);
        this.add(btLichSun);
        
        JButton btLogout = new JButton("Đăng xuất");
        btLogout.setBounds(0,100,200,40);
        this.add(btLogout);
        btLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DangNhap dn = new DangNhap();
				dn.setVisible(true);
				setVisible(false);
			}
        	
        });
    }

}
