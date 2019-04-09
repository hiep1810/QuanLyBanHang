package screen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import controller.DBUtil;



/**
 *
 * @author Tuan Hiep Truong
 */
public class LoginScreen extends javax.swing.JFrame{
	//
	private static String saveUser;
	private static String savePassword;
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	
	
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
   
    void initComponent(){

        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        
        
        //Setup screen: 
        this.setTitle("Login");
        this.setSize(350,240);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/ 2) - 175,
                        (Toolkit.getDefaultToolkit().getScreenSize().height / 2) - 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        //Set properties:
        
        //jButton1:
        jButton1.setText("Xác nhận");
        jButton1.setBounds(100,150,100,25);
        
        //jCheckBox1:
        jCheckBox1.setText("Lưu đăng nhập");
        jCheckBox1.setBounds(120,115,140,25);
        
        //jLabel1:
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel1.setText("Tài khoản:");
        jLabel1.setBounds(50, 50, 140, 25);
        
        //jLabel2:
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel2.setText("Mật khẩu:");
        jLabel2.setBounds(50, 90, 140, 25);
        
        //jLabel3:
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jLabel3.setText("Đăng nhập");
        jLabel3.setBounds(120,0,140,40);
        
        //jTextField2:
        jTextField2.setBounds(150,50,130,25);
        
        //jPasswordField1:
        jPasswordField1.setBounds(150,90,130,25);
        
        //Add control to screen:
        this.add(jButton1);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jTextField2);
        this.add(jCheckBox1);
        this.add(jPasswordField1);
        
        jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlsv = "SELECT * FROM project.sinhvien WHERE hoten=? AND idsv=? ";
				
				try {
					stmt = conn.prepareStatement(sqlsv);
					if (jTextField2.getText().toString().length() == 0) {
						JOptionPane.showMessageDialog(null, "Username không được để trống !");
					} else if (jPasswordField1.getText().toString().length() == 0) {
						JOptionPane.showMessageDialog(null, "Password không được để trống !");
					} else {
						stmt.setString(1, jTextField2.getText());
						stmt.setString(2, jPasswordField1.getText());
						rs = stmt.executeQuery();
						if (rs.next()) {
							String a = jTextField2.getText(), b = rs.getString("hoten");
							if (a.equals(b)) {
							//Login login = new Login(rs.getString("hoten"), rs.getString("idsv"), "Xin chào sinh viên");
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
							//MainForm window = new MainForm(login);
							//frmLogin.dispose();
							//window.frmMarkManagerSystem.setVisible(true);
							//window.tabbedPane.remove(window.quan_ly); //Xoa tab ql
							//window.panel_3.removeAll(); // Xoa moi chay duoc loi chao xem diem panel_1
							}else{
								JOptionPane.showMessageDialog(null, "Username sinh viên gần đúng !");
							}
						} else {
							//giaovien();
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi đăng nhập \n" + e2);
				}
			}
		});
    }
    public LoginScreen(){
    	
			conn = DBUtil.getConnection();
		
        initComponent();
    }
    public static void main(String args[]){
				try {
					LoginScreen lg = new LoginScreen();
					lg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
    }
}