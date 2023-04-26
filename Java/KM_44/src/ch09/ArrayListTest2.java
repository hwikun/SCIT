package ch09;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.printf("정수 입력: ");
			int a = sc.nextInt();
			if(a == -1) break;
			list.add(a);
		}
		System.out.println(list);
	}

}
