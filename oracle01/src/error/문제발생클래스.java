package error;

public class 문제발생클래스 {

	// 예외처리: 실행에 예외를 둔다는 개념, 에러가 발생했을 때 처리는 하자
	public static void main(String[] args) {
		System.out.println("1. 나는 프린트가 잘 될 예정");

		try {
			System.out.println("2. 문제 발생 코드" + 10 / 0);
		} catch (Exception e) {
			System.out.println("에러 발생했을 때 처리내용");
		}

		System.out.println("3. 나는 과연 프맄트가 될까요");
	}

}
