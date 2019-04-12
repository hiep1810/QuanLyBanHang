package models.table_models;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import models.SanPhamDAO;

public class HienThiTimKiemSanPhamModel extends DefaultTableModel {
	SanPhamDAO cn = new SanPhamDAO();
   
    public HienThiTimKiemSanPhamModel() {
    	
    	cn.showBangSanPhamFind(this);
    }
    
    public HienThiTimKiemSanPhamModel(String search, boolean isMaHang) {
    	
    	cn.showBangSanPhamFind(this, search, isMaHang);
    	  
    }
    public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(column == 4) {
			return super.isCellEditable(row, column);
		}
		else {
			return false;
		}
	}
  
}
