package error;

public class 예외처리Main {

	public static void main(String[] args) {
		// 에러가 있는 클래스의 객체를 생성하고, 메서드를 호출해보자.
		에러발생2 error = new 에러발생2();
		error.call();
		System.out.println("에러발생후 실행이 될까요");
	}

}
