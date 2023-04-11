package ch04;

public class ForExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, sum;
		for(i = 1, sum = 0; i <= 10; i++) {
			sum += 1;
		}
		System.out.printf("1부터 10까지의 합은 %d입니다", sum);
	}
}