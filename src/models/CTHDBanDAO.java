package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CTHDBanDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;

	public CTHDBanDAO() {
		try {
			conn = DBUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
	}

	public void showBangCTHDBan(DefaultTableModel model) {
		Vector cols = new Vector();
		cols.addElement("Mã hóa đơn");
		cols.addElement("Mã sản phẩm");
		cols.addElement("Số lượng bán");

		Vector data = new Vector();
		try {
			Statement statement = conn.createStatement();

			// where: dieu kien de tim
			rs = statement.executeQuery("SELECT * FROM CTHDBan");
			int i = 0;
			while (rs.next()) {
				// Lay thong tin tung dong ra cho vao trong vector
				Vector xemHD = new Vector();
				xemHD.addElement(rs.getString(1));
				xemHD.addElement(rs.getString(2));
				xemHD.addElement(rs.getString(3));
				
				data.add(xemHD);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !");
		}
		for (Object a : cols) {
			model.addColumn(a);
		}
		for (Object a : data) {
			model.addRow((Vector) a);
		}
	}

	public void addCTHDBan(CTHDBan cthd) {

		String sql = "INSERT INTO CTHDBan VALUES (?,?,?)";
		/*String check = "SELECT * FROM KhachHang";
		boolean test = false;
		try {
			stmt = conn.prepareStatement(check);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String compare = rs.getString("maHDBan");
				if (compare.equals(hd.getMaKH())) {
					test = true;
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Có lỗi khi thêm sản phẩm!\n" + e);
		}*/
		try {/*
			if (true) {
				JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại !");
			} else {
			*/
				stmt = conn.prepareStatement(sql);

				stmt.setLong(1, cthd.getMaHDBan());
				stmt.setLong(2, cthd.getMaSP());
				stmt.setLong(3, cthd.getSlBan());
				
				stmt.executeUpdate();
			//}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu!");
		}
	}

	public void editCTHDBan(CTHDBan cthd) {
		String sql = "UPDATE CTHDBan SET slBan=? WHERE maHDBan=? AND maSP=?";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setLong(1, cthd.getSlBan());
			
			stmt.setLong(2, cthd.getMaHDBan());
			stmt.setLong(3, cthd.getMaSP());
			
			stmt.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		}
	}

	public boolean deleteCTHDBan(CTHDBan cthd) {
		boolean tich = false;
		Object[] options = { "Yes", "No" };
		int n = JOptionPane.showOptionDialog(null, "Bạn có muốn xóa dữ liệu này không?", "Confirm to Delete?",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if (n == 0) // Confirm Delete = Yes
		{
			String sql = "DELETE FROM CTHDBan WHERE maHDBan=? AND maSP=?";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, cthd.getMaHDBan());
				stmt.setInt(2, cthd.getMaSP());
				stmt.executeUpdate();
				tich = true;
			} catch (Exception ed) {
				JOptionPane.showMessageDialog(null, "Không thể xóa ");

				tich = false;
			}
		}

		if (tich) {
			JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công!");
		}
		return tich;
	}

	public void showBangKhachHangFind(DefaultTableModel model) {
		Vector cols = new Vector();
		cols.addElement("Mã khách hàng");
		cols.addElement("Tên khách hàng");
		cols.addElement("Số điện thoại");
		cols.addElement("Địa chỉ");
		cols.addElement("Công nợ");

		for (Object a : cols) {
			model.addColumn(a);
		}

	}
	public void showKhachHangDefault(JLabel tenKH, JLabel sdt, JLabel diaChi, JLabel congNo) {
		String sql = "SELECT * FROM KhachHang LIMIT 2";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				tenKH.setText(rs.getString(2));
				sdt.setText(rs.getString(3));
				diaChi.setText(rs.getString(4));
				congNo.setText(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showBangKhachHangFind(DefaultTableModel model, String search, boolean isMaKH) {
		// TODO Auto-generated method stub

		Vector cols = new Vector();
		cols.addElement("Mã khách hàng");
		cols.addElement("Tên khách hàng");
		cols.addElement("Số điện thoại");
		cols.addElement("Địa chỉ");
		cols.addElement("Công nợ");

		Vector data = new Vector();
		try {
			String sql = "";
			if (isMaKH) {
				sql = "SELECT * FROM KhachHang WHERE maKH LIKE ?";
			} else {
				sql = "SELECT * FROM KhachHang WHERE tenKH LIKE ?";
			}
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			// where: dieu kien de tim
			rs = statement.executeQuery();
			int i = 0;
			while (rs.next()) {
				// Lay thong tin tung dong ra cho vao trong vector
				Vector xemKH = new Vector();
				xemKH.addElement(rs.getString(1));
				xemKH.addElement(rs.getString(2));
				xemKH.addElement(rs.getString(3));
				xemKH.addElement(rs.getString(4));
				xemKH.addElement(rs.getString(5));
				data.add(xemKH);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !");
		}
		for (Object a : cols) {
			model.addColumn(a);
		}
		for (Object a : data) {
			model.addRow((Vector) a);
		}
	}
	
}
