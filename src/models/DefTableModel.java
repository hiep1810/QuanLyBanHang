package models;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;

public class DefTableModel extends DefaultTableModel{
	SanPhamDAO cn;
    @Override
    public boolean isCellEditable(int row, int column){  
    	return false;  
    }
    
    public DefTableModel() {
		// TODO Auto-generated constructor stub
    	cn = new SanPhamDAO();
    	cn.showBangSanPham(this);
    }
    
    public void xoaDongDuLieu(int row) {
    	if(row >=0) {
    		cn = new SanPhamDAO();
    		SanPham sp = new SanPham();
    		sp.setMaSP(Integer.parseInt(this.getValueAt(row, 0).toString()));
    		//xoa san pham
    		boolean check = cn.deleteSanPham(sp);
    		if(check) {
    			this.removeRow(row);
    		}
		}
		else {
			Frame frame = new Frame();
			frame.setBounds(500, 500, 300, 200);
			JOptionPane.showMessageDialog(frame, "Bạn chưa chọn dòng nào!");

		}
    }
    
    public void doDuLieu(int row, JTextField text, int column) {
    	//xac dinh vi tri dong du lieu va o du lieu can lay qua 2 bien i va viTri
    	//neu thong tin trong dong khong co gi thi phai 
        if(this.getValueAt(row, column) == null) {
        	text.setText("");
        }
        else {
        	text.setText(this.getValueAt(row, column).toString());
        }
    }
    public void updateDuLieu(int row) {
    	// them thi lam kieu gi
    	SanPham sp = new SanPham();
    	sp.setTenSP(this.getValueAt(row, 1).toString());
    	sp.setSoLuongCo(Integer.parseInt(this.getValueAt(row, 2).toString()));
    	sp.setGiaBan(Float.parseFloat(this.getValueAt(row, 3).toString()));
    	cn.editSanPham(sp);
    }
}
