package ch07.test;

public class Exam_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			int newNum = (int)(Math.random()*45) + 1;
			lotto[i] = newNum;
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
			System.out.printf("%d ", lotto[i]);
		}
	}

}
