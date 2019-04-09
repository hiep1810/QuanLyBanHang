/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 * @author hoang minh duong
 */
public class test extends JFrame{
    //QLKhachHang ql = new QLKhachHang();
   // QLSanPham ql = new QLSanPham();
    //QuanLyNhaPP ql = new QuanLyNhaPP();
    //QLCTHDN ql = new QLCTHDN();
    QLHoaDonNhap ql = new QLHoaDonNhap();

    public test() throws HeadlessException {
        this.add(ql);
        ql.setVisible(true);
        this.setSize(800,800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new test().setVisible(true);
        
    }
    
}
