package ch03;

public class OperationEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fatherAge = 45;
		int motherAge = 47;
		
		// 삼항연산자
		
		char ch = (fatherAge > motherAge) ? 'T' : 'F';
		// cmd + shift + o auto import;
		System.out.println(ch);
	}

}
