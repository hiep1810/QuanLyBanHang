/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author hoang minh duong
 */
public class SanPham {
    private int maSP;
    private String tenSP;
    private int soLuongCo;
    private String donViTinh;

    public SanPham() {
    }

    public SanPham(int maSP, String tenSP, int soLuongCo, String donViTinh) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongCo = soLuongCo;
        this.donViTinh = donViTinh;
    }

    public SanPham(String tenSP, String donViTinh) {
        this.tenSP = tenSP;
        this.donViTinh = donViTinh;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuongCo() {
        return soLuongCo;
    }

    public void setSoLuongCo(int soLuongCo) {
        this.soLuongCo = soLuongCo;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

   
}
