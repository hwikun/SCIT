package ch09;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int j = 0;
		int num[] = new int[3];
		// 정수를 반복 입력받아 배열을 초기화
		while(true) {
			System.out.printf("정수입력: ");
			int a = sc.nextInt();
			if(a == -1) break;
			num[j++] = a;
			if(j == num.length) {
				int tempArr[] = new int[num.length * 2];
				for(int n=0; n<num.length; n++) {
					tempArr[n] = num[n];
				}
				num = tempArr;
			}
		}
		// 배열에 저장된 값을 출력
		System.out.printf("[");
		for(int i=0; i<j; i++) {
			System.out.printf("%d%s", num[i], i != j-1 ? ", " : "");
		}
		System.out.println("]");
	}

}
