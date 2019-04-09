/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khachhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.DBUtil;

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

    @Override
    public List<KhachHang> getAll() {
        PreparedStatement pst = null;
        Connection cnn = null;
        ResultSet rs = null;
        List<KhachHang> list = null;
        try {
            cnn = DBUtil.getConnection();
                pst = cnn.prepareStatement(sqlSelectAll);
                rs = pst.executeQuery();
                list = new ArrayList<KhachHang>();
                while (rs.next()) {
                    int ma = rs.getInt(1);
                    String ten = rs.getString(2);
                    String sdt = rs.getString(3);
                    String diaChi = rs.getString(4);
                    float congNo = rs.getFloat(5);
                    KhachHang kh = new KhachHang(ma, ten, sdt, diaChi, congNo);
                    list.add(kh);
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
				cnn.close();
				//pst.close();
	            rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
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
            cnn = DBUtil.getConnection();
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
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	try {
				cnn.close();
				pst.close();
	            rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return list;
    }

    @Override
    public KhachHang themMoi(KhachHang t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = DBUtil.getConnection();
                pst = cnn.prepareStatement(sqlInsertNew);
                pst.setNString(1, t.getTen());
                pst.setString(2, t.getSoDT());
                pst.setString(3, t.getDiaChi());
                pst.setFloat(4, t.getCongNo());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	try {
				cnn.close();
				pst.close();
	          
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   }
        return null;
    }

    @Override
    public KhachHang capNhat(KhachHang t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlCapNhat);
                pst.setNString(1, t.getTen());
                pst.setString(2, t.getSoDT());
                pst.setString(3, t.getDiaChi());
                pst.setFloat(4, t.getCongNo());
                pst.setInt(5, t.getMa());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return t;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	try {
				cnn.close();
				pst.close();
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        return null;
    }

    @Override
    public boolean xoa(KhachHang t) {
        PreparedStatement pst = null;
        Connection cnn = null;
        try {
            cnn = DBUtil.getConnection();
            if (cnn != null) {
                pst = cnn.prepareStatement(sqlDelete);
                pst.setInt(1, t.getMa());
                int row = pst.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	try {
				cnn.close();
				pst.close();
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return false;
    }

    @Override
    public KhachHang hienDongClick(int row) {
        Connection cnn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cnn = DBUtil.getConnection();
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
        	try {
				cnn.close();
				pst.close();
	            rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return null;
    }

}
