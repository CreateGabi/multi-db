package error;

// MemberDAO
public class 에러발생3 {

	// insert ---> call()메서드를 호출한 메서드에 예외처리를 떠넘길 수 있다.
	public void call() throws Exception {
		// 실행에러(run-time error) <----> 번역에러(compile error)
		System.out.println(3 / 0);
	}
}
