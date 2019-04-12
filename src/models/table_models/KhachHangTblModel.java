package models.table_models;

import javax.swing.table.DefaultTableModel;

import models.KhachHang;
import models.KhachHangDAO;

public class KhachHangTblModel extends DefaultTableModel{
	KhachHangDAO cn = new KhachHangDAO();
	   
    public KhachHangTblModel() {
    	
    	cn.showBangKhachHang(this);
    }
    
    public KhachHangTblModel(String maKH, String tenKH, String sdt, String diaChi) {
    	cn.showBangKhachHangFind(this, maKH, tenKH, sdt, diaChi);  
    }
    public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		//Khong cho edit cell trong bang khach hang hien thi o dialog
    	return false;
	}
    public KhachHangTblModel(KhachHang khach) {
    	cn.addKhachHang(khach);
    	cn.showBangKhachHang(this);
    }
}
