package ch02;

public class ExplicitConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dNum1 = 1.2;
		float fNum2 = 0.9F;
		
		int iNum3 = (int)dNum1 + (int)fNum2; // 1 + 0;
		int iNum4 = (int)(dNum1 + fNum2); //(int)(1.2 + 0.9) = 2.1;
		System.out.println(iNum3); // 1
		System.out.println(iNum4); // 2
	}

}
