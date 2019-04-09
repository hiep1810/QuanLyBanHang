package qlbh.jdbc;

import java.sql.*;
import java.util.ArrayList;

import qlbh.entity.CTHoaDonNhap;
import qlbh.entity.HoaDonNhap;


public class DSHoaDonNhap {
	
	private ArrayList<HoaDonNhap> ds;
	private ArrayList<CTHoaDonNhap> dsct;
	
	public ArrayList<HoaDonNhap> getHoaDon(){
		ds = new ArrayList<HoaDonNhap>();
		Connection con = null;
		con = new Connect().getConnect();
		String sql = "select maHDNhap, ngayNhap, n.tenNPP from HDNhap as h inner join NhaPP as n " +
				"on h.maNPP = n.maNPP";
		if(con!=null) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					HoaDonNhap hd = new HoaDonNhap(rs.getInt(1),rs.getDate(2),rs.getString(3));
					ds.add(hd);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ds;
	}
	
	public ArrayList<HoaDonNhap> getHoaDon(int ma){
		ds = new ArrayList<HoaDonNhap>();
		Connection con = null;
		con = new Connect().getConnect();
		String sql = "select maHDNhap, ngayNhap, n.tenNPP from HDNhap as h inner join NhaPP as n " +
				" on h.maNPP = n.maNPP where maHDNhap = ?";
		if(con!=null) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, ma);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					HoaDonNhap hd = new HoaDonNhap(rs.getInt(1),rs.getDate(2),rs.getString(3));
					ds.add(hd);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ds;
	}
	
	public ArrayList<HoaDonNhap> getHoaDon(int thang, int nam){
		ds = new ArrayList<HoaDonNhap>();
		Connection con = null;
		con = new Connect().getConnect();
		String sqlThang = "select maHDNhap, ngayNhap, n.tenNPP from HDNhap as h inner join NhaPP as n " +
				" on h.maNPP = n.maNPP where MONTH(ngayNhap) = ? and Year(ngayNhap) = ?";
		if(con!=null) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sqlThang);
				ps.setInt(1,thang);
				ps.setInt(2, nam);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					HoaDonNhap hd = new HoaDonNhap(rs.getInt(1),rs.getDate(2),rs.getString(3));
					ds.add(hd);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ds;
	}
	
	public ArrayList<HoaDonNhap> getHoaDon(int ngay, int thang, int nam){
		ds = new ArrayList<HoaDonNhap>();
		Connection con = null;
		con = new Connect().getConnect();
		String sqlAll = "select maHDNhap, ngayNhap, n.tenNPP from HDNhap as h inner join NhaPP as n " +
				" on h.maNPP = n.maNPP where DAY(ngayNhap) = ? and MONTH(ngayNhap) = ? and YEAR(ngayNhap) = ?";
		
		if(con!=null) {
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sqlAll);
				ps.setInt(1,ngay);
				ps.setInt(2, thang);
				ps.setInt(3, nam);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					HoaDonNhap hd = new HoaDonNhap(rs.getInt(1),rs.getDate(2),rs.getString(3));
					ds.add(hd);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ds;
	}

	/*public ArrayList<CTHoaDonNhap> getCTHoaDon(int ma){
		dsct = new ArrayList<CTHoaDonNhap>();
		Connection con = null;
		con = new Connect().getConnect();
		String sql = "select c.maSP,tenSP,donGiaNhap,slNhap from CTHDNhap as c inner join SanPham as s "
				+ "on c.maSP = s.maSP where maHDNhap = ?";
		String sql1= "select * from CTHDNhap where maHDNhap = ?";
		if(con!=null) {
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(sql1);
				ps.setInt(1, ma);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					CTHoaDonNhap hd = new CTHoaDonNhap(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getInt(4));
					dsct.add(hd);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dsct;
	}*/
	
	public ArrayList<CTHoaDonNhap> getCTHoaDonSP(int ma){
		dsct = new ArrayList<CTHoaDonNhap>();
		Connection con = null;
		con = new Connect().getConnect();
		String sql = "select c.maSP,tenSP,donGiaNhap,slNhap from CTHDNhap as c inner join SanPham as s "
				+ "on c.maSP = s.maSP where maHDNhap = ?";
	//	String sql1= "select * from CTHDNhap where maHDNhap = ?";
		if(con!=null) {
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, ma);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					CTHoaDonNhap hd = new CTHoaDonNhap(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
					dsct.add(hd);
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getInt(4));
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dsct;
	}

	public double tongNhap(){
		double tong= 0;
		String sql = "select * from vw_tongNhap";
		Connection con = new Connect().getConnect();

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				tong = rs.getDouble(1);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tong;
	}
}
