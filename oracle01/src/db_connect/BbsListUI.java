package db_connect;

import java.util.ArrayList;

public class BbsListUI {

	public static void main(String[] args) {
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> list = dao.list();
		System.out.println("검색한 회원수>> " + list.size());
		
		for (int i = 0; i < list.size(); i++) {
			BbsVO bbsVO = list.get(i);
			System.out.println(bbsVO.getId());
			System.out.println(bbsVO.getTitle());
			System.out.println(bbsVO.getContent());
			System.out.println(bbsVO.getWriter());
			System.out.println("--------------------------");
		}
		
//		for (BbsVO bbsVO : list) {
//			System.out.println(bbsVO.getId());
//			System.out.println(bbsVO.getTitle());
//			System.out.println(bbsVO.getContent());
//			System.out.println(bbsVO.getWriter());
//			System.out.println("--------------------------");
//		}
	}

}
