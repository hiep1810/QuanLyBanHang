package qlbh.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
	static Connection cnn;
	static ResultSet rs;
	static PreparedStatement stmt;
	public static void main(String[] args) {
		cnn = Connect.getConnect();
		try {
			stmt = cnn.prepareStatement("SELECT* FROM KhachHang");
			rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
