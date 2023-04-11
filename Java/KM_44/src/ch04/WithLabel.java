package ch04;

public class WithLabel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		label1:
			for(int i = 0; i < 4; i++) {
				label2:
					for(int j = 0; j < 4; j++) {
						if(j == 2) continue label2;
						else if (i == 2) break label1;
						System.out.printf("i = %d j = %d\n", i, j);
					}//inner for
			}// outer for
	}// main

}//class
