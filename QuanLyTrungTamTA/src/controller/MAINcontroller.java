package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MAINview;

public class MAINcontroller implements ActionListener {
	public MAINview mv;
	
	public MAINcontroller(MAINview mv) {
		this.mv = mv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		if(btn.equals("Quản lý giáo viên")) {
			this.mv.moTabQLGV();
		}else
			if(btn.equals("Quản lý học viên")) {
				this.mv.moTabQLHV();
		}else
			if(btn.equals("Phân công giảng dạy")) {
					this.mv.moTabPCGD();
				}
	}
	
}
