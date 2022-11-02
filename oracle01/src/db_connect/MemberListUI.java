package db_connect;

import java.util.ArrayList;

public class MemberListUI {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.list();
		System.out.println("검색한 회원수>> " + list.size());
		
		for (int i = 0; i < list.size(); i++) {
			MemberVO memberVO = list.get(i);
			System.out.println(memberVO.getId());
			System.out.println(memberVO.getPw());
			System.out.println(memberVO.getName());
			System.out.println(memberVO.getTel());
			System.out.println("--------------------------");
		}
//		for (MemberVO memberVO : list) {
//			System.out.println(memberVO.getId());
//			System.out.println(memberVO.getPw());
//			System.out.println(memberVO.getName());
//			System.out.println(memberVO.getTel());
//			System.out.println("--------------------------");
//		}
	}

}
