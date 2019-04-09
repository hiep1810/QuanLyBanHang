package qlbh.jdbc;

import qlbh.entity.CTHoaDonBan;
import qlbh.entity.HoaDonBan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DSHoaDonBan {
    ArrayList<HoaDonBan> ds;
    ArrayList<CTHoaDonBan> dsct;

    public ArrayList<HoaDonBan> getDs(){
        Connection con = null;
        con = new Connect().getConnect();
        ds = new ArrayList<>();
        String sql = "select maHDBan,ngayBan,tenND,tenKH from HDBan as h inner join NguoiDung as n " +
                " on h.maND = n.maND inner join KhachHang as k on k.maKH = h.maKH";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHDB(rs.getInt("maHDBan"));
                hdb.setNgayBan(rs.getDate("NgayBan"));
                hdb.setTenND(rs.getString("tenND"));
                hdb.setTenKH(rs.getString("tenKH"));

                ds.add(hdb);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<HoaDonBan> getDs(int ma){
        Connection con = null;
        con = new Connect().getConnect();
        ds = new ArrayList<>();
        String sql = "select maHDBan,ngayBan,tenND,tenKH from HDBan as h inner join NguoiDung as n " +
                " on h.maND = n.maND inner join KhachHang as k " +
                " on k.maKH = h.maKH where maHDBan = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,ma);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHDB(rs.getInt(1));
                hdb.setNgayBan(rs.getDate(2));
                hdb.setTenND(rs.getString(3));
                hdb.setTenKH(rs.getString(4));

                ds.add(hdb);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public ArrayList<HoaDonBan> getDs(int day, int thang, int nam){
        Connection con = null;
        con = new Connect().getConnect();

        String sql = "select * from HDBan ";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHDB(rs.getInt(1));
                hdb.setMaND(rs.getInt(2));
                hdb.setNgayBan(rs.getDate(3));
                hdb.setMaKH(rs.getInt(4));

                ds.add(hdb);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }


}
