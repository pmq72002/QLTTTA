package test;

import javax.swing.UIManager;

import view.QLGVview;

public class test {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLGVview();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
