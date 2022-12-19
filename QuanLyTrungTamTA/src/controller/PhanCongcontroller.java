package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PhanCongview;

public class PhanCongcontroller implements ActionListener {
	public PhanCongview pcv;
	
	public PhanCongcontroller(PhanCongview pcv) {
		this.pcv = pcv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();		
		if(btn.equals("Clear")) {
			this.pcv.xoaForm();
			
		}else
		if(btn.equals("Thêm")) {
			this.pcv.thucHienThem();
			
		}else
			if(btn.equals("Cập nhật")) {
			this.pcv.showTkbDangChon();
		}else
			if(btn.equals("Lưu")){
			this.pcv.luuThongTin();
		}else
			if(btn.equals("Xóa")){
			this.pcv.thucHienXoa();
		}else
			if(btn.equals("Cancel")){
			this.pcv.huyBo();
			}
	}
	}

