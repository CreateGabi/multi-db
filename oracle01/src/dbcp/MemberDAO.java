package dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAO {

	public ArrayList<MemberVO> list() {
		// 가변길이인 경우 arraylist
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		try {
			DBConnectionMgr dbcp = DBConnectionMgr.getInstance();
			Connection con = dbcp.getConnection();
			// 3. sql문을 만든다.
			String sql = "select * from member";
			// 준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. sql문 생성 성공");

			// 4. sql문을 db서버에 보낸다.
			ResultSet rs = ps.executeQuery(); // r의 결과는 table, cud는 숫자(실행된 row수)
			// rs.next() true면 결과가 있으므. false면 결과가 없음.
//			System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + rs.next());

			while (rs.next()) {
				System.out.println("검색 결과가 있음");
				String id2 = rs.getString(1);
				String pw = rs.getString("pw");
				String name = rs.getString(3);
				String tel = rs.getString(4);
				System.out.println(id2 + " " + pw + " " + name + " " + tel);

				// UI에서 사용자가 검색한 결과를 볼 수 있어야 한다.
				// 4개의 데이터를 UI에게 return 해주자
				// 1) 가방을 만들어서,
				MemberVO vo = new MemberVO();
				// 2) 데이터를 넣고,
				vo.setId(id2);
				vo.setPw(pw);
				vo.setName(name);
				vo.setTel(tel);

				list.add(vo);
				// 3) return하자.(전달)
			}
			System.out.println("박스(list)에 들어간 가방의 갯수>> " + list.size());

			// db처리와 관련된 메모리 할당된 것 해제시켜주자.
			dbcp.freeConnection(con, ps, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 메서드의 처리를 다 끝내고, 결과를 보내줘라는 개념
		return list;
	}

	public int login(MemberVO bag) {
		int result = 0; // 0인 경우, 실패
		try {
			DBConnectionMgr dbcp = DBConnectionMgr.getInstance();
			Connection con = dbcp.getConnection();
			// 3. sql문을 만든다.
			String sql = "select * from member where id = ? and pw = ?";
			// 준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. sql문 생성 성공");

			// 4. sql문을 db서버에 보낸다.
			ResultSet rs = ps.executeQuery(); // r의 결과는 table, cud는 숫자(실행된 row수)
			// rs.next() true면 결과가 있으므. false면 결과가 없음.
//			System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + rs.next());

			if (rs.next()) {
				System.out.println("검색 결과가 있음");
				result = 1;
				// 3) return하자.(전달)
			}

			// db처리와 관련된 메모리 할당된 것 해제시켜주자.
			dbcp.freeConnection(con, ps, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 메서드의 처리를 다 끝내고, 결과를 보내줘라는 개념
		return result;
	}

	public MemberVO one(String id) {

		System.out.println(id);
		MemberVO vo = null;
		try {
			DBConnectionMgr dbcp = DBConnectionMgr.getInstance();
			Connection con = dbcp.getConnection();
			// 3. sql문을 만든다.
			String sql = "select * from member where id = ?";
			// 준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. sql문 생성 성공");

			// 4. sql문을 db서버에 보낸다.
			ResultSet rs = ps.executeQuery(); // r의 결과는 table, cud는 숫자(실행된 row수)
			// rs.next() true면 결과가 있으므. false면 결과가 없음.
//			System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + rs.next());

			if (rs.next()) {
				System.out.println("검색 결과가 있음");
				String id2 = rs.getString(1);
				String pw = rs.getString("pw");
				String name = rs.getString(3);
				String tel = rs.getString(4);
				System.out.println(id2 + " " + pw + " " + name + " " + tel);

				// UI에서 사용자가 검색한 결과를 볼 수 있어야 한다.
				// 4개의 데이터를 UI에게 return 해주자
				// 1) 가방을 만들어서,
				vo = new MemberVO();
				// 2) 데이터를 넣고,
				vo.setId(id2);
				vo.setPw(pw);
				vo.setName(name);
				vo.setTel(tel);
				// 3) return하자.(전달)

			}

			// db처리와 관련된 메모리 할당된 것 해제시켜주자.
			dbcp.freeConnection(con, ps, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 메서드의 처리를 다 끝내고, 결과를 보내줘라는 개념
		return vo;
	}

	public void insert(MemberVO bag) {
		try {
			DBConnectionMgr dbcp = DBConnectionMgr.getInstance();
			Connection con = dbcp.getConnection();
			// 3. sql문을 만든다.
			String sql = "insert into member values (?, ?, ? ,?)";
			// 준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());
			System.out.println("3. sql문 생성 성공");

			// 4. sql문을 db서버에 보낸다.
			String result2 = "실패";
			try {
				int result = ps.executeUpdate();
				System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + result);
				if (result == 1) {
					result2 = "성공";
				}
			} catch (Exception e) {
				System.out.println("회원가입시 에러 발생");
			}
			JOptionPane.showMessageDialog(null, result2);

			dbcp.freeConnection(con, ps);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(String id) {
		try {
			DBConnectionMgr dbcp = DBConnectionMgr.getInstance();
			Connection con = dbcp.getConnection();
			// 3. sql문을 만든다.
			String sql = "delete from member where id = ?";
			// 준비된 문장(Preparedstatement)
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. sql문 생성 성공");

			// 4. sql문을 db서버에 보낸다.
			int result = ps.executeUpdate();
			System.out.println("4. sql문 db서버로 전송 성공 반영된. row 수 >> " + result);

			dbcp.freeConnection(con, ps);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
