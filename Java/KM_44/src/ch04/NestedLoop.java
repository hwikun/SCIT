package ch04;

public class NestedLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dan, times;
		for(dan = 2; dan <= 9; dan++) {
			for(times = 1; times <= 9; times++) {
				System.out.printf("%d * %d = %d\n", dan, times, dan * times);
			}
			System.out.println();
		}
	}

}
