package model;

import java.sql.Date;
import java.util.Objects;

public class GiaoVien {
	private String maGV;
	private String tenGV;
	private java.util.Date ngaySinh;
	private double luongCB;
	private int soDT;
	private boolean gioiTinh;

	public GiaoVien() {
	}

	public GiaoVien(String maGV, String tenGV, java.util.Date ngaySinh, double luongCB, int soDT, boolean gioiTinh) {
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.ngaySinh = ngaySinh;
		this.luongCB = luongCB;
		this.soDT = soDT;
		this.gioiTinh = gioiTinh;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}

	public java.util.Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public double getLuongCB() {
		return luongCB;
	}

	public void setLuongCB(double luongCB) {
		this.luongCB = luongCB;
	}

	public int getSoDT() {
		return soDT;
	}

	public void setSoDT(int soDT) {
		this.soDT = soDT;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		return "GiaoVien [maGV=" + maGV + ", tenGV=" + tenGV + ", ngaySinh=" + ngaySinh + ", luongCB=" + luongCB
				+ ", soDT=" + soDT + ", gioiTinh=" + gioiTinh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioiTinh, luongCB, maGV, ngaySinh, soDT, tenGV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoVien other = (GiaoVien) obj;
		return gioiTinh == other.gioiTinh && Double.doubleToLongBits(luongCB) == Double.doubleToLongBits(other.luongCB)
				&& Objects.equals(maGV, other.maGV) && Objects.equals(ngaySinh, other.ngaySinh) && soDT == other.soDT
				&& Objects.equals(tenGV, other.tenGV);
	}

}
