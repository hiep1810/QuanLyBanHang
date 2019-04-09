/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang minh duong
 */
public class dbConnections {
    private static final String url="jdbc:sqlserver://localhost:1433; databasename=QLBH";
    private static final String username="sa";
    private static final String password="123456";
    public static Connection open(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cnn = DriverManager.getConnection(url, username, password);
            return cnn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbConnections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(dbConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void closeDB(ResultSet rs,Statement st,Connection cnn)
    {
        try {
            if(rs!=null&&!rs.isClosed())
                rs.close();
                } catch (SQLException ex) {
            Logger.getLogger(dbConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(st!=null&&!st.isClosed())
                st.close();
                } catch (SQLException ex) {
            Logger.getLogger(dbConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(cnn!=null&&!cnn.isClosed())
                cnn.close();
                } catch (SQLException ex) {
            Logger.getLogger(dbConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
