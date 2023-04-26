package ch08.test;

import java.util.Scanner;

public class ArithmeticCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 진법(2/8/10/16): ");
		int inputNumSystem = sc.nextInt();
		sc.nextLine();
		System.out.print("정수 입력(2진수): ");
		String inputNum = sc.nextLine();
		System.out.printf("변환할 진법(2/8/10/16): ");
		int outputNumSystem = sc.nextInt();
		switch(inputNumSystem) {
		case 2: ArithmeticCalc.calcOut(inputNum, outputNumSystem); break;
		case 8: break;
		case 10: break;
		case 16: break;
			
		}
		ArithmeticCalc.paintResult(inputNumSystem, outputNumSystem, inputNum, result);
		
		
	}
	public static void paintResult(int in, int out, String str1, String str2) {
		System.out.printf("%s(%d) -> %s(%d)", str1, in, str2, out);
	}
	
	public static String calcOut(String in, int out) {
		String result = "";
		switch(out) {
		case 2:
			result = Integer.toBinaryString(Integer.parseInt(in));
			break;
		case 8:
			result = Integer.toOctalString(Integer.parseInt(in));
			break;
		case 16:
			result = Integer.toHexString(Integer.parseInt(in));
		}
		return result;
	}

}
/**
 * 입력할 진법(2/8/10/16): 2
 * 정수 입력(2진수): 11111111
 * 변환할 진법(2/8/10/16): 16
 * 252(2) -> FF(16)
 */