package dbcp;

public class MemberVO {
	// 가방에는 데이터를 넣을 공간이 필요하다.
	// 회원테이블은 4개의 항목을 가지고 있음
	// 회원테이블의 항목과 동일하게 저장공간(변수)을 만들어준다.
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
	}

}
