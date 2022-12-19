package model;

import java.util.ArrayList;

public class QLHVmodel {
	private ArrayList<HocVien> dsHocVien;
	private String luachon;

	public QLHVmodel() {
		this.dsHocVien = new ArrayList<HocVien>();
	}

	public QLHVmodel(ArrayList<HocVien> dsHocVien) {
		this.dsHocVien = dsHocVien;
	}

	public ArrayList<HocVien> getDsHocVien() {
		return dsHocVien;
	}

	public void setDsHocVien(ArrayList<HocVien> dsHocVien) {
		this.dsHocVien = dsHocVien;
	}

	// phuong thuc
	public void insert(HocVien hv) {
		this.dsHocVien.add(hv);
	}

	public void delete(HocVien hv) {
		this.dsHocVien.remove(hv);
	}

	public void update(HocVien hv) {
		this.dsHocVien.remove(hv);
		this.dsHocVien.add(hv);
	}

	public String getLuachon() {
		return luachon;
	}

	public void setLuachon(String luachon) {
		this.luachon = luachon;
	}

	public boolean checkMahv(HocVien hv) {
		for (HocVien HocVien : dsHocVien) {
			if (HocVien.getMaHV().equals(hv.getMaHV()))
				return true;
		}
		return false;
	}
}
