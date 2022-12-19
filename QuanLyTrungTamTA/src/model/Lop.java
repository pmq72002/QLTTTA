package model;

import java.util.ArrayList;
import java.util.Objects;

public class Lop {
	private int maLop;
	private String tenLop;

	public Lop(int maLop, String tenLop) {
		this.maLop = maLop;
		this.tenLop = tenLop;
	}

	public int getMaLop() {
		return maLop;
	}

	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	@Override
	public String toString() {
		return "Lop [maLop=" + maLop + ", tenLop=" + tenLop + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLop, tenLop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lop other = (Lop) obj;
		return maLop == other.maLop && Objects.equals(tenLop, other.tenLop);
	}

	public static ArrayList<Lop> getDsLop() {
		String[] arr_lop = { "...", "Lớp 250", "Lớp 450", "Lớp 550", "Lớp 650+"

		};
		ArrayList<Lop> listLop = new ArrayList<>();
		int i = 0;
		for (String tenLop : arr_lop) {
			Lop l = new Lop(i, tenLop);
			listLop.add(l);
		}
		return listLop;
	}

	public static Lop getLopById(int maLop2) {
		return Lop.getDsLop().get(maLop2);
	}

	public static Lop getLopByTen(String tenLop) {
		ArrayList<Lop> listLop = Lop.getDsLop();
		for (Lop lop : listLop) {
			if (lop.tenLop.equals(tenLop))
				return lop;
		}
		return null;
	}
}
