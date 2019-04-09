package qlbh.swing;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import qlbh.entity.CTHoaDonNhap;
import qlbh.entity.HoaDonNhap;
import qlbh.jdbc.DSHoaDonNhap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.KeyAdapter;

public class LichSuNhap extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfTimkiem;
	private JTable tbHoaDon;
	private JTable tbCTHoaDon;
	private DefaultTableModel model1;
	ArrayList<HoaDonNhap> ds;
	ArrayList<CTHoaDonNhap> dsct;
	DSHoaDonNhap hdn;
	private DefaultTableModel model2;
	DecimalFormat df = new DecimalFormat("##,###,###đ");
	/**
	 * Create the panel.
	 */
	public LichSuNhap() {
		hdn = new DSHoaDonNhap();
		ds = hdn.getHoaDon();
		setLayout(null);
		setBounds(0,0,1000,600);	

		tfTimkiem = new JTextField();
		tfTimkiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					String getNgay = tfTimkiem.getText();
					model1.setRowCount(0);
					
					
					if(getNgay.isEmpty())//ko nhập tim tất cả
						//if(timKiem() == false)
						//	JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1); 
						timKiem();
					else if(getNgay.length()==4){//mã có 1 hoặc 4 ký tự
						int ma = Integer.parseInt(getNgay);
						timKiem(ma);
						//if(timKiem(ma)==false)
						//JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1); 
						
					}else {
							String [] date = getNgay.split("-");		//Tim theo ngày tháng		
							try {
								int day = Integer.parseInt(date[0]);
								int month = Integer.parseInt(date[1]);
								if(date.length==3){
									int year = Integer.parseInt(date[2]);
									timKiem(day, month, year);
									//if(timKiem(day, month, year)==false)
										//JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1);
								}else
									timKiem(day,month);
									//if(timKiem(day,month)==false)
										//JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1);
							}catch(Exception e1) {
								JOptionPane.showMessageDialog(null, "Ký tự nhập không đúng", "Nhắc nhở", 2);
								tfTimkiem.setText("");
						}
					}
					tfTimkiem.setText("");
				}
			}
		});
		tfTimkiem.setBounds(27, 105, 226, 29);
		add(tfTimkiem);
		tfTimkiem.setColumns(10);
		
		
		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo mã hóa đơn, theo ngày (dd-mm-yyyy) hoặc theo tháng (mm-yyyy)");
		lblTmKimTheo.setBounds(28, 71, 397, 29);
		add(lblTmKimTheo);
		
		Button btTimKiem = new Button("Tìm kiếm");
		btTimKiem.setBounds(259, 105, 70, 29);
		add(btTimKiem);

		//tfTimkiem.addKeyListener(KeyEvent.VK_ENTER);
		model1 = new DefaultTableModel(new Object[][] {
			
		},
		new String[] {
				"Mã hóa đơn","Ngày lập","Tên NPP"
		});
		
		btTimKiem.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				//String text = tfTimkiem.getText();
				
				String getNgay = tfTimkiem.getText();
				model1.setRowCount(0);
				
				
				if(getNgay.isEmpty())//ko nhập tim tất cả
					//if(timKiem() == false)
					//	JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1); 
					timKiem();
				else if(getNgay.length()==4){//mã có 1 hoặc 4 ký tự
					int ma = Integer.parseInt(getNgay);
					timKiem(ma);
					//if(timKiem(ma)==false)
					//JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1); 
					
				}else {
						String [] date = getNgay.split("-");		//Tim theo ngày tháng		
						try {
							int day = Integer.parseInt(date[0]);
							int month = Integer.parseInt(date[1]);
							if(date.length==3){
								int year = Integer.parseInt(date[2]);
								timKiem(day, month, year);
								//if(timKiem(day, month, year)==false)
									//JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1);
							}else
								timKiem(day,month);
								//if(timKiem(day,month)==false)
									//JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn nào", "Thông báo", 1);
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Ký tự nhập không đúng", "Nhắc nhở", 2);
							tfTimkiem.setText("");
					}
				}
				tfTimkiem.setText("");
				
			}
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
				"Tên SP","Đơn giá","Số lượng","Tổng"
		});
		
		tbCTHoaDon = new JTable(model2);
		tbCTHoaDon.setBounds(508, 164, 432, 380);
		
		JScrollPane sp1 = new JScrollPane(tbCTHoaDon);
		sp1.setBounds(508, 164, 432, 380);
		add(sp1);
		
		Button button = new Button("Chi tiết");
		button.setBounds(355, 105, 70, 29);
		add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int col = 0;
				int row = tbHoaDon.getSelectedRow();
				
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "Hãy chọn 1 hóa đơn", "Nhắc nhở", 1);
				}
				else {
					model2.setRowCount(0);
					int maHD = (int) tbHoaDon.getValueAt(row, col);
					dsct = hdn.getCTHoaDonSP(maHD);
					double tong=0f;
					for(CTHoaDonNhap ct : dsct) {
						tong += ct.thanhTien();
						model2.addRow(new Object[] {
								ct.getTenSP(),ct.getDonGia(),ct.getSoLuong(),df.format(ct.thanhTien())
						});
					}
					model2.addRow(new Object[]{
							null,null,"Thành tiền",df.format(tong)
					});
				}
			}
		});

		TextField tfTgNhap = new TextField();
		tfTgNhap.setBounds(700, 105,70,29);
		this.add(tfTgNhap);

		Button btTgNhap = new Button("Tổng tiền nhập:");
		btTgNhap.setBounds(550,105,120,29);
		this.add(btTgNhap);
		btTgNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfTgNhap.setText(String.valueOf(df.format(hdn.tongNhap())));
			}
		});

		
	}

	public void showLSBan() {
		LichSuBan lsb = new LichSuBan();
		this.add(lsb);
		this.setVisible(false);
		lsb.setVisible(true);
	}
	
	public boolean timKiem() {
		ds = hdn.getHoaDon();
		for(HoaDonNhap hd : ds) {
			model1.addRow(new Object[]{
					hd.getMaHDNhap(),hd.getNgayLap(),hd.getTenNPP()
			});
			System.out.println("Found all " +hd.getMaHDNhap());
		}
		if(ds.size()==0)
			return false;
		return true;
	}
	
	public boolean timKiem(int a) {
		ds = hdn.getHoaDon(a);
		for(HoaDonNhap hd : ds) {
			model1.addRow(new Object[]{
					hd.getMaHDNhap(),hd.getNgayLap(),hd.getTenNPP()
			});
			System.out.println("Found with idHD " +hd.getMaHDNhap());
		}
		if(ds.size()==0)
			return false;
		return true;
	}
	public boolean timKiem(int month, int year) {
		ds = hdn.getHoaDon(month, year);
		for(HoaDonNhap hd : ds) {
			model1.addRow(new Object[]{
					hd.getMaHDNhap(),hd.getNgayLap(),hd.getTenNPP()
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
					hd.getMaHDNhap(),hd.getNgayLap(),hd.getTenNPP()
			});
			System.out.println("Found with para day & month & year" +hd.getNgayLap());
		}
		if(ds.size()==0)
			return false;
		return true;
	}
}
