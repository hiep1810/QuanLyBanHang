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

public class KhachHangDAO {
	/*
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement stmt;
	
	public KhachHangDAO() {
		try {
			conn = DBUtilSQLServer.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
	}
	*/
	
	public void showBangKhachHang(DefaultTableModel model) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		Vector cols = new Vector();
		cols.addElement("Mã khách hàng");
		cols.addElement("Tên khách hàng");
		cols.addElement("Số điện thoại");
		cols.addElement("Địa chỉ");
		cols.addElement("Công nợ");

		Vector data = new Vector();
		try {
			Statement statement = conn.createStatement();

			// where: dieu kien de tim
			rs = statement.executeQuery("SELECT * FROM KhachHang");
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
		}finally {
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

	public void addKhachHang(KhachHang kh) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		/*PreparedStatement stmt1 = null;
		Connection connection = null;
		*/
		String sql = "INSERT INTO KhachHang (tenKH,sdt,diaChi,congNo)VALUES (?,?,?,?)";
		String check = "SELECT * FROM KhachHang";
		boolean test = false;
		try {
			Statement statement = conn.createStatement();
			rs = statement.executeQuery(check);
			while (rs.next()) {
				
				String compare = rs.getString("sdt");
				if (compare.trim().equals(kh.getSdt().trim())) {
					System.out.println("true");
					test = true;
				}
			}
			rs.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Có lỗi khi thêm sản phẩm!\n");
			e.printStackTrace();
		}
		
		
		try {
			if (test) {
				JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại !");
			} else {
			
				
				stmt = conn.prepareStatement(sql);
				
				
				stmt.setString(1, kh.getTenKH());
				stmt.setString(2, kh.getSdt());
				stmt.setString(3, kh.getDiaChi());
				stmt.setFloat(4, 0);

				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu!");
		}finally {
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

	public void editKhachHang(KhachHang kh) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		String sql = "UPDATE KhachHang SET tenKH=?, sdt=?, diaChi=? congNo=? WHERE maKH=?";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getSdt());
			stmt.setString(3, kh.getDiaChi());
			stmt.setFloat(4, kh.getCongNo());

			stmt.setInt(5, kh.getMaKH());
			stmt.executeUpdate();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi cập nhật !");
		}finally {
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

	public boolean deleteKhachHang(KhachHang kh) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
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
			String sql = "DELETE FROM KhachHang WHERE maKH=?";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, kh.getMaKH());
				stmt.executeUpdate();
				tich = true;
			} catch (Exception ed) {
				JOptionPane.showMessageDialog(null, "Không thể xóa ");

				tich = false;
			}finally {
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
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		String sql = "SELECT * FROM KhachHang LIMIT 2";
		try {
			PreparedStatement stmt1 = conn.prepareStatement(sql);
			rs = stmt1.executeQuery();
			while(rs.next()) {
				tenKH.setText(rs.getString(2));
				sdt.setText(rs.getString(3));
				diaChi.setText(rs.getString(4));
				congNo.setText(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	public void showBangKhachHangFind(DefaultTableModel model, String maKH, String tenKH, String sdt, String diaChi) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		Vector<String> cols = new Vector<String>();
		cols.addElement("Mã khách hàng");
		cols.addElement("Tên khách hàng");
		cols.addElement("Số điện thoại");
		cols.addElement("Địa chỉ");
		cols.addElement("Công nợ");

		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			String sql = "";
			
			sql = "SELECT * FROM KhachHang WHERE maKH LIKE ? AND tenKH LIKE ? AND sdt LIKE ? AND diaChi LIKE ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, maKH + "%");
			stmt.setString(2, tenKH + "%");
			stmt.setString(3, sdt + "%");
			stmt.setString(4, diaChi + "%");
			// where: dieu kien de tim
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				// Lay thong tin tung dong ra cho vao trong vector
				Vector<String> xemKH = new Vector<String>();
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
		}finally {
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
	
}
