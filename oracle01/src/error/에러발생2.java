package error;

// MemberDAO
public class 에러발생2 {

	// insert
	public void call() {
		// 실행에러(run-time error) <----> 번역에러(compile error)
		try {
			System.out.println(3 / 0);
		} catch (Exception e) {
			System.out.println("내가 예외처리했음. 프로그램중단x");
		}
	}
}
