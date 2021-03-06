/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.CTHDNhapDAO;
import model.dao.HDNhapDAO;
import model.dao.SanPhamDAO;
import model.entity.CTHDNhap;
import model.entity.HDNhap;
import model.entity.SanPham;

/**
 *
 * @author hoang minh duong
 */
public class QLCTHDN extends javax.swing.JPanel {

    /**
     * Creates new form QLCTHDN
     */
    HDNhapDAO hdNhapDao;
    SanPhamDAO spDao;
    DefaultTableModel dtm;
    CTHDNhapDAO ctHD;
    DefaultComboBoxModel cbmMaHDN;
    DefaultComboBoxModel cbmMaSP;
    DefaultComboBoxModel cbmTimKiem;
    DefaultComboBoxModel cbmTenSP;
    CTHDNhap tam;

    public QLCTHDN() {
        cbmMaHDN = new DefaultComboBoxModel();
        cbmMaSP = new DefaultComboBoxModel();
        cbmTenSP = new DefaultComboBoxModel();
        cbmTimKiem = new DefaultComboBoxModel();
        hdNhapDao = new HDNhapDAO();
        spDao = new SanPhamDAO();
        dtm = new DefaultTableModel();
        ctHD = new CTHDNhapDAO();
        initComponents();
        tbCTHD.setModel(dtm);
        dtm.addColumn("Mã HDN");
        dtm.addColumn("Mã SP");
        dtm.addColumn("Đơn giá nhập");
        dtm.addColumn("Số lượng nhập");
        cbMaHDN.setModel(cbmMaHDN);
        cbMaSP.setModel(cbmMaSP);
        cbTenSP.setModel(cbmTenSP);
        cbTimKiem.setModel(cbmTimKiem);
        cbmTimKiem.removeAllElements();
        cbmTimKiem.addElement("Tìm theo mã HDN");
        cbmTimKiem.addElement("Tìm theo mã SP");
        hienThiDS();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDonGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        cbMaHDN = new javax.swing.JComboBox<>();
        cbMaSP = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbTenSP = new javax.swing.JComboBox<>();

        jLabel1.setText("Mã HDN:");

        jLabel2.setText("Mã SP:");

        jLabel3.setText("Đơn giá:");

        jLabel4.setText("Số lượng:");

        cbMaHDN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaHDN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaHDNItemStateChanged(evt);
            }
        });

        cbMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaSPItemStateChanged(evt);
            }
        });

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HDN", "Mã SP", "Đơn giá nhập", "Số lương nhập"
            }
        ));
        tbCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCTHD);

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CHI TIẾT HÓA ĐƠN NHẬP");

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cbTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTenSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTenSPItemStateChanged(evt);
            }
        });
        cbTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSoLuong)
                            .addComponent(tfDonGia)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbMaSP, javax.swing.GroupLayout.Alignment.LEADING, 0, 90, Short.MAX_VALUE)
                                .addComponent(cbMaHDN, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(btnTimKiem)
                                .addGap(28, 28, 28)
                                .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbTimKiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbMaHDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnReset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String tuKhoa = tfTimKiem.getText().trim();
        if (tuKhoa == "") {
            JOptionPane.showMessageDialog(null, "nhap tu khoa tim kiem");
            return;
        }
        int tieuChi = cbTimKiem.getSelectedIndex();
        if (tieuChi == 0) {
            List<CTHDNhap> li = ctHD.timTheoMaHDN(Integer.parseInt(tuKhoa));
            if (li != null) {
                dtm.setRowCount(0);
                for (CTHDNhap cthd : li) {
                    dtm.addRow(new String[]{cthd.getMaHDN() + "", cthd.getMaSP() + "", cthd.getDonGiaNhap() + "", cthd.getSoLuongNhap() + ""});
                }
            }
        } else {
            List<CTHDNhap> li = ctHD.timTheoMaSP(Integer.parseInt(tuKhoa));
            if (li != null) {
                dtm.setRowCount(0);
                for (CTHDNhap cthd : li) {
                    dtm.addRow(new String[]{cthd.getMaHDN() + "", cthd.getMaSP() + "", cthd.getDonGiaNhap() + "", cthd.getSoLuongNhap() + ""});
                }
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbMaHDNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaHDNItemStateChanged
//        List<HDNhap> all = hdNhapDao.getAll();
//        if(all!=null){
//            for (HDNhap hdn : all) {
//                cbMaHDN.addItem(hdn.getMaHDN()+"");
//            }
//        }
//        
    }//GEN-LAST:event_cbMaHDNItemStateChanged

    private void cbMaSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaSPItemStateChanged
//
//        int vt = cbMaSP.getSelectedIndex();
//         String giaTri = (String) cbmMaSP.getElementAt(vt);
//        cbmTenSP.setSelectedItem(giaTri);
        int vt = cbMaSP.getSelectedIndex();
        String ten = (String) cbmTenSP.getElementAt(vt);
        cbmTenSP.setSelectedItem(ten);
    }//GEN-LAST:event_cbMaSPItemStateChanged

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        cbMaHDN.setEnabled(true);
        cbMaSP.setEnabled(true);
        cbTenSP.setEnabled(true);
        Integer maHDN = (Integer) cbmMaHDN.getSelectedItem();
        Integer maSP = (Integer) cbmMaSP.getSelectedItem();
        float donGia = Float.parseFloat(tfDonGia.getText());
        int soLuong = Integer.parseInt(tfSoLuong.getText());
        CTHDNhap hdn = new CTHDNhap(maHDN, maSP, donGia, soLuong);
        CTHDNhap ok = ctHD.themMoi(hdn);
        if (ok != null) {
            JOptionPane.showMessageDialog(null, "Them moi thanh cong");
            hienThiDS();
            xoaText();
        } else {
            JOptionPane.showMessageDialog(null, "Them moi that bai");
            return;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        cbMaHDN.setEnabled(true);
        cbMaSP.setEnabled(true);
        cbTenSP.setEnabled(true);
        Integer maHDN = (Integer) cbmMaHDN.getSelectedItem();
        Integer maSP = (Integer) cbmMaSP.getSelectedItem();

        float donGia = Float.parseFloat(tfDonGia.getText());
        int soLuong = Integer.parseInt(tfSoLuong.getText());
        CTHDNhap hdn = new CTHDNhap(maHDN, maSP, donGia, soLuong);
        CTHDNhap ok = ctHD.capNhat(hdn);
        System.out.println(maHDN + "-" + maSP + "-" + donGia + "-" + soLuong);
        if (ok != null) {
            JOptionPane.showMessageDialog(null, "cap nhat thanh cong");
            hienThiDS();
            xoaText();
        } else {
            JOptionPane.showMessageDialog(null, "cap nhat that bai");
            return;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        cbMaHDN.setEnabled(true);
        cbMaSP.setEnabled(true);
        cbTenSP.setEnabled(true);
        Integer maHDN = (Integer) cbmMaHDN.getSelectedItem();
        Integer maSP = (Integer) cbmMaSP.getSelectedItem();

        CTHDNhap hdn = new CTHDNhap(maHDN, maSP);
        System.out.println("Xoa mahdn: " + maHDN + " maSP: " + maSP);
        boolean ok = ctHD.xoa(hdn);
        if (ok) {
            JOptionPane.showMessageDialog(null, "Xoa thanh cong");
            hienThiDS();
            xoaText();
        } else {
            JOptionPane.showMessageDialog(null, "Xoa that bai");
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTHDMouseClicked
        int vt = tbCTHD.getSelectedRow();
        tam = ctHD.hienDongClick(vt + 1);
        cbmMaHDN.setSelectedItem(tam.getMaHDN());
        cbmMaSP.setSelectedItem(tam.getMaSP());
        tfDonGia.setText(tam.getDonGiaNhap() + "");
        tfSoLuong.setText(tam.getSoLuongNhap() + "");
        cbMaHDN.setEnabled(false);
        cbMaSP.setEnabled(false);
        cbTenSP.setEnabled(false);
    }//GEN-LAST:event_tbCTHDMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cbMaHDN.setEnabled(true);
        cbMaSP.setEnabled(true);
        cbTenSP.setEnabled(true);
        xoaText();
    }//GEN-LAST:event_btnResetActionPerformed

    private void cbTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTenSPActionPerformed

    private void cbTenSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTenSPItemStateChanged
        int vt = cbTenSP.getSelectedIndex();
//        Integer ma = (Integer) cbmMaSP.getElementAt(vt);
       // cbmMaSP.setSelectedItem(ma);
       cbmMaSP.setSelectedItem(cbmMaSP.getElementAt(vt));
    }//GEN-LAST:event_cbTenSPItemStateChanged
    private void xoaText() {
        cbmMaHDN.setSelectedItem(cbmMaHDN.getElementAt(0));
        cbmMaSP.setSelectedItem(cbmMaSP.getElementAt(0));
        cbmTenSP.setSelectedItem(cbmTenSP.getElementAt(0));
        tfDonGia.setText("");
        tfSoLuong.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbMaHDN;
    private javax.swing.JComboBox<String> cbMaSP;
    private javax.swing.JComboBox<String> cbTenSP;
    private javax.swing.JComboBox<String> cbTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables

    private void hienThiDS() {
        List<CTHDNhap> all = ctHD.getAll();
        if (all != null) {
            dtm.setRowCount(0);
            for (CTHDNhap cthd : all) {
                dtm.addRow(new String[]{cthd.getMaHDN() + "", cthd.getMaSP() + "", cthd.getDonGiaNhap() + "", cthd.getSoLuongNhap() + ""});
            }
        }
        List<SanPham> li = spDao.getAll();
        if (li != null) {
            cbmMaSP.removeAllElements();
            cbmMaSP.addElement("Chon MaSP");
            cbmTenSP.removeAllElements();
            cbmTenSP.addElement("Chon TenSP");
            for (SanPham sp : li) {
                cbmMaSP.addElement(sp.getMaSP());
                cbmTenSP.addElement(sp.getTenSP());
            }
        }
        List<HDNhap> list = hdNhapDao.getAll();
        if (list != null) {
            cbmMaHDN.removeAllElements();
            cbmMaHDN.addElement("Chon MaHDN");
            for (HDNhap hdn : list) {
                cbmMaHDN.addElement(hdn.getMaHDN());
            }
        }
    }
}
