package qlbh.entity;

import java.util.Date;

public class HoaDonBan {
    private int maHDB;
    private int maND;
    private Date ngayBan;
    private int maKH;
    private String tenKH;
    private String tenND;

    public HoaDonBan() {
    }

    public HoaDonBan(int maHDB, int maND, Date ngayBan, int maKH) {
        this.maHDB = maHDB;
        this.maND = maND;
        this.ngayBan = ngayBan;
        this.maKH = maKH;
    }

    public int getMaHDB() {
        return maHDB;
    }

    public void setMaHDB(int maHDB) {
        this.maHDB = maHDB;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
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

    public String getTenND() {
        return tenND;
    }

    public void setTenND(String tenND) {
        this.tenND = tenND;
    }
}
