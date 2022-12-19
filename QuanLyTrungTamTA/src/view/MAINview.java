package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MAINcontroller;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MAINview extends JFrame {
	public QLGVview gvView;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAINview frame = new MAINview();
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
	
	ActionListener act = new MAINcontroller(this);
	public MAINview() {
		this.setTitle("Trung tâm Tiếng Anh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 417);
		this.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_quanLy = new JMenu("Quản lý");
		menuBar.add(menu_quanLy);
		
		JMenuItem menuItem_QLGV = new JMenuItem("Quản lý giáo viên");
		menuItem_QLGV.addActionListener(act);
		menu_quanLy.add(menuItem_QLGV);
		
		JMenuItem menuItem_QLHV = new JMenuItem("Quản lý học viên");
		menuItem_QLHV.addActionListener(act);
		menu_quanLy.add(menuItem_QLHV);
		
		JMenuItem menuItem_PCGD = new JMenuItem("Phân công giảng dạy");
		menuItem_PCGD.addActionListener(act);
		menu_quanLy.add(menuItem_PCGD);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MAINview.class.getResource("/view/background_TTTA.jpg")));
		lblNewLabel.setBounds(0, 0, 640, 360);
		getContentPane().add(lblNewLabel);
	}

	public void moTabQLGV() {
		QLGVview gvView = new QLGVview();
		gvView.newScreen();
	}

	public void moTabQLHV() {
		QLHVview hvView = new QLHVview();
		hvView.newScreen();
	}
	
	public void moTabPCGD() {
		PhanCongview pcView = new PhanCongview();
		pcView.newScreen();
	}
}
