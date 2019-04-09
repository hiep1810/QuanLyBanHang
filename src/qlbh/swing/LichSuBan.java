package qlbh.swing;

import qlbh.entity.CTHoaDonNhap;
import qlbh.entity.HoaDonBan;
import qlbh.entity.HoaDonNhap;
import qlbh.jdbc.DSHoaDonBan;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LichSuBan extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfTimkiem;
	private DefaultTableModel model1;
	private JTable tbHoaDon;
	private DefaultTableModel model2;
	private JTable tbCTHoaDon;
	DSHoaDonBan hdb;
	ArrayList<HoaDonBan> ds;

 	/**
	 * Create the panel.
	 */
	public LichSuBan() {
		hdb = new DSHoaDonBan();
		ds = hdb.getDs();
		setLayout(null);
		setBounds(0,0,1000,600);
		
		tfTimkiem = new JTextField();
		tfTimkiem.setBounds(27, 105, 226, 29);
		add(tfTimkiem);
		tfTimkiem.setColumns(10);

		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo mã hoặc theo ngày bán");
		lblTmKimTheo.setBounds(28, 71, 225, 29);
		add(lblTmKimTheo);

		Button btTimKiem = new Button("Tìm kiếm");
		btTimKiem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String text = tfTimkiem.getText();
				model1.setRowCount(0);
									if(text.length()==0)
					timKiem();
				else if(text.length()==4){
					int ma = Integer.parseInt(text);
					timKiem(ma);
				}


			}
		});
		btTimKiem.setBounds(259, 105, 70, 29);
		add(btTimKiem);
		
		model1 = new DefaultTableModel(new Object[][] {

		},
		new String[] {
				"Mã hóa đơn","Ngày lập","Tên nhân viên","Tên khách hàng"
		});
		
		tbHoaDon = new JTable(model1);
		tbHoaDon.setBounds(27, 164, 432, 380);
	
		JScrollPane sp = new JScrollPane(tbHoaDon);
		sp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		sp.setBounds(27, 164, 432, 380);
		add(sp);
		//model1 = (DefaultTableModel) tbHoaDon.getModel();
		
		model2 = new DefaultTableModel(new Object[][] {
			
		},
		new String[] {
				"Mã SP","Tên SP","Số lượng","Loại SP","Giá bán"
		});
		
		tbCTHoaDon = new JTable(model2);
		tbCTHoaDon.setBounds(508, 164, 432, 380);
		
		JScrollPane sp1 = new JScrollPane(tbCTHoaDon);
		sp1.setBounds(508, 164, 432, 380);
		add(sp1);
		

	}
	
	public void showLSNhap() {
		LichSuNhap ls = new LichSuNhap();
		this.add(ls);
		this.setVisible(false);
		ls.setVisible(true);
	}

	public boolean timKiem() {
		ds = hdb.getDs();
		for(HoaDonBan hd : ds) {
			model1.addRow(new Object[]{
					hd.getMaHDB(),hd.getNgayBan(),hd.getTenND(),hd.getTenKH()
			});
			System.out.println("Found all " +hd.getMaHDB());
		}
		if(ds.size()==0)
			return false;
		return true;
	}

	public boolean timKiem(int a) {
		ds = hdb.getDs(a);
		for(HoaDonBan hd : ds) {
			model1.addRow(new Object[]{
					hd.getMaHDB(),hd.getNgayBan(),hd.getTenND(),hd.getTenKH()
			});
			System.out.println("Found with idHD " +hd.getMaHDB());
		}
		if(ds.size()==0)
			return false;
		return true;
	}
	/*
	public boolean timKiem(int month, int year) {
		ds = hdn.getHoaDon(month, year);
		for(HoaDonNhap hd : ds) {
			model1.addRow(new Object[]{
					hd.getMaHDNhap(),hd.getNgayLap(),hd.getMaNPP()
			});
			System.out.println("Found with month & year " +hd.getNgayLap());
		}
		if(ds.size()==0)
			return false;
		return true;
	}

	public boolean timKiem(int day,int month,int year) {
		ds = hdn.getHoaDon(day,month,year);
		for(HoaDonNhap hd : ds) {
			model1.addRow(new Object[]{
					hd.getMaHDNhap(),hd.getNgayLap(),hd.getMaNPP()
			});
			System.out.println("Found with para day & month & year" +hd.getNgayLap());
		}
		if(ds.size()==0)
			return false;
		return true;
	}*/
}
