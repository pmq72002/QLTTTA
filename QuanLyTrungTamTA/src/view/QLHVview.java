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

import controller.QLHVcontroller;
//import controller.QLHVcontroller;
import model.HocVien;
import model.Lop;
import model.QLHVmodel;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class QLHVview extends JFrame {

	private JPanel contentPane;
	public QLHVmodel model;
	private JTable table;
	public JTextField textField_mhv;
	public JTextField textField_thv;
	public JTextField textField_sdthv;
	public JTextField textField_dchv;
	private JTextField textField_timMaHv;
	private JTextField textField_timTenHv;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	private JButton button_luu;
	private JButton button_capNhat;
	private JButton button_Xoa;
	public JComboBox comboBox_lop;
	private Lop lop;
	
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLHVview frame = new QLHVview();
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
	public QLHVview() {
		this.model = new QLHVmodel();
		this.setTitle("Quản lý học viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 665);
		
		ActionListener act = new QLHVcontroller(this);
				
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_header = new JLabel("QUẢN LÝ HỌC VIÊN");
		label_header.setFont(new Font("Arial", Font.BOLD, 25));
		label_header.setBounds(264, 11, 253, 45);
		contentPane.add(label_header);
		
		JLabel lblMHcVin = new JLabel("Mã Học Viên");
		lblMHcVin.setFont(new Font("Arial", Font.BOLD, 17));
		lblMHcVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblMHcVin.setBounds(10, 62, 108, 32);
		contentPane.add(lblMHcVin);
		
		textField_timMaHv = new JTextField();
		textField_timMaHv.setBounds(128, 62, 181, 33);
		contentPane.add(textField_timMaHv);
		textField_timMaHv.setColumns(10);
		
		JButton button_timMaHv = new JButton("Tìm theo mã");
		button_timMaHv.setForeground(new Color(0, 0, 0));
		button_timMaHv.setBackground(new Color(240, 240, 240));
		button_timMaHv.addActionListener(act);
		button_timMaHv.setFont(new Font("Arial", Font.BOLD, 13));
		button_timMaHv.setBounds(319, 61, 123, 34);
		contentPane.add(button_timMaHv);
		
		JLabel lblTnHcVin = new JLabel("Tên Học Viên");
		lblTnHcVin.setHorizontalAlignment(SwingConstants.LEFT);
		lblTnHcVin.setFont(new Font("Arial", Font.BOLD, 17));
		lblTnHcVin.setBounds(10, 107, 123, 32);
		contentPane.add(lblTnHcVin);
		
		textField_timTenHv = new JTextField();
		textField_timTenHv.setColumns(10);
		textField_timTenHv.setBounds(128, 106, 181, 33);
		contentPane.add(textField_timTenHv);
		
		JButton button_timTenHv = new JButton("Tìm theo tên");
		button_timTenHv.setBackground(new Color(240, 240, 240));
		button_timTenHv.setForeground(new Color(0, 0, 0));
		button_timTenHv.addActionListener(act);
		button_timTenHv.setFont(new Font("Arial", Font.BOLD, 13));
		button_timTenHv.setBounds(319, 106, 123, 34);
		contentPane.add(button_timTenHv);
		
		JLabel lblDanhSchHc = new JLabel("Danh sách học viên");
		lblDanhSchHc.setFont(new Font("Arial", Font.BOLD, 10));
		lblDanhSchHc.setBounds(10, 214, 108, 21);
		contentPane.add(lblDanhSchHc);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 389, 734, 2);
		contentPane.add(separator);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u1ECDc Vi\u00EAn", "T\u00EAn H\u1ECDc Vi\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa Ch\u1EC9", "Gi\u1EDBi T\u00EDnh", "L\u1EDBp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(114);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 234, 741, 144);
		contentPane.add(scrollPane);
		
		JLabel lblThngTinHc = new JLabel("Thông tin học viên");
		lblThngTinHc.setFont(new Font("Arial", Font.BOLD, 10));
		lblThngTinHc.setBounds(10, 402, 108, 21);
		contentPane.add(lblThngTinHc);
		
		JLabel label_maHv = new JLabel("Mã học viên");
		label_maHv.setFont(new Font("Arial", Font.BOLD, 18));
		label_maHv.setBounds(25, 434, 118, 32);
		contentPane.add(label_maHv);
		
		textField_mhv = new JTextField();
		textField_mhv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_mhv.setBounds(153, 434, 168, 32);
		contentPane.add(textField_mhv);
		textField_mhv.setColumns(10);
		
		JLabel label_tenHv = new JLabel("Tên học viên");
		label_tenHv.setFont(new Font("Arial", Font.BOLD, 18));
		label_tenHv.setBounds(25, 480, 118, 32);
		contentPane.add(label_tenHv);
		
		textField_thv = new JTextField();
		textField_thv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_thv.setColumns(10);
		textField_thv.setBounds(153, 482, 168, 32);
		contentPane.add(textField_thv);
		
		JLabel label_sdtHv = new JLabel("Số điện thoại");
		label_sdtHv.setFont(new Font("Arial", Font.BOLD, 18));
		label_sdtHv.setBounds(25, 523, 118, 32);
		contentPane.add(label_sdtHv);
		
		textField_sdthv = new JTextField();
		textField_sdthv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_sdthv.setColumns(10);
		textField_sdthv.setBounds(153, 525, 168, 32);
		contentPane.add(textField_sdthv);
		
		JLabel label_dcHv = new JLabel("Địa chỉ");
		label_dcHv.setHorizontalAlignment(SwingConstants.LEFT);
		label_dcHv.setFont(new Font("Arial", Font.BOLD, 18));
		label_dcHv.setBounds(407, 434, 135, 32);
		contentPane.add(label_dcHv);
		
		textField_dchv = new JTextField();
		textField_dchv.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_dchv.setColumns(10);
		textField_dchv.setBounds(546, 434, 168, 32);
		contentPane.add(textField_dchv);
		
		JLabel label_gtHv = new JLabel("Giới tính");
		label_gtHv.setFont(new Font("Arial", Font.BOLD, 18));
		label_gtHv.setBounds(407, 482, 82, 32);
		contentPane.add(label_gtHv);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setBounds(556, 489, 59, 23);
		contentPane.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setBounds(647, 489, 59, 23);
		contentPane.add(radioButton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);
		
		JButton button_Them = new JButton("Thêm");
		button_Them.setBackground(new Color(240, 240, 240));
		button_Them.setIcon(new ImageIcon(QLHVview.class.getResource("/view/plus-icon.png")));
		button_Them.addActionListener(act);
		button_Them.setFont(new Font("Arial", Font.BOLD, 14));
		button_Them.setBounds(10, 583, 138, 40);
		contentPane.add(button_Them);
		JButton button_Xoa = new JButton("Xóa");
		button_Xoa.setBackground(new Color(240, 240, 240));
		button_Xoa.setIcon(new ImageIcon(QLHVview.class.getResource("/view/delete-icon.png")));
		button_Xoa.addActionListener(act);
		button_Xoa.setFont(new Font("Arial", Font.BOLD, 14));
		button_Xoa.setBounds(158, 583, 138, 40);
		contentPane.add(button_Xoa);
		
		button_capNhat = new JButton("Cập nhật");
		button_capNhat.setBackground(new Color(240, 240, 240));
		button_capNhat.setIcon(new ImageIcon(QLHVview.class.getResource("/view/update-icon.png")));
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
		button_luu.setIcon(new ImageIcon(QLHVview.class.getResource("/view/Save-icon.png")));
		
		button_luu.addActionListener(act);
		button_luu.setFont(new Font("Arial", Font.BOLD, 14));
		button_luu.setBounds(456, 583, 138, 40);
		contentPane.add(button_luu);
		
		JButton button_cancel = new JButton("Cancel");
		button_cancel.addActionListener(act);
		button_cancel.setBackground(new Color(240, 240, 240));
		button_cancel.setIcon(new ImageIcon(QLHVview.class.getResource("/view/exit-icon.png")));
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
		lable_bigIcon.setIcon(new ImageIcon(QLHVview.class.getResource("/view/college-icon.png")));
		lable_bigIcon.setBounds(533, 62, 133, 128);
		contentPane.add(lable_bigIcon);
		
		JLabel label_lopHv = new JLabel("Lớp");
		label_lopHv.setFont(new Font("Arial", Font.BOLD, 18));
		label_lopHv.setBounds(407, 523, 132, 32);
		contentPane.add(label_lopHv);
		
		comboBox_lop = new JComboBox();
		comboBox_lop.setModel(new DefaultComboBoxModel(new String[] {"....", "Lớp 250", "Lớp 450", "Lớp 550", "Lớp 650+"}));
		comboBox_lop.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBox_lop.setBounds(546, 523, 168, 32);
		contentPane.add(comboBox_lop);
		
		JButton button_clear = new JButton("Clear");
		button_clear.addActionListener(act);
		button_clear.setFont(new Font("Arial", Font.BOLD, 13));
		button_clear.setBackground(SystemColor.menu);
		button_clear.setBounds(614, 401, 100, 23);
		contentPane.add(button_clear);
		
		
		
	this.setVisible(false);
	}
	//-------------------------------------------------------------khi bấm nút clear sẽ set giá trị về rỗng-------------------------------------------------------------
	public void xoaForm() {
		textField_mhv.setText("");
		textField_thv.setText("");
		textField_sdthv.setText("");
		textField_dchv.setText("");
		btn_gioiTinh.clearSelection();
		comboBox_lop.setSelectedIndex(0);
	}
	//-------------------------------------------------------------nút thêm để thêm 1 học viên mới vào-------------------------------------------------------------
	
	
	public void themHvVaoTable(HocVien hv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {
				hv.getMaHV()+"",
				hv.getTenHV()+"",
				hv.getSoDT()+"",
				hv.getDiaChi()+"",
				hv.isGioiTinh()?"Nam":"Nữ",
				hv.getLop()+"",
						});
	}
	public void themHV(HocVien hv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.checkMahv(hv)) {
		this.model.insert(hv);
		this.themHvVaoTable(hv);
	}else {
		JOptionPane.showMessageDialog(button_Xoa, "Mã học viên đã tồn tại");
		
	}
	}
	public void thucHienThem() {
		String maHV = this.textField_mhv.getText();
		String tenHv = this.textField_thv.getText();
		int soDT = Integer.valueOf(this.textField_sdthv.getText());
		String diaChi =this.textField_dchv.getText();
		boolean gioiTinh = true;
		if(this.radioButton_nam.isSelected()) {
			gioiTinh=true;
		}else
			if(this.radioButton_nu.isSelected()) {
				gioiTinh=false;
			}
		String lop = this.comboBox_lop.getSelectedItem().toString();
		
		HocVien hv = new HocVien(maHV, tenHv, soDT,diaChi, gioiTinh,lop);
		this.themHV(hv);
	}
	//-------------------------------------------------------------khi bấm vào giáo viên sẽ hiển thị lại thông tin-------------------------------------------------------------
	public HocVien getHocVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		String maHV = model_table.getValueAt(i_row, 0)+"";
		String tenHv = model_table.getValueAt(i_row, 1)+"";
		int soDT = Integer.valueOf(model_table.getValueAt(i_row, 2)+"");
		String diaChi = model_table.getValueAt(i_row, 3)+"";
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		String lop = model_table.getValueAt(i_row, 5)+"";
		
		
		HocVien hv = new HocVien(maHV, tenHv,soDT , diaChi, gioiTinh, lop);
		return hv;
		
	}
	
	public void showHvDaChon() {
		HocVien hv = getHocVienDangChon();
		
		this.textField_mhv.setText(hv.getMaHV()+"");
		this.textField_thv.setText(hv.getTenHV()+"");
		this.textField_sdthv.setText(hv.getSoDT()+"");
		
		if(hv.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		}else {
			radioButton_nu.setSelected(true);
		}
		
		this.textField_dchv.setText(hv.getDiaChi()+"");
		this.comboBox_lop.setSelectedItem(hv.getLop()+"");
		}
	//nút cập nhật
	public void capNhatHV(HocVien hv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		this.model.update(hv);
		int countRow = model_table.getRowCount();
		for (int i = 0; i < countRow; i++) {
			String id = model_table.getValueAt(i, 0)+"";
			if(id.equals(hv.getMaHV())) {
				model_table.setValueAt(hv.getMaHV()+"", i, 0);
				model_table.setValueAt(hv.getTenHV()+"", i, 1);
				model_table.setValueAt(hv.getSoDT()+"", i, 2);
				model_table.setValueAt(hv.getDiaChi()+"", i, 3);
				model_table.setValueAt(hv.isGioiTinh()?"Nam":"Nữ", i, 4);
				model_table.setValueAt(hv.getLop()+"",i, 5);
				
			}
		}
	}
	public void luuThongTin() {
		String maHV = this.textField_mhv.getText();
		String tenHv = this.textField_thv.getText();
		int soDT = Integer.valueOf(this.textField_sdthv.getText());
		String diaChi =this.textField_dchv.getText();
		boolean gioiTinh = true;
		if(this.radioButton_nam.isSelected()) {
			gioiTinh=true;
		}else
			if(this.radioButton_nu.isSelected()) {
				gioiTinh=false;
			}
		String lop = this.comboBox_lop.getSelectedItem().toString();
		
		HocVien hv = new HocVien(maHV, tenHv, soDT,diaChi, gioiTinh,lop);
		this.capNhatHV(hv);
	}
		
	//-------------------------------------------------------------nút xóa-------------------------------------------------------------
	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?");
		if(luaChon == JOptionPane.YES_OPTION) {
			HocVien hv = getHocVienDangChon();
			this.model.delete(hv);
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
		Set<Integer> idCuaHvCanXoa = new TreeSet<Integer>();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int countRow = model_table.getRowCount();
		
		String layMaHv = this.textField_timMaHv.getText();
		
		
		if(layMaHv.length()>0) {
		for (int i = 0; i < countRow; i++) {
			String id = model_table.getValueAt(i, 0)+"";
			if(!id.equals(layMaHv)) {
				idCuaHvCanXoa.add(Integer.valueOf(id));
			}
	}
}
		for(Integer idCanXoa : idCuaHvCanXoa) {
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
		Set<String> tenCuaHvCanXoa = new TreeSet<String>();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int countRow = model_table.getRowCount();
		
		String layTenHv = this.textField_timTenHv.getText();
		
		
		if(layTenHv.length()>0) {
		for (int i = 0; i < countRow; i++) {
			String ten = model_table.getValueAt(i, 1)+"";
			if(!ten.equals(layTenHv)) {
				tenCuaHvCanXoa.add(String.valueOf(ten));
			}
	}
}
		for(String tenCanXoa : tenCuaHvCanXoa) {
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
		for (HocVien hv : this.model.getDsHocVien()) {
			this.themHvVaoTable(hv);
		}
	}
}
	