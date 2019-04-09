package qlbh.entity;

public class CTHoaDonBan {
    private int maHDB;
    private int maSP;
    private int soLuongBan;

    public CTHoaDonBan() {
    }

    public CTHoaDonBan(int maHDB, int maSP, int soLuongBan) {
        this.maHDB = maHDB;
        this.maSP = maSP;
        this.soLuongBan = soLuongBan;
    }

    public int getMaHDB() {
        return maHDB;
    }

    public void setMaHDB(int maHDB) {
        this.maHDB = maHDB;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }
}
