package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLGVcontroller;
import model.GiaoVien;
import model.QLGVmodel;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class QLGVview extends JFrame {

	private JPanel contentPane;
	public QLGVmodel model;
	private JTable table;
	public JTextField textField_mgv;
	public JTextField textField_tgv;
	public JTextField textField_nsgv;
	public JTextField textField_sdtgv;
	public JTextField textField_lcbgv;
	private JTextField textField_timMaGv;
	private JTextField textField_timTenGv;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	private JButton button_luu;
	private JButton button_capNhat;
	private Component button_Xoa;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLGVview frame = new QLGVview();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLGVview() {
		this.model = new QLGVmodel();
		this.setTitle("Quản lý giáo viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 665);
		
		ActionListener act = new QLGVcontroller(this);
				
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_header = new JLabel("QUẢN LÝ GIÁO VIÊN");
		label_header.setFont(new Font("Arial", Font.BOLD, 25));
		label_header.setBounds(264, 11, 253, 45);
		contentPane.add(label_header);
		
		JLabel label_timMaGv = new JLabel("Mã Giáo Viên");
		label_timMaGv.setFont(new Font("Arial", Font.BOLD, 17));
		label_timMaGv.setHorizontalAlignment(SwingConstants.LEFT);
		label_timMaGv.setBounds(10, 62, 108, 32);
		contentPane.add(label_timMaGv);
		
		textField_timMaGv = new JTextField();
		textField_timMaGv.setBounds(128, 62, 181, 33);
		contentPane.add(textField_timMaGv);
		textField_timMaGv.setColumns(10);
		
		JButton button_timMaGv = new JButton("Tìm theo mã");
		button_timMaGv.setForeground(new Color(0, 0, 0));
		button_timMaGv.setBackground(new Color(240, 240, 240));
		button_timMaGv.addActionListener(act);
		button_timMaGv.setFont(new Font("Arial", Font.BOLD, 13));
		button_timMaGv.setBounds(319, 61, 123, 34);
		contentPane.add(button_timMaGv);
		
		JLabel label_timTenGv = new JLabel("Tên Giáo Viên");
		label_timTenGv.setHorizontalAlignment(SwingConstants.LEFT);
		label_timTenGv.setFont(new Font("Arial", Font.BOLD, 17));
		label_timTenGv.setBounds(10, 107, 123, 32);
		contentPane.add(label_timTenGv);
		
		textField_timTenGv = new JTextField();
		textField_timTenGv.setColumns(10);
		textField_timTenGv.setBounds(128, 106, 181, 33);
		contentPane.add(textField_timTenGv);
		
		JButton button_timTenGv = new JButton("Tìm theo tên");
		button_timTenGv.setBackground(new Color(240, 240, 240));
		button_timTenGv.setForeground(new Color(0, 0, 0));
		button_timTenGv.addActionListener(act);
		button_timTenGv.setFont(new Font("Arial", Font.BOLD, 13));
		button_timTenGv.setBounds(319, 106, 123, 34);
		contentPane.add(button_timTenGv);
		
		JLabel label_dsgvTittle = new JLabel("Danh sách giáo viên");
		label_dsgvTittle.setFont(new Font("Arial", Font.BOLD, 10));
		label_dsgvTittle.setBounds(10, 214, 108, 21);
		contentPane.add(label_dsgvTittle);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 389, 734, 2);
		contentPane.add(separator);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Gi\u00E1o Vi\u00EAn", "T\u00EAn Gi\u00E1o Vi\u00EAn", "Ng\u00E0y Sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "L\u01B0\u01A1ng c\u0103n b\u1EA3n", "Gi\u1EDBi t\u00EDnh"
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 234, 741, 144);
		contentPane.add(scrollPane);
		
		JLabel label_ttgvTittle = new JLabel("Thông tin giáo viên");
		label_ttgvTittle.setFont(new Font("Arial", Font.BOLD, 10));
		label_ttgvTittle.setBounds(10, 402, 108, 21);
		contentPane.add(label_ttgvTittle);
		
		JLabel label_mgv = new JLabel("Mã giáo viên");
		label_mgv.setFont(new Font("Arial", Font.BOLD, 18));
		label_mgv.setBounds(25, 434, 118, 32);
		contentPane.add(label_mgv);
		
		textField_mgv = new JTextField();
		textField_mgv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_mgv.setBounds(153, 434, 168, 32);
		contentPane.add(textField_mgv);
		textField_mgv.setColumns(10);
		
		JLabel label_tgv = new JLabel("Tên giáo viên");
		label_tgv.setFont(new Font("Arial", Font.BOLD, 18));
		label_tgv.setBounds(25, 482, 118, 32);
		contentPane.add(label_tgv);
		
		textField_tgv = new JTextField();
		textField_tgv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_tgv.setColumns(10);
		textField_tgv.setBounds(153, 482, 168, 32);
		contentPane.add(textField_tgv);
		
		JLabel label_nsgv = new JLabel("Ngày sinh");
		label_nsgv.setFont(new Font("Arial", Font.BOLD, 18));
		label_nsgv.setBounds(25, 525, 118, 32);
		contentPane.add(label_nsgv);
		
		textField_nsgv = new JTextField();
		textField_nsgv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_nsgv.setColumns(10);
		textField_nsgv.setBounds(153, 525, 168, 32);
		contentPane.add(textField_nsgv);
		
		JLabel label_sdtgv = new JLabel("Số điện thoại");
		label_sdtgv.setFont(new Font("Arial", Font.BOLD, 18));
		label_sdtgv.setBounds(407, 434, 118, 32);
		contentPane.add(label_sdtgv);
		
		textField_sdtgv = new JTextField();
		textField_sdtgv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_sdtgv.setColumns(10);
		textField_sdtgv.setBounds(546, 434, 168, 32);
		contentPane.add(textField_sdtgv);
		
		JLabel label_lcbgv = new JLabel("Lương căn bản");
		label_lcbgv.setHorizontalAlignment(SwingConstants.LEFT);
		label_lcbgv.setFont(new Font("Arial", Font.BOLD, 18));
		label_lcbgv.setBounds(407, 482, 135, 32);
		contentPane.add(label_lcbgv);
		
		textField_lcbgv = new JTextField();
		textField_lcbgv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_lcbgv.setColumns(10);
		textField_lcbgv.setBounds(546, 482, 168, 32);
		contentPane.add(textField_lcbgv);
		
		JLabel label_gtgv = new JLabel("Giới tính");
		label_gtgv.setFont(new Font("Arial", Font.BOLD, 18));
		label_gtgv.setBounds(407, 525, 82, 32);
		contentPane.add(label_gtgv);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setBounds(556, 532, 59, 23);
		contentPane.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setBounds(647, 532, 59, 23);
		contentPane.add(radioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);
		
		JButton button_Them = new JButton("Thêm");
		button_Them.setBackground(new Color(240, 240, 240));
		button_Them.setIcon(new ImageIcon(QLGVview.class.getResource("/view/plus-icon.png")));
		button_Them.addActionListener(act);
		button_Them.setFont(new Font("Arial", Font.BOLD, 14));
		button_Them.setBounds(10, 583, 138, 40);
		contentPane.add(button_Them);
		JButton button_Xoa = new JButton("Xóa");
		button_Xoa.setBackground(new Color(240, 240, 240));
		button_Xoa.setIcon(new ImageIcon(QLGVview.class.getResource("/view/delete-icon.png")));
		button_Xoa.addActionListener(act);
		button_Xoa.setFont(new Font("Arial", Font.BOLD, 14));
		button_Xoa.setBounds(158, 583, 138, 40);
		contentPane.add(button_Xoa);
		
		button_capNhat = new JButton("Cập nhật");
		button_capNhat.setBackground(new Color(240, 240, 240));
		button_capNhat.setIcon(new ImageIcon(QLGVview.class.getResource("/view/update-icon.png")));
		button_capNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_capNhat.addActionListener(act);
		button_capNhat.setFont(new Font("Arial", Font.BOLD, 14));
		button_capNhat.setBounds(308, 583, 138, 40);
		contentPane.add(button_capNhat);
		
		button_luu = new JButton("Lưu");
		button_luu.setBackground(new Color(240, 240, 240));
		button_luu.setIcon(new ImageIcon(QLGVview.class.getResource("/view/Save-icon.png")));
		
		button_luu.addActionListener(act);
		button_luu.setFont(new Font("Arial", Font.BOLD, 14));
		button_luu.setBounds(456, 583, 138, 40);
		contentPane.add(button_luu);
		
		JButton button_cancel = new JButton("Cancel");
		button_cancel.setBackground(new Color(240, 240, 240));
		button_cancel.setIcon(new ImageIcon(QLGVview.class.getResource("/view/exit-icon.png")));
		button_cancel.addActionListener(act);
		button_cancel.setFont(new Font("Arial", Font.BOLD, 14));
		button_cancel.setBounds(603, 583, 138, 40);
		contentPane.add(button_cancel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(13, 201, 731, 2);
		contentPane.add(separator_1);
		
		JButton button_huyTim = new JButton("Hủy tìm");
		button_huyTim.setForeground(new Color(0, 0, 0));
		button_huyTim.setBackground(new Color(240, 240, 240));
		button_huyTim.addActionListener(act);
		button_huyTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_huyTim.setFont(new Font("Arial", Font.BOLD, 13));
		button_huyTim.setBounds(319, 151, 123, 34);
		contentPane.add(button_huyTim);
		
		JLabel lable_bigIcon = new JLabel("");
		lable_bigIcon.setIcon(new ImageIcon(QLGVview.class.getResource("/view/college-icon.png")));
		lable_bigIcon.setBounds(533, 62, 133, 128);
		contentPane.add(lable_bigIcon);
		
		JButton button_clear = new JButton("Clear");
		button_clear.addActionListener(act);
		button_clear.setFont(new Font("Arial", Font.BOLD, 13));
		button_clear.setBackground(SystemColor.menu);
		button_clear.setBounds(614, 402, 100, 23);
		contentPane.add(button_clear);
		
		
		
	this.setVisible(false);
	}
	//-------------------------------------------------------------khi bấm nút clear sẽ set giá trị về rỗng-------------------------------------------------------------
	public void xoaForm() {
		textField_mgv.setText("");
		textField_tgv.setText("");
		textField_nsgv.setText("");
		textField_sdtgv.setText("");
		textField_lcbgv.setText("");
		btn_gioiTinh.clearSelection();
		button_luu.setEnabled(true);
	}
	//-------------------------------------------------------------nút thêm -------------------------------------------------------------
	
	
	public void themGvVaoTable(GiaoVien gv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {
				gv.getMaGV()+"",
				gv.getTenGV()+"",
				gv.getNgaySinh().getDate()+"/"+(gv.getNgaySinh().getMonth()+1)+"/"+(gv.getNgaySinh().getYear()+1900),
				gv.getSoDT()+"",
				gv.getLuongCB()+"",
				gv.isGioiTinh()?"Nam":"Nữ",
						});
	}
	public void themGV(GiaoVien gv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.checkMaGV(gv)) {
		this.model.insert(gv);
		this.themGvVaoTable(gv);
	}else {
		JOptionPane.showMessageDialog(button_Xoa, "Mã giáo viên đã tồn tại");
		
	}
	}
	public void thucHienThem() {
		String maGV = this.textField_mgv.getText();
		String tenGv = this.textField_tgv.getText();
		java.util.Date ngaySinh = new Date(this.textField_nsgv.getText());
		double luongCB = Double.valueOf(this.textField_lcbgv.getText());
		int soDT = Integer.valueOf(this.textField_sdtgv.getText());
		
		boolean gioiTinh = true;
		if(this.radioButton_nam.isSelected()) {
			gioiTinh=true;
		}else
			if(this.radioButton_nu.isSelected()) {
				gioiTinh=false;
			}
		
		GiaoVien gv = new GiaoVien(maGV, tenGv, ngaySinh, luongCB, soDT, gioiTinh);
		this.themGV(gv);
	}
	//-------------------------------------------------------------khi bấm vào giáo viên sẽ hiển thị lại thông tin-------------------------------------------------------------
	public GiaoVien getGiaoVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		String maGV = model_table.getValueAt(i_row, 0)+"";
		String tenGv = model_table.getValueAt(i_row, 1)+"";
		//String ngaySinh = this.qlgvView.textField_nsgv.getText();
		String s_ngaySinh = model_table.getValueAt(i_row, 2)+"";
		java.util.Date ngaySinh = new Date(s_ngaySinh);
		int soDT = Integer.valueOf(model_table.getValueAt(i_row, 3)+"");
		double luongCB = Double.valueOf(model_table.getValueAt(i_row, 4)+"");
		String textGioiTinh = model_table.getValueAt(i_row, 5)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		
		GiaoVien gv = new GiaoVien(maGV, tenGv, ngaySinh, luongCB, soDT, gioiTinh);
		return gv;
		
	}
	
	public void showGvDaChon() {
		GiaoVien gv = getGiaoVienDangChon();
		
		this.textField_mgv.setText(gv.getMaGV()+"");
		this.textField_tgv.setText(gv.getTenGV()+"");
		String s_ngaySinh = gv.getNgaySinh().getDate()+"/"+(gv.getNgaySinh().getMonth()+1)+"/"+(gv.getNgaySinh().getYear()+1900);
		this.textField_nsgv.setText(s_ngaySinh+"");
		this.textField_sdtgv.setText(gv.getSoDT()+"");
		this.textField_lcbgv.setText(gv.getLuongCB()+"");
		
		if(gv.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		}else {
			radioButton_nu.setSelected(true);
		}
		}
	//cập nhật giáo viên
	public void capNhatGV(GiaoVien gv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		this.model.update(gv);
		int countRow = model_table.getRowCount();
		for (int i = 0; i < countRow; i++) {
			String id = model_table.getValueAt(i, 0)+"";
			if(id.equals(gv.getMaGV())) {
				model_table.setValueAt(gv.getMaGV()+"", i, 0);
				model_table.setValueAt(gv.getTenGV()+"", i, 1);
				model_table.setValueAt(gv.getNgaySinh().getDate()+"/"+(gv.getNgaySinh().getMonth()+1)+"/"+(gv.getNgaySinh().getYear()+1900), i, 2);
				model_table.setValueAt(gv.getSoDT()+"", i, 3);
				model_table.setValueAt(gv.getLuongCB()+"", i, 4);
				model_table.setValueAt(gv.isGioiTinh()?"Nam":"Nữ", i, 5);
			}
		}
	}
	public void luuThongTin() {
		String maGV = this.textField_mgv.getText();
		String tenGv = this.textField_tgv.getText();
		java.util.Date ngaySinh = new Date(this.textField_nsgv.getText());
		double luongCB = Double.valueOf(this.textField_lcbgv.getText());
		int soDT = Integer.valueOf(this.textField_sdtgv.getText());
		
		boolean gioiTinh = true;
		if(this.radioButton_nam.isSelected()) {
			gioiTinh=true;
		}else
			if(this.radioButton_nu.isSelected()) {
				gioiTinh=false;
			}
		
		GiaoVien gv = new GiaoVien(maGV, tenGv, ngaySinh, luongCB, soDT, gioiTinh);
		this.capNhatGV(gv);
	}
	//-------------------------------------------------------------nút xóa-------------------------------------------------------------
	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?");
		if(luaChon == JOptionPane.YES_OPTION) {
			GiaoVien gv = getGiaoVienDangChon();
			this.model.delete(gv);
			model_table.removeRow(i_row);
		}
	}
	
	
	//-------------------------------------------------------------nút cancel-------------------------------------------------------------
	public void huyBo() {
		this.setVisible(false);
	}

	//-------------------------------------------------------------nút tìm theo mã-------------------------------------------------------------
	public void thucHienTimTheoMa() {
		//gọi hàm hủy tìm trước
		this.thucHienHuyTim();
		//tìm kiếm
		Set<Integer> idCuaGvCanXoa = new TreeSet<Integer>();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int countRow = model_table.getRowCount();
		
		String layMaGv = this.textField_timMaGv.getText();
		
		
		if(layMaGv.length()>0) {
		for (int i = 0; i < countRow; i++) {
			String id = model_table.getValueAt(i, 0)+"";
			if(!id.equals(layMaGv)) {
				idCuaGvCanXoa.add(Integer.valueOf(id));
			}
	}
}
		for(Integer idCanXoa : idCuaGvCanXoa) {
			countRow = model_table.getRowCount();
			for (int i = 0; i < countRow; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
						;
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
		}
		}
}

	
	//-------------------------------------------------------------nút tìm theo tên-------------------------------------------------------------
	
	
	public void thucHienTimTheoTen() {
		this.thucHienHuyTim();
		Set<String> tenCuaGvCanXoa = new TreeSet<String>();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int countRow = model_table.getRowCount();
		
		String layTenGv = this.textField_timTenGv.getText();
		
		
		if(layTenGv.length()>0) {
		for (int i = 0; i < countRow; i++) {
			String ten = model_table.getValueAt(i, 1)+"";
			if(!ten.equals(layTenGv)) {
				tenCuaGvCanXoa.add(String.valueOf(ten));
			}
	}
}
		for(String tenCanXoa : tenCuaGvCanXoa) {
			countRow = model_table.getRowCount();
			for (int i = 0; i < countRow; i++) {
				String tenTrongTable = model_table.getValueAt(i, 1)+"";
				if(tenTrongTable.equals(tenCanXoa)) {
					try {
						model_table.removeRow(i);
						;
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
		}
		
		
	}
}
	//-------------------------------------------------------------nút hủy tìm-------------------------------------------------------------
	
	public void thucHienHuyTim() {
		//xóa các dòng đã tìm kiếm được
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int countRow = model_table.getRowCount();
			if(countRow==0) {
				break;
			}else {
				model_table.removeRow(0);
			}
		}
		//thêm lại danh sách giáo viên vào table
		for (GiaoVien gv : this.model.getDsGiaoVien()) {
			this.themGvVaoTable(gv);
		}
	}
}

