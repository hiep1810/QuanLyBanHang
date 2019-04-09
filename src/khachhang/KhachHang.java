/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khachhang;

/**
 *
 * @author hoang minh duong
 */
public class KhachHang {
    private int ma;
    private String ten;
    private String soDT;
    private String diaChi;
    private float congNo;

    public KhachHang() {
    }

    public KhachHang(int ma, String ten, String soDT, String diaChi, float congNo) {
        this.ma = ma;
        this.ten = ten;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.congNo = congNo;
    }

    public KhachHang(String ten, String soDT, String diaChi) {
        this.ten = ten;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.congNo = 0;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
