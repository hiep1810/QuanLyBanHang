package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.DBUtilSQLServer;

public class CloseDatabase {
	
	
	public static void main(String[] args){
		
		DBUtilSQLServer.checkConnection();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
		    // Do stuff
			conn = DBUtilSQLServer.getConnection();
		    ps = conn.prepareStatement("Select * FROM KhachHang");
		    rs = ps.executeQuery();

		} catch (SQLException ex) {
		    // Exception handling stuff
		    
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
	}
}
