package ch04;

public class WhileExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		int sum = 0;
		
		while(num <= 10) {
			sum += num;
			num++;
		}
		System.out.printf("1부터 10까지의 합은 %d입니다.", sum);
		
		
	}

}
