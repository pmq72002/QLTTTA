package model;

import java.util.Objects;

public class PhanCong {
	private String tenGV;
	private String lop;
	private String maPhongHoc;
	private String thu;
	private String caHoc;
	
	public PhanCong() {
	}

	public PhanCong(String tenGV, String lop,String maPhongHoc, String thu, String caHoc) {
		this.tenGV = tenGV;
		this.lop = lop;
		this.maPhongHoc = maPhongHoc;
		this.thu = thu;
		this.caHoc = caHoc;
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String maGV) {
		this.tenGV = tenGV;
	}


	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	

	public String getMaPhongHoc() {
		return maPhongHoc;
	}

	public void setMaPhongHoc(String maPhongHoc) {
		this.maPhongHoc = maPhongHoc;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getCaHoc() {
		return caHoc;
	}

	public void setCaHoc(String caHoc) {
		this.caHoc = caHoc;
	}

	@Override
	public String toString() {
		return "PhanCongGiangDay [tenGV=" + tenGV + ", Lop=" + lop + ", maPhongHoc=" + maPhongHoc + ", thu=" + thu
				+ ", caHoc=" + caHoc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(caHoc, tenGV, maPhongHoc, lop, thu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanCong other = (PhanCong) obj;
		return Objects.equals(caHoc, other.caHoc) && Objects.equals(tenGV, other.tenGV)
				&& Objects.equals(maPhongHoc, other.maPhongHoc) && Objects.equals(lop, other.lop)
				&& Objects.equals(thu, other.thu);
	}
	
}
