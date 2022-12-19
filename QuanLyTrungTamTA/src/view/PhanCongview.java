package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import controller.PhanCongcontroller;
import model.GiaoVien;
import model.HocVien;
import model.Lop;
import model.PhanCong;
import model.PhanCongmodel;
import model.QLHVmodel;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

public class PhanCongview extends JFrame {
	public PhanCongmodel model;
	private JPanel contentPane;
	public JTextField textField_tgvTkb;
	public JTextField textField_phTkb;
	private JTable table_tkb;
	public JComboBox comboBox_thu;
	public JComboBox comboBox_ca;
	private JButton button_tkb_cancel;
	private JButton button_tkb_luu;
	private JButton button_tkb_capnhat;
	private JButton button_tkb_xoa;
	private JButton button_tkb_them;
	private JButton button_clear;
	private JButton button_xuat;
	public JComboBox comboBox_lopTKB;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhanCongview frame = new PhanCongview();
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
	public PhanCongview() {
		this.model = new PhanCongmodel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener act = new PhanCongcontroller(this);
		
		JLabel label_tttkb = new JLabel("Thông tin thời khóa biểu");
		label_tttkb.setFont(new Font("Arial", Font.BOLD, 13));
		label_tttkb.setBounds(10, 60, 164, 22);
		contentPane.add(label_tttkb);
		
		JLabel label_header = new JLabel("PHÂN CÔNG GIẢNG DẠY");
		label_header.setBounds(180, 11, 316, 31);
		label_header.setFont(new Font("Arial", Font.BOLD, 26));
		contentPane.add(label_header);
		
		JLabel label_tgvTKB = new JLabel("Tên giáo viên");
		label_tgvTKB.setFont(new Font("Arial", Font.BOLD, 18));
		label_tgvTKB.setBounds(10, 105, 126, 42);
		contentPane.add(label_tgvTKB);
		
		textField_tgvTkb = new JTextField();
		textField_tgvTkb.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_tgvTkb.setBounds(135, 112, 126, 31);
		contentPane.add(textField_tgvTkb);
		textField_tgvTkb.setColumns(10);
		
		JLabel label_lopTKB = new JLabel("Lớp");
		label_lopTKB.setFont(new Font("Arial", Font.BOLD, 18));
		label_lopTKB.setBounds(10, 158, 115, 42);
		contentPane.add(label_lopTKB);
		
		JLabel label_thuTkb = new JLabel("Thứ");
		label_thuTkb.setFont(new Font("Arial", Font.BOLD, 18));
		label_thuTkb.setBounds(370, 105, 115, 42);
		contentPane.add(label_thuTkb);
		
		JLabel label_caTkb = new JLabel("Ca học");
		label_caTkb.setFont(new Font("Arial", Font.BOLD, 18));
		label_caTkb.setBounds(370, 158, 115, 42);
		contentPane.add(label_caTkb);
		
		JLabel label_phTkb = new JLabel("Phòng học");
		label_phTkb.setFont(new Font("Arial", Font.BOLD, 18));
		label_phTkb.setBounds(10, 211, 115, 42);
		contentPane.add(label_phTkb);
		
		textField_phTkb = new JTextField();
		textField_phTkb.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_phTkb.setColumns(10);
		textField_phTkb.setBounds(135, 218, 126, 31);
		contentPane.add(textField_phTkb);
		
		comboBox_thu = new JComboBox();
		comboBox_thu.setBackground(new Color(240, 240, 240));
		comboBox_thu.setModel(new DefaultComboBoxModel(new String[] {".....", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật"}));
		comboBox_thu.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_thu.setBounds(465, 117, 115, 22);
		contentPane.add(comboBox_thu);
		
		comboBox_ca = new JComboBox();
		comboBox_ca.setBackground(new Color(240, 240, 240));
		comboBox_ca.setModel(new DefaultComboBoxModel(new String[] {".....", "Ca 1(tiết 1-3)", "Ca 2(tiết 4-6)", "Ca 3(tiết 7-9)", "Ca 4(tiết 10-12)", "Ca 5(tiết 13-16)"}));
		comboBox_ca.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_ca.setBounds(465, 170, 115, 22);
		contentPane.add(comboBox_ca);
		
		button_tkb_them = new JButton("Thêm");
		button_tkb_them.addActionListener(act);
		button_tkb_them.setIcon(new ImageIcon(PhanCongview.class.getResource("/view/plus-icon.png")));
		button_tkb_them.setFont(new Font("Arial", Font.BOLD, 14));
		button_tkb_them.setBackground(SystemColor.menu);
		button_tkb_them.setBounds(370, 213, 138, 40);
		contentPane.add(button_tkb_them);
		
		button_tkb_xoa = new JButton("Xóa");
		button_tkb_xoa.addActionListener(act);
		button_tkb_xoa.setIcon(new ImageIcon(PhanCongview.class.getResource("/view/delete-icon.png")));
		button_tkb_xoa.setFont(new Font("Arial", Font.BOLD, 14));
		button_tkb_xoa.setBackground(SystemColor.menu);
		button_tkb_xoa.setBounds(205, 498, 138, 40);
		contentPane.add(button_tkb_xoa);
		
		button_tkb_capnhat = new JButton("Cập nhật");
		button_tkb_capnhat.addActionListener(act);
		button_tkb_capnhat.setIcon(new ImageIcon(PhanCongview.class.getResource("/view/update-icon.png")));
		button_tkb_capnhat.setFont(new Font("Arial", Font.BOLD, 14));
		button_tkb_capnhat.setBackground(SystemColor.menu);
		button_tkb_capnhat.setBounds(10, 498, 138, 40);
		contentPane.add(button_tkb_capnhat);
		
		button_tkb_luu = new JButton("Lưu");
		button_tkb_luu.addActionListener(act);
		button_tkb_luu.setIcon(new ImageIcon(PhanCongview.class.getResource("/view/Save-icon.png")));
		button_tkb_luu.setFont(new Font("Arial", Font.BOLD, 14));
		button_tkb_luu.setBackground(SystemColor.menu);
		button_tkb_luu.setBounds(405, 498, 138, 40);
		
		contentPane.add(button_tkb_luu);
		
		button_tkb_cancel = new JButton("Cancel");
		button_tkb_cancel.addActionListener(act);
		button_tkb_cancel.setIcon(new ImageIcon(PhanCongview.class.getResource("/view/exit-icon.png")));
		button_tkb_cancel.setFont(new Font("Arial", Font.BOLD, 14));
		button_tkb_cancel.setBackground(SystemColor.menu);
		button_tkb_cancel.setBounds(589, 498, 138, 40);
		contentPane.add(button_tkb_cancel);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 329, 717, 144);
		contentPane.add(scrollPane);
		
		table_tkb = new JTable();
		table_tkb.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn Gi\u00E1o Vi\u00EAn", "L\u1EDBp", "Ph\u00F2ng h\u1ECDc", "Th\u1EE9", "Ca h\u1ECDc"
			}
		));
		table_tkb.getColumnModel().getColumn(0).setPreferredWidth(102);
		table_tkb.getColumnModel().getColumn(1).setPreferredWidth(102);
		table_tkb.getColumnModel().getColumn(2).setPreferredWidth(105);
		table_tkb.getColumnModel().getColumn(4).setPreferredWidth(111);
		table_tkb.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table_tkb);
		
		JLabel label_tkb_title = new JLabel("Thời khóa biểu");
		label_tkb_title.setFont(new Font("Arial", Font.BOLD, 12));
		label_tkb_title.setBounds(10, 296, 126, 22);
		contentPane.add(label_tkb_title);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 293, 717, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 92, 717, 2);
		contentPane.add(separator_1);
		
		button_clear = new JButton("Clear");
		button_clear.setBackground(new Color(240, 240, 240));
		button_clear.addActionListener(act);
		button_clear.setFont(new Font("Arial", Font.BOLD, 13));
		button_clear.setBounds(601, 117, 100, 23);
		contentPane.add(button_clear);
		
		button_xuat = new JButton("Xuất file excel");
		button_xuat.setBackground(new Color(240, 240, 240));
		button_xuat.setFont(new Font("Arial", Font.BOLD, 12));
		button_xuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				XSSFWorkbook workBook = new XSSFWorkbook();
				XSSFSheet sheet = workBook.createSheet("Thời khóa biểu");
				
				XSSFRow row = null;
				Cell cell = null;
				
				row = sheet.createRow(3);
				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue("STT");
				
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue("Tên giáo viên");
				
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue("Mã lớp");
				
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue("Phòng học");
				
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue("Thứ");
				
				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue("Tiết");
				
				List<PhanCong> listItem = model.getTkb();
				if(listItem != null) {
					int s = listItem.size();
					for(int i =0;i<s;i++) {
						PhanCong phanCong = listItem.get(i);
						row =sheet.createRow(4+ i);
						
						cell = row.createCell(0,CellType.NUMERIC);
						cell.setCellValue(i+1);
						
						cell = row.createCell(1, CellType.STRING);
						cell.setCellValue(phanCong.getTenGV()+"");
						
						cell = row.createCell(2, CellType.STRING);
						cell.setCellValue(phanCong.getLop()+"");
						
						cell = row.createCell(3, CellType.STRING);
						cell.setCellValue(phanCong.getMaPhongHoc()+"");
						
						cell = row.createCell(4, CellType.STRING);
						cell.setCellValue(phanCong.getThu()+"");
						
						cell = row.createCell(5, CellType.STRING);
						cell.setCellValue(phanCong.getCaHoc()+"");
						}
					
					File f = new File("TKB-Phan Cong.xlsx");
					FileOutputStream fis = new FileOutputStream(f);
					workBook.write(fis);
					fis.close();
				}
				}catch(Exception d) {
					d.printStackTrace();
				}
			}
				
		});
		button_xuat.setBounds(603, 296, 124, 23);
		contentPane.add(button_xuat);
		
		comboBox_lopTKB = new JComboBox();
		comboBox_lopTKB.setBackground(new Color(240, 240, 240));
		comboBox_lopTKB.setModel(new DefaultComboBoxModel(new String[] {"....", "Lớp 250", "Lớp 450", "Lớp 550", "Lớp 650+"}));
		
		comboBox_lopTKB.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBox_lopTKB.setBounds(135, 165, 168, 32);
		contentPane.add(comboBox_lopTKB);
		
	}

	//nut clear
	public void xoaForm() {
		textField_tgvTkb.setText("");
		comboBox_lopTKB.setSelectedIndex(0);
		textField_phTkb.setText("");
		comboBox_thu.setSelectedIndex(0);
		comboBox_ca.setSelectedIndex(0);
	}
	
	//Them tkb
	public void themTkbVaoTable(PhanCong pc) {
		DefaultTableModel model_table = (DefaultTableModel) table_tkb.getModel();
		model_table.addRow(new Object[] {
				pc.getTenGV()+"",
				pc.getLop()+"",
				pc.getMaPhongHoc()+"",
				pc.getThu()+"",
				pc.getCaHoc()+"",
						});
	}
	public void themTKB(PhanCong pc) {
		DefaultTableModel model_table = (DefaultTableModel) table_tkb.getModel();
		this.model.insert(pc);
		this.themTkbVaoTable(pc);
		
			}

	public void thucHienThem() {
		String maGV = this.textField_tgvTkb.getText();
		String lop = this.comboBox_lopTKB.getSelectedItem().toString();
		String maPH = this.textField_phTkb.getText();
		String thu = this.comboBox_thu.getSelectedItem().toString();
		String ca = this.comboBox_ca.getSelectedItem().toString();
		
		PhanCong pc = new PhanCong(maGV, lop, maPH, thu, ca);
		this.themTKB(pc);
	}
	//cap nhat tkb
	
	public PhanCong getTkbDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table_tkb.getModel();
		int i_row = table_tkb.getSelectedRow();
		
		String maGV = model_table.getValueAt(i_row, 0)+"";
		String lop = model_table.getValueAt(i_row, 1)+"";
		String maPH = model_table.getValueAt(i_row, 2)+"";
		String thu = model_table.getValueAt(i_row, 3)+"";
		String ca = model_table.getValueAt(i_row, 4)+"";
		
		PhanCong pc = new PhanCong(maGV, lop, maPH, thu, ca);
		return pc;
	}
	public void showTkbDangChon() {
		PhanCong pc = getTkbDangChon();
		
		this.textField_tgvTkb.setText(pc.getTenGV()+"");
		this.comboBox_lopTKB.setSelectedItem(pc.getLop());
		this.textField_phTkb.setText(pc.getMaPhongHoc()+"");
		this.comboBox_thu.setSelectedItem(pc.getThu());
		this.comboBox_ca.setSelectedItem(pc.getCaHoc());
	}

	
	public void capNhatTKB(PhanCong pc) {
		DefaultTableModel model_table = (DefaultTableModel) table_tkb.getModel();
		if(this.model.checkTenGv(pc)) {
			this.model.update(pc);
			int countRow = model_table.getRowCount();
			for (int i = 0; i < countRow; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(pc.getTenGV())) {
					model_table.setValueAt(pc.getTenGV()+"", i, 0);
					model_table.setValueAt(pc.getLop()+"", i, 1);
					model_table.setValueAt(pc.getMaPhongHoc()+"", i, 2);
					model_table.setValueAt(pc.getThu()+"",i,3);
					model_table.setValueAt(pc.getCaHoc()+"",i,4);
				}
			}
		}
				
	}
	public void luuThongTin() {
		String maGV = this.textField_tgvTkb.getText();
		String lop =this.comboBox_lopTKB.getSelectedItem().toString();
		String maPH = this.textField_phTkb.getText();
		String thu = this.comboBox_thu.getSelectedItem().toString();
		String ca = this.comboBox_ca.getSelectedItem().toString();
		
		PhanCong pc = new PhanCong(maGV,lop, maPH, thu, ca);
		this.capNhatTKB(pc);
		
	}
	// nut xoa
	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table_tkb.getModel();
		int i_row = table_tkb.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?");
		if(luaChon == JOptionPane.YES_OPTION) {
			PhanCong pc = getTkbDangChon();
			this.model.delete(pc);
			model_table.removeRow(i_row);
		}
	}
	//nut cancel
	public void huyBo() {
		this.setVisible(false);
	}
}
