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
import view.QLHVview;

public class QLHVcontroller implements ActionListener{
	public QLHVview qlhvView;
	
	
	public QLHVcontroller(QLHVview qlhvView) {
		this.qlhvView = qlhvView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		
		if(cm.equals("Clear")){
			this.qlhvView.xoaForm();
		}else
			if(cm.equals("Thêm")){
			try {
				this.qlhvView.thucHienThem();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			}else if(cm.equals("Cập nhật")) {
			this.qlhvView.showHvDaChon();
			}else if(cm.equals("Lưu")) {
				this.qlhvView.luuThongTin();
		}else if(cm.equals("Xóa")) {
			this.qlhvView.thucHienXoa();
		}else if(cm.equals("Cancel")) {
			this.qlhvView.huyBo();;
		}
		else if(cm.equals("Tìm theo mã")) {
			this.qlhvView.thucHienTimTheoMa();
		}else if(cm.equals("Tìm theo tên")) {
			this.qlhvView.thucHienTimTheoTen();
		}else if(cm.equals("Hủy tìm")) {
			this.qlhvView.thucHienHuyTim();
		}
	}
}