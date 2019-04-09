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
import model.entity.NhaPP;
import model.dbConnections;

/**
 *
 * @author hoang minh duong
 */
public class NhaPPDAO implements IDAO<NhaPP> {

    private static String sqlSelectAll = "select * from nhapp";
    private static String sqlInsertNew = "insert into nhapp(tennpp,sdt,diachi) values (?,?,?)";
    private static String sqlDelete = "delete from nhapp where manpp = ?";
    private static String sqlTimTheoTen = "select * from nhapp where tennpp like ?";
    private static String sqlCapNhat = "update nhapp set tennpp = ?,sdt = ?,diachi = ? where manpp = ?";

    @Override
    public List<NhaPP> getAll() {
        PreparedStatement pst = null;
        Connection cnn = null;
        ResultSet rs = null;
        List<NhaPP> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlSelectAll);
                rs = pst.executeQuery();
                list = new ArrayList<NhaPP>();
                while (rs.next()) {
                    int ma = rs.getInt("manpp");
                    String ten = rs.getNString("tennpp");
                    String sdt = rs.getString("sdt");
                    String diaChi = rs.getNString("diachi");
                    NhaPP npp = new NhaPP(ma, ten, sdt, diaChi);
                    list.add(npp);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaPPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

    @Override
    public List<NhaPP> timTheoTen(String s) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cnn = null;
        List<NhaPP> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoTen);
                pst.setNString(1, "%" + s + "%");
                rs = pst.executeQuery();
                list = new ArrayList<NhaPP>();
                while (rs.next()) {
                    int ma = rs.getInt("manpp");
                    String ten = rs.getNString("tennpp");
                    String sdt = rs.getString("sdt");
                    String diaChi = rs.getNString("diachi");
                    NhaPP npp = new NhaPP(ma, ten, sdt, diaChi);
                    list.add(npp);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaPPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

    @Override
    public NhaPP themMoi(NhaPP t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlInsertNew);
                pst.setNString(1, t.getTenNPP());
                pst.setNString(2, t.getSdt());
                pst.setNString(3, t.getDiaChi());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaPP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public NhaPP capNhat(NhaPP t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlCapNhat);
                pst.setNString(1, t.getTenNPP());
                pst.setString(2, t.getSdt());
                pst.setString(3, t.getDiaChi());
                pst.setInt(4, t.getMaNPP());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaPP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }

    @Override
    public boolean xoa(NhaPP t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlDelete);
                pst.setInt(1, t.getMaNPP());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaPP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(null, pst, cnn);
        }
        return false;
    }

    @Override
    public NhaPP hienDongClick(int row) {
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
                int ma = rs.getInt("manpp");
                String ten = rs.getNString("tennpp");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("diachi");
                NhaPP npp = new NhaPP(ma, ten, sdt, diaChi);
                return npp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaPP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return null;
    }

    @Override
    public NhaPP timTheoMa(int ma) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection cnn = null;
        List<NhaPP> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlTimTheoTen);
                pst.setInt(1, ma);
                rs = pst.executeQuery();
                int maNPP = rs.getInt("manpp");
                String ten = rs.getNString("tennpp");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getNString("diachi");
                NhaPP npp = new NhaPP(maNPP, ten, sdt, diaChi);
                return npp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaPPDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return null;
    }

}
