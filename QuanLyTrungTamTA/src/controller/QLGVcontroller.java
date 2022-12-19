package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import model.GiaoVien;
import view.QLGVview;

public class QLGVcontroller implements ActionListener{
	public QLGVview qlgvView;
	
	
	public QLGVcontroller(QLGVview qlgvView) {
		this.qlgvView = qlgvView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		
		if(cm.equals("Clear")){
			this.qlgvView.xoaForm();
		}else
		if(cm.equals("Thêm")){
			try {
				this.qlgvView.thucHienThem();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(cm.equals("Cập nhật")) {
			this.qlgvView.showGvDaChon();
		}else if(cm.equals("Lưu")) {
			this.qlgvView.luuThongTin();
		}else if(cm.equals("Xóa")) {
			this.qlgvView.thucHienXoa();
		}else if(cm.equals("Cancel")) {
			this.qlgvView.huyBo();;
		}
		else if(cm.equals("Tìm theo mã")) {
			this.qlgvView.thucHienTimTheoMa();
		}else if(cm.equals("Tìm theo tên")) {
			this.qlgvView.thucHienTimTheoTen();
		}else if(cm.equals("Hủy tìm")) {
			this.qlgvView.thucHienHuyTim();
		}
	}
}
