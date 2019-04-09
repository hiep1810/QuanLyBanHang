/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.Date;

/**
 *
 * @author hoang minh duong
 */
public class HDNhap {
    private int maHDN;
    private Date ngayNhap;
    private int maNPP;

    public HDNhap() {
    }

    public HDNhap(int maHDN, Date ngayNhap, int maNPP) {
        this.maHDN = maHDN;
        this.ngayNhap = ngayNhap;
        this.maNPP = maNPP;
    }

    public HDNhap(int maNPP) {
        this.maNPP = maNPP;
    }

    public int getMaHDN() {
        return maHDN;
    }

    public void setMaHDN(int maHDN) {
        this.maHDN = maHDN;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getMaNPP() {
        return maNPP;
    }

    public void setMaNPP(int maNPP) {
        this.maNPP = maNPP;
    }

}
