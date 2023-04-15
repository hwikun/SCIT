package ch07.test;

import java.util.Scanner;

public class Exam_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length;
		int sum = 0;
		while(true) {
			System.out.print("배열의 크기: ");
			length = sc.nextInt();
			if(length > 1) break;
			System.out.println("2 이상의 값을 입력하세요");
		}
		int arr [] = new int[length];
		for(int i=0; i<length; i++) {
			System.out.printf("배열[%d]: ", i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i == arr.length-1) {
				System.out.print(" = ");
				break;
			}
			System.out.printf(" + ");
		}
		System.out.printf("%d", sum);
	}

}
