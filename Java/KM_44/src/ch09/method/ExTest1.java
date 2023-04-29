package ch09.method;

public class ExTest1 {

	public static void main(String[] args) {
		// TODO 예외처리 try, catch, finally;
		String arr[] = {"10", "0"};
		int a, b, c;
		
		try {
			a = Integer.parseInt(arr[0]);
			b = Integer.parseInt(arr[1]);
			c = a / b;
			System.out.println(c);
		}
		catch(NumberFormatException e) { // 상속관계상 하위 Exception부터 처리;
			// 해결 방법 작성
			System.out.println("숫자가 아닙니다");
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 index가 범위를 넘었습니다.");
		}
		catch(Exception e) {
			System.out.println("알 수 없는 오류");
		}
		finally {
			System.out.println("마지막에 무조건");
		}
		System.out.println("프로그램 종료");
	}

}

// Throwable 종류
// Error & Exception

// Error = 프로그래머가 해결할 수 없는 문제;
// Exception > RuntimeException = 처리도중 생긴 문제 전달만.;
// 그 외의 Exception = 의무적으로 처리해야하는 Exception;
