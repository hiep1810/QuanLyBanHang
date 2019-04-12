package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;
import controller.DBUtilSQLServer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CTHDBanDAO {
	

	public void showBangCTHDBan(DefaultTableModel model) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		KhachHang kh = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
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
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		for (Object a : cols) {
			model.addColumn(a);
		}
		for (Object a : data) {
			model.addRow((Vector) a);
		}
	}

	public void addCTHDBan(CTHDBan cthd) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		KhachHang kh = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		String sql = "INSERT INTO CTHDBan VALUES (?,?,?)";
		
		try {
				stmt = conn.prepareStatement(sql);

				stmt.setLong(1, cthd.getMaHDBan());
				stmt.setLong(2, cthd.getMaSP());
				stmt.setLong(3, cthd.getSlBan());
				
				stmt.executeUpdate();
			//}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu!");
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
	}

	public void editCTHDBan(CTHDBan cthd) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		KhachHang kh = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		String sql = "UPDATE CTHDBan SET slBan=? WHERE maHDBan=? AND maSP=?";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setLong(1, cthd.getSlBan());
			
			stmt.setLong(2, cthd.getMaHDBan());
			stmt.setLong(3, cthd.getMaSP());
			
			stmt.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
	}

	public boolean deleteCTHDBan(CTHDBan cthd) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		KhachHang kh = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
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
			} finally {
			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			    if (stmt != null) {
			        try {
			            stmt.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			    if (conn != null) {
			        try {
			            conn.close();
			        } catch (SQLException e) { /* ignored */}
			    }
			}

		}

		if (tich) {
			JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công!");
		}
		return tich;
	}


	
	
}
