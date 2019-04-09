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
import model.entity.KhachHang;
import model.dbConnections;

/**
 *
 * @author hoang minh duong
 */
public class KhachHangDAO implements IDAO<KhachHang> {

    private static String sqlSelectAll = "select * from khachhang";
    private static String sqlInsertNew = "insert into khachhang(tenkh,sdt,diachi,congno) values (?,?,?,?)";
    private static String sqlDelete = "delete from khachhang where makh = ?";
    private static String sqlTimTheoTen = "select * from khachhang where tenkh like ?";
    private static String sqlCapNhat = "update khachhang set tenkh = ?,sdt = ?,diachi = ?,congno=? where makh = ?";
    private static String sqlTimTheoMa = "select * from khachhang where makh = ?";
    @Override
    public List<KhachHang> getAll() {
        PreparedStatement pst = null;
        Connection cnn = null;
        ResultSet rs = null;
        List<KhachHang> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlSelectAll);
                rs = pst.executeQuery();
                list = new ArrayList<KhachHang>();
                while (rs.next()) {
                    int ma = rs.getInt("makh");
                    String ten = rs.getNString("tenkh");
                    String sdt = rs.getString("sdt");
                    String diaChi = rs.getNString("diachi");
                    float congNo = rs.getFloat("congno");
                    KhachHang kh = new KhachHang(ma, ten, sdt, diaChi, congNo);
                    list.add(kh);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

    @Override
    public List<KhachHang> timTheoTen(String s) { 
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cnn = null;
        List<KhachHang> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoTen);
                pst.setNString(1, "%" + s + "%");
                rs = pst.executeQuery();
                list = new ArrayList<KhachHang>();
                while (rs.next()) {
                    int ma = rs.getInt("makh");
                    String ten = rs.getNString("tenkh");
                    String sdt = rs.getString("sdt");
                    String diaChi = rs.getNString("diachi");
                    float congNo = rs.getFloat("congno");
                    KhachHang kh = new KhachHang(ma, ten, sdt, diaChi, congNo);
                    list.add(kh);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

    @Override
    public KhachHang themMoi(KhachHang t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlInsertNew);
                pst.setNString(1, t.getTenKH());
                pst.setString(2, t.getSoDT());
                pst.setString(3, t.getDiaChi());
                pst.setFloat(4, t.getCongNo());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public KhachHang capNhat(KhachHang t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlCapNhat);
                pst.setNString(1, t.getTenKH());
                pst.setString(2, t.getSoDT());
                pst.setString(3, t.getDiaChi());
                pst.setFloat(4, t.getCongNo());
                pst.setInt(5, t.getMaKH());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public boolean xoa(KhachHang t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlDelete);
                pst.setInt(1, t.getMaKH());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return false;
    }

    @Override
    public KhachHang hienDongClick(int row) {
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
                int ma = rs.getInt("makh");
                String ten = rs.getNString("tenkh");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diachi");
                float congNo = rs.getFloat("congno");
                KhachHang kh = new KhachHang(ma, ten, sdt, diaChi, congNo);
                return kh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return null;
    }

    @Override
    public KhachHang timTheoMa(int ma) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoMa);
                pst.setInt(1,ma);
                rs = pst.executeQuery();
                if(rs.next()) {
                    int makh = rs.getInt("makh");
                    String ten = rs.getNString("tenkh");
                    String sdt = rs.getString("sdt");
                    String diaChi = rs.getNString("diachi");
                    float congNo = rs.getFloat("congno");
                    KhachHang kh = new KhachHang(makh, ten, sdt, diaChi, congNo);
                    return kh;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return null;
    }

}
