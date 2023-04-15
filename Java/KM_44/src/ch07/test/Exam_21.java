package ch07.test;

import java.util.Random;
import java.util.Scanner;

public class Exam_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int a, b, temp;
		int arr [] = new int[10];
		System.out.print("Original: ");
		for(int i=0; i<10; i++) {
			arr[i] = r.nextInt(100);
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
		while(true) {
			System.out.print("변경하고 싶은 위치1을 입력하세요: ");
			a = sc.nextInt();
			if(a > 0 && a < 11) break;
			System.out.println("유효하지 않은 값입니다. 다시 입력해주세요");
		}
		while(true) {
			System.out.print("변경하고 싶은 위치2을 입력하세요: ");
			b = sc.nextInt();
			if(b > 0 && a < 11 && b != a) break;
			System.out.println("유효하지 않은 값입니다. 다시 입력해주세요");
		}
		temp = arr[a-1];
		arr[a-1] = arr[b-1];
		arr[b-1] = temp;
		for(int el : arr) {
			System.out.printf("%d ", el);
		}
	}
	
	

}
