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

public class HDBanDAO {
	
	public void showBangHDBan(DefaultTableModel model) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		KhachHang kh = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		Vector<String> cols = new Vector<String>();
		cols.addElement("Mã hóa đơn");
		cols.addElement("Ngày bán");
		cols.addElement("Mã khách hàng");

		Vector data = new Vector();
		try {
			stmt = conn.createStatement();

			// where: dieu kien de tim
			rs = stmt.executeQuery("SELECT * FROM HDBan");
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

	public void addHDBan(HDBan hd) {
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
		String sql = "INSERT INTO HDBan(maKH) VALUES (?)";
		
		try {
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, hd.getMaKH());
				
				stmt.executeUpdate();
			
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
	public HDBan getHDBan() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		HDBan hd = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		try {
			
			stmt = conn.prepareStatement("SELECT TOP 1 * FROM HDBan ORDER BY maHDBan DESC ");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				hd = new HDBan();
				hd.setMaHDBan(rs.getInt(1));
				hd.setNgayBan(rs.getString(2));
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
	    return hd;
}
	public void addHDBan(int maKH) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		HDBan hd = null;
		try {
			DBUtilSQLServer db = new DBUtilSQLServer();
			conn = db.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra !" + e);
		}
		String sql = "INSERT INTO HDBan(maKH) VALUES (?)";
		
		try {
				stmt = conn.prepareStatement(sql);

				stmt.setString(1, Integer.toString(maKH));
				
				System.out.println(stmt.executeUpdate());
				
				PreparedStatement stmt1 = conn.prepareStatement("SELECT TOP 1 * FROM HDBan ORDER BY maHDBan DESC ");
				rs = stmt1.executeQuery();
				System.out.println(rs.next());
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					hd.setMaHDBan(rs.getInt(1));
					hd.setNgayBan(rs.getString(2));
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
	public void editHDBan(HDBan hd) {
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
		String sql = "UPDATE HDBan SET maKH=? WHERE maHDBan=?";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, hd.getMaKH());
			
			stmt.setLong(2, hd.getMaHDBan());
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

	public boolean deleteHDBan(HDBan hd) {
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
			String sql = "DELETE FROM HDBan WHERE maHDBan=?";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, hd.getMaHDBan());
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

	
	
}
