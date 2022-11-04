package db_connect;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BbsUI6 {
    private static JTextField t1;
    private static JTextField t2;
    private static JTextField t3;
    private static JTextField t4;

    public static void open() {
        JFrame f = new JFrame();
        f.getContentPane().setBackground(Color.GREEN);
        f.setSize(500, 800);
        f.getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("제목");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel_1.setBounds(22, 255, 142, 40);
        f.getContentPane().add(lblNewLabel_1);
        
        JLabel label = new JLabel("내용");
        label.setFont(new Font("굴림", Font.BOLD, 30));
        label.setBounds(22, 318, 142, 40);
        f.getContentPane().add(label);
        
        JLabel label_1 = new JLabel("작성자");
        label_1.setFont(new Font("굴림", Font.BOLD, 30));
        label_1.setBounds(22, 388, 142, 40);
        f.getContentPane().add(label_1);
        
        JLabel label_2 = new JLabel("넘버");
        label_2.setFont(new Font("굴림", Font.BOLD, 30));
        label_2.setBounds(22, 456, 142, 40);
        f.getContentPane().add(label_2);
        
        t1 = new JTextField();
        t1.setFont(new Font("굴림", Font.BOLD, 30));
        t1.setBounds(176, 248, 260, 47);
        f.getContentPane().add(t1);
        t1.setColumns(10);
        
        t2 = new JTextField();
        t2.setFont(new Font("굴림", Font.BOLD, 30));
        t2.setColumns(10);
        t2.setBounds(176, 316, 260, 45);
        f.getContentPane().add(t2);
        
        t3 = new JTextField();
        t3.setFont(new Font("굴림", Font.BOLD, 30));
        t3.setColumns(10);
        t3.setBounds(176, 385, 260, 47);
        f.getContentPane().add(t3);
        
        t4 = new JTextField();
        t4.setFont(new Font("굴림", Font.BOLD, 30));
        t4.setColumns(10);
        t4.setBounds(176, 456, 260, 47);
        f.getContentPane().add(t4);
        
        JButton btnNewButton = new JButton("게시물 삭제 완료");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int id = Integer.parseInt(t4.getText());
        		BbsDAO dao = new BbsDAO();
        		dao.delete(id);
        	}
        });
        btnNewButton.setBackground(Color.MAGENTA);
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 45));
        btnNewButton.setBounds(22, 599, 436, 67);
        f.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("나의 게시판");
        btnNewButton_1.setBackground(SystemColor.info);
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 40));
        btnNewButton_1.setBounds(61, 25, 365, 185);
        f.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("게시물 작성 완료");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		// 1. t1, t2, t3, t4에 입력한 값을 가지고 와라
        		String title = t1.getText();
        		String content = t2.getText();
        		String writer = t3.getText();
        		int id = Integer.parseInt(t4.getText());
        		// 2. db에 넣기 위해 BbsDAO를 만들어주고,
        		BbsDAO dao = new BbsDAO();
        		// 가방을 만들어서, 값들을 넣고, 가방을 전달해보자.
        		BbsVO vo = new BbsVO();
        		vo.setTitle(title);
        		vo.setContent(content);
        		vo.setWriter(writer);
        		vo.setId(id);
        		// 3. 회원등록 기능을 쓰기 위해서 insert()메서드를 호출
        		dao.insert(vo);
        	}
        });
        btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 45));
        btnNewButton_2.setBackground(Color.MAGENTA);
        btnNewButton_2.setBounds(22, 530, 436, 67);
        f.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("게시물 검색 완료");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String s = JOptionPane.showInputDialog("검색할 id입력");
        		int id = Integer.parseInt(s);
        		BbsDAO dao = new BbsDAO();
        		BbsVO vo = dao.one(id);
        		t1.setText(vo.getTitle());
        		t2.setText(vo.getContent());
        		t3.setText(vo.getWriter());
        		t4.setText(String.valueOf(vo.getId()));
        	}
        });
        btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 45));
        btnNewButton_3.setBackground(Color.MAGENTA);
        btnNewButton_3.setBounds(22, 668, 436, 67);
        f.getContentPane().add(btnNewButton_3);
        f.setVisible(true);
    }
}
