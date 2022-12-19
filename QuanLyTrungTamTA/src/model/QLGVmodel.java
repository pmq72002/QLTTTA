package model;

import java.util.ArrayList;

public class QLGVmodel {
	private ArrayList<GiaoVien> dsGiaoVien;
	private String luachon;

	public QLGVmodel() {
		this.dsGiaoVien = new ArrayList<GiaoVien>();
	}

	public QLGVmodel(ArrayList<GiaoVien> dsGiaoVien) {
		this.dsGiaoVien = dsGiaoVien;
	}

	public ArrayList<GiaoVien> getDsGiaoVien() {
		return dsGiaoVien;
	}

	public void setDsGiaoVien(ArrayList<GiaoVien> dsGiaoVien) {
		this.dsGiaoVien = dsGiaoVien;
	}

	// phuong thuc
	public void insert(GiaoVien gv) {
		this.dsGiaoVien.add(gv);
	}

	public void delete(GiaoVien gv) {
		this.dsGiaoVien.remove(gv);
	}

	public void update(GiaoVien gv) {
		this.dsGiaoVien.remove(gv);
		this.dsGiaoVien.add(gv);
	}

	public String getLuachon() {
		return luachon;
	}

	public void setLuachon(String luachon) {
		this.luachon = luachon;
	}

	public boolean checkMaGV(GiaoVien gv) {
		for (GiaoVien giaoVien : dsGiaoVien) {
			if (giaoVien.getMaGV().equals(gv.getMaGV()))
				return true;
		}
		return false;
	}

}
