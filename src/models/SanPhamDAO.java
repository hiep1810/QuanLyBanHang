package models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class SanPhamDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;
	
	public SanPhamDAO() {
		try {
			conn = DBUtil.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !"+e);
		}
	}
	
	public void showBangSanPhamSell(DefaultTableModel model) {
		Vector cols = new Vector();
		cols.addElement("Mã sp");
		cols.addElement("Tên sp");
		cols.addElement("Số lượng có");
		cols.addElement("Giá bán");
		cols.addElement("Thêm");
		cols.addElement("Số lượng bán");
		cols.addElement("Bớt");
		cols.addElement("Xóa");
		Vector data = new Vector();
		try {
			Statement statement = conn.createStatement();
			
			// where: dieu kien de tim
			rs = statement.executeQuery("SELECT * FROM HangHoa");
			int i = 0;
			while(rs.next()) {
				//Lay thong tin tung dong ra cho vao trong vector
				Vector xemHang = new Vector();
				xemHang.addElement(rs.getString(1));
				xemHang.addElement(rs.getString(2));
				xemHang.addElement(rs.getString(3));
				xemHang.addElement(rs.getString(4));
				xemHang.addElement("+");
				xemHang.addElement(1);
				xemHang.addElement("-");
				xemHang.addElement(new Boolean(false));
				data.add(xemHang);
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !");
		}
		for(Object a : cols) {
			model.addColumn(a);
		}
		for(Object a : data) {
			model.addRow((Vector) a);
		}
}
	public void showBangSanPham(DefaultTableModel model) {
			Vector cols = new Vector();
			cols.addElement("maSP");
			cols.addElement("tenSP");
			cols.addElement("soLuongCo");
			cols.addElement("giaBan");
			Vector data = new Vector();
			try {
				Statement statement = conn.createStatement();
				
				// where: dieu kien de tim
				rs = statement.executeQuery("SELECT * FROM HangHoa");
				int i = 0;
				while(rs.next()) {
					//Lay thong tin tung dong ra cho vao trong vector
					Vector xemHang = new Vector();
					xemHang.addElement(rs.getString(1));
					xemHang.addElement(rs.getString(2));
					xemHang.addElement(rs.getString(3));
					xemHang.addElement(rs.getString(4));
					data.add(xemHang);
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !");
			}
			for(Object a : cols) {
				model.addColumn(a);
			}
			for(Object a : data) {
				model.addRow((Vector) a);
			}
	}

	public void addSanPham(SanPham sp) {
		
		String sql = "INSERT INTO SanPham VALUES (?,?,?,?)";
		String check = "SELECT * FROM SanPham";
		boolean test = false;
		try {
			stmt = conn.prepareStatement(check);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String compare = rs.getString("maSP");
				if (compare.equals(sp.getMaSP())) {
					test = true;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Có lỗi khi thêm sản phẩm!\n" + e);
		}
		try {
			if(test) {
				JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại !");
			}else {
				stmt = conn.prepareStatement(sql);
				
				
				stmt.setLong(1, sp.getMaSP());
				stmt.setString(2, sp.getTenSP());
				stmt.setInt(3, sp.getSoLuongCo());
				stmt.setFloat(4, sp.getGiaBan());
			
				stmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu!");
		}
	}
	public void editSanPham(SanPham sp) {
		String sql = "UPDATE SanPham SET tenSP=?, soLuongCo=?, giaBan=? WHERE maSP=?";
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, sp.getTenSP());
			stmt.setInt(2, sp.getSoLuongCo());
			stmt.setFloat(3, sp.getGiaBan());
			
			stmt.setInt(4, sp.getMaSP());
			stmt.executeUpdate();
			
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		}
	}
	public boolean deleteSanPham(SanPham sp) {
		boolean tich = false;
		Object[] options = { "Yes", "No" };
		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) // Confirm Delete = Yes
		{
			String sql = "DELETE FROM SanPham WHERE maSP=?";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setLong(1, sp.getMaSP());
				stmt.executeUpdate();
				tich = true;
			} 
			catch (Exception ed) {
				JOptionPane.showMessageDialog(null,
				"Không thể xóa điểm ID " );
					
				tich = false;
			}
		}
			
		if (tich) {
			JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công!");
		}
		return tich;
	}
	public void showBangSanPhamFind(DefaultTableModel model) {
		Vector<String> cols = new Vector();
		cols.addElement("Mã sản phẩm");
		cols.addElement("Tên sản phẩm");
		cols.addElement("Số lượng có");
		cols.addElement("Giá bán");
		cols.addElement("Thêm");
		
		for(Object a : cols) {
			model.addColumn(a);
		}
		
	}
	public void showBangSanPhamFind(DefaultTableModel model, String search, boolean isMaHang) {
		// TODO Auto-generated method stub
		Vector<String> cols = new Vector<String>();
		cols.addElement("Mã sản phẩm");
		cols.addElement("Tên sản phẩm");
		cols.addElement("Số lượng có");
		cols.addElement("Giá bán");
		cols.addElement("Thêm");
		
		Vector data = new Vector();
		
		try {
			String sql = "";
			if(isMaHang) {
				sql = "SELECT * FROM HangHoa WHERE maHang LIKE ?";
			}
			else {
				sql = "SELECT * FROM HangHoa WHERE tenHang LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%"+search+"%");
			// where: dieu kien de tim
			rs = statement.executeQuery();
			int i = 0;
			while(rs.next()) {
				//Lay thong tin tung dong ra cho vao trong vector
				Vector xemHang = new Vector();
				xemHang.addElement(rs.getString(1));
				xemHang.addElement(rs.getString(2));
				xemHang.addElement(rs.getString(3));
				xemHang.addElement(rs.getString(4));
				xemHang.addElement("+");
				data.add(xemHang);
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !");
		}
		for(Object a : cols) {
			model.addColumn(a);
		}
		for(Object a : data) {
			model.addRow((Vector) a);
		}
	}
}
