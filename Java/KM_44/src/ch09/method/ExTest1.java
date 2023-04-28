package ch09.method;

public class ExTest1 {

	public static void main(String[] args) {
		// TODO 예외처리 try, catch, finally;
		String arr[] = {"10", "0"};
		int a, b, c;
		
		a = Integer.parseInt(arr[0]);
		b = Integer.parseInt(arr[1]);
		c = a / b;
		System.out.println(c);
	}

}
