package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.DBUtil;
import controller.DBUtilSQLServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class SanPhamDAO {
	
	
	public void showBangSanPhamSell(DefaultTableModel model) {
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
			rs = statement.executeQuery("SELECT * FROM SanPham");
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
		for(Object a : cols) {
			model.addColumn(a);
		}
		for(Object a : data) {
			model.addRow((Vector) a);
		}
}
	public void showBangSanPham(DefaultTableModel model) {
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
		Vector cols = new Vector();
			cols.addElement("maSP");
			cols.addElement("tenSP");
			cols.addElement("soLuongCo");
			cols.addElement("giaBan");
			Vector data = new Vector();
			try {
				Statement statement = conn.createStatement();
				
				// where: dieu kien de tim
				rs = statement.executeQuery("SELECT * FROM SanPham");
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
			for(Object a : cols) {
				model.addColumn(a);
			}
			for(Object a : data) {
				model.addRow((Vector) a);
			}
	}

	public void addSanPham(SanPham sp) {
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
		String sql = "INSERT INTO SanPham (tenSP,soLuongCo,donGiaBan) VALUES (?,?,?)";
		String check = "SELECT * FROM SanPham";
		boolean test = false;
		try {
			stmt = conn.prepareStatement(check);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String compare = rs.getString("tenSP");
				if (compare.trim().equals(sp.getTenSP())) {
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
				
				
				
				stmt.setString(1, sp.getTenSP());
				stmt.setInt(2, sp.getSoLuongCo());
				stmt.setFloat(3, sp.getGiaBan());
			
				stmt.executeUpdate();
			}
		}catch(Exception e) {
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
	public void editSanPham(SanPham sp) {
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
	public boolean deleteSanPham(SanPham sp) {
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
				sql = "SELECT * FROM SanPham WHERE maSP LIKE ?";
			}
			else {
				sql = "SELECT * FROM SanPham WHERE tenSP LIKE ?";
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
		for(Object a : cols) {
			model.addColumn(a);
		}
		for(Object a : data) {
			model.addRow((Vector) a);
		}
	}
}
