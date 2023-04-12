package ch05;

public class FunctionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10, num2 = 20;
		
		FunctionTest t = new FunctionTest();
		int sum = t.add(num1, num2);
		System.out.printf("%d + %d = %d입니다", num1, num2, sum);
	}
	public int add(int a, int b) {
		int result = a + b;
		return result;
	}
	
	
}
