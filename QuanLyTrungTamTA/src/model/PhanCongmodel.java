package model;

import java.util.ArrayList;

public class PhanCongmodel {
	private ArrayList<PhanCong> tkb;
	private String luachon;

	public PhanCongmodel() {
		this.tkb = new ArrayList<PhanCong>();
	}

	public PhanCongmodel(ArrayList<PhanCong> tkb) {
		this.tkb = tkb;
	}

	public ArrayList<PhanCong> getTkb() {
		return tkb;
	}

	public void setTkb(ArrayList<PhanCong> tkb) {
		this.tkb = tkb;
	}
	//phuong thuc
	public void insert(PhanCong pc) {
		this.tkb.add(pc);
	}

	public void delete(PhanCong pc) {
		this.tkb.remove(pc);
	}

	public void update(PhanCong pc) {
		this.tkb.remove(pc);
		this.tkb.add(pc);
	}

	public String getLuachon() {
		return luachon;
	}

	public void setLuachon(String luachon) {
		this.luachon = luachon;
	}
	public boolean checkTenGv(PhanCong pc) {
		for (PhanCong phanCong : tkb) {
			if (pc.getTenGV().equals(phanCong.getTenGV()))
				return true;
		}
		return false;
	}
}
