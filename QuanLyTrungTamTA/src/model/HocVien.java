package model;

import java.util.Date;
import java.util.Objects;

public class HocVien {
	private String maHV;
	private String tenHV;
	private int soDT;
	private String diaChi;
	private boolean gioiTinh;
	private String lop;

	public HocVien() {
	}

	public HocVien(String maHV, String tenHV, int soDT, String diaChi, boolean gioiTinh, String lop) {
		this.maHV = maHV;
		this.tenHV = tenHV;
		this.soDT = soDT;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.lop = lop;
	}

	public String getMaHV() {
		return maHV;
	}

	public void setMaHV(String maHV) {
		this.maHV = maHV;
	}

	public String getTenHV() {
		return tenHV;
	}

	public void setTenHV(String tenHV) {
		this.tenHV = tenHV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
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
	public int hashCode() {
		return Objects.hash(diaChi, gioiTinh, lop, maHV, soDT, tenHV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HocVien other = (HocVien) obj;
		return Objects.equals(diaChi, other.diaChi) && gioiTinh == other.gioiTinh && Objects.equals(lop, other.lop)
				&& Objects.equals(maHV, other.maHV) && soDT == other.soDT && Objects.equals(tenHV, other.tenHV);
	}

	@Override
	public String toString() {
		return "HocVien [maHV=" + maHV + ", tenHV=" + tenHV + ", soDT=" + soDT + ", diaChi=" + diaChi + ", gioiTinh="
				+ gioiTinh + ", lop=" + lop + "]";
	}

}
