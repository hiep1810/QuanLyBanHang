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
import model.entity.SanPham;
import model.dbConnections;

/**
 *
 * @author hoang minh duong
 */
public class SanPhamDAO implements IDAO<SanPham> {

    private static String sqlSelectAll = "select * from sanpham";
    private static String sqlInsertNew = "insert into sanpham(tensp,soluongco,donvitinh) values (?,?,?)";
    private static String sqlDelete = "delete from sanpham where masp = ?";
    private static String sqlTimTheoTen = "select * from sanpham where tensp like ?";
    private static String sqlCapNhat = "update sanpham set tensp = ?,soluongco = ?,donvitinh = ? where masp = ?";
    private static String sqlTimTheoMa = "select * from sanpham where masp = ?";

    @Override
    public List<SanPham> getAll() {
        PreparedStatement pst = null;
        Connection cnn = null;
        ResultSet rs = null;
        List<SanPham> list = null;
        try {
            cnn = dbConnections.open();
            pst = cnn.prepareStatement(sqlSelectAll);
            rs = pst.executeQuery();
            list = new ArrayList<SanPham>();
            while (rs.next()) {
                int ma = rs.getInt("masp");
                String ten = rs.getNString("tensp");
                int soLuongCo = rs.getInt("soluongco");
                String donViTinh = "";
                SanPham sp = new SanPham(ma, ten, soLuongCo, donViTinh);
                list.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

    @Override
    public List<SanPham> timTheoTen(String s) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cnn = null;
        List<SanPham> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoTen);
                pst.setNString(1, "%" + s + "%");
                rs = pst.executeQuery();
                list = new ArrayList<SanPham>();
                while (rs.next()) {
                    int ma = rs.getInt("masp");
                    String ten = rs.getNString("tensp");
                    int soLuongCo = rs.getInt("soluongco");
                    String donViTinh = rs.getNString("donvitinh");
                    SanPham sp = new SanPham(ma, ten, soLuongCo, donViTinh);
                    list.add(sp);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;

    }

    @Override
    public SanPham themMoi(SanPham t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlInsertNew);
                pst.setNString(1, t.getTenSP());
                pst.setInt(2, 0);
                pst.setNString(3, t.getDonViTinh());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public SanPham capNhat(SanPham t) {
         PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlCapNhat);
                pst.setNString(1, t.getTenSP());
                pst.setInt(2, t.getSoLuongCo());
                pst.setNString(3, t.getDonViTinh());
                pst.setInt(4, t.getMaSP());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public boolean xoa(SanPham t) {
         PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlDelete);
                pst.setInt(1, t.getMaSP());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return false;
    }

    @Override
    public SanPham hienDongClick(int row) {
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
                int ma = rs.getInt("masp");
                String ten = rs.getNString("tensp");
                int soLuongCo = rs.getInt("soluongco");
                String donViTinh = rs.getNString("donvitinh");
                SanPham sp = new SanPham(ma, ten, soLuongCo, donViTinh);
                return sp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return null;
    }

    @Override
    public SanPham timTheoMa(int ma) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cnn = null;
        List<SanPham> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoMa);
                pst.setInt(1, ma);
                rs = pst.executeQuery();
                if(rs.next()){
                    int masp = rs.getInt("masp");
                    String ten = rs.getNString("tensp");
                    int soLuongCo = rs.getInt("soluongco");
                    String donViTinh = rs.getNString("donvitinh");
                    SanPham sp = new SanPham(masp, ten, soLuongCo, donViTinh);
                    return sp;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return null;
    }

}
