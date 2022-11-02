package db_connect;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class MemberUI3 {
	private static JTable table;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 700);
		
		JLabel lblNewLabel = new JLabel("회원정보목록");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		f.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.CENTER);
		
		// table의 항목명은 1차원 배열로
		String[] header = {"아이디", "패스워드", "이름", "전화번호"};
		
		// main()이 시작하자마자, dao.list()
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.list();
		
		Object[][] all = new Object[list.size()][4];
		// table의 내용은 2차원 배열로
		for (int i = 0; i < list.size(); i++) {
			MemberVO bag = list.get(i);
				all[i][0] = bag.getId();
				all[i][1] = bag.getPw();
				all[i][2] = bag.getName();
				all[i][3] = bag.getTel();
		}
		
		table = new JTable(all, header);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 행
				int rowNo = table.getSelectedRow();
				// 열
				int colNo = table.getSelectedColumn();
				
				// 한줄 다~ 가지고 봐보세요
//				Object value = table.getSelectedColumn();
				Object id = table.getModel().getValueAt(rowNo, 0);
				Object pw = table.getModel().getValueAt(rowNo, 1);
				Object name = table.getModel().getValueAt(rowNo, 2);
				Object tel = table.getModel().getValueAt(rowNo, 3);
				JOptionPane.showMessageDialog(table, id + " " + pw + " " + name + " " + tel);
			}
		});
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\javadev\\db-workspace\\oracle01\\img.jpg"));
		panel.add(lblNewLabel_1);
		f.setVisible(true);
	}

}
