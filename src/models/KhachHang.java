package models;

public class KhachHang {
	private int maKH;
	private String tenKH;
	private String sdt;
	private String diaChi;
	private float congNo;
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
	public float getCongNo() {
		return congNo;
	}
	public void setCongNo(float congNo) {
		this.congNo = congNo;
	}
	public KhachHang() {
		this.tenKH = "";
		this.maKH = 0;
		this.diaChi = "";
		this.sdt = "";
		this.congNo = 0f;
	}
	public KhachHang(int maKH, String tenKH, String sdt, String diaChi, float congNo) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.congNo = congNo;
	}
	
}
