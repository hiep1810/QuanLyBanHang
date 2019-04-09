package qlbh.entity;

public class CTHoaDonNhap {
	private int maHDNhap;
	private int maSP;
	private String tenSP;
	private float donGia;
	private int soLuong;

	
	public CTHoaDonNhap() {
		
	}
	public CTHoaDonNhap( int maSP, String tenSP, float donGia, int soluong) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.soLuong = soluong;
	}
	public int getMaHDNhap() {
		return maHDNhap;
	}
	public void setMaHDNhap(int maHDNhap) {
		this.maHDNhap = maHDNhap;
	}
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soluong) {
		this.soLuong = soluong;
	}
	public double thanhTien() {
		return donGia*soLuong;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	
}
