package qlbh.entity;

import java.util.Date;

public class HoaDonNhap {
	private int maHDNhap;
	private Date ngayLap;
	private int maNPP;
	private String tenNPP;
	
	public HoaDonNhap() {
		
	}

	public HoaDonNhap(int maHDNhap, Date ngayLap, int maNPP) {
		super();
		this.maHDNhap = maHDNhap;
		this.ngayLap = ngayLap;
		this.maNPP = maNPP;
	}

	public HoaDonNhap(int maHDNhap, Date ngayLap, String tenNPP) {
		super();
		this.maHDNhap = maHDNhap;
		this.ngayLap = ngayLap;
		this.tenNPP = tenNPP;
	}
	public int getMaHDNhap() {
		return maHDNhap;
	}

	public void setMaHDNhap(int maHDNhap) {
		this.maHDNhap = maHDNhap;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
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
}
