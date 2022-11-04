package error;

public class 문제발생클래스2 {

	// 예외처리: 실행에 예외를 둔다는 개념, 에러가 발생했을 때 처리는 하자
	public static void main(String[] args) {
		try {
			System.out.println(3/0);
			
			int[] num = {1, 2};
			num[2] = 22;
			// 여러개의 catch를 써주는 경우 위는 작은거에서부터 아래는 큰 것으로 써주어야한다.
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("수학 에러");
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("배열 에러");
		} catch (Exception e3) {  // 맨 위에 써주면 안됨
			System.out.println("위에서 안잡은 다른 에러 처리");
		} finally {
			// 반드시 처리되어야하는 애용을 쓰는 편
			// db프로그램에서는 자원해제해줘야하는
			// close()
			System.out.println("에러처리 다 끝남");
		}
	}

}
