/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoang minh duong
 */
public class Demo extends JFrame{
    private JLabel lma;
    private JTextField tfma;
    private JLabel ten;
    private JTextField tften;
    private JLabel lSdt;
    private JTextField tfSdt;
    private JLabel lDiaChi;
    private JTextField tfDiaChi;
    private JLabel lCongNo;
    private JTextField tfCongNo;
    private JButton bThem;
    private JButton bSua;
    private JButton bXoa;
    private JButton bReset;
    private JTable table;
    private DefaultTableModel dtm;

    public Demo() throws HeadlessException {
        init();
    }

    private void init() {
        lma = new JLabel("mMa");
        tfma = new JTextField(20);
    }
    
    
}
