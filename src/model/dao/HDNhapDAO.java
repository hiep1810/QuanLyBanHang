/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entity.HDNhap;
import model.dbConnections;

/**
 *
 * @author hoang minh duong
 */
public class HDNhapDAO {
    private static String sqlSelectAll = "select * from HDNhap";
    private static String sqlInsertNew = "insert into HDNhap(manpp) values(?)";

    public List<HDNhap> getAll() {
        Connection cnn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<HDNhap> list = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlSelectAll);
                rs = pst.executeQuery();
                list = new ArrayList<HDNhap>();
                while (rs.next()) {
                    int ma = rs.getInt(1);
                    Date date = rs.getDate(2);
                    java.util.Date ngayNhap = new java.util.Date(date.getTime());
                    int maNPP = rs.getInt(3);
                    HDNhap hd = new HDNhap(ma, ngayNhap, maNPP);
                    list.add(hd);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConnections.closeDB(rs, pst, cnn);
        }
        return list;
    }

    public HDNhap themHDN(HDNhap hd) {
        Connection cnn = null;
        PreparedStatement pst = null;
        try {
            cnn = dbConnections.open();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlInsertNew);
                pst.setInt(1, hd.getMaNPP());
                int row = pst.executeUpdate();
                if(row>0)
                    return hd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HDNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            dbConnections.closeDB(null, pst, cnn);
        }
        return null;
    }
}
