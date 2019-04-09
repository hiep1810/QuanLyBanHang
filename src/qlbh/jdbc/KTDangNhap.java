package qlbh.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KTDangNhap {
	public int testLogin(String tk, String mk) {
		
		Connection con = Connect.getConnect();
		String sql = "Select chucVu from NguoiDung "
				+ "where username = ? and password = ?";
		if(con!=null) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1,tk);
				
				ps.setString(2, mk);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					if(rs.getString(1).trim().equals("admin"))//LÃ m ná»‘t phÃ¢n quyá»�n
						return 1;
					else return 2;
				}
				/*if(rs.next()==true) {
					con.close();
					return true;
				}	
				else return false;*/
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return 0;
	}
}
