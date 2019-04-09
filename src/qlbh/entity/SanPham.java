package qlbh.entity;

public class SanPham {
	private int maSP;
	private String tenSP;
	private int soluong;
	private String loaiSP;
	private float donGia;
	
	public SanPham() {
		
	}
	public SanPham(int maSP, String tenSP, int soluong, String loaiSP, float donGia) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soluong = soluong;
		this.loaiSP = loaiSP;
		this.donGia = donGia;
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
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public float getDonGia() {
		return donGia;
	}
	
}
