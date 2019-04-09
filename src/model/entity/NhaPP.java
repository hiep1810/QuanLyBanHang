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
public class NhaPP {
    private int maNPP;
    private String tenNPP;
    private String sdt;
    private String diaChi;

    public NhaPP() {
    }
   
    public NhaPP(String tenNPP, String sdt, String diaChi) {
        this.tenNPP = tenNPP;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public NhaPP(int maNPP, String tenNPP, String sdt, String diaChi) {
        this.maNPP = maNPP;
        this.tenNPP = tenNPP;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public int getMaNPP() {
        return maNPP;
    }

    public void setMaNPP(int maNPP) {
        this.maNPP = maNPP;
    }

    public String getTenNPP() {
        return tenNPP;
    }

    public void setTenNPP(String tenNPP) {
        this.tenNPP = tenNPP;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
}
