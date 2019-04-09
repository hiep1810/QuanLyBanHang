package models;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
 
public class HienThiBanSanPhamModel extends javax.swing.table.DefaultTableModel {
	SanPhamDAO cn = new SanPhamDAO();
    public HienThiBanSanPhamModel() {
		// TODO Auto-generated constructor stub
    	this.addColumn("Mã sp");
    	this.addColumn("Tên sp");
    	this.addColumn("Số lượng có");
    	this.addColumn("Giá bán");
    	this.addColumn("Thêm");
    	this.addColumn("Số lượng bán");
    	this.addColumn("Bớt");
    	this.addColumn("Xóa");
    	
    	}
    
    @Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(column == 4 || column == 6 || column == 7) {
			return super.isCellEditable(row, column);
		}
		else {
			return false;
		}
	}

	public HienThiBanSanPhamModel(String search, boolean isMaHang) {
    	cn.showBangSanPhamFind(this, search, isMaHang);
    
    }
    
    

 
    @Override
 
    public Class getColumnClass(int columnIndex) {
    //column index: vi tri cua cot ma minh can xac dinh de render 
    //day la neu column index la cot 4 thi no se getClasss cot 4(vd o day la boolean) de render thanh checkbox
    	if(columnIndex == 7)
        	return getValueAt(0, columnIndex).getClass();
    //con lai thi lai goi class cha render nhunng cai con lai
        else return super.getColumnClass(columnIndex);
 
    }
 
}