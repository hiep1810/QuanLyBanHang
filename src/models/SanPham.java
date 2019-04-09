package models;

public class SanPham {
	private int maSP;
	private String tenSP;
	private int soLuongCo;
	private float giaBan;
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
	public float getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(float giaBan) {
		this.giaBan = giaBan;
	}
	public SanPham(int maSP, String tenSP, int soLuongCo, float giaBan) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuongCo = soLuongCo;
		this.giaBan = giaBan;
	}
	public SanPham() {
		this.maSP = 0;
		this.tenSP = "";
		this.soLuongCo = 0;
		this.giaBan = 0;
	}
	
}
