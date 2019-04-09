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
public class CTHDNhap {
    private int maHDN;
    private int maSP;
    private float donGiaNhap;
    private int soLuongNhap;

    public CTHDNhap() {
    }

    public CTHDNhap(int maHDN, int maSP, float donGiaNhap, int soLuongNhap) {
        this.maHDN = maHDN;
        this.maSP = maSP;
        this.donGiaNhap = donGiaNhap;
        this.soLuongNhap = soLuongNhap;
    }

    public CTHDNhap(int maHDN, int maSP) {
        this.maHDN = maHDN;
        this.maSP = maSP;
    }

    public int getMaHDN() {
        return maHDN;
    }

    public void setMaHDN(int maHDN) {
        this.maHDN = maHDN;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public float getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(float donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

}
