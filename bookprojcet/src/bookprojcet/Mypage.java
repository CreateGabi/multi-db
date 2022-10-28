package bookprojcet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class Mypage {
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	
	public Mypage() {
		JFrame f = new JFrame();
		f.setSize(1200, 700);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("마이페이지");
		lblNewLabel.setBounds(79, 73, 97, 30);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("현재 금액 :");
		lblNewLabel_1.setBounds(147, 135, 97, 30);
		f.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("충전 금액 :");
		lblNewLabel_1_1.setBounds(147, 214, 97, 30);
		f.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(252, 140, 96, 21);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(252, 219, 96, 21);
		f.getContentPane().add(t2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("장바구니 내역");
		lblNewLabel_1_1_1.setBounds(147, 305, 97, 30);
		f.getContentPane().add(lblNewLabel_1_1_1);
		
		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(225, 355, 780, 213);
		f.getContentPane().add(table);
		f.setVisible(true);
	}
}
