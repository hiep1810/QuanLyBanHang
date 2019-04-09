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
public class KhachHang {
    private int maKH;
    private String tenKH;
    private String soDT;
    private String diaChi;
    private float congNo;

    public KhachHang() {
    }

    public KhachHang(String tenKH, String soDT, String diaChi) {
        this.tenKH = tenKH;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }

    public KhachHang(int maKH, String tenKH, String soDT, String diaChi, float congNo) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.congNo = congNo;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public float getCongNo() {
        return congNo;
    }

    public void setCongNo(float congNo) {
        this.congNo = congNo;
    }
}
