/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entity.CTHDNhap;
import model.dbConnections;

/**
 *
 * @author hoang minh duong
 */
public class CTHDNhapDAO implements IDAO<CTHDNhap> {

    private static String sqlSelectAll = "select * from CTHDNhap";
    private static String sqlInsertNew = "insert into CTHDNhap(mahdn,masp,soluongnhap,dongianhap) values (?,?,?,?)";
    private static String sqlDelete = "delete from CTHDNhap where mahdn = ? and masp = ? ";
    private static String sqlCapNhat = "update CTHDNhap set soluongnhap=?,dongianhap=? where mahdn=? and masp=?";
    private static String sqlTimTheoMaHDN = "select * from CTHDNhap where mahdn = ?";
    private static String sqlTimTheoMaSP = "select * from CTHDNhap where masp = ?";
    @Override
    public List<CTHDNhap> getAll() {
        Connection cnn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<CTHDNhap> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlSelectAll);
                rs = pst.executeQuery();
                list = new ArrayList<CTHDNhap>();
                while (rs.next()) {
                    int maHDN = rs.getInt("mahdn");
                    int maSP = rs.getInt("masp");
                    int sln = rs.getInt("soluongnhap");
                    float donGia = rs.getFloat("dongianhap");
                    CTHDNhap cnhd = new CTHDNhap(maHDN, maSP, donGia, sln);
                    list.add(cnhd);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

    @Override
    public List<CTHDNhap> timTheoTen(String s) {
        return null;
    }

    @Override
    public CTHDNhap themMoi(CTHDNhap t) {
        Connection cnn = null;
        PreparedStatement pst = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlInsertNew);
                pst.setInt(1, t.getMaHDN());
                pst.setInt(2, t.getMaSP());
                pst.setInt(3, t.getSoLuongNhap());
                pst.setFloat(4, t.getDonGiaNhap());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public CTHDNhap capNhat(CTHDNhap t) {
        Connection cnn = null;
        PreparedStatement pst = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlCapNhat);
                pst.setInt(1, t.getSoLuongNhap());
                pst.setFloat(2, t.getDonGiaNhap());
                pst.setInt(3, t.getMaHDN());
                pst.setInt(4, t.getMaSP());
                int row = pst.executeUpdate();
                if(row>0)
                    return t;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public boolean xoa(CTHDNhap t) {
        Connection cnn = null;
        PreparedStatement pst = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlDelete);
                pst.setInt(1, t.getMaHDN());
                pst.setInt(2, t.getMaSP());
                int row = pst.executeUpdate();
                if(row>0)
                    return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            dbConnections.closeDB(null, pst, cnn);
        }
        return false;
    }

    @Override
    public CTHDNhap hienDongClick(int row) {
         Connection cnn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlSelectAll);
                rs = pst.executeQuery();
                for (int i = 0; i < row; i++) {
                    rs.next();
                }
                int mahdn = rs.getInt(1);
                int masp = rs.getInt(2);
                int soLuongNhap = rs.getInt(3);
                float donGia = rs.getFloat(4);
                CTHDNhap cthd = new CTHDNhap(mahdn, masp, donGia, soLuongNhap);
                return cthd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return null;
    }

    @Override
    public CTHDNhap timTheoMa(int ma) {
        return null;
    }
    public List<CTHDNhap> timTheoMaHDN(int mahdn){
         Connection cnn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<CTHDNhap> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoMaHDN);
                pst.setInt(1, mahdn);
                rs = pst.executeQuery();
                list = new ArrayList<CTHDNhap>();
                while (rs.next()) {
                    int maHDN = rs.getInt("mahdn");
                    int maSP = rs.getInt("masp");
                    int sln = rs.getInt("soluongnhap");
                    float donGia = rs.getFloat("dongianhap");
                    CTHDNhap cnhd = new CTHDNhap(maHDN, maSP, donGia, sln);
                    list.add(cnhd);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }
    public List<CTHDNhap> timTheoMaSP(int masp){
         Connection cnn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<CTHDNhap> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoMaSP);
                pst.setInt(1, masp);
                rs = pst.executeQuery();
                list = new ArrayList<CTHDNhap>();
                while (rs.next()) {
                    int maHDN = rs.getInt("mahdn");
                    int maSP = rs.getInt("masp");
                    int sln = rs.getInt("soluongnhap");
                    float donGia = rs.getFloat("dongianhap");
                    CTHDNhap cnhd = new CTHDNhap(maHDN, maSP, donGia, sln);
                    list.add(cnhd);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

}
